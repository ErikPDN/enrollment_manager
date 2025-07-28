package dev.erik.enrollment_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.erik.enrollment_manager.entities.Enrollment;
import jakarta.persistence.Entity;

@Entity
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
