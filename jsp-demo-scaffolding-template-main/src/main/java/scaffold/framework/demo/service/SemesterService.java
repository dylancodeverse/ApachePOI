package scaffold.framework.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import scaffold.framework.demo.entity.Semester;
import scaffold.framework.demo.repository.SemesterRepository;

@Service
public class SemesterService {

    private SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository repository) {
        this.semesterRepository = repository;
    }

    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }

    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    public Semester findById(Long id) {
        return semesterRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        semesterRepository.deleteById(id);
    }
}
