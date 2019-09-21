package com.grafik.sda.api;


import com.grafik.sda.dao.Student;
import com.grafik.sda.dao.StudentRepo;
import com.grafik.sda.manager.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentApi {

    private StudentManager studentManager;

    @Autowired
    public StudentApi(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @GetMapping("/all")
    public Iterable<Student> getAll(){
        return this.studentManager.findAll();
    }
    @GetMapping
    public Optional<Student> getById(Long id){
        return this.studentManager.findById(id);
    }
    @PostMapping
    public Student post(@RequestBody Student student){
        return this.studentManager.save(student);
    }
    @PutMapping
    public Student put(@RequestBody Student student){
        return this.studentManager.save(student);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){
        studentManager.deleteById(id);
    }

}
