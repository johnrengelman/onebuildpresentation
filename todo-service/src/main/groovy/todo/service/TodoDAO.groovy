package todo.service

import io.dropwizard.hibernate.*
import org.hibernate.SessionFactory

class TodoDAO extends AbstractDAO<TodoEntity> {

  TodoDAO(SessionFactory factory) {
    super(factory)
  }

  List<TodoEntity> list() {
    list(criteria())
  }

  void store(List<TodoEntity> todos) {
    def existing = list()
    def deletes = existing - todos
    deletes.each {
      currentSession().delete(it)
    }
    todos.each { todo ->
      def current = existing.find { it.id == todo.id}
      if (!current) {
        persist(todo)
      } else {
        persist(current.with {
          title = todo.title
          completed = todo.completed
          it
        })
      }
    }
  }
}
