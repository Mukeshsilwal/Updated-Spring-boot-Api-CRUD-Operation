package com.example.demo.controller;

import com.example.demo.exception.ApiResponse;
import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class StudentController {



   private final StudentService studentService;

   @Autowired
    public StudentController(StudentService studentService){

               this.studentService=studentService;
  }

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
StudentDto studentDto1=studentService.createStudent(studentDto);
        return new ResponseEntity<>(studentDto1,HttpStatus.CREATED);
    }

    @GetMapping("/s")
    public ResponseEntity<List<StudentDto>> getAll(){
List<StudentDto> studentDtos=this.studentService.getAllStudent();
        return ResponseEntity.ok(studentDtos);
    }
    @GetMapping("/s/{ID}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer ID){

        return ResponseEntity.ok(studentService.getStudentById(ID));
    }

    @DeleteMapping("/s/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id)

    {
        studentService.deleteStudent(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("You have deleted item successfully",true),HttpStatus.OK);
    }
    @PutMapping("/s/{ID}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer ID,@RequestBody StudentDto studentDto){

        return ResponseEntity.ok(studentService.updateStudent(ID,studentDto));
    }

}
