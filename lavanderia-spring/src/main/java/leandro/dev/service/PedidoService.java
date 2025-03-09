package leandro.dev.service;


import leandro.dev.exception.RecursoNaoEncontradoException;
import leandro.dev.model.Pedido;
import leandro.dev.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findByIdWithCliente(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado"));
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}