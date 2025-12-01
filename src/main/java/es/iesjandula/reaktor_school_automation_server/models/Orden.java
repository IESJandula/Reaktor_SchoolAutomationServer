package es.iesjandula.reaktor_school_automation_server.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="orden")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Orden
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date fecha;
    
    @Column(length = 255)
    private String frase;

    @OneToMany(mappedBy = "orden")
    private List<Accion> acciones;

    @OneToMany(mappedBy = "orden")
    private List<Validacion> validaciones;
}