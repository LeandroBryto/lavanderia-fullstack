package leandro.dev.dto;


public record ClienteDTO(
        Long id,
        String nome,
        String email,
        String telefone
) {}