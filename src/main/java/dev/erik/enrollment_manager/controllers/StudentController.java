package dev.erik.enrollment_manager.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erik.enrollment_manager.dtos.PaginatedResponseDTO;
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

  @GetMapping
  public ResponseEntity<PaginatedResponseDTO<StudentResponseDTO>> listAllStudents(Pageable pageable) {
    Page<StudentResponseDTO> studentsPage = this.studentService.listAllStudents(pageable);
    var response = new PaginatedResponseDTO<>(studentsPage.getContent(), studentsPage.getNumber(),
        studentsPage.getTotalElements(), studentsPage.getTotalPages());

    return ResponseEntity.ok(response);
  }
}
