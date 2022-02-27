package co.com.sofka.crud.Controller;


import co.com.sofka.crud.Model.Todo;
import co.com.sofka.crud.Repositories.TodoRepository;
import co.com.sofka.crud.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "api/todo")
    public Iterable<Todo> list(){
        return  todoService.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save (@RequestBody Todo todo){
        return  todoService.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update (@RequestBody Todo todo){
        if(Long.valueOf(todo.getId()) != null) {
            return  todoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");

    }

    @DeleteMapping(value= "api/todo/{id}")
    public void deleteById(@PathVariable("id") long id){
        todoService.deleteById(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo getById (@PathVariable("id") long id){
        return todoService.getById(id);
    }



}
