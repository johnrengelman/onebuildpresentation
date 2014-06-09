// Place your Spring DSL code here
import retrofit.Endpoints
import retrofit.RestAdapter
import retrofit.RestAdapter.Builder
import todo.app.TodoServiceApi

beans = {
  builder(Builder) {
     endpoint =  Endpoints.newFixedEndpoint("http://localhost:9090")
  }

  adapter(builder: 'build')

  serviceApi(adapter: 'create') { bean ->
    bean.constructorArgs = [TodoServiceApi]
  }
}
