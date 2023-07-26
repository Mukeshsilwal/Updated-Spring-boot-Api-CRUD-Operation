package com.example.demo.service;

import com.example.demo.model.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(Integer id,StudentDto studentDto);
    void deleteStudent(Integer id);
    List<StudentDto> getAllStudent();
    StudentDto getStudentById(Integer id);

}