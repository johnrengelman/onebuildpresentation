package todo.app

import todo.api.Todo

@grails.validation.Validateable
class TodosCommand {

  List<Todo> todos
}
