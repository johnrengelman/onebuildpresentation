package todo.service

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.hibernate.HibernateBundle
import io.dropwizard.db.DataSourceFactory

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
    bootstrap.addBundle(hibernate)
  }

  @Override
  public void run(TodoConfiguration configuration, Environment environment) {
    TodoDAO dao = new TodoDAO(hibernate.sessionFactory)
    environment.jersey().register(new TodoResource(dao))
  }

  private final HibernateBundle<TodoConfiguration> hibernate =
    new HibernateBundle<TodoConfiguration>(TodoEntity, [] as Class[]) {
      @Override
      public DataSourceFactory getDataSourceFactory(TodoConfiguration configuration) {
        return configuration.database
      }
    }
}
