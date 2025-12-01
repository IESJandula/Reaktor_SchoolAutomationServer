package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.OrdenSimpleResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.OrdenSimple;

public interface IOrdenSimpleRepository extends JpaRepository<OrdenSimple, Long>
{
    @Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.OrdenSimpleResponseDto(" +
            "o.id, o.fecha, o.frase) " +
            "FROM OrdenSimple o")
     List<OrdenSimpleResponseDto> buscarOrdenesSimples();
}
