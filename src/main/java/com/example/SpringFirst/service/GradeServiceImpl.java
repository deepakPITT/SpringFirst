package com.example.SpringFirst.service;

import com.example.SpringFirst.model.Grade;
import com.example.SpringFirst.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepo repo;

//    @Override
//    public Grade findByName(String name) {
//        for (Grade g : repo.getGradeList()) {
//            if (g.getName().equalsIgnoreCase(name)) {
//                return g;
//            }
//        }
//
//        return null;
//    }

    @Override
    public void saveGrades(Grade grade) {
        repo.saveGrades(grade);
    }

    @Override
    public void deleteGradeByName(String name) {
        repo.deleteGrade(name);
    }

    @Override
    public List<Grade> getAllGrades() {
        return repo.getGrades();
    }

    @Override
    public void updateGradeByName(String name,String score) {
         repo.updateGradebyName(name,score);
    }
}
