package dev.erik.enrollment_manager.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_enrollment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String enrollmentCode;
  private String courseName;
  private LocalDate startDate;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

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
