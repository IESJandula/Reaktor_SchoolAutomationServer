package es.iesjandula.reaktor_school_automation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.reaktor_school_automation_server.models.Orden;

public interface IOrdenRepository extends JpaRepository<Orden, Long>
{

}
