package dev.erik.enrollment_manager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erik.enrollment_manager.dtos.CreateEnrollmentRequestDTO;
import dev.erik.enrollment_manager.services.EnrollmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
  private final EnrollmentService enrollmentService;

  @PostMapping
  public ResponseEntity<Void> enrollStudent(@RequestBody CreateEnrollmentRequestDTO dto) {
    this.enrollmentService.enrollStudent(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> cancelEnrollment(@PathVariable("id") Long id) {
    this.enrollmentService.cancelEnrollment(id);
    return ResponseEntity.noContent().build();
  }
}
