package com.example.proyectogrupalspring.actividad;


import com.example.proyectogrupalspring.alumno.Alumno;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idactividad;
    private Date Fecha;
    private Tips Tipo;
    private Integer Horas;
    private String Actividad;
    private String Observacion;
    @ManyToOne
    @JoinColumn(name = "Alumno", referencedColumnName = "idalumno")
    private Alumno Alumno;
}
