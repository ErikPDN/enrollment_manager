package dev.erik.enrollment_manager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erik.enrollment_manager.dtos.RegisterStudentRequestDTO;
import dev.erik.enrollment_manager.dtos.StudentResponseDTO;
import dev.erik.enrollment_manager.services.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService studentService;

  @PostMapping
  public ResponseEntity<Void> registerStudent(@RequestBody RegisterStudentRequestDTO dto) {
    this.studentService.registerStudent(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
