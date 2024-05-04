package scaffold.framework.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import scaffold.framework.demo.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
