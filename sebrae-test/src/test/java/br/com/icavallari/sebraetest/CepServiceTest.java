package br.com.icavallari.sebraetest;

import br.com.icavallari.sebraetest.model.CepModel;
import br.com.icavallari.sebraetest.repository.CepRepository;
import br.com.icavallari.sebraetest.service.BusinessException;
import br.com.icavallari.sebraetest.service.CepService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = BaseTest.class)
public class CepServiceTest {

    private CepService service;

    @Mock
    private CepRepository cepRepositoryMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new CepService(cepRepositoryMock);
    }

    @Test
    public void mustDontHaveCepByWrongParam_getCep() {
        final BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            ResponseEntity<CepModel> records = service.getCep("1332216");
            Mockito.verify(cepRepositoryMock, Mockito.never()).getCep(Mockito.any());
        });

        Assertions.assertEquals("O CEP deve conter 8 caracteres", e.getMessage());
    }

    @Test
    public void mustFindACep_getCep() throws BusinessException {
        ResponseEntity<CepModel> founded = new ResponseEntity<CepModel>(
                new CepModel(), HttpStatus.OK
        );

        Mockito.when(cepRepositoryMock.getCep(Mockito.any())).thenReturn(founded);
        ResponseEntity<CepModel> records = service.getCep("13322161");
        Mockito.verify(cepRepositoryMock, Mockito.atLeastOnce()).getCep(Mockito.any());
    }

}
