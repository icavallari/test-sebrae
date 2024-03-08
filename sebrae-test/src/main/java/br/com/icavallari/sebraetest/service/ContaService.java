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

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta findById(Integer id) throws BusinessException {
        return findContaById(id);
    }

    public Conta create(ContaDTO dto) throws BusinessException {
        validateFields(dto);

        Conta conta = new Conta();
        conta.setNome(dto.nome());
        conta.setDescricao(dto.descricao());

        return contaRepository.save(conta);
    }

    @Transactional
    public Conta update(ContaDTO dto) throws BusinessException {
        validateFields(dto);

        Conta conta = findContaById(dto.id());
        conta.setDescricao(dto.descricao());
        conta.setNome(dto.nome());
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta delete(Integer id) throws BusinessException {
        Conta conta = findContaById(id);
        contaRepository.delete(conta);
        return conta;
    }

    private void validateFields(ContaDTO dto) throws BusinessException {
        if ("".equals(dto.nome()) || dto.nome() == null) {
            throw new BusinessException("O nome deve ser informado");
        } else if ("".equals(dto.descricao()) || dto.descricao() == null) {
            throw new BusinessException("A descrição deve ser informada");
        }
    }

    private Conta findContaById(Integer id) throws BusinessException {
        return contaRepository.findById(id).orElseThrow(() -> new BusinessException("Conta não encontrada"));
    }

}
