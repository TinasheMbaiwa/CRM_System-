package com.faramatsi.crm.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;
    @Override
    public ResponseEntity<User> addUser(User user) {
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
}
