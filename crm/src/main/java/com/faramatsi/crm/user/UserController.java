package com.faramatsi.crm.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm/users/v1")
@AllArgsConstructor
public class UserController {
    private UserServiceImpl service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return service.addUser(user);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user)
    {
        return service.updateUser(id,user);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        return service.deleteUserById(id);
    }
}
