package com.adtpo.cpr.bean.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;
import com.adtpo.cpr.beans.model.Cotizacion;
import com.adtpo.cpr.beans.model.ItemListaComparativa;
import com.adtpo.cpr.beans.model.ListaComparativa;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.MapaRodamientoPrecio;
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
		almacenaEntidad(proveedor);
	}

	public Proveedor getProveedor(Proveedor prove)
			throws DataBaseInvalidDataException {
		return getEntidad(prove.getIdProveedor(), Proveedor.class);
	}

	public void eliminarProveedor(Proveedor proveedor) {
		try {
			iniciaOperacion();
			if (proveedor.getIdProveedor() > 0)
				sesion.createQuery(
						"delete from Proveedor where idProveedor = " + ":id")
						.setInteger("id", proveedor.getIdProveedor())
						.executeUpdate();
			else if (!proveedor.getCuit().isEmpty())
				sesion.createQuery(
						"delete from Proveedor where cuit = " + ":cuit")
						.setString("cuit", proveedor.getCuit()).executeUpdate();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			terminaOperacion();
		}
	}

	public List<Proveedor> getProveedores() {
		return getListaEntidades(Proveedor.class);
	}

	@SuppressWarnings("unchecked")
	public List<ListasProveedor> getListasProveedor(int idProvedor) {
		List<ListasProveedor> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery(
					"From ListaProveedor l where l.idProveedor = " + ":id")
					.setInteger("id", idProvedor).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} 
//		finally {
//			terminaOperacion();
//		}
		return lista;
	}

	public void setPorcentajeGanancia(float porcentaje) {
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			sesion.createQuery(
					"Update Politicas set porcentaje = :porc where discriminator = "
							+ ":dis").setFloat("porc", porcentaje).setString(
					"dis", "PG").executeUpdate();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			sesion.close();
		}
	}

	public void setPorcentajeGanancia(PorcentajeGanancia pg) {
		almacenaEntidad(pg);
	}

	public PorcentajeGanancia getPorcentajeGanancia() {
		PorcentajeGanancia porc = null;
		try {
			iniciaOperacion();
			porc = (PorcentajeGanancia) sesion.createQuery(
					"from Politicas where discriminator = " + ":dis")
					.setString("dis", "PG").uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			terminaOperacion();
		}
		return porc;
	}

	public void eliminarProveedorPorCuit(String cuit) {
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			sesion.createQuery("Delete from Proveedor where cuit = " + ":cuit")
					.setString("cuit", cuit).executeUpdate();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			sesion.close();
		}
	}

	public Proveedor getProveedorPorCuit(String cuit) {
		Proveedor prove = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			prove = (Proveedor) sesion.createQuery(
					"From Proveedor where cuit = :cuit").setParameter("cuit",
					cuit).uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			sesion.close();
		}
		return prove;
	}

	public void grabarRodamiento(Rodamiento rod) {
		almacenaEntidad(rod);
	}

	public void eliminarRodamiento(Rodamiento rod) {
		removerEntidad(rod);
	}

	public ListaComparativa getUltimaListaComparativa() {
		ListaComparativa lista = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			Query query = sesion.createQuery(""
					+ "From ListaComparativa as l"
					+ "where l.fechaLista = (Select MAX(lc.fechaLista) "
										+ "From ListaComparativa as lc)");
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			sesion.flush();
			sesion.close();
		}
		return lista;
	}

	public void registrarMovimientoStock(MovimientosStock ms) {
		almacenaEntidad(ms);
	}

	public void grabarListaProveedor(ListasProveedor listaProveedor) {
//		almacenaEntidad(listaProveedor);
		try{
			sesion = HibernateUtil.getSessionFactory().openSession();
			sesion.beginTransaction();
			sesion.saveOrUpdate(listaProveedor);
		}catch(HibernateException ex){
			manejaExcepcion(ex);
		}finally{
			sesion.getTransaction().commit();
			sesion.close();
		}
	}

	public CondicionVenta getCondicionVenta(int idCondicion) {
		return getEntidad(idCondicion, CondicionVenta.class);
	}

	public void grabarCondicionVenta(CondicionVenta condicionVenta) {
		almacenaEntidad(condicionVenta);
	}

	public Cotizacion getCotizacion(int idCotizacion) {
		return getEntidad(idCotizacion, Cotizacion.class);
	}

	public void guardarListaComparativa(ListaComparativa listaHoy) {
		almacenaEntidad(listaHoy);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ListasProveedor> getListadoListaDeProveedores() {
		ArrayList<ListasProveedor> lp = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			lp = (ArrayList<ListasProveedor>) sesion.createQuery(
					"From ListasProveedor").list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} 
//		finally {
//			sesion.close();
//		}
		return lp;
	}

	public ArrayList<ListaComparativa> levantarListasComparativas() {
		return (ArrayList<ListaComparativa>) getListaEntidades(ListaComparativa.class);
	}

	public ListaComparativa getListaComparativa() {
		ListaComparativa lc = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			lc = (ListaComparativa) sesion.createQuery(
					"From ListaComparativa").uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} 
//		finally {
//			sesion.close();
//		}
		return lc;
	}

	public ArrayList<Rodamiento> getRodamientos() {
		return (ArrayList<Rodamiento>) getListaEntidades(Rodamiento.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Cotizacion> getCotizacionesCliente(Cliente cliente) {
		ArrayList<Cotizacion> cotizaciones = null;
		try {
			iniciaOperacion();
			cotizaciones = (ArrayList<Cotizacion>) sesion.createQuery(
					"From Cotizacion where idCliente = :idCliente").setInteger(
					"idCliente", cliente.getIdCliente());
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			terminaOperacion();
		}
		return cotizaciones;
	}

	public MapaRodamientoPrecio getMapaRodamientoPrecio(MapaRodamientoPrecio mrp) {
		return getEntidad(mrp.getIdMapaRodamientoPrecio(), MapaRodamientoPrecio.class);
	}

	public void agregarMapaRodamientoPrecio(MapaRodamientoPrecio mrp) {
		almacenaEntidad(mrp);
	}

	public boolean existeProveedor(Proveedor proveedor) {
		if(proveedor.getIdProveedor()>0)
			if(getEntidad(proveedor.getIdProveedor(), Proveedor.class) !=null)
				return true;
		if(proveedor.getCuit() != null && !proveedor.getCuit().isEmpty()){
			Proveedor p = null;
			try{
				sesion = HibernateUtil.getSessionFactory().openSession();
				p = (Proveedor) sesion.createQuery(
				"From Proveedor where cuit = :cuit").setParameter("cuit",
						proveedor.getCuit()).uniqueResult();				
			}catch(HibernateException he){
				manejaExcepcion(he);
			}finally{
				sesion.close();
			}
			if(p !=null)
				return true;
		}
		return false; 
	}
	
	public boolean existenListasProveedores(){
		Long cant = null;
		try{
			iniciaOperacion();
			cant = (Long) sesion.createQuery(
					"Select count(*) From ListasProveedor").uniqueResult();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
		if(cant!= null && cant.intValue()>0)
			return true;
		else
			return false;
	}
}
