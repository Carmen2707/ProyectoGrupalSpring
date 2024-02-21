package com.example.proyectogrupalspring.alumno;

import com.example.proyectogrupalspring.actividad.Actividad;
import com.example.proyectogrupalspring.empresa.Empresa;
import com.example.proyectogrupalspring.profesor.Profesor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idalumno;
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Contrasenya;
    private String Email;

    @ManyToOne
    @JoinColumn(name = "Empresa", referencedColumnName = "idempresa")
    private Empresa Empresa;

    @ManyToOne
    @JoinColumn(name = "Tutor", referencedColumnName = "idprofesor")
    private Profesor Tutor;
    private String Observaciones;
    private Date Nacimiento;
    private Integer horasdual;
    private Integer horasfct;
    private Integer Telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "Alumno", fetch = FetchType.EAGER)
    private List<Actividad> actividad_diaria = new ArrayList<>();

}
