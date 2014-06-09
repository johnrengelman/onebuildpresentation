package todo.app

import todo.api.Todo
import retrofit.http.*

interface TodoServiceApi {

  @GET("/todos")
  List<Todo> list()

  @POST("/todos")
  int store(@Body List<Todo> todos)
}
