package leandro.dev.controller;


import jakarta.validation.Valid;
import leandro.dev.dto.PedidoDTO;
import leandro.dev.exception.RecursoNaoEncontradoException;
import leandro.dev.model.Cliente;
import leandro.dev.model.Pedido;
import leandro.dev.repository.ClienteRepository;
import leandro.dev.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return pedidoService.listarPedidos().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PedidoDTO criarPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        System.out.println("PedidoDTO recebido: " + pedidoDTO); // Log para depuração
        Pedido pedido = converterParaEntidade(pedidoDTO);
        System.out.println("Pedido convertido: " + pedido); // Log para depuração
        Pedido pedidoSalvo = pedidoService.criarPedido(pedido);
        return converterParaDTO(pedidoSalvo);
    }


    @GetMapping("/{id}")
    public PedidoDTO buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        return converterParaDTO(pedido);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizarPedido(@PathVariable Long id, @Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoExistente = pedidoService.buscarPedidoPorId(id);

        if (pedidoExistente == null) {
            throw new RecursoNaoEncontradoException("Pedido não encontrado com ID: " + id);
        }

        pedidoExistente.setTipoServico(pedidoDTO.tipoServico());
        pedidoExistente.setRoupas(pedidoDTO.roupas());
        pedidoExistente.setPrazo(pedidoDTO.prazo());
        pedidoExistente.setStatus(pedidoDTO.status());

        Cliente cliente = clienteRepository.findByNome(pedidoDTO.clienteNome())
                .orElseGet(() -> {
                    Cliente novoCliente = new Cliente();
                    novoCliente.setNome(pedidoDTO.clienteNome());
                    return clienteRepository.save(novoCliente);
                });

        pedidoExistente.setCliente(cliente);

        Pedido pedidoAtualizado = pedidoService.atualizarPedido(pedidoExistente);
        return converterParaDTO(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }

    private PedidoDTO converterParaDTO(Pedido pedido) {
        System.out.println("Pedido convertido para DTO: " + pedido); // Log para depuração
        if (pedido.getCliente() == null) {
            throw new IllegalStateException("Cliente não pode ser nulo");
        }
        return new PedidoDTO(
                pedido.getId(),
                pedido.getCliente().getNome(),
                pedido.getTipoServico(),
                pedido.getRoupas(),
                pedido.getPrazo(),
                pedido.getStatus()
        );
    }

    private Pedido converterParaEntidade(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setTipoServico(pedidoDTO.tipoServico());
        pedido.setRoupas(pedidoDTO.roupas());
        pedido.setPrazo(pedidoDTO.prazo());
        pedido.setStatus(pedidoDTO.status());

        // Busca ou cria o cliente com base no nome
        Cliente cliente = clienteRepository.findByNome(pedidoDTO.clienteNome())
                .orElseGet(() -> {
                    Cliente novoCliente = new Cliente();
                    novoCliente.setNome(pedidoDTO.clienteNome());
                    return clienteRepository.save(novoCliente);
                });

        pedido.setCliente(cliente);
        return pedido;
    }
}