package com.example.demo.service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements StudentService {


   private final StudentRepo studentRepo;
  private final ModelMapper modelMapper;

@Autowired
    public ServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper){
    this.studentRepo = studentRepo;
    this.modelMapper=modelMapper;
    }
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student=this.dtoTOStudent(studentDto);
        Student student1=this.studentRepo.save(student);
        return this.studentToDto(student1);
    }

    @Override
    public StudentDto updateStudent(Integer id,StudentDto studentDto) {
        Student student1=studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("You Have entered Wrong Id","id",id));
        student1.setcName(studentDto.getcName());
        student1.setId(studentDto.getId());
        student1.setcName(studentDto.getcName());
        student1.setRoll(studentDto.getRoll());
        return this.studentToDto(studentRepo.save(student1));
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student=this.studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Entered id is","id",id));
        this.studentRepo.deleteById(id);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> student=this.studentRepo.findAll();
        List<StudentDto> studentDtos=this.studentRepo.findAll().stream().map(this::studentToDto).collect(Collectors.toList());

        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student=this.studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Item with this Id","id",id));
        return this.studentToDto(student);
    }
public Student dtoTOStudent(StudentDto studentDto){
        Student student=this.modelMapper.map(studentDto,Student.class);

        return student;
}
public StudentDto studentToDto(Student student){
        StudentDto studentDto=this.modelMapper.map(student,StudentDto.class);

        return studentDto;

}

}