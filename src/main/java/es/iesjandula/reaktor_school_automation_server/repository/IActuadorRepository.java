package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.ActuadorResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.Actuador;

public interface IActuadorRepository extends JpaRepository<Actuador, String>
{
	@Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.ActuadorResponseDto("
			+ "a.nombreDispositivo, a.estado, a.ubicacion.nombreUbicacion) " + "FROM Actuador a")
	List<ActuadorResponseDto> buscarActuadores();
}
