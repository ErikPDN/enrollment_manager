package dev.erik.enrollment_manager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.erik.enrollment_manager.dtos.RegisterStudentRequestDTO;
import dev.erik.enrollment_manager.dtos.StudentResponseDTO;
import dev.erik.enrollment_manager.dtos.UpdateStudentDTO;
import dev.erik.enrollment_manager.entities.Student;
import dev.erik.enrollment_manager.mappers.StudentMapper;
import dev.erik.enrollment_manager.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;

  public void registerStudent(RegisterStudentRequestDTO dto) {
    var student = StudentMapper.toEntity(dto);
    this.studentRepository.save(student);
  }

  public Page<StudentResponseDTO> listAllStudents(Pageable pageable) {
    Page<Student> studentPage = this.studentRepository.findAll(pageable);
    return studentPage.map(StudentMapper::toDTO);
  }

  public StudentResponseDTO getStudentById(Long id) {
    Student student = this.studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));

    var studentDTO = StudentMapper.toDTO(student);
    return studentDTO;
  }

  public StudentResponseDTO updateStudent(Long id, UpdateStudentDTO dto) {
    Student student = this.studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));

    if (dto.birthDate() != null) {
      student.setBirthDate(dto.birthDate());
    }

    if (dto.name() != null) {
      student.setName(dto.name());
    }

    if (dto.phone() != null) {
      student.setPhone(dto.phone());
    }

    Student updateStudent = this.studentRepository.save(student);
    return StudentMapper.toDTO(updateStudent);
  }
}
