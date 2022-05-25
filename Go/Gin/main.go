package main

import (
	"github.com/gin-gonic/gin"
)

func main() {
	//Initialise the Router
	router := gin.New()

	health := make(map[string]string, 1)
	health["status"] = "ok"
	//Add health check endpoint
	router.GET("/health", func(c *gin.Context) {
		c.JSON(200, health)
	})

	//Run the server
	router.Run("localhost:8080")
}
