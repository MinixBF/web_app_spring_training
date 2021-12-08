package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {
    TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/api/todo")
    public Iterable<TodoEntity> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping(value = "/api/todo", consumes = {"application/json"})
    public void addTodo(@RequestBody Todo todo) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.message = todo.message();
        todoEntity.author = todo.author();

        todoRepository.save(todoEntity);
    }
}