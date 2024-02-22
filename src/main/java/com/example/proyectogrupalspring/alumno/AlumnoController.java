package com.example.proyectogrupalspring.alumno;

import com.example.proyectogrupalspring.SecurityService;
import com.example.proyectogrupalspring.actividad.ActividadRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AlumnoController {
    @Autowired //inicializar los componentes de sprint de forma automatica
    private AlumnoRepository alumnoRepository;



    /**
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("alumnos",alumnoRepository.findAll());
        return "home";
    }**/



    @GetMapping("/login")
    public String verificarAlumno(@ModelAttribute Alumno alumno, HttpServletRequest request){
        Alumno alumno1= alumnoRepository.getAlumnoByEmail(alumno.getEmail());
        if(alumnoRepository.existsAlumnoByEmail(alumno.getEmail())){

            if(alumno1.getContrasenya().equals(alumno.getContrasenya())){
                HttpSession s=request.getSession();
                s.setAttribute("alumno",alumno1);
                return "redirect:/"+ alumno1.getIdalumno();
            }else{
                return "Usuario o contraseña incorrecto";
            }
        }else{
            return "Usuario o contraseña incorrecto";
        }
    }


}
