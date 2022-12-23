package br.com.banco.main.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.main.model.Transferencia;


public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query(value = "SELECT t FROM Transferencia t WHERE t.conta.idConta = :id",
           countQuery = "SELECT count(*) FROM Transferencia t WHERE t.conta.idConta = :id",
           nativeQuery = false)
    Page<Transferencia> buscaListaTransferenciasPorIdConta(Integer id, Pageable paginacao);
    
    
}
