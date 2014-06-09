package todo.service

import todo.api.Todo
import javax.persistence.*
import groovy.transform.*

@Entity
@Table(name = 'todo')
@EqualsAndHashCode
class TodoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id

  @Column(nullable = false)
  String title

  @Column
  boolean completed

  static TodoEntity from(Todo todo) {
      new TodoEntity(id: todo.id, title: todo.title, completed: todo.completed)
  }
}
