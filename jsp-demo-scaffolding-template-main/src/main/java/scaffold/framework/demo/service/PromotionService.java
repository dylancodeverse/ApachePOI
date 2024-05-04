package scaffold.framework.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import scaffold.framework.demo.entity.Promotion;
import scaffold.framework.demo.repository.PromotionRepository;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion save(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }
}
