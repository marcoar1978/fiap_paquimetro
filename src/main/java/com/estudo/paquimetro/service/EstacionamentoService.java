package com.estudo.paquimetro.service;

import com.estudo.paquimetro.domain.dto.CheckInEstacionamentoDto;
import com.estudo.paquimetro.domain.model.CheckInEstacionamento;
import com.estudo.paquimetro.domain.repository.CheckInEstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EstacionamentoService {

    @Autowired
    CheckInEstacionamentoRepository repository;


     public CheckInEstacionamentoDto checkIn(CheckInEstacionamentoDto dto){
         CheckInEstacionamento checkInEstacionamento = new CheckInEstacionamento();
         checkInEstacionamento.setPlaca(dto.getPlaca());

         LocalDateTime momentoEntrada = LocalDateTime.now();
         checkInEstacionamento.setEntrada(momentoEntrada);
         checkInEstacionamento.setSaida(momentoEntrada.plusHours(dto.getQdeHoras()));
         checkInEstacionamento.setHoras(dto.getQdeHoras());

         return new CheckInEstacionamentoDto(repository.save(checkInEstacionamento));

     }

}
