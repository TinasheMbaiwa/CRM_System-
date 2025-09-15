package com.faramatsi.crm.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;
    private PasswordEncoder encoder ;
    @Override
    public ResponseEntity<User> addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserName(user.getEmail());
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User user) {
        Optional<User> DBUser = repository.findById(id);
        if(DBUser.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else {
            User updateUser = DBUser.get();
            updateUser.setEmail(user.getEmail());
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());

            var updatedUser  = repository.save(updateUser);

            return ResponseEntity.ok(updatedUser);

        }
    }

    @Override
    public ResponseEntity<User> deleteUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            User delUser = user.get();
            repository.deleteById(delUser.getId());
            return ResponseEntity.ok(delUser);

        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
