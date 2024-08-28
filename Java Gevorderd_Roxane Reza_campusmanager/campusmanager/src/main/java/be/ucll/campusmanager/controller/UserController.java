package be.ucll.campusmanager.controller;


import be.ucll.campusmanager.entity.User;
import be.ucll.campusmanager.repository.ReservationRepository;
import be.ucll.campusmanager.repository.UserRepository;
import be.ucll.campusmanager.service.ReservationService;
import be.ucll.campusmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    // Create a new User
   /* @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = UserService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }*/

    // Get a User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get a User by name or part of the name
    /*@GetMapping
    public ResponseEntity<List<User>> getUsersByName(@RequestParam String nameMatches) {
        Optional<User> userList = userService.getUserByName("%" + nameMatches + "%");
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }*/ //Error: put in comments

    /* Update a User
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setFirstName(userDetails.getFirstName());
            updatedUser.setLastName(userDetails.getLastName());
            updatedUser.setBirthDate(userDetails.getBirthDate());
            updatedUser.setEmail(userDetails.getEmail());
            userRepository.save(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a User
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable*/

}
