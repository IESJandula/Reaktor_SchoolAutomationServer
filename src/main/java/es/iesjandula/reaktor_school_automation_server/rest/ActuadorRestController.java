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
import es.iesjandula.reaktor_school_automation_server.dtos.ActuadorRequestDto;
import es.iesjandula.reaktor_school_automation_server.models.Actuador;
import es.iesjandula.reaktor_school_automation_server.repository.IActuadorRepository;
import es.iesjandula.reaktor_school_automation_server.utils.Constants;
import es.iesjandula.reaktor_school_automation_server.utils.SistemaVozException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/api/actuador")
@RestController
public class ActuadorRestController
{
    @Autowired
    private IActuadorRepository actuadorRepository; 
    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> crearActuador(@RequestBody(required = true) ActuadorRequestDto actuadorRequestDto) 
    {
        try 
        {
            if (actuadorRequestDto.getNombreDispositivo() == null || actuadorRequestDto.getNombreDispositivo().isEmpty()) 
            {
                log.error(Constants.ERR_ACTUADOR_NULO_VACIO);
                throw new SistemaVozException(Constants.ERR_ACTUADOR_NULO_VACIO, Constants.ERR_ACTUADOR_CODE);
            }
            if (this.actuadorRepository.existsById(actuadorRequestDto.getNombreDispositivo())) 
            {
                log.error(Constants.ERR_ACTUADOR_EXISTE);
                throw new SistemaVozException(Constants.ERR_ACTUADOR_EXISTE, Constants.ERR_ACTUADOR_CODE);
            }
            Actuador actuador = new Actuador();
            actuador.setNombreDispositivo(actuadorRequestDto.getNombreDispositivo());
            actuador.setEstado(actuadorRequestDto.getEstado());
            this.actuadorRepository.saveAndFlush(actuador);
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
    public ResponseEntity<?> obtenerActuador() 
    {
        return ResponseEntity.ok(this.actuadorRepository.buscarActuadores());
    }
    @DeleteMapping(value = "/{nombreDispositivo}")
    public ResponseEntity<?> eliminarActuador(@PathVariable String nombreDispositivo) 
    {
        try 
        {
            if (!this.actuadorRepository.existsById(nombreDispositivo)) 
            {
                log.error(Constants.ERR_ACTUADOR_NO_EXISTE);
                throw new SistemaVozException(Constants.ERR_ACTUADOR_CODE, Constants.ERR_ACTUADOR_NO_EXISTE); 
            }
            this.actuadorRepository.deleteById(nombreDispositivo);
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