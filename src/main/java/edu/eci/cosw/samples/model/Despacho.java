package edu.eci.cosw.samples.model;
// Generated 9/10/2015 03:08:07 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Despachos generated by hbm2java
 */
@Entity
@Table(name="Despachos"
    ,catalog="cosw2"
)
public class Despacho  implements java.io.Serializable {


     private Integer idDespacho;
     private Mensajero mensajeros;
     private Pedido pedidos;
     private String estado;
     private Integer numeroPagoCoutaModeradora;
     private Integer tiempoEspera;

    public Despacho() {
    }

	
    public Despacho(Mensajero mensajeros, Pedido pedidos) {
        this.mensajeros = mensajeros;
        this.pedidos = pedidos;
    }
    public Despacho(Mensajero mensajeros, Pedido pedidos, String estado, Integer numeroPagoCoutaModeradora, Integer tiempoEspera) {
       this.mensajeros = mensajeros;
       this.pedidos = pedidos;
       this.estado = estado;
       this.numeroPagoCoutaModeradora = numeroPagoCoutaModeradora;
       this.tiempoEspera = tiempoEspera;
    }
    
    
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDespacho", unique=true, nullable=false)
    public Integer getIdDespacho() {
        return this.idDespacho;
    }
    
    public void setIdDespacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Mensajeros_idEmpleados", nullable=false)
    public Mensajero getMensajeros() {
        return this.mensajeros;
    }
    
    public void setMensajeros(Mensajero mensajeros) {
        this.mensajeros = mensajeros;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Pedidos_idPedidos", nullable=false)
    public Pedido getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    
    @Column(name="estado", length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="NumeroPagoCoutaModeradora")
    public Integer getNumeroPagoCoutaModeradora() {
        return this.numeroPagoCoutaModeradora;
    }
    
    public void setNumeroPagoCoutaModeradora(Integer numeroPagoCoutaModeradora) {
        this.numeroPagoCoutaModeradora = numeroPagoCoutaModeradora;
    }

    
    @Column(name="tiempoEspera")
    public Integer getTiempoEspera() {
        return this.tiempoEspera;
    }
    
    public void setTiempoEspera(Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }




}


