package es.iesjandula.reaktor_school_automation_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.reaktor_school_automation_server.dtos.SensorResponseDto;
import es.iesjandula.reaktor_school_automation_server.models.Sensor;

public interface ISensorRepository extends JpaRepository<Sensor, String>
{
    @Query("SELECT new es.iesjandula.reaktor_school_automation_server.dtos.SensorResponseDto(" +
            "s.nombreDispositivo, s.estado, s.ubicacion.nombreUbicacion, s.valorActual, s.tipoMedia) " +
            "FROM Sensor s")
     List<SensorResponseDto> buscarSensores();
}
