package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

var cache = map[int]Book{}
var rnd = rand.New(rand.NewSource(time.Now().UnixNano()))

func main() {
	wg := &sync.WaitGroup{}
	m := &sync.RWMutex{}

	cacheCh := make(chan Book)
	dbCh := make(chan Book)

	for i := 0; i < 10; i++ {
		id := rnd.Intn(10) + 1
		wg.Add(2)
		go func(id int, wg *sync.WaitGroup, m *sync.RWMutex, ch chan<- Book) {
			if b, ok := queryCache(id, m); ok {
				ch <- b
			}
			wg.Done()
		}(id, wg, m, cacheCh)
		go func(id int, wg *sync.WaitGroup, m *sync.RWMutex, ch chan<- Book) {
			if b, ok := queryDatabase(id, m); ok {
				m.Lock()
				cache[id] = b
				m.Unlock()
				ch <- b
			}
			wg.Done()
		}(id, wg, m, dbCh)

		go func(cacheCh, dbCh <-chan Book) {
			select {
			case b := <-cacheCh:
				fmt.Println("From cache")
				fmt.Println(b)
				<-dbCh //When cache is accessed then we don't need DB. Thus, the message drain from dbCh
			case b := <-dbCh:
				fmt.Println("From db")
				fmt.Println(b)
			}
		}(cacheCh, dbCh)
		time.Sleep(150 * time.Millisecond)
	}

	wg.Wait()
}

func queryCache(id int, m *sync.RWMutex) (Book, bool) {
	m.RLock()
	b, ok := cache[id]
	m.RUnlock()
	return b, ok
}

func queryDatabase(id int, m *sync.RWMutex) (Book, bool) {
	time.Sleep(100 * time.Millisecond)
	for _, b := range books {
		if b.ID == id {
			return b, true
		}
	}
	return Book{}, false
}

func ChannelForLoop() {
	wg := &sync.WaitGroup{}
	ch := make(chan int, 1)

	wg.Add(2)

	go func(ch <-chan int, wg *sync.WaitGroup) { //Receive only
		//for i := 0; i < 10; i++ {
		//	fmt.Println(<-ch)
		//}
		for msg := range ch {
			fmt.Println(msg)
		}
		wg.Done()
	}(ch, wg)
	go func(ch chan<- int, wg *sync.WaitGroup) { //Send only
		for i := 0; i < 10; i++ {
			ch <- i
		}
		close(ch)
		wg.Done()
	}(ch, wg)
	wg.Wait()
}

func ChannelIfStatements() {
	wg := &sync.WaitGroup{}
	ch := make(chan int, 1)

	wg.Add(2)

	go func(ch <-chan int, wg *sync.WaitGroup) { //Receive only
		if msg, ok := <-ch; ok {
			fmt.Println(msg, ok)
		}
		wg.Done()
	}(ch, wg)
	go func(ch chan<- int, wg *sync.WaitGroup) { //Send only
		close(ch)
		wg.Done()
	}(ch, wg)
	wg.Wait()
}

func SendAndReceiveChannels() {
	wg := &sync.WaitGroup{}
	ch := make(chan int, 1)

	wg.Add(2)

	go func(ch <-chan int, wg *sync.WaitGroup) { //Receive only
		fmt.Println(<-ch)
		wg.Done()
	}(ch, wg)
	go func(ch chan<- int, wg *sync.WaitGroup) { //Send only
		ch <- 42
		wg.Done()
	}(ch, wg)
	wg.Wait()
}
