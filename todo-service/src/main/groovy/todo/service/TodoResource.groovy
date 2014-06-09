package todo.service

import io.dropwizard.hibernate.UnitOfWork
import javax.ws.rs.*

@Path("/todos")
@Produces('application/json')
class TodoResource  {

  TodoDAO dao

  TodoResource(TodoDAO dao) {
    this.dao = dao
  }

  @GET
  @UnitOfWork
  public List<TodoEntity> list() {
    dao.list()
  }

  @POST
  @UnitOfWork
  public int store(List<TodoEntity> todos) {
    dao.store(todos)
    return todos.size()
  }
}
