package com.rest.example.controller;

import com.rest.example.dto.UidDTO;
import com.rest.example.dto.UserDTO;
import com.rest.example.manager.UserManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @Operation(summary = "Get all the users", description = "Get all the users from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userManager.getAllUsers();
        log.info("Users: {}", users);
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Get the user for the given id", description = "Get the user from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userManager.getUserById(id);
        log.info("User: {}", user);
        return ResponseEntity.ok(user);
    }


    @Operation(summary = "Get the random uid", description = "Get the random uid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/getUid")
    public ResponseEntity<UidDTO> getUid(@RequestParam( "delay" ) int delay) {
        long id = userManager.getUid(delay);
        UidDTO uid = new UidDTO();
        uid.setUid(id);
        return ResponseEntity.ok(uid);
    }

    @Operation(summary = "Save the user", description = "Save the user from to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @PostMapping("/user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        UserDTO savedUser = userManager.saveUser(user);
        log.info("Saved User: {}", savedUser);
        return ResponseEntity.ok(savedUser);
    }
}
