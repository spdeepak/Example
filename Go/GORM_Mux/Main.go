package main

import (
	"github.com/gorilla/mux"
	"github.com/spdeepak/gormmux/controller"
	"github.com/spdeepak/gormmux/sql"
	"log"
	"net/http"
)

func main() {
	sql.InitialMigration()
	initializeRouter()
}

func initializeRouter() {
	r := mux.NewRouter()
	r.HandleFunc("/users", controller.GetUsers).Methods("GET")
	r.HandleFunc("/users/{id}", controller.GetUser).Methods("GET")
	r.HandleFunc("/users", controller.CreateUser).Methods("POST")
	r.HandleFunc("/users/{id}", controller.UpdateUser).Methods("PUT")
	r.HandleFunc("/users/{id}", controller.DeleteUser).Methods("DELETE")
	log.Fatal(http.ListenAndServe(":8080", r))
}
