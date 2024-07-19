package com.example.BackendSwan.Service;

import com.example.BackendSwan.Entity.User;
import com.example.BackendSwan.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveEmployee(User user) {
        // If you were encoding the password, remove that code
        return userRepository.save(user);
    }

    public User updateEmployee(String id, User updatedUser) {
        // Implement the update logic
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
           // user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            // Update other fields as necessary
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteEmployeeById(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllEmployees() {
        return userRepository.findAll();
    }

    public Optional<User> findEmployeeById(String id) {
        return userRepository.findById(id);
    }
}
