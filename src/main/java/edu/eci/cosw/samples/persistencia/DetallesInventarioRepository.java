/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.persistencia;

import edu.eci.cosw.samples.model.DetalleInventario;
import edu.eci.cosw.samples.model.Medicamento;
import edu.eci.cosw.samples.model.MedicamentoPorProveedor;
import edu.eci.cosw.samples.model.Pedido;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Usuario
 */
public interface DetallesInventarioRepository extends CrudRepository<DetalleInventario, Integer>{
   
@Query("from DetalleInventario di where di.cantidad= :cantidad  ")
    public List<DetalleInventario> detallesInventarioPorCantidad(@Param("cantidad") int cantidad);

@Query("from DetalleInventario di where di.medicamentosPorProveedor.idMedicamentosProvedor= :medprov  ")
    public List<DetalleInventario> detallesInventarioProv(@Param("medprov") int medprov);
    

    
    
}


