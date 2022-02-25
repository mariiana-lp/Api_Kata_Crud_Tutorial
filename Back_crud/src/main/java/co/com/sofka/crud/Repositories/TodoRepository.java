package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
