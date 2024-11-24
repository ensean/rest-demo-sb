package com.rest.example.service.impl;

import com.rest.example.dto.TeacherDTO;
import com.rest.example.entity.Teacher;
import com.rest.example.exception.TeacherNotFoundException;
import com.rest.example.mapper.TeacherDataMapper;
import com.rest.example.repository.TeacherRepository;
import com.rest.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherDataMapper teacherDataMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherDataMapper teacherDataMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherDataMapper = teacherDataMapper;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();

        List<TeacherDTO> teacherDTOS = teacherDataMapper.mapToTeacherDTOList(teachers);

        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return teacherOptional.get();
        } else {
            String logMessage = "Teacher not found for the given id: " + id;
            log.error(logMessage);
            throw new TeacherNotFoundException(logMessage);
        }
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
