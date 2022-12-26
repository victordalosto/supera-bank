package br.com.banco.main.repository;
import java.util.Date;
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

    
       @Query(value = "SELECT t FROM Transferencia t WHERE t.conta.idConta = :id AND UPPER(operador) LIKE %:operador%",
           countQuery = "SELECT count(*) FROM Transferencia t WHERE t.conta.idConta = :id AND UPPER(operador) LIKE %:operador%",
           nativeQuery = false)
       Page<Transferencia> buscaListaTransferenciasPorIdContaEOperador(Integer id, String operador, Pageable paginacao);

    
       @Query(value = "SELECT t FROM Transferencia t WHERE t.conta.idConta = :id AND t.dataTransferencia BETWEEN :dataInicio AND :dataFinal",
           countQuery = "SELECT count(*) FROM Transferencia t WHERE t.conta.idConta = :id AND t.dataTransferencia BETWEEN :dataInicio AND :dataFinal",
           nativeQuery = false)
       Page<Transferencia> buscaListaTransferenciasPorIdEDatas(Integer id, Date dataInicio, Date dataFinal, Pageable paginacao);

    
       @Query(value = "SELECT t FROM Transferencia t WHERE t.conta.idConta = :id AND UPPER(operador) LIKE %:operador% AND t.dataTransferencia BETWEEN :dataInicio AND :dataFinal",
           countQuery = "SELECT count(*) FROM Transferencia t WHERE t.conta.idConta = :id AND UPPER(operador) LIKE %:operador% AND t.dataTransferencia BETWEEN :dataInicio AND :dataFinal",
           nativeQuery = false)
       Page<Transferencia> buscaListaTransferenciasPorIdEOperadorEDatas(Integer id, String operador, Date dataInicio, Date dataFinal, Pageable paginacao);


    
}
