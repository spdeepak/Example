package main

import (
	"github.com/gin-gonic/gin"
	"github.com/spdeepak/Gin/controller"
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

	newController := controller.NewController()
	routerGroup := router.Group("/api/v1")
	routerGroup.GET("/get", newController.GetController)

	//Run the server
	router.Run(":8080")
}
