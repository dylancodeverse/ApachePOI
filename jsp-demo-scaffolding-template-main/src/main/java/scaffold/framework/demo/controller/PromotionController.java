package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.entity.Promotion;
import scaffold.framework.demo.service.PromotionService;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    private PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/list")
    public String listPromotions(Model model) {
        model.addAttribute("promotions", promotionService.findAll());
        return "pages/promotion/list";
    }

    @GetMapping("/add")
    public String showAddPromotionForm(Model model) {
        return "pages/promotion/add";
    }

    @PostMapping("/add")
    public String addPromotion(Promotion promotion) {
        promotionService.save(promotion);
        return "redirect:/promotions/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditPromotionForm(@PathVariable Long id, Model model) {
        model.addAttribute("promotion", promotionService.findById(id));
        return "pages/promotion/edit";
    }

    @PostMapping("/edit")
    public String editPromotion(Promotion promotion) {
        // No error handling for yet
        if (promotion.getId() != null) {
            promotionService.save(promotion);
        }
        return "redirect:/promotions/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePromotion(@PathVariable Long id) {
        promotionService.deleteById(id);
        return "redirect:/promotions/list";
    }
}