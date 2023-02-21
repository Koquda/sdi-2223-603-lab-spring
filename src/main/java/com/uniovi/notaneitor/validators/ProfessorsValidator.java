package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProfessorsValidator  implements Validator {

    @Autowired
    private ProfessorService professorService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Professor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        if (!(professor.getDni().length() == 9 && Character.isLetter(professor.getDni().charAt(professor.getDni().length())))) {
            errors.rejectValue("dni", "Error.dni.value");
        }
        professorService.getProffesors().stream().forEach(prof -> {
            if (prof.getDni().equals(professor.getDni()))
                errors.rejectValue("dni", "Error.dni.notUnique");
        });
    }
}
