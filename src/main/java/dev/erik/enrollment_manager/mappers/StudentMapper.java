package dev.erik.enrollment_manager.mappers;

import java.util.List;

import dev.erik.enrollment_manager.dtos.EnrollmentDTO;
import dev.erik.enrollment_manager.dtos.RegisterStudentRequestDTO;
import dev.erik.enrollment_manager.dtos.StudentResponseDTO;
import dev.erik.enrollment_manager.entities.Enrollment;
import dev.erik.enrollment_manager.entities.Student;

public class StudentMapper {

  public static Student toEntity(RegisterStudentRequestDTO dto) {
    Student student = new Student();
    student.setName(dto.name());
    student.setBirthDate(dto.birthDate());
    student.setPhone(dto.phone());

    List<Enrollment> enrollmentList = dto.enrollments().stream().map(e -> {
      Enrollment enrollment = new Enrollment();
      enrollment.setEnrollmentCode(e.enrollmentCode());
      enrollment.setCourseName(e.courseName());
      enrollment.setStartDate(e.startDate());
      enrollment.setStudent(student);

      return enrollment;
    }).toList();

    student.setEnrollments(enrollmentList);
    return student;
  }

  public static StudentResponseDTO toDTO(Student student) {
    List<EnrollmentDTO> enrollmentsDTO = student.getEnrollments().stream().map(e -> {
      EnrollmentDTO enrollmentDTO = new EnrollmentDTO(e.getEnrollmentCode(), e.getCourseName(), e.getStartDate());
      return enrollmentDTO;
    }).toList();

    var studentResponseDTO = new StudentResponseDTO(
        student.getId(),
        student.getName(),
        student.getPhone(),
        student.getBirthDate(),
        student.getCreateAt(),
        student.getUpdateAt(),
        enrollmentsDTO);

    return studentResponseDTO;
  }
}
