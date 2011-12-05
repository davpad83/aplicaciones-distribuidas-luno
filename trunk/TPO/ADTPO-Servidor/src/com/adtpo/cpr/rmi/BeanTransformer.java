package com.adtpo.cpr.rmi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.bean.gui.ListaComparativaBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.cpr.bean.gui.RodamientoBean;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;
import com.adtpo.cpr.beans.model.ListaComparativa;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.beans.model.Rodamiento;
import com.adtpo.cpr.beans.model.RodamientoId;

class BeanTransformer {
	
	
	public static Cliente toCliente(ClienteBean cb){
		Cliente cliente = new Cliente();
		cliente.setApellido(cb.getApellido());
		
		if(cb.getCondicion() != null){
			List<CondicionVenta> condicion = new ArrayList<CondicionVenta>();
			for(CondicionVentaBean cvb: cb.getCondicion()){
				condicion.add(toCondicionVenta(cvb));
			}
			cliente.setCondicion(condicion);
		}
		
		cliente.setNombre(cb.getNombre());
		cliente.setTelefono(cb.getTelefono());
		cliente.setEmail(cb.getEmail());
		
		return cliente;
	}

	public static ClienteBean toClienteBean(Cliente cl){
		ClienteBean cb = new ClienteBean();
		cb.setNombre(cl.getNombre());
		cb.setApellido(cl.getApellido());
		cb.setEmail(cl.getEmail());
		cb.setTelefono(cl.getTelefono());
		return cb;
	}

	public static CondicionVenta toCondicionVenta(CondicionVentaBean cvb){
		CondicionVenta condicion = new CondicionVenta();
		condicion.setInteres(cvb.getInteres());
		condicion.setTipo(cvb.getTipo());		
		return condicion;
	}
	
	public static CondicionVentaBean toCondicionVentaBean(CondicionVenta cv) {
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setInteres(cv.getInteres());
		cvb.setTipo(cv.getTipo());
		return cvb;
	}

	public static ArrayList<CondicionVentaBean> toCondicionVentaBeanList(List<CondicionVenta> cvList){
		ArrayList<CondicionVentaBean> cvbList = new ArrayList<CondicionVentaBean>();
		for(CondicionVenta cv: cvList)
			cvbList.add(toCondicionVentaBean(cv));
		return cvbList;
	}

	public static ArrayList<Proveedor> toProveedorList(
			ArrayList<ProveedorBean> proveedores) {
		ArrayList<Proveedor> prove = new ArrayList<Proveedor>();
		for(ProveedorBean p: proveedores)
			prove.add(toProveedor(p));
		return prove;
	}

	public static ArrayList<ProveedorBean> toProveedorBeanList(
			ArrayList<Proveedor> proveedores) {
		ArrayList<ProveedorBean> pbList = new ArrayList<ProveedorBean>();
		for(Proveedor prov: proveedores)
			pbList.add(toProveedorBean(prov));
		return pbList;
	}

	
	public static ListasProveedor toListaProveedor(ListasProveedorBean lpb) {
		ListasProveedor lp = new ListasProveedor();
		lp.setIdLista(lpb.getIdLista());
		lp.setNombre(lpb.getNombre());
		lp.setDescuento(lpb.getDescuento());
		lp.setProveedor(toProveedor(lpb.getProveedor()));
		//TODO CORREGIR ESTO, VER SI ES MEJOR PONER EN VEZ DE UN MAPA RODAMIENTO/PRECIO, QUE SEA IDRODAMIENTO/PRECIO
//		lp.setListaRodamientos(toRodamientosMap(lpb.getRodamientos()));
		return lp;
	}

	public static ArrayList<ListasProveedor> toListasProveedorList(ArrayList<ListasProveedorBean> lpb){
		ArrayList<ListasProveedor> lp = new ArrayList<ListasProveedor>();
		for(ListasProveedorBean l: lpb){
			lp.add(toListaProveedor(l));
		}
		return lp;
	}
	
	public static ArrayList<ListasProveedorBean> toListasProveedorBeanList(ArrayList<ListasProveedor> lpb) {
		ArrayList<ListasProveedorBean> lp = new ArrayList<ListasProveedorBean>();
		for(ListasProveedor l: lpb){
			lp.add(toListaProveedorBean(l));
		}
		return lp;
	}

	public static ListasProveedorBean toListaProveedorBean(ListasProveedor lc) {
		ListasProveedorBean lpb = new ListasProveedorBean();
		lpb.setDescuento(lc.getDescuento());
		lpb.setIdLista(lc.getIdLista());
		lpb.setProveedor(toProveedorBean(lc.getProveedor()));
		lpb.setNombre(lc.getNombre());
		lpb.setCondVenta(toCondicionVentaBeanList(lc.getCondVenta()));
		lpb.setRodamientos(toRodamientoPrecioBeanMap(lc.getListaRodamientos()));
		return lpb;
	}
	
	public static Map<RodamientoBean, Float> toRodamientoPrecioBeanMap(Map<Rodamiento, Float> lr) {
		Map<RodamientoBean, Float> mb = new HashMap<RodamientoBean, Float>();
		for (Rodamiento rod : lr.keySet())
			mb.put(toRodamientoBean(rod), lr.get(rod));
		return mb;
	}
	
	public static Map<Rodamiento, Float> toRodamientoPrecioMap(Map<RodamientoBean, Float> lr) {
		Map<Rodamiento, Float> mb = new HashMap<Rodamiento, Float>();
		for (RodamientoBean rod : lr.keySet())
			mb.put(toRodamiento(rod), lr.get(rod));
		return mb;
	}

	public static Rodamiento toRodamiento(RodamientoBean rb){
		Rodamiento r = new Rodamiento();
		r.setStock(rb.getStock());
		RodamientoId id = new RodamientoId();
		id.setCaracteristica(rb.getCaracteristica());
		id.setCodigo(rb.getCodigo());
		id.setPais(rb.getPais());
		id.setMarca(rb.getMarca());
		r.setIdRodamiento(id);
		return r;
		}
		
	
	public static RodamientoBean toRodamientoBean(Rodamiento rod){
		RodamientoBean rodBean = new RodamientoBean();
		rodBean.setStock(rod.getStock());
		rodBean.setCaracteristica(rod.getCaracteristica());
		rodBean.setCodigo(rod.getCodigo());
		rodBean.setPais(rod.getPais());
		rodBean.setMarca(rod.getMarca());
		return rodBean;
	}
	
	public static Proveedor toProveedor(ProveedorBean pb) {
		Proveedor p = new Proveedor();
		p.setCuit(pb.getCuit());
		p.setNombre(pb.getNombre());
		return p;
	}

	public static ProveedorBean toProveedorBean(Proveedor proveedor) {
		ProveedorBean pb = new ProveedorBean();
		pb.setCuit(proveedor.getCuit());
		pb.setNombre(proveedor.getNombre());
		return null;
	}
	
	
	public static ArrayList<RodamientoBean> toRodamientoBeanList(ArrayList<Rodamiento> rodList){
		ArrayList<RodamientoBean> lp = new ArrayList<RodamientoBean>();
		for(Rodamiento rb: rodList){
			lp.add(toRodamientoBean(rb));
		}
		return lp;
	}
	
	public static ArrayList<Rodamiento> toRodamientoList(ArrayList<RodamientoBean> rodBeanList){
		ArrayList<Rodamiento> lp = new ArrayList<Rodamiento>();
		for(RodamientoBean rod: rodBeanList){
			lp.add(toRodamiento(rod));
		}
		return lp;
	}

	public static ListaComparativaBean toListaComparativaBean(
			ListaComparativa listaComparativa) {
		// TODO Auto-generated method stub
		return null;
	}
}
