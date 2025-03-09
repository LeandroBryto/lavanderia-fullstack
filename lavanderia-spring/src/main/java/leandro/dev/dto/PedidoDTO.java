package leandro.dev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(
        Long id,
        String clienteNome, // Nome do cliente (não o objeto Cliente completo)
        String tipoServico,
        List<String> roupas,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate prazo,
        String status
) {
}