package todo.service

import io.dropwizard.Configuration
import javax.validation.*
import javax.validation.constraints.*
import io.dropwizard.db.*

class TodoConfiguration extends Configuration {

  @Valid
  @NotNull
  DataSourceFactory database = new DataSourceFactory()

}
