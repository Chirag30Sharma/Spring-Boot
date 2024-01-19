package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    private List<Student> students = new ArrayList<>(); 

    @GetMapping("/world")
    public String get() {
        return "<b>Hello World</b>";
    }

    @GetMapping("/{name}")
    public String getURL(@PathVariable String name) {
        return name;
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        if (students.isEmpty()) {
            students.add(new Student("Computer", "Network"));
            students.add(new Student("Spring", "Boot"));
            students.add(new Student("Operating", "System"));
        }
        return students;
    }

    @PostMapping("/insert")
    public List<Student> insertStudents(@RequestBody Student student) {
        students.add(student);
        return students;
    }

    @DeleteMapping("/delete/{firstName}/{lastName}")
    public List<Student> deleteStudent(@PathVariable String firstName, @PathVariable String lastName) {
        // students.remove(0); To delete the first element of the List.
        students.removeIf(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName));
        return students;
    }
}
