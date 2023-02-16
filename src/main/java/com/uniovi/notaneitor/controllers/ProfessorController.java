package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/details/{dni}")
    public String getDetail(Model model, @PathVariable String dni) {
        model.addAttribute("professor", professorService.getProffesor(dni));
        return "professor/details";
    }
    @RequestMapping("/professor/delete/{dni}")
    public String deleteProffesor(@PathVariable String dni) {
        professorService.deleteProffesor(dni);
        return "redirect:/professor/list";
    }
    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("professors", professorService.getProffesors());
        return "professor/list";
    }
    @RequestMapping(value = "/professor/add/", method=RequestMethod.POST)
    public String setProffesor(@ModelAttribute Professor professor) {
        professorService.addProffesor(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping(value="/professor/add")
    public String getProfessor() {
        return "professor/add";
    }
}
