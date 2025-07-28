package dev.erik.enrollment_manager.dtos;

import java.time.LocalDate;

public record EnrollmentDTO(String enrollmentCode, String courseName, LocalDate startDate) {
}
