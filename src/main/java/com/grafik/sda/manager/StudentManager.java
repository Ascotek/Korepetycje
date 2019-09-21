package com.grafik.sda.manager;

import com.grafik.sda.dao.Przedmiot;
import com.grafik.sda.dao.Student;
import com.grafik.sda.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentManager {

    private StudentRepo studentRepo;

    @Autowired
    public StudentManager(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Iterable<Student> findAll(){
        return studentRepo.findAll();
    }
    public Optional<Student> findById (Long id){
        return studentRepo.findById(id);
    }
    public Student save(Student student){
        return studentRepo.save(student);
    }
    public void deleteById(Long id){
        studentRepo.deleteById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void findDB(){
        save(new Student("Daria", "Kieda", 2, Przedmiot.ANGIELSKI));
        save(new Student("Tomek", "Alferowicz", 3, Przedmiot.ANGIELSKI));
        save(new Student("Damian", "Kieda", 5, Przedmiot.ANGIELSKI));
        save(new Student("Wiktoria", "Kujawska", 5, Przedmiot.ANGIELSKI));
        save(new Student("Patrycja_Sandra", "Doroszczyk", 5, Przedmiot.ANGIELSKI));
        save(new Student("Asia", "Babynko", 6, Przedmiot.ANGIELSKI));
        save(new Student("Kuba", "Chrynkiewicz", 6, Przedmiot.MATEMATYKA));
        save(new Student("Igor", "Siemienczuk", 7, Przedmiot.ANGIELSKI));
        save(new Student("Ola", "Alferowicz", 7, Przedmiot.MATEMATYKA));
    }

}
