package todo.app

import grails.converters.*

class TodoController {

  TodoServiceApi serviceApi

  def index() { }

  def list() {
    render serviceApi.list() as JSON
  }

  def store(TodosCommand command) {
    render serviceApi.store(command.todos)
  }
}
