package com.adtpo.cpr.bean.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adtpo.cpr.beans.model.CondicionVenta;
import com.adtpo.cpr.beans.model.ListaComparativa;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.MovimientosStock;
import com.adtpo.cpr.beans.model.PorcentajeGanancia;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.beans.model.Rodamiento;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hbt.HibernateUtil;

public class CprDAO extends AbstractDAO {

	private static CprDAO instancia = null;

	public static CprDAO getInstancia() {
		if (instancia == null) {
			instancia = new CprDAO();
		}
		return instancia;
	}

	public void grabarProveedor(Proveedor proveedor) {
		try{
			iniciaOperacion();
			almacenaEntidad(proveedor);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
	}

	public Proveedor getProveedor(Proveedor prove) throws DataBaseInvalidDataException {
		Proveedor p = null;
		try{
			iniciaOperacion();
			p = getEntidad(prove.getIdProveedor(), Proveedor.class);
			if(p == null)
				throw new DataBaseInvalidDataException();
			sesion.flush();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
		return p;
	}

	public void eliminarProveedor(Proveedor proveedor){
		try{
			iniciaOperacion();
			if(proveedor.getIdProveedor()>0)
				sesion.createQuery("delete from Proveedor where idProveedor = " +
						":id").setInteger("id", proveedor.getIdProveedor()).executeUpdate();
			else if(!proveedor.getCuit().isEmpty())
					sesion.createQuery("delete from Proveedor where cuit = " +
					":cuit").setString("cuit", proveedor.getCuit()).executeUpdate();
			sesion.flush();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
	}

	public List<Proveedor> getProveedores(){
		List<Proveedor> lista = null;
		try{
			iniciaOperacion();
			lista = getListaEntidades(Proveedor.class);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListasProveedor> getListasProveedor(int idProvedor){
		List<ListasProveedor> lista = null;
		try{
			iniciaOperacion();
			lista = sesion.createQuery("From ListaProveedor l where l.idProveedor = " +
					":id").setInteger("id", idProvedor).list();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
		return lista;
	}

	public void setPorcentajeGanancia(float porcentaje) {
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			sesion.createQuery("Update Politicas set porcentaje = :porc where discriminator = " +
					":dis").setFloat("porc", porcentaje).setString("dis", "PG").executeUpdate();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			sesion.close();				
		}
	}

	public void inicializarPorcentajeGanancia(PorcentajeGanancia pg){
		try{
			iniciaOperacion();
			sesion.persist(pg);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
	}
	
	public PorcentajeGanancia getPorcentajeGanancia() {
		PorcentajeGanancia porc = null;
		try{
			iniciaOperacion();
			porc = (PorcentajeGanancia) sesion.createQuery("from Politicas where discriminator = " +
					":dis").setString("dis", "PG").uniqueResult();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();				
		}
		return porc;
	}

	public void eliminarProveedorPorCuit(String cuit) {
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			sesion.createQuery("Delete from Proveedor where cuit = " +
					":cuit").setString("cuit", cuit).executeUpdate();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			sesion.close();				
		}
	}

	public Proveedor getProveedorPorCuit(String cuit) {
		Proveedor prove = null;
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			prove = (Proveedor) sesion.createQuery("From Proveedor where cuit = " +
					":cuit").setString("cuit", cuit).uniqueResult();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			sesion.close();				
		}
		return prove;
	}

	public void grabarRodamiento(Rodamiento rod) {
		try{
			iniciaOperacion();
			almacenaEntidad(rod);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
	}
	
	public void eliminarRodamiento(Rodamiento rod){
		//TODO
	}

	public ListaComparativa getUltimaListaComparativa() {
		ListaComparativa lista = null;
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			lista = (ListaComparativa) sesion.createQuery("" +
					"From ListaComparativa " +
					"where fecha = (Select MAX(LC.fecha) " +
									"from ListaComparativa LC)");
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			sesion.flush();
			sesion.close();
		}
		return lista;
	}

	public void registrarMovimientoStock(MovimientosStock ms) {
		try{
			iniciaOperacion();
			almacenaEntidad(ms);			
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
	}

	public void grabarListaProveedor(ListasProveedor listaProveedor) {
		try{
			iniciaOperacion();
			almacenaEntidad(listaProveedor);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
	}

	public CondicionVenta getCondicionVenta(int idCondicion) {
		CondicionVenta cond = null;
		try{
			iniciaOperacion();
			cond = getEntidad(idCondicion, CondicionVenta.class);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
		return cond;
	}

	public void grabarCondicionVenta(CondicionVenta condicionVenta) {
		try{
			iniciaOperacion();
			almacenaEntidad(condicionVenta);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
	}
}
