package com.example.proyectogrupalspring.actividad;

import com.example.proyectogrupalspring.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actividad")
public class ActividadController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private ActividadRepository actividadRepository;

    @Autowired
    private SecurityService security;
    @PostMapping("/post")
    public ResponseEntity<Actividad> añadirActividad(@RequestBody Actividad actividad, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<Actividad>(actividadRepository.save(actividad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
