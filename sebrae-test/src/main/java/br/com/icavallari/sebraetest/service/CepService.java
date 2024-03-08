package br.com.icavallari.sebraetest.service;

import br.com.icavallari.sebraetest.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final ContaRepository contaRepository;


}
