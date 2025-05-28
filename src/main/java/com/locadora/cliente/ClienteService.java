package com.locadora.cliente;

import com.locadora.exception.ApiError.BadRequestException;
import com.locadora.exception.ApiError.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new BadRequestException("Cliente não pode ser nulo");
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente com id " + id + " não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        if (clienteAtualizado == null) {
            throw new BadRequestException("Dados para atualização são inválidos");
        }

        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    cliente.setContato(clienteAtualizado.getContato());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new NotFoundException("Cliente com id " + id + " não encontrado"));
    }

    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new NotFoundException("Cliente com id " + id + " não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
