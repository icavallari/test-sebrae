package br.com.icavallari.sebraetest;

import br.com.icavallari.sebraetest.model.Conta;
import br.com.icavallari.sebraetest.model.ContaDTO;
import br.com.icavallari.sebraetest.repository.ContaRepository;
import br.com.icavallari.sebraetest.service.BusinessException;
import br.com.icavallari.sebraetest.service.ContaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = BaseTest.class)
public class ContaServiceTest {

    private ContaService service;

    @Mock
    private ContaRepository contaRepositoryMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new ContaService(contaRepositoryMock);
    }

    @Test
    public void mustFindAllConta() {
        Mockito.when(contaRepositoryMock.findAll()).thenReturn(null);
        List<Conta> records = service.findAll();
        Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).findAll();
    }

    @Test
    public void mustHaveNoItemFounded_findById() {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            Integer findBy = 3;
            Optional<Conta> founded = Optional.empty();

            Mockito.when(contaRepositoryMock.findById(findBy)).thenReturn(founded);
            Conta records = service.findById(findBy);
            Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).findById(findBy);
        });

        Assertions.assertEquals("Conta não encontrada", e.getMessage());
    }

    @Test
    public void mustHaveItemFounded_findById() throws BusinessException {
        Integer findBy = 3;
        Optional<Conta> founded = Optional.of(new Conta());

        Mockito.when(contaRepositoryMock.findById(findBy)).thenReturn(founded);
        Conta records = service.findById(findBy);
        Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).findById(findBy);

        Assertions.assertTrue(records != null);
    }

    @Test
    public void mustDontHaveCreateItemWhenNoNome_create() throws BusinessException {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            ContaDTO dto = new ContaDTO(1, null, "descrição");

            Conta records = service.create(dto);
            Mockito.verify(contaRepositoryMock, Mockito.never()).save(Mockito.any());
        });

        Assertions.assertEquals("O nome deve ser informado", e.getMessage());
    }

    @Test
    public void mustDontHaveCreateItemWhenNoDescricao_create() throws BusinessException {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            ContaDTO dto = new ContaDTO(1, "nome", null);

            Conta records = service.create(dto);
            Mockito.verify(contaRepositoryMock, Mockito.never()).save(Mockito.any());
        });

        Assertions.assertEquals("A descrição deve ser informada", e.getMessage());
    }

    @Test
    public void mustHaveCreateItem_create() throws BusinessException {
        ContaDTO dto = new ContaDTO(1, "nome", "descricao");

        Conta records = service.create(dto);
        Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).save(Mockito.any());

        Assertions.assertTrue(records != null);
    }

    @Test
    public void mustDontHaveUpdatedItemWhenNoNome_update() throws BusinessException {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            ContaDTO dto = new ContaDTO(1, null, "descrição");

            Conta records = service.update(dto);
            Mockito.verify(contaRepositoryMock, Mockito.never()).save(Mockito.any());
        });

        Assertions.assertEquals("O nome deve ser informado", e.getMessage());
    }

    @Test
    public void mustDontHaveUpdatedItemWhenNoDescricao_update() throws BusinessException {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            ContaDTO dto = new ContaDTO(1, "nome", null);

            Conta records = service.update(dto);
            Mockito.verify(contaRepositoryMock, Mockito.never()).save(Mockito.any());
        });

        Assertions.assertEquals("A descrição deve ser informada", e.getMessage());
    }

    @Test
    public void mustHaveCreateItem_update() throws BusinessException {
        ContaDTO dto = new ContaDTO(1, "nome", "descricao");
        Optional<Conta> founded = Optional.of(new Conta());

        Mockito.when(contaRepositoryMock.findById(Mockito.anyInt())).thenReturn(founded);
        Mockito.when(contaRepositoryMock.save(Mockito.any())).thenReturn(new Conta());

        Conta records = service.update(dto);
        Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).save(Mockito.any());

        Assertions.assertTrue(records != null);
    }

    @Test
    public void mustDontDeleteItemWhenNoDescricao_delete() throws BusinessException {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {

            Mockito.when(contaRepositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.empty());
            Conta records = service.delete(1);
            Mockito.verify(contaRepositoryMock, Mockito.never()).delete(Mockito.any());
        });

        Assertions.assertEquals("Conta não encontrada", e.getMessage());
    }

    @Test
    public void mustDeleteItemWhenNoDescricao_delete() throws BusinessException {

        Mockito.when(contaRepositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(new Conta()));
        Conta records = service.delete(1);
        Mockito.verify(contaRepositoryMock, Mockito.atLeastOnce()).delete(Mockito.any());

        Assertions.assertTrue(records != null);
    }

}
