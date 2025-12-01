package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.OrdenProgramadaResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.OrdenProgramada;

public interface IOrdenProgramadaRepository extends JpaRepository<OrdenProgramada, Long>
{
    @Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.OrdenProgramadaResponseDto(" +
            "o.id, o.fecha, o.frase, o.fechaProgramada, o.repeticion) " +
            "FROM OrdenProgramada o")
     List<OrdenProgramadaResponseDto> buscarOrdenesProgramadas();
}
