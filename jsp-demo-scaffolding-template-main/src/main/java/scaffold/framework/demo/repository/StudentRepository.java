package scaffold.framework.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import scaffold.framework.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
