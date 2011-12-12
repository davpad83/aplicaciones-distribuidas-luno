package com.adtpo.cpr.rmi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.collection.PersistentBag;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.*;

class BeanTransformer {

	public static Cliente toCliente(ClienteBean cb) {
		Cliente cliente = new Cliente();
		cliente.setApellido(cb.getApellido());

		if (cb.getCondicion() != null) {
			List<CondicionVenta> condicion = new ArrayList<CondicionVenta>();
			for (CondicionVentaBean cvb : cb.getCondicion()) {
				condicion.add(toCondicionVenta(cvb));
			}
			cliente.setCondicion(condicion);
		}

		cliente.setNombre(cb.getNombre());
		cliente.setTelefono(cb.getTelefono());
		cliente.setEmail(cb.getEmail());
		cliente.setIdCliente(cb.getId());

		return cliente;
	}

	public static ArrayList<ItemRodamiento> toItemRodamientoList(
			ArrayList<ItemRodamientoBean> irb) {
		ArrayList<ItemRodamiento> Itemsrods = new ArrayList<ItemRodamiento>();
		for (ItemRodamientoBean ib : irb) {
			ItemRodamiento ir = new ItemRodamiento();
			ir.setCantidad(ib.getCantidad());
			ir.setPrecio(ib.getPrecio());
			ir.setProveedor(toProveedor(ib.getProveedor()));
			ir.setRodamiento(toRodamiento(ib.getRodamiento()));
			Itemsrods.add(ir);
		}
		return Itemsrods;
	}

	public static ArrayList<ItemRodamientoBean> toItemRodamientoBeanList(
			List<ItemRodamiento> irb) {
		ArrayList<ItemRodamientoBean> Itemsrods = new ArrayList<ItemRodamientoBean>();
		for (ItemRodamiento ib : irb) {
			ItemRodamientoBean ir = new ItemRodamientoBean();
			ir.setCantidad(ib.getCantidad());
			ir.setPrecio(ib.getPrecio());
			ir.setProveedor(toProveedorBean(ib.getProveedor()));
			ir.setRodamiento(toRodamientoBean(ib.getRodamiento()));
			Itemsrods.add(ir);
		}
		return Itemsrods;
	}

	public static ClienteBean toClienteBean(Cliente cl) {
		ClienteBean cb = new ClienteBean();
		cb.setId(cl.getIdCliente());
		cb.setNombre(cl.getNombre());
		cb.setApellido(cl.getApellido());
		cb.setEmail(cl.getEmail());
		cb.setTelefono(cl.getTelefono());
		return cb;
	}

	public static CondicionVenta toCondicionVenta(CondicionVentaBean cvb) {
		CondicionVenta condicion = new CondicionVenta();
		condicion.setIdCondicion(cvb.getIdCondicion());
		condicion.setInteres(cvb.getInteres());
		condicion.setTipo(cvb.getTipo());
		condicion.setCantidadDiasDePago(cvb.getCantidadDiasDePago());
		condicion.setDescuento(cvb.getDescuento());
		return condicion;
	}

	public static ArrayList<CondicionVenta> toCondicionVentaList(
			ArrayList<CondicionVentaBean> cvb) {
		ArrayList<CondicionVenta> cvList = new ArrayList<CondicionVenta>();
		for(CondicionVentaBean cvbItem : cvb)
			cvList.add(toCondicionVenta(cvbItem));
		return cvList;
	}	

	public static CondicionVentaBean toCondicionVentaBean(CondicionVenta cv) {
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setInteres(cv.getInteres());
		cvb.setTipo(cv.getTipo());
		return cvb;
	}

	public static ArrayList<CondicionVentaBean> toCondicionVentaBeanList(
			List<CondicionVenta> cvList) {
		ArrayList<CondicionVentaBean> cvbList = new ArrayList<CondicionVentaBean>();
		for (CondicionVenta cv : cvList)
			cvbList.add(toCondicionVentaBean(cv));
		return cvbList;
	}

	public static ArrayList<Proveedor> toProveedorList(
			ArrayList<ProveedorBean> proveedores) {
		ArrayList<Proveedor> prove = new ArrayList<Proveedor>();
		for (ProveedorBean p : proveedores)
			prove.add(toProveedor(p));
		return prove;
	}

	public static ArrayList<ProveedorBean> toProveedorBeanList(
			ArrayList<Proveedor> proveedores) {
		ArrayList<ProveedorBean> pbList = new ArrayList<ProveedorBean>();
		for (Proveedor prov : proveedores)
			pbList.add(toProveedorBean(prov));
		return pbList;
	}

	public static ListasProveedor toListaProveedor(ListasProveedorBean lpb) {
		ListasProveedor lp = new ListasProveedor();
		lp.setIdLista(lpb.getIdLista());
		lp.setNombre(lpb.getNombre());
		lp.setDescuento(lpb.getDescuento());
//		lp.setCondVenta(toCondicionVentaList(lpb.getCondVenta()));
		lp.setProveedor(toProveedor(lpb.getProveedor()));
		lp.setMapaRodamientoPrecio(toMapaRodamientoPrecioList(lpb
				.getMapaRodamientoPrecio()));
		return lp;
	}

	public static ArrayList<ListasProveedor> toListasProveedorList(
			ArrayList<ListasProveedorBean> lpb) {
		ArrayList<ListasProveedor> lp = new ArrayList<ListasProveedor>();
		for (ListasProveedorBean l : lpb) {
			lp.add(toListaProveedor(l));
		}
		return lp;
	}

	public static ArrayList<ListasProveedorBean> toListasProveedorBeanList(
			ArrayList<ListasProveedor> lpb) {
		ArrayList<ListasProveedorBean> lp = new ArrayList<ListasProveedorBean>();
		for (ListasProveedor l : lpb) {
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
//		lpb.setCondVenta(BeanTransformer
//				.toCondicionVentaBeanList((ArrayList<CondicionVenta>) lc
//						.getCondVenta()));
		lpb.setMapaRodamientoPrecio(toMapaRodamientoPrecioBeanList(lc
				.getMapaRodamientoPrecio()));
		return lpb;
	}

	public static MapaRodamientoPrecioBean toMapaRodamientoPrecioBean(
			MapaRodamientoPrecio mrp) {
		MapaRodamientoPrecioBean mrpb = new MapaRodamientoPrecioBean();
		mrpb.setPrecio(mrp.getPrecio());
		mrpb.setRodamiento(toRodamientoBean(mrp.getRodamiento()));
		return mrpb;
	}

	public static MapaRodamientoPrecio toMapaRodamientoPrecio(
			MapaRodamientoPrecioBean mrpb) {
		MapaRodamientoPrecio mrp = new MapaRodamientoPrecio();
		mrp.setPrecio(mrpb.getPrecio());
		mrp.setRodamiento(toRodamiento(mrpb.getRodamiento()));
		return mrp;
	}

	public static List<MapaRodamientoPrecioBean> toMapaRodamientoPrecioBeanList(
			List<MapaRodamientoPrecio> mrp) {
		List<MapaRodamientoPrecioBean> list = new ArrayList<MapaRodamientoPrecioBean>();
		for (MapaRodamientoPrecio mrpItem : mrp)
			list.add(toMapaRodamientoPrecioBean(mrpItem));
		return list;
	}

	public static List<MapaRodamientoPrecio> toMapaRodamientoPrecioList(
			List<MapaRodamientoPrecioBean> mrpb) {
		List<MapaRodamientoPrecio> list = new ArrayList<MapaRodamientoPrecio>();
		for (MapaRodamientoPrecioBean mrpbItem : mrpb)
			list.add(toMapaRodamientoPrecio(mrpbItem));
		return list;
	}

	public static Rodamiento toRodamiento(RodamientoBean rb) {
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

	public static RodamientoBean toRodamientoBean(Rodamiento rod) {
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
		p.setIdProveedor(pb.getId());
		return p;
	}

	public static ProveedorBean toProveedorBean(Proveedor proveedor) {
		ProveedorBean pb = new ProveedorBean();
		pb.setCuit(proveedor.getCuit());
		pb.setNombre(proveedor.getNombre());
		pb.setId(proveedor.getIdProveedor());
		return null;
	}

	public static ArrayList<RodamientoBean> toRodamientoBeanList(
			ArrayList<Rodamiento> rodList) {
		ArrayList<RodamientoBean> lp = new ArrayList<RodamientoBean>();
		for (Rodamiento rb : rodList) {
			lp.add(toRodamientoBean(rb));
		}
		return lp;
	}

	public static ArrayList<Rodamiento> toRodamientoList(
			ArrayList<RodamientoBean> rodBeanList) {
		ArrayList<Rodamiento> lp = new ArrayList<Rodamiento>();
		for (RodamientoBean rod : rodBeanList) {
			lp.add(toRodamiento(rod));
		}
		return lp;
	}

	public static ListaComparativaBean toListaComparativaBean(
			ListaComparativa listaComparativa) {
		ListaComparativaBean lcb = new ListaComparativaBean();
		
		lcb.setFechaLista(listaComparativa.getFechaLista());
		lcb.setItems(new ArrayList<ItemListaComparativaBean>());
		
		for (ItemListaComparativa il : listaComparativa.getItems()) {
			ItemListaComparativaBean it = new ItemListaComparativaBean();
			if(it.getListaProveedor()!=null)
				it.setListaProveedor(BeanTransformer.toListaProveedorBean(il
						.getListaProveedor()));
			it.setPrecio(il.getPrecio());
			it.setRodamiento(BeanTransformer.toRodamientoBean(il
					.getRodamiento()));
			lcb.getItems().add(it);
		}
		return lcb;
	}

	public static CotizacionBean toCotizacionBean(Cotizacion c) {
		CotizacionBean cb = new CotizacionBean();
		cb.setCliente(toClienteBean(c.getCliente()));
		cb.setIdCotizacion(c.getIdCotizazion());
		cb.setVencimiento(c.getVencimiento());
		cb.setIva(c.getIva());
		cb.setItems(toItemRodamientoBeanList(c.getItems()));
		return cb;
	}

	public static Cotizacion toCotizacion(CotizacionBean c) {
		Cotizacion cb = new Cotizacion();
		cb.setCliente(toCliente(c.getCliente()));
		cb.setIdCotizazion(c.getIdCotizacion());
		cb.setVencimiento(c.getVencimiento());
		cb.setIva(c.getIva());
		cb.setItems(toItemRodamientoList(c.getItems()));
		return cb;
	}

	public static FacturaBean toFacturaBean(Factura factura) {
		FacturaBean fb = new FacturaBean();
		fb.setFechaFactura(factura.getFechaFactura());
		fb.setIdFactura(factura.getIdFactura());
		fb.setVenta(toVentaBean(factura.getVenta()));
		return fb;
	}

	private static VentaBean toVentaBean(Venta venta) {
		VentaBean vb = new VentaBean();
		vb.setIdVenta(venta.getIdVenta());
		vb.setCotizacion(toCotizacionBean(venta.getCotizacion()));
		return null;
	}

	public static ArrayList<CotizacionBean> toCotizacionBeanList(
			ArrayList<Cotizacion> cotizacionesCliente) {
		ArrayList<CotizacionBean> cotList = new ArrayList<CotizacionBean>();
		for (Cotizacion c : cotizacionesCliente)
			cotList.add(toCotizacionBean(c));
		return cotList;
	}

}
