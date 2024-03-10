package br.com.icavallari.sebraetest.controller;

import br.com.icavallari.sebraetest.model.Conta;
import br.com.icavallari.sebraetest.model.ContaDTO;
import br.com.icavallari.sebraetest.service.BusinessException;
import br.com.icavallari.sebraetest.service.ContaService;
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
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(contaService.findById(id));
        } catch (BusinessException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ContaDTO conta) {
        try {
            return ResponseEntity.ok(contaService.create(conta));
        } catch (BusinessException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ContaDTO conta) {
        try {
            return ResponseEntity.ok(contaService.update(conta));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(contaService.delete(id));
        } catch (BusinessException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
