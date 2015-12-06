
package edu.eci.cosw.samples.persistencia;


import edu.eci.cosw.samples.model.Despacho;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Usuario
 */
public interface DespachoRepository extends CrudRepository<Despacho, Integer>{
    @Query("from Despacho a where a.idDespacho= :ln")
    public Despacho search(@Param("ln") int searchTerm);
    
     @Query("from Despacho a")
    public List<Despacho> getDespachos();
    
    //   Prueba de Subida
    
    @Query("from Despacho a where a.pedidos.pacientes.idPacientes= :ln")
    public List<Despacho> DespachoPorPaciente (@Param("ln")Integer id );

}
