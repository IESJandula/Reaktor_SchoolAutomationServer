package es.iesjandula.reaktor_school_automation_server.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorBooleanoRequestDto
{
	private String mac;
	private Long ultimaActualizacion;
	private Double valorActual;
}
