package com.uniovi.notaineitor.controllers;

import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/details/{dni}")
    public String getDetail(@PathVariable String dni) {
        Professor professor = professorService.getProffesor(dni);
        return professor.toString();
    }
    @RequestMapping("/professor/delete/{dni}")
    public String deleteProffesor(@PathVariable String dni) {
        professorService.deleteProffesor(dni);
        return "Ok";
    }
    @RequestMapping("/professor/list")
    public String getList() {
        return professorService.getProffesors().toString();
    }
    @RequestMapping(value = "/professor/add/", method=RequestMethod.POST)
    public String setProffesor(@ModelAttribute Professor professor) {
        professorService.addProffesor(professor);
        return professor.toString();
    }
}
