package br.com.icavallari.sebraetest.service;

import br.com.icavallari.sebraetest.model.CepModel;
import br.com.icavallari.sebraetest.repository.CepRepository;
import br.com.icavallari.sebraetest.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final CepRepository cepRepository;

    public CepModel getCep(String cep) {
        cep = cep.replace("-", "");

        if (cep.length() != 8) {
            throw new IllegalArgumentException("The Cep must contains 8 characters");
        }

        return cepRepository.getCep(cep);
    }

}
