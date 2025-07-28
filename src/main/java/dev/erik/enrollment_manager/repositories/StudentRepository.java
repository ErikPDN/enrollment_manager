package dev.erik.enrollment_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.erik.enrollment_manager.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
