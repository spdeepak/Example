package main

import "github.com/spdeepak/Viper/config"

func main() {
	appConfig := config.NewConfiguration()
	println(appConfig.Name)
	println(appConfig.Username)
	println(appConfig.Password)
}
