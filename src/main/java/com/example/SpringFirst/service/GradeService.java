package com.example.SpringFirst.service;

import com.example.SpringFirst.model.Grade;

import java.util.List;

public interface GradeService {
    //Grade findByName(String name);

    void saveGrades(Grade grade);
     void deleteGradeByName(String name);
    List<Grade> getAllGrades();
    void updateGradeByName(String name,String score);


}
