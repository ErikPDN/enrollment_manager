package dev.erik.enrollment_manager.dtos;

import java.time.LocalDate;

public record UpdateStudentDTO(
    String name,
    String phone,
    LocalDate birthDate) {
}
