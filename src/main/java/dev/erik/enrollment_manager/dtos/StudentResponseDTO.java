package dev.erik.enrollment_manager.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record StudentResponseDTO(
    Long id,
    String name,
    String phone,
    LocalDate birthDate,
    LocalDateTime createAt,
    LocalDateTime updateAt,
    List<EnrollmentDTO> enrollments) {
}
