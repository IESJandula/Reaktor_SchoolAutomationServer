package es.iesjandula.reaktor_school_automation_server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="validacion")
public class Validacion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private Integer score; 
    
    @Column(length = 50, nullable = false)
    private String resultado; 

    @Column(length = 255)
    private String motivoRechazo;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}