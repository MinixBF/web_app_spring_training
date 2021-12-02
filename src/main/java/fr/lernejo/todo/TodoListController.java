package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {
    private final List<Todo> todoLists;

    public TodoListController(List<Todo> todoLists) {
        this.todoLists = new ArrayList<>();
    }

    @GetMapping("/api/todo")
    public List<Todo> getTodoLists() {
        return todoLists;
    }

    @PostMapping("/api/todo")
    public void addTodo(@RequestBody Todo todo) {
        todoLists.add(todo);
    }

    public void removeTodo(Todo todo) {
        todoLists.remove(todo);
    }
}
