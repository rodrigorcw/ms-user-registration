package com.jabra.api.infra.web;

import com.jabra.api.adapter.UserAdapter;
import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.User;
import com.jabra.api.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> Created(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.Created(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> Update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.Update(id, userDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
