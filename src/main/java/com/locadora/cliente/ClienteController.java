package com.locadora.cliente;


import com.locadora.cliente.entity.Cliente;
import com.locadora.cliente.service.ClienteService;
import com.locadora.locacao.entity.Locacao;
import com.locadora.locacao.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    @Autowired
    public ClienteService clienteService;



    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);

    }
}
