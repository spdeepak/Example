package sql

import (
	"fmt"
	"github.com/spdeepak/gormmux/entity"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var DB *gorm.DB

const DbUrl = "host=localhost user=admin password=admin " +
	"dbname=godb port=5432 sslmode=disable"

func InitialMigration() {
	var err error
	DB, err = gorm.Open(postgres.Open(DbUrl), &gorm.Config{})
	if err != nil {
		fmt.Println(err.Error())
		panic("Cannot connect to DB")
	}
	DB.AutoMigrate(&entity.User{})
}
