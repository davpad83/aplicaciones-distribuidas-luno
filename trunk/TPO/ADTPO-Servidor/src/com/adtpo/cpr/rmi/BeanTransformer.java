package com.adtpo.cpr.rmi;

import java.util.ArrayList;
import java.util.List;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.Proveedor;

class BeanTransformer {
	
	
	static Cliente toCliente(ClienteBean cb){
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

	static ClienteBean toClienteBean(Cliente cl){
		ClienteBean cb = new ClienteBean();
		cb.setNombre(cl.getNombre());
		cb.setApellido(cl.getApellido());
		cb.setEmail(cl.getEmail());
		cb.setTelefono(cl.getTelefono());
		return cb;
	}

	static Proveedor toProveedor(ProveedorBean pb) {
		Proveedor p = new Proveedor();
		p.setCuit(pb.getCuit());
		p.setNombre(pb.getNombre());
		return p;
	}

	static ProveedorBean toProveedorBean(Proveedor proveedor) {
		ProveedorBean pb = new ProveedorBean();
		pb.setCuit(proveedor.getCuit());
		pb.setNombre(proveedor.getNombre());
		return null;
	}
	
	static CondicionVenta toCondicionVenta(CondicionVentaBean cvb){
		CondicionVenta condicion = new CondicionVenta();
		condicion.setInteres(cvb.getInteres());
		condicion.setTipo(cvb.getTipo());		
		return condicion;
	}
	
	static CondicionVentaBean toCondicionVentaBean(CondicionVenta cv) {
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setInteres(cv.getInteres());
		cvb.setTipo(cv.getTipo());
		return cvb;
	}

	static ArrayList<CondicionVentaBean> toCondicionVentaBeanList(ArrayList<CondicionVenta> cvList){
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

	
	public static ArrayList<ListasProveedor> toListasProveedorList(ArrayList<ListasProveedorBean> lpb){
		ArrayList<ListasProveedor> lp = new ArrayList<ListasProveedor>();
		for(ListasProveedorBean l: lpb){
			lp.add(toListaProveedor(l));
		}
		return null;
		
	}

	public static ListasProveedor toListaProveedor(ListasProveedorBean lpb) {
		ListasProveedor lp = new ListasProveedor();
		lp.setIdLista(lpb.getIdLista());
		lp.setNombre(lpb.getNombre());
		lp.setDescuento(lpb.getDescuento());
		lp.setProveedor(toProveedorList(lpb.getProveedores()));
		lp.setCondVenta(lpb.getCondVenta());
		//TODO CORREGIR ESTO, VER SI ES MEJOR PONER EN VEZ DE UN MAPA RODAMIENTO/PRECIO, QUE SEA IDRODAMIENTO/PRECIO
//		lp.setListaRodamientos(toRodamientosMap(lpb.getRodamientos()));
		return lp;
	}



}
