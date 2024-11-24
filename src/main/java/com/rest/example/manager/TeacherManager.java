package com.rest.example.manager;

import com.rest.example.dto.TeacherDTO;
import com.rest.example.entity.Teacher;
import com.rest.example.mapper.TeacherDataMapper;
import com.rest.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TeacherManager {

    private final TeacherService teacherService;

    private final TeacherDataMapper teacherDataMapper;

    public TeacherManager(TeacherService teacherService, TeacherDataMapper teacherDataMapper) {
        this.teacherService = teacherService;
        this.teacherDataMapper = teacherDataMapper;
    }

    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return teacherDataMapper.mapToTeacherDTOList(teachers);
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return teacherDataMapper.mapToTeacherDTO(teacher);

    }

    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.saveTeacher(teacherDataMapper.mapToTeacher(teacherDTO));
        return teacherDataMapper.mapToTeacherDTO(teacher);
    }
}
