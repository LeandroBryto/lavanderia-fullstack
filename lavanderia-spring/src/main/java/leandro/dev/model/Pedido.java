package leandro.dev.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String tipoServico;

    @ElementCollection
    private List<String> roupas;

    private LocalDate prazo;
    private String status; // "EM_ANDAMENTO", "CONCLUIDO", "ENTREGUE", "ATRASADO"
}