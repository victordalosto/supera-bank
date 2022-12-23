package br.com.banco.main.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.main.model.Transferencia;


public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query("SELECT t from Transferencia t where t.conta.idConta = :id")
    List<Transferencia> buscaListaTransferenciasPorIdConta(Integer id);
    
    
}
