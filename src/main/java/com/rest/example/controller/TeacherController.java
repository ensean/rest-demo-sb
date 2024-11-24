package com.rest.example.controller;

import com.rest.example.dto.TeacherDTO;
import com.rest.example.manager.TeacherManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TeacherController {

    private final TeacherManager teacherManager;

    public TeacherController(TeacherManager teacherManager) {
        this.teacherManager = teacherManager;
    }

    @Operation(summary = "Get all the teachers", description = "Get all the teachers from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TeacherDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teachers = teacherManager.getAllTeachers();
        log.info("Teachers: {}", teachers);
        return ResponseEntity.ok(teachers);
    }

    @Operation(summary = "Get the teacher for the given id", description = "Get the teacher from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TeacherDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
        TeacherDTO teacher = teacherManager.getTeacherById(id);
        log.info("Teacher: {}", teacher);
        return ResponseEntity.ok(teacher);
    }

    @Operation(summary = "Save the teacher", description = "Save the teacher to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TeacherDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @PostMapping("/teacher")
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacher) {
        TeacherDTO savedTeacher = teacherManager.saveTeacher(teacher);
        log.info("Saved Teacher: {}", savedTeacher);
        return ResponseEntity.ok(savedTeacher);
    }
}
