package br.com.icavallari.sebraetest.service;

import br.com.icavallari.sebraetest.model.CepModel;
import br.com.icavallari.sebraetest.repository.CepRepository;
import br.com.icavallari.sebraetest.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CepService {

    private final CepRepository cepRepository;

    public ResponseEntity<CepModel> getCep(String cep) throws BusinessException {
        cep = cep.replace("-", "");

        if (cep.length() != 8) {
            throw new BusinessException("The Cep must contains 8 characters");
        }

        try {
            return cepRepository.getCep(cep);
        } catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
