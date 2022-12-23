package br.com.banco.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.banco.main.model.DadosBancario;


public interface DadosBancariosRepository extends JpaRepository<DadosBancario, Integer> {
    
}
