package com.example.tuesdb.controllers;

import com.example.tuesdb.dtos.UserInputDto;
import com.example.tuesdb.repositories.TuesRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final TuesRepository tuesRepository;

    public Controller(TuesRepository tuesRepository) {
        this.tuesRepository = tuesRepository;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(this.tuesRepository.getAllUsers());
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    examples = {
                            @ExampleObject(name = "Create-1", value = """
                                            {
                                              "username": "Pesho",
                                              "password": "1234",
                                              "name": "Pesho Peshov",
                                              "permissions": ["permission1", "permission2"],
                                              "groups": ["group2", "group2"]
                                            }""")
                    }
            )
        )
        @RequestBody UserInputDto userInputDto)
    {
            return ResponseEntity.ok(this.tuesRepository.createUser(userInputDto));
    }

    @GetMapping(value = "/groups")
    public ResponseEntity<?> getAllGroups() {
        return ResponseEntity.ok(this.tuesRepository.getAllGroups());
    }

    @GetMapping(value = "/permissions")
    public ResponseEntity<?> getAllPermissions() {
        return ResponseEntity.ok(this.tuesRepository.getAllPermissions());
    }
}
