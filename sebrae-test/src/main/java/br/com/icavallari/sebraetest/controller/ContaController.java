package br.com.icavallari.sebraetest.controller;

import br.com.icavallari.sebraetest.model.Conta;
import br.com.icavallari.sebraetest.model.ContaDTO;
import br.com.icavallari.sebraetest.repository.ContaRepository;
import br.com.icavallari.sebraetest.service.ContaService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @GetMapping("/all")
    public ResponseEntity<List<Conta>> getAll() {
        return ResponseEntity.ok(contaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(contaService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Conta> create(@RequestBody ContaDTO conta) {
        return ResponseEntity.ok(contaService.create(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@RequestBody ContaDTO conta) {
        try {
            return ResponseEntity.ok(contaService.update(conta));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(contaService.delete(id));
    }

}
