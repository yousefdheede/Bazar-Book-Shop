package com.example.bazar.bookshop;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
 
    @Autowired
    private UserRepository userRepository;
        
  
    @GetMapping
    public Iterable<User> findAllbooks() {
        return userRepository.findAll();
    }
    
  
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById1(@PathVariable(value = "id") long id) {
        java.util.Optional<User> user = userRepository.findById(id);
     
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    
    
    @PostMapping
    public User saveUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }
}