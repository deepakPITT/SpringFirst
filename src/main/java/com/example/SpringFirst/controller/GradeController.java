package com.example.SpringFirst.controller;

import com.example.SpringFirst.model.Grade;
import com.example.SpringFirst.repo.GradeRepo;
import com.example.SpringFirst.service.GradeService;
import com.example.SpringFirst.service.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GradeController {

    //GradeService service= new GradeServiceImpl();

    @Autowired
    GradeService service;

//    @Autowired
//    GradeRepo repo;
//    List<Grade> grades = new ArrayList<>();

    @GetMapping("/grades")
    public ResponseEntity<Grade> getGrades() {
        return new ResponseEntity(service.getAllGrades(),HttpStatus.OK);
    }


   @PostMapping("/grades")
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Grade> createGrade(@Valid @RequestBody Grade grade) {
       service.saveGrades(grade);
       return new ResponseEntity("Success",HttpStatus.CREATED);
    }

    @PutMapping("/grades/{name}/{score}")
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Grade> updateGradeByName(@PathVariable String name ,@PathVariable String score) {
        service.updateGradeByName(name,score);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }


   @DeleteMapping("/grades/{name}")
    public void  delGradesByName(@PathVariable String name) {
        service.deleteGradeByName(name);
        return;
    }


//    @GetMapping("/grades/{name}")
//    public Grade getGradesByName(@PathVariable String name) {
//        Grade grade = service.findByName(name);
//        return grade;
//    }



//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
