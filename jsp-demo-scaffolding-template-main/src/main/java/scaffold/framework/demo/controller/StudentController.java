package scaffold.framework.demo.controller;

import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import java.util.List ;

import scaffold.framework.demo.entity.Student ;

import scaffold.framework.demo.service.StudentService ;

import scaffold.framework.demo.service.PromotionService ;

import scaffold.framework.demo.entity.Promotion ;

@Controller
@RequestMapping("/students")        

public class StudentController {

    private StudentService studentService ;

    private PromotionService promotionService ;

    public StudentController(StudentService studentService

            ,PromotionService promotionService

        ) {

        this.studentService = studentService;        

        this.promotionService = promotionService;

    }        

    @GetMapping("/list")
    public String listStudents(Model model,@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        model.addAttribute("students", studentService.findAll(page > 0 ? page : 0, size));

        model.addAttribute("promotions", promotionService.findAll());

        return "pages/models/Studentlist";
    }        

    @GetMapping("/add")
    public String showAddStudentForms(Model model,@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        model.addAttribute("promotions", promotionService.findAll());

        return "pages/models/Studentadd";
    }        

    @PostMapping("/add")
    public String addStudent(

            @RequestParam String promotionId

            , Student student){

        Promotion promotion = new Promotion();
        promotion.setId(Integer.parseInt(promotionId));
        student.setPromotion(promotion);

        studentService.save(student);
        return "redirect:/Studentlist";
    }    

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Integer id, Model model) {
        Student student = studentService.findById(id);

        List<Promotion> promotions = promotionService.findAll();
        promotions.remove(student.getPromotion());     
        model.addAttribute("promotions", promotions);

        model.addAttribute("student", student);
        return "pages/models/Studentedit";
    }        

    @PostMapping("/edit")
    public String editStudent(

            @RequestParam String promotionId

            , Student student){

        if (student.getId() != null          

               && promotionId != null

            ){

            Promotion promotion = new Promotion();
            promotion.setId(Integer.parseInt(promotionId));    
            student.setPromotion(promotion);    

            studentService.save(student);
        }
        return "redirect:/Studentlist";
    }        

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/Studentlist";
    }        

}

