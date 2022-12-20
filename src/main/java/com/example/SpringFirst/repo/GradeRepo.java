package com.example.SpringFirst.repo;

import com.example.SpringFirst.model.Grade;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class GradeRepo {
    //List<Grade> list = Arrays.asList(new Grade("Sourav", "OS", "99", "100"));

    List<Grade> list = new ArrayList<>();

    public List<Grade> getGrades(){
        System.out.println(list);
        return list;

    }

    public void saveGrades(Grade grade){
        list.add(grade);

    }

    public void deleteGrade(String name){
        for (Grade g : list) {
            if (g.getName().equalsIgnoreCase(name)) {
                list.remove(g);
            }
        }

    }

    public void updateGradebyName(String name,String score){
        for (Grade g : list) {
            if (g.getName().equalsIgnoreCase(name)) {
                g.setScore(score);
            }
        }

    }


}
