/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.restcontrollers;

import edu.eci.cosw.samples.logica.Clase;
import edu.eci.cosw.samples.model.DetallePedido;
import edu.eci.cosw.samples.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2088395
 */

@RestController
@RequestMapping("/pedidos")
public class ManejadorPedidos {
    @Autowired
    Clase c;

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
     public Pedido consped(@PathVariable int id) throws OperationFailedException{
        
         Pedido p= c.consultarPedidoId(id);
        
        
        
        
        if(p==null){
            throw new OperationFailedException();
        }
        return p;
     }
     
     @RequestMapping(method = RequestMethod.GET)        
    public List<Pedido> allPedidos() {        
        List<Pedido> p=new ArrayList<Pedido>();
        p=(List<Pedido>) c.consultarPedidos();
        return p;
    }
    
    @RequestMapping(method = RequestMethod.POST)        
    public ResponseEntity<?> addPedido(@RequestBody Pedido p) {       
        c.addNewPedido(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value="/detalle/{id}",method = RequestMethod.GET)
       
    public List<DetallePedido> DetallePedidos(@PathVariable int id) {  
        
        List<DetallePedido> p=new ArrayList<DetallePedido>();
        p= c.ConsultarDetallePedido(id);
        
        return p;
    }
}
