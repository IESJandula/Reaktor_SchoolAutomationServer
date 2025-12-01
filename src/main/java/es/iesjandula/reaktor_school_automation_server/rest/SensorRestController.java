package es.iesjandula.reaktor_school_automation_server.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.iesjandula.reaktor_school_automation_server.dtos.SensorRequestDto;
import es.iesjandula.reaktor_school_automation_server.models.Sensor;
import es.iesjandula.reaktor_school_automation_server.repository.ISensorRepository;
import es.iesjandula.reaktor_school_automation_server.utils.Constants;
import es.iesjandula.reaktor_school_automation_server.utils.SistemaVozException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/sensor")
@RestController
public class SensorRestController
{
    @Autowired
    private ISensorRepository sensorRepository;
    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> crearSensor(@RequestBody(required = true) SensorRequestDto sensorRequestDto) 
    {
        try 
        {
            if (sensorRequestDto.getNombreDispositivo() == null || sensorRequestDto.getNombreDispositivo().isEmpty()) 
            {
                log.error(Constants.ERR_SENSOR_NULO_VACIO);
                throw new SistemaVozException(Constants.ERR_SENSOR_NULO_VACIO, Constants.ERR_SENSOR_CODE);
            }
            if (this.sensorRepository.existsById(sensorRequestDto.getNombreDispositivo())) {
                log.error(Constants.ERR_SENSOR_EXISTE);
                throw new SistemaVozException(Constants.ERR_SENSOR_EXISTE, Constants.ERR_SENSOR_CODE);
            }
            Sensor sensor = new Sensor();
            sensor.setNombreDispositivo(sensorRequestDto.getNombreDispositivo());
            sensor.setEstado(sensorRequestDto.getEstado());
            sensor.setValorActual(sensorRequestDto.getValor());
            sensor.setTipoMedia(sensorRequestDto.getTipo());
            this.sensorRepository.saveAndFlush(sensor);
            log.info(Constants.ELEMENTO_AGREGADO); 
            return ResponseEntity.ok().build();
        } 
        catch (SistemaVozException exception) 
        {
            log.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception);
        }
    }
    @GetMapping(value = "/")
    public ResponseEntity<?> obtenerSensor() 
    {
        return ResponseEntity.ok(this.sensorRepository.buscarSensores());
    }
    @DeleteMapping(value = "/{nombreDispositivo}")
    public ResponseEntity<?> eliminarSensor(@PathVariable String nombreDispositivo) 
    {
        try 
        {
            if (!this.sensorRepository.existsById(nombreDispositivo)) 
            {
                log.error(Constants.ERR_SENSOR_NO_EXISTE);
                throw new SistemaVozException(Constants.ERR_SENSOR_CODE, Constants.ERR_SENSOR_NO_EXISTE); 
            }
            this.sensorRepository.deleteById(nombreDispositivo);
            log.info(Constants.ELEMENTO_ELIMINADO);
            return ResponseEntity.ok().body(Constants.ELEMENTO_ELIMINADO);
        } 
        catch (SistemaVozException exception) 
        {
            log.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception);
        }
    }
}