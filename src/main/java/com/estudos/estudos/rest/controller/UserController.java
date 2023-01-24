package com.estudos.estudos.rest.controller;

import com.estudos.estudos.domain.entity.DTO.UserDto;
import com.estudos.estudos.domain.entity.User;
import com.estudos.estudos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> userDtos = userService.findAll()
                                .stream()
                                .map(user -> new UserDto(user))
                                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(userDtos);

    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> findAllAdmin(){
        List<User> user = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
    }

    @PostMapping("/admin")
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid  User user){
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping
    public ResponseEntity<UserDto> cadastroUser(@RequestBody @Valid User user){
        userService.cadastroUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<User> edit(@PathVariable Long id, @Valid @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.edit(id,user));

    }


}
