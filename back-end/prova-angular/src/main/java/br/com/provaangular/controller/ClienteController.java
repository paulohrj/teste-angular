package br.com.provaangular.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provaangular.domain.Cliente;
import br.com.provaangular.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") UUID id) {
        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
