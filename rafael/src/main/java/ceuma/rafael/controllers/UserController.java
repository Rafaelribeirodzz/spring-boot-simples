package ceuma.rafael.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ceuma.rafael.entities.User;
import ceuma.rafael.repositories.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @GetMapping
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User result = repository.findById(id).get();
        return result;
    }

    @PostMapping//Post usado para salvar uma coisa nova
    public User insert(@RequestBody User user) {
        User result = repository.save(user);//save vai mandar o obj pro banco de dados  ja converttido para relacional
        return result;
    }
}
