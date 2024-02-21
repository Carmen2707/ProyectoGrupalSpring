package com.example.proyectogrupalspring.profesor;

import com.example.proyectogrupalspring.actividad.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private ProfesorRepository profesorRepository;
}
