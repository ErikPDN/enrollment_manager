package dev.erik.enrollment_manager.services;

import org.springframework.stereotype.Service;

import dev.erik.enrollment_manager.dtos.CreateEnrollmentRequestDTO;
import dev.erik.enrollment_manager.entities.Enrollment;
import dev.erik.enrollment_manager.entities.Student;
import dev.erik.enrollment_manager.exceptions.EnrollmentNotFoundException;
import dev.erik.enrollment_manager.exceptions.StudentNotFoundException;
import dev.erik.enrollment_manager.repositories.EnrollmentRepository;
import dev.erik.enrollment_manager.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
  private final EnrollmentRepository enrollmentRepository;
  private final StudentRepository studentRepository;

  public void enrollStudent(CreateEnrollmentRequestDTO dto) {
    Student student = this.studentRepository.findById(dto.studentId())
        .orElseThrow(() -> new StudentNotFoundException("Student with id: " + dto.studentId() + " not found!"));

    Enrollment enrollment = new Enrollment();
    enrollment.setStartDate(dto.startDate());
    enrollment.setCourseName(dto.courseName());
    enrollment.setEnrollmentCode(dto.enrollmentCode());
    enrollment.setStudent(student);

    this.enrollmentRepository.save(enrollment);
  }

  public void cancelEnrollment(Long id) {
    Enrollment enrollment = this.enrollmentRepository.findById(id)
        .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with id: " + id + " not found!"));

    this.enrollmentRepository.delete(enrollment);
  }
}
