package br.com.icavallari.sebraetest.controller;

import br.com.icavallari.sebraetest.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

}
