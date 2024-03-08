package br.com.icavallari.sebraetest.service;

import br.com.icavallari.sebraetest.model.Conta;
import br.com.icavallari.sebraetest.model.ContaDTO;
import br.com.icavallari.sebraetest.repository.ContaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Conta findById(Integer id) throws Exception {
        return findContaById(id);
    }

    public Conta create(ContaDTO dto){
        Conta conta = new Conta();
        conta.setNome(dto.nome());
        conta.setDescricao(dto.descricao());

        // TODO implementar validacoes
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta update(ContaDTO dto) throws Exception {
        Conta conta = findContaById(dto.id());
        conta.setDescricao(dto.descricao());
        conta.setNome(dto.nome());
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta delete(Integer id) throws Exception {
        Conta conta = findContaById(id);
        contaRepository.delete(conta);
        return conta;
    }

    private Conta findContaById(Integer id) throws Exception {
        return contaRepository.findById(id).orElseThrow(() -> new Exception("Conta not found"));
    }

}
