package dev.erik.enrollment_manager.services;

import org.springframework.stereotype.Service;

import dev.erik.enrollment_manager.dtos.RegisterStudentRequestDTO;
import dev.erik.enrollment_manager.dtos.StudentResponseDTO;
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
}
