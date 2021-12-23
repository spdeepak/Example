package controller

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"github.com/spdeepak/gormmux/entity"
	"github.com/spdeepak/gormmux/sql"
	"net/http"
)

func GetUsers(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var users []entity.User
	sql.DB.Find(&users)
	err := json.NewEncoder(w).Encode(users)
	if err != nil {
		return
	}
}

func GetUser(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)
	var user entity.User
	sql.DB.First(&user, params["id"])
	err := json.NewEncoder(w).Encode(user)
	if err != nil {
		return
	}
}

func CreateUser(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	var user = entity.User{}
	err := json.NewDecoder(r.Body).Decode(&user)
	if err != nil {
		return
	}
	sql.DB.Create(&user)
	err = json.NewEncoder(w).Encode(user)
	if err != nil {
		return
	}
}

func UpdateUser(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)
	var user entity.User
	sql.DB.First(&user, params["id"])
	err := json.NewDecoder(r.Body).Decode(&user)
	if err != nil {
		return
	}
	sql.DB.Save(&user)
	err = json.NewEncoder(w).Encode(user)
	if err != nil {
		return
	}
}

func DeleteUser(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)
	var user entity.User
	sql.DB.Delete(&user, params["id"])
	err := json.NewEncoder(w).Encode("The User is Deleted Successfully!")
	if err != nil {
		return
	}
}
