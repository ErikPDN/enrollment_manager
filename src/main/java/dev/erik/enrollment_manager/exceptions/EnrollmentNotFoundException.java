package dev.erik.enrollment_manager.exceptions;

public class EnrollmentNotFoundException extends RuntimeException {
  public EnrollmentNotFoundException(String message) {
    super(message);
  }
}
