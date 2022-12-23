package br.com.banco.main.repository;
import br.com.banco.main.model.DadosBancario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DadosBancariosRepository extends JpaRepository<DadosBancario, Integer> {
    
}
