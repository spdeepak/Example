package controller

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

type Controller struct {
}

func NewController() *Controller {
	return &Controller{}
}

func (c *Controller) GetController(ctx *gin.Context) {
	headers := ctx.Request.Header
	ctx.JSON(http.StatusOK, headers)
}
