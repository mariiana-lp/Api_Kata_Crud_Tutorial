package co.com.sofka.crud.Services;

import co.com.sofka.crud.Model.Todo;
import co.com.sofka.crud.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> list(){
        return  todoRepository.findAll();
    }

    public Todo save (Todo todo){
        return  todoRepository.save(todo);
    }

    public void deleteById(long id){
        todoRepository.delete(getById(id));
    }

    public Todo getById (long id){
        return todoRepository.findById(id).orElseThrow();
    }
}
