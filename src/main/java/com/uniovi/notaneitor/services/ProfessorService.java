package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {
    private List<Professor> professors = new LinkedList<>();
    @PostConstruct
    public void init(){
        professors.add(new Professor("1", "Alejandro", "Campa", "SDI"));
        professors.add(new Professor("2", "Dani", "Uria", "DLP"));
    }


    public Professor getProffesor(String dni) {
        return professors.stream().filter(professor -> professor.getDni().equals(dni)).findFirst().get();
    }

    public void deleteProffesor(String dni) {
        professors.removeIf(professor -> professor.getDni().equals(dni));
    }

    public List<Professor> getProffesors() {
        return professors;
    }

    public void addProffesor(Professor professor) {
        if (professor.getDni() == null) {
            professor.setDni(professors.get(professors.size() - 1).getDni() + 1);
        }
        professors.add(professor);
    }
}
