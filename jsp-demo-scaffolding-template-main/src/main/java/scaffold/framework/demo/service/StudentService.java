package scaffold.framework.demo.service;

import java.util.List ;
import org.springframework.stereotype.Service ;
import org.springframework.data.domain.Page ;
import org.springframework.data.domain.PageRequest ;

import scaffold.framework.demo.entity.Student ;

import scaffold.framework.demo.repository.StudentRepository ;

@Service        

public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Page<Student> findAll(int pageNumber, int itemCount) {
        return studentRepository.findAll(PageRequest.of(pageNumber, itemCount));
    }    
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}    

