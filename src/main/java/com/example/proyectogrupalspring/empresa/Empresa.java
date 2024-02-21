package com.example.proyectogrupalspring.empresa;

import com.example.proyectogrupalspring.alumno.Alumno;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempresa ;
    private String Nombre;
    private String Email;
    private Integer Telefono;
    private String Responsable;
    private String Observaciones;

    @OneToMany(mappedBy = "Empresa",fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();


}
