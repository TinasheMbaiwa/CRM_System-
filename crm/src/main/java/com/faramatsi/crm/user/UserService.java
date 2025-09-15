package com.faramatsi.crm.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<User> addUser(User user);

    ResponseEntity<User> updateUser(Long id, User user);

    ResponseEntity<User> deleteUserById(Long id);

    List<User> getAllUsers();
}
