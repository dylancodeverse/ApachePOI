package scaffold.framework.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import scaffold.framework.demo.entity.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
