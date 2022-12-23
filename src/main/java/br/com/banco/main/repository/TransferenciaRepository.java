package br.com.banco.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.main.model.Transferencia;


public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    
}
