package todo.service

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class TodoService extends Application<TodoConfiguration> {

  public static void main(String[] args) {
    new TodoService().run(args)
  }

  @Override
  public String getName() {
    return 'todo-service'
  }

  @Override
  public void initialize(Bootstrap<TodoConfiguration> bootstrap) {

  }

  @Override
  public void run(TodoConfiguration configuration, Environment environment) {
      environment.jersey().register(new TodoResource())
  }
}
