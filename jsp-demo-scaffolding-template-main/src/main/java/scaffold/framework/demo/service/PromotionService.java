package scaffold.framework.demo.service;

import java.util.List ;
import org.springframework.stereotype.Service ;
import org.springframework.data.domain.Page ;
import org.springframework.data.domain.PageRequest ;

import scaffold.framework.demo.entity.Promotion ;

import scaffold.framework.demo.repository.PromotionRepository ;

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
    public Page<Promotion> findAll(int pageNumber, int itemCount) {
        return promotionRepository.findAll(PageRequest.of(pageNumber, itemCount));
    }    
    public Promotion findById(Integer id) {
        return promotionRepository.findById(id).orElse(null);
    }
    public void deleteById(Integer id) {
        promotionRepository.deleteById(id);
    }
}    

