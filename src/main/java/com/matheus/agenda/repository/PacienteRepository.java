package com.matheus.agenda.repository;

import com.matheus.agenda.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByCpfIgnoreCase(String cpf);
    Optional<Paciente> findByEmailIgnoreCase(String email);


}
