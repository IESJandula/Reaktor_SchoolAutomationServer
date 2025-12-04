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
@Table(name="sensor_numerico")
public class SensorNumerico extends Sensor
{
	@Column
	private Double umbralMinimo;
	@Column
	private Double umbralMaximo;
	@Column
	private Double valorActual;
	
	
}
