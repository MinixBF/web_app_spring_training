package fr.lernejo.todo;

import org.jetbrains.annotations.NotNull;
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

    @PostMapping("/api/todo")
    public void addTodo(@RequestBody @NotNull Todo todo) {
        TodoEntity entity = new TodoEntity();
        entity.author = todo.author();
        entity.message = todo.message();
        todoRepository.save(entity);
    }
}