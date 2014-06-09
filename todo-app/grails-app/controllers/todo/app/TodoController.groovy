package todo.app

import grails.converters.*

class TodoController {

  TodoServiceApi serviceApi

  def index() { }

  def list() {
    render serviceApi.list() as JSON
  }
}
