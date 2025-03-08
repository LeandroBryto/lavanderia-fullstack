package leandro.dev.repository;



import leandro.dev.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id")
    Optional<Pedido> findByIdWithCliente(@Param("id") Long id);
    List<Pedido> findByPrazoBeforeAndStatusNot(LocalDate prazo, String status);
}
