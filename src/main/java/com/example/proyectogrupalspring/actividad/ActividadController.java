package com.example.proyectogrupalspring.actividad;

import com.example.proyectogrupalspring.SecurityService;
import com.example.proyectogrupalspring.alumno.Alumno;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ActividadController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private ActividadRepository actividadRepository;

    @GetMapping("/{id}")
    public String irPaginaAlumno(@PathVariable Long id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Alumno alumnoSession = (Alumno) session.getAttribute("alumno");

        if (alumnoSession != null) {
            Alumno alumno = alumnoSession;
            model.addAttribute("actividades", actividadRepository.getAllByIdAlumno(alumno));
            System.out.println(actividadRepository.getAllByIdAlumno(alumno));
            return "actividades";
        }
return "actividades";
    }

}
