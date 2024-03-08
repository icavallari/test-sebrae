package br.com.icavallari.sebraetest.repository;

import br.com.icavallari.sebraetest.model.CepModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cepApi", url = "https://viacep.com.br/ws/")
public interface CepRepository {

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json/")
    CepModel getCep(@PathVariable("cep") String cep);

}
