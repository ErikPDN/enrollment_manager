package dev.erik.enrollment_manager.dtos;

import java.time.LocalDate;
import java.util.List;

public record RegisterStudentRequestDTO(
    String name,
    String phone,
    LocalDate birthDate,
    List<EnrollmentDTO> enrollments) {
}
