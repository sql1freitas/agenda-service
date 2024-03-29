package com.matheus.agenda.repository;

import com.matheus.agenda.entity.Agenda;
import com.matheus.agenda.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    public Optional<Agenda> findByHorario(LocalDateTime horario);

    public List<Agenda> findByPaciente(Paciente paciente);
}
