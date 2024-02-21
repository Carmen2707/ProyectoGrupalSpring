package com.example.proyectogrupalspring.profesor;

import com.example.proyectogrupalspring.alumno.Alumno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprofesor;

    private String Nombre;
    private String Apellidos;
    private String Contrasenya;
    private String Email;

    @JsonIgnore
    @OneToMany(mappedBy = "Tutor", fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();
}
