package dev.erik.enrollment_manager.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String phone;
  private LocalDate birthDate;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Enrollment> enrollments;

  public Student(String name, String phone, LocalDate birthDate, List<Enrollment> enrollments) {
    this.name = name;
    this.phone = phone;
    this.birthDate = birthDate;
    this.enrollments = enrollments;
  }

  @PrePersist
  public void prePersist() {
    LocalDateTime now = LocalDateTime.now();
    this.createAt = now;
    this.updateAt = now;
  }

  @PreUpdate
  public void preUpdate() {
    this.updateAt = LocalDateTime.now();
  }
}
