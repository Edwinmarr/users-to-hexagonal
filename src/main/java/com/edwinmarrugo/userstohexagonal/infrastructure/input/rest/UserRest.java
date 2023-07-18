package com.edwinmarrugo.userstohexagonal.infrastructure.input.rest;

import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;
import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;
import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRest {

    private final UsersHandler usersHandler;

    @PostMapping("persistence")
    public ResponseEntity<Void> saveUser(
            @RequestBody UserRequest userRequest){
        usersHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<UserResponse> getUser(
            @RequestHeader("user-type-id") String typeId,
            @RequestHeader("user-number-id") String numberId){
        return ResponseEntity.ok(usersHandler.getUser(numberId,typeId));
    }
}
