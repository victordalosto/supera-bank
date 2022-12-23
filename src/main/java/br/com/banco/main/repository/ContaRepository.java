package br.com.banco.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.main.model.Conta;


public interface ContaRepository extends JpaRepository<Conta, Integer> {

    
}
