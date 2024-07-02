package br.com.fiap.parquimetro.condutor.application.services;

import br.com.fiap.parquimetro.condutor.application.services.dto.CondutorDto;
import br.com.fiap.parquimetro.condutor.application.services.dto.VeiculoDto;
import org.springframework.stereotype.Service;

@Service
public interface CondutorService {

    long criarCondutor();

    void alterarCondutor();

    void excluirCondutor();

    CondutorDto obterCondutor(long condutorId);

    void adicionarVeiculo(VeiculoDto dto);

    void excluirVeiculo(long veiculoId);

}
