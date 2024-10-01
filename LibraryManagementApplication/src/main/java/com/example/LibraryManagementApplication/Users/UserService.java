package com.example.LibraryManagementApplication.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(UserDTO userDTO) {
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String password = encoder.encode(user.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setCreatedAt(java.time.LocalDateTime.now());
        return userRepository.save(user);
    }

    public User updateUser(int id, UserDTO useruserDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(useruserDTO.getUsername());
            user.setPassword(useruserDTO.getPassword());
            user.setEmail(useruserDTO.getEmail());
            user.setRole(useruserDTO.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
