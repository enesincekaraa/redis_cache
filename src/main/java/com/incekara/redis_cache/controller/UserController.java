package com.incekara.redis_cache.controller;

import com.incekara.redis_cache.dto.CreateUserDto;
import com.incekara.redis_cache.dto.UpdateUserDto;
import com.incekara.redis_cache.model.User;
import com.incekara.redis_cache.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public User getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDto updateUserDto){
        return new ResponseEntity<>(userService.updateUser(updateUserDto),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
