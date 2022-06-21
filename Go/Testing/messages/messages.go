package messages

import "fmt"

func Greet(name string) string {
	return fmt.Sprintf("Hello, %s!\n", name)
}

func Depart(name string) string {
	return fmt.Sprintf("Bye, %s!\n", name)
}
