package leandro.dev.dto;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(
        Long id,
        String clienteNome, // Nome do cliente (não o objeto Cliente completo)
        String tipoServico,
        List<String> roupas,
        @FutureOrPresent(message = "O prazo deve ser uma data futura ou igual à data atual")
        LocalDate prazo,
        String status
) {}