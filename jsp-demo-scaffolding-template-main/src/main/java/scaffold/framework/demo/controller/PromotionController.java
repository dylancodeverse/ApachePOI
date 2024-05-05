package scaffold.framework.demo.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import scaffold.framework.demo.entity.Promotion;

import scaffold.framework.demo.service.PromotionService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/promotions")

public class PromotionController {

    private PromotionService promotionService;

    @GetMapping("/xlsx")
    public ResponseEntity<byte[]> exportXlsx(HttpServletResponse response) throws IOException {
        byte[] bytecodes = Promotion.generateExcelProm(promotionService.findAll());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.oasis.opendocument.text"));
        headers.setContentDispositionFormData("attachment", "example.ods");
        return new ResponseEntity<>(bytecodes, headers, HttpStatus.OK);
    }

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/list")
    public String listPromotions(Model model) {
        model.addAttribute("promotions", promotionService.findAll());
        return "pages/models/Promotionlist";
    }

    @GetMapping("/add")
    public String showAddPromotionForm(Model model) {
        return "pages/models/Promotionadd";
    }

    @PostMapping("/add")
    public String addPromotion(Promotion promotion) {
        promotionService.save(promotion);
        return "redirect:/Promotionlist";
    }

    @GetMapping("/edit/{id}")
    public String showEditPromotionForm(@PathVariable Integer id, Model model) {
        model.addAttribute("promotion", promotionService.findById(id));
        return "pages/models/Promotionedit";
    }

    @PostMapping("/edit")
    public String editPromotion(Promotion promotion) {
        // No error handling for yet
        if (promotion.getId() != null) {
            promotionService.save(promotion);
        }
        return "redirect:/Promotionlist";
    }

    @GetMapping("/delete/{id}")
    public String deletePromotion(@PathVariable Integer id) {
        promotionService.deleteById(id);
        return "redirect:/Promotionlist";
    }
}
