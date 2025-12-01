package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.ValidacionResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.Validacion;

public interface IValidacionRepository extends JpaRepository<Validacion, Long>
{

    @Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.ValidacionResponseDto(" +
           "v.id, v.score, v.resultado, v.motivoRechazo, v.orden.id) " +
           "FROM Validacion v")
    List<ValidacionResponseDto> buscarValidaciones();
}
