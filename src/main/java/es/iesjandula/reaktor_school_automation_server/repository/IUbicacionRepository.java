package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.UbicacionResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.Ubicacion;

public interface IUbicacionRepository extends JpaRepository<Ubicacion, String>
{
	@Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.UbicacionResponseDto(u.nombreUbicacion) "
			+ "FROM Ubicacion u")
	List<UbicacionResponseDto> buscarUbicaciones();
}
