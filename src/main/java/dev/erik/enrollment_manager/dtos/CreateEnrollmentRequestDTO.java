package dev.erik.enrollment_manager.dtos;

import java.time.LocalDate;

public record CreateEnrollmentRequestDTO(
    String enrollmentCode,
    String courseName,
    LocalDate startDate,
    Long studentId) {
}
