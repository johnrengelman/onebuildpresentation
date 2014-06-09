package todo.service

import todo.api.Todo
import javax.ws.rs.*

@Path("/todos")
@Produces('application/json')
class TodoResource  {

  @GET
  public List<Todo> list() {
    return [
      new Todo(title: "test todo", completed: false)
    ]
  }
}
