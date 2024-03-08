package br.com.icavallari.sebraetest.controller;

import br.com.icavallari.sebraetest.model.CepModel;
import br.com.icavallari.sebraetest.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepModel> getCep(@PathVariable("cep") String cep){
        return cepService.getCep(cep);
    }

}
