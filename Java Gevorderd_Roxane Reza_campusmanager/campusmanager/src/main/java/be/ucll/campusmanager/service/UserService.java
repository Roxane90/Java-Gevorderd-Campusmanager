package be.ucll.campusmanager.service;

import be.ucll.campusmanager.entity.User;
import be.ucll.campusmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //beans are automatically wired (automatic dependency injection)
    private UserRepository userRepository;

    /*public User addUser(User user) {

        return UserRepository.save(user);

    }*/

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    public Optional<User> getUserByName(String name) {

        return userRepository.findByNameContaining(name);

    }

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);

    }
}