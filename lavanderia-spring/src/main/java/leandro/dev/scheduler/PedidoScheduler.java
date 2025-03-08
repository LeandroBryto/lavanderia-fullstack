package leandro.dev.scheduler;



import leandro.dev.model.Pedido;
import leandro.dev.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PedidoScheduler {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Executa a cada minuto (para testes)
    @Scheduled(fixedRate = 60000) // 60000 ms = 1 minuto
    public void verificarPedidosAtrasados() {
        LocalDate hoje = LocalDate.now();
        List<Pedido> pedidosAtrasados = pedidoRepository.findByPrazoBeforeAndStatusNot(hoje, "ENTREGUE");

        for (Pedido pedido : pedidosAtrasados) {
            pedido.setStatus("ATRASADO");
            pedidoRepository.save(pedido);
            System.out.println("Pedido atrasado atualizado: " + pedido.getId());
        }
    }
}