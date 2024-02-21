package com.example.proyectogrupalspring.alumno;

import com.example.proyectogrupalspring.SecurityService;
import com.example.proyectogrupalspring.actividad.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private AlumnoRepository alumnoRepository;
    @GetMapping("/")
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }
    @Autowired
    private SecurityService security;


    /**
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("alumnos",alumnoRepository.findAll());
        return "home";
    }**/


    @PostMapping("/post")
    public ResponseEntity<Alumno> regitrarAlumno(@RequestBody Alumno alumno, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<Alumno>(alumnoRepository.save(alumno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
