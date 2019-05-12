package my.demo.controller;

import my.demo.entity.Student;
import my.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("view")
    public Student view(int id){
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }

    }

}
