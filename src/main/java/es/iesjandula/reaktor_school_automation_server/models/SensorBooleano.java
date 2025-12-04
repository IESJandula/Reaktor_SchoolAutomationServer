package es.iesjandula.reaktor_school_automation_server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "field")
public class SensorBooleano extends Sensor
{
	@Column(nullable = false)
	private Boolean valorActual;

}
