/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.logica;

import edu.eci.cosw.samples.model.Autorizacion;
import edu.eci.cosw.samples.model.Cotizacion;
import edu.eci.cosw.samples.model.Despacho;
import edu.eci.cosw.samples.model.DetalleInventario;
import edu.eci.cosw.samples.model.DetalleOrdenCompra;
import edu.eci.cosw.samples.model.DetallePedido;
import edu.eci.cosw.samples.model.Epsafilida;
import edu.eci.cosw.samples.model.Inventario;
import edu.eci.cosw.samples.model.Medicamento;
import edu.eci.cosw.samples.model.MedicamentoPorProveedor;
import edu.eci.cosw.samples.model.Mensajero;
import edu.eci.cosw.samples.model.OrdenCompra;
import edu.eci.cosw.samples.model.Paciente;
import edu.eci.cosw.samples.model.Pedido;
import edu.eci.cosw.samples.model.Proveedor;
import edu.eci.cosw.samples.persistencia.AutorizacionRepository;
import edu.eci.cosw.samples.persistencia.CotizacionesRepository;
import edu.eci.cosw.samples.persistencia.DespachoRepository;
import edu.eci.cosw.samples.persistencia.DetallePedidoRepository;
import edu.eci.cosw.samples.persistencia.DetallesInventarioRepository;
import edu.eci.cosw.samples.persistencia.DetallesOrdenesCompraRepository;
import edu.eci.cosw.samples.persistencia.EpsafilidaRepository;
import edu.eci.cosw.samples.persistencia.InventarioRepository;
import edu.eci.cosw.samples.persistencia.MedicamentoPPRepository;
import edu.eci.cosw.samples.persistencia.MedicamentoRepository;
import edu.eci.cosw.samples.persistencia.MensajeroRepository;
import edu.eci.cosw.samples.persistencia.OrdenesCompraRepository;
import edu.eci.cosw.samples.persistencia.PacientesRepository;
import edu.eci.cosw.samples.persistencia.PedidosRepository;
import edu.eci.cosw.samples.persistencia.ProveedoresRepository;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2088395
 */
@Service
public class Clase {

    @Autowired
    PedidosRepository pr;
    
    @Autowired
    MedicamentoPPRepository mppr;
    
      
    @Autowired
    MedicamentoRepository mr;
    
    @Autowired
    PacientesRepository par;
    
     @Autowired
    DetallePedidoRepository dpr;
    
    @Autowired
    EpsafilidaRepository epsr;
    
    @Autowired
    AutorizacionRepository ar;
    
    @Autowired
    MensajeroRepository menr;
    
    @Autowired
    DetallesInventarioRepository dir;
    
    @Autowired
    CotizacionesRepository cr;
    
    @Autowired
    ProveedoresRepository prr;
    
    @Autowired
    OrdenesCompraRepository ocr;
    
    @Autowired
    DetallesOrdenesCompraRepository docr;
    
    @Autowired
    InventarioRepository invr;
    
    @Autowired
    DespachoRepository des;
    
    public DetalleOrdenCompra consultarOrden (int id) {
    
        DetalleOrdenCompra p = docr.findOne(id);
        return p;
    }
    
    public Pedido consultarPedidoId (int id) {
    
        Pedido p = pr.search2(id);
        return p;
    }
    
    public Iterable<DetalleOrdenCompra> consultarOrdenes(){
        
        Iterable<DetalleOrdenCompra> p = docr.findAll();
        return p;
    }
       
    public Iterable<Pedido> consultarPedido(int id) {
        Iterable<Pedido> p= pr.search(id);
        return p;
    }

    public Iterable<Pedido> consultarPedidos() {
        Iterable<Pedido> p = pr.findAll();
        return p;
    }
    
    public List<DetallePedido> ConsultarDetallePedido(int id){
    
        List<DetallePedido> p = dpr.search(id);
        return p;
    
    }

    public MedicamentoPorProveedor consultarMedicamentoPP(int id) {
        MedicamentoPorProveedor mp=mppr.findOne(id);
        return mp;
    }

    public Iterable<MedicamentoPorProveedor> consultarMedicamentosPP() {
        Iterable<MedicamentoPorProveedor> mp = mppr.findAll();
        return mp;
    }

    public Medicamento consultarMedicamento(int id) {
        Medicamento m= mr.findOne(id);
        return m;
    }
    
    public Iterable<Medicamento> consultarMedicamentos() {
        Iterable<Medicamento> mp = mr.findAll();
        return mp;
    }

    public Paciente consultarPaciente(int id) {
        Paciente p=par.findOne(id);
        return p;
    }
    
    public Iterable<Paciente> consultarPacientes() {
        Iterable<Paciente> p = par.findAll();
        return p;
    }

    public Epsafilida consultarEpsafilida(int id) {
        Epsafilida eps=epsr.findOne(id);
        return eps;
    }
    
    public Iterable<Epsafilida> consultarEpsafilidas() {
        Iterable<Epsafilida> eps = epsr.findAll();
        return eps;
    }
    
    public Autorizacion consultarAutorizacion(int id) {
        Autorizacion au=ar.findOne(id);
        return au;
    }
    
    public Iterable<Autorizacion> consultarAutorizaciones() {
        Iterable<Autorizacion> au = ar.findAll();
        return au;
    }

    
    public void addNewPedido(Pedido p) {
        pr.save(p);
    }
    
    public Iterable<Despacho> consultarDespachos(){
        
        Iterable<Despacho> p = des.findAll();
        return p;
    }
    
    

  /*========================================================================
                              AUTORIZACION - DESPACHO
    ========================================================================*/
    @Transactional
    public void guardarAutorizacion(Autorizacion v){
        ar.save(v);
    }
    
    public List<Autorizacion> TodasAutorizaciones(){
        return ar.getAutorizaciones();
    }
    
    public List<Medicamento> TodosMedicamentos(){
        return mr.getMedicamentos();
    }
    
    public List<Autorizacion> ConsultarAutorizacionPaciente(int id){
        return ar.AutorizacionPorPaciente(id);
    }
    
    public List<Despacho> ConsultarDespachoPaciente(int id){
        return des.DespachoPorPaciente(id);
    }
    
     public List<Despacho> TodasDespacho(){
        return des.getDespachos();
    }
    
    /*========================================================================
                              ORDEN DE COMPRA
    ========================================================================*/
    public Mensajero consultarEmpleado(int id) {
        Mensajero p=menr.findOne(id);
        return p;
    }
    
    public Iterable<Mensajero> consultarEmpleados() {
        Iterable<Mensajero> p = menr.findAll();
        return p;
    }
    
     
    public Iterable<DetalleInventario> consultarDetalleInventario() {
        Iterable<DetalleInventario> di = dir.findAll();
        return di;
    }
    
     public Iterable<DetalleInventario> cargarDetalleInventarioPorCantidad(int cantidad)
     {
     Iterable<DetalleInventario> di = dir.detallesInventarioPorCantidad(cantidad);
        return di;
     }
     
     public Iterable<DetalleInventario> cargarDetalleInventarioProv(int prov){
         Iterable<DetalleInventario> pro = dir.detallesInventarioProv(prov);
         return pro;
     }
    
    public void addNewCotizacion(Cotizacion c) {
        cr.save(c);
    }
    
    public void addMedPP(DetalleInventario p){
    
      
        dir.save(p);
    
    
    }
    
      public void adddespacho(Despacho p){
    
      
        des.save(p);
    
    
    }
    
    
    
     public Iterable<Cotizacion> consultarCotizaciones() {
        Iterable<Cotizacion> ctz = cr.findAll();
        return ctz;
    }
    
     public Iterable<Proveedor> consultarProveedores() {
        Iterable<Proveedor> prs = prr.findAll();
        return prs;
    }
     
     public Proveedor consultarProveedorPOrId(int id) {
        Proveedor p=prr.findOne(id);
        return p;
    }
     public Cotizacion consultarCotizacionPorId(int id) {
        Cotizacion c=cr.findOne(id);
        return c;
    }
     
     public Iterable<OrdenCompra> consultarOrdenesCompra() { 
         Iterable<OrdenCompra> oc = ocr.findAll();
        return oc;
    }
     
     public OrdenCompra consultarOrdenCompraPorId(int id) {
        OrdenCompra o=ocr.findOne(id);
        return o;
    }
     
     public Iterable<DetalleOrdenCompra> consultarDetalleOrdenCompra() {
        Iterable<DetalleOrdenCompra> oc = docr.findAll();
        return oc;
    }
     
     public DetalleOrdenCompra consultarDetalleOrdenCompraPorId(int id) {
        DetalleOrdenCompra  p = docr.findOne(id);
        return p;
    }
      public void addNewOrdenCompra(OrdenCompra o) {
        ocr.save(o);
    }
      
      public Iterable<Inventario> consultarInventarios() {
        Iterable<Inventario> oc = invr.findAll();
        return oc;
    }
     
     public Inventario consultarInventarioPorId(int id) {
        Inventario p=invr.findOne(id);
        return p;
    }
     
     public OrdenCompra CrearOrdenDeCompra(Date fecha)
     {
        OrdenCompra o= new OrdenCompra(fecha);
         ocr.save(o);
         return o;
    }
      public DetalleOrdenCompra CrearDetalleOrdenDeCompra(MedicamentoPorProveedor medicamentosPorProveedor, OrdenCompra ordenesCompra)
     {
        DetalleOrdenCompra doc= new DetalleOrdenCompra(medicamentosPorProveedor,ordenesCompra);
        docr.save(doc);
        return doc;
    }
      
      public void AdicionarDetallesAOrden(OrdenCompra oc, Set<DetalleOrdenCompra> dt)
     {
        oc.setDetallesOrdenesCompras(dt);
        ocr.save(oc); 
    }
      
      public long tamañoArrayOrdenes()
     {
        return ocr.count();
    }
      
       

    
}
