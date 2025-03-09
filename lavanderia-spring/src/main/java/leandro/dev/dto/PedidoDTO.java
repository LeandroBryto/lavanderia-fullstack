package leandro.dev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.List;

public record PedidoDTO(
        Long id,
        String clienteNome,
        String tipoServico,
        List<String> roupas,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Alterado para yyyy-MM-dd
        LocalDate prazo,
        String status
) {
}