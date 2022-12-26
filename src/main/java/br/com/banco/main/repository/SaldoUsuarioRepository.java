package br.com.banco.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.main.model.Saldo;


public interface SaldoUsuarioRepository extends JpaRepository<Saldo, Integer>{
    
}
