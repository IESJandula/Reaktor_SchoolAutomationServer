package es.iesjandula.reaktor_school_automation_server.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="actuador")
public class Actuador extends Dispositivo
{
	@OneToMany(mappedBy = "actuador")
    private List<Accion> acciones;
}
