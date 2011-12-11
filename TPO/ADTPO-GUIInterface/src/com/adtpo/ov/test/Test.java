package com.adtpo.ov.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.ov.clienteRmi.ClienteRmi;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Test {

	private static ClienteRmi rmi;

	public static void main(String[] args) {

		try {
			rmi  = new ClienteRmi();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		
		// Condiciones de venta

		ArrayList<CondicionVentaBean> cvbList = new ArrayList<CondicionVentaBean>();
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setTipo("Contado");
		cvb.setDescuento((float) 0.15);
		cvb.setInteres((float) 0);
		cvb.setCantidadDiasDePago(0);
		cvbList.add(cvb);

		ArrayList<CondicionVentaBean> cvsl = new ArrayList<CondicionVentaBean>();
		CondicionVentaBean cvs = new CondicionVentaBean();
		cvs.setTipo("en cuotas");
		cvs.setDescuento((float) 0);
		cvs.setInteres((float) 0.05);
		cvs.setCantidadDiasDePago(0);
		cvsl.add(cvb);

		try {
			rmi.nuevaCondicionVenta(cvb.getInteres(), cvb.getTipo(), cvb
					.getCantidadDiasDePago(), cvb.getDescuento());
			rmi.nuevaCondicionVenta(cvs.getInteres(), cvs.getTipo(), cvs
					.getCantidadDiasDePago(), cvs.getDescuento());
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// RODAMIENTOS
		RodamientoBean b = new RodamientoBean();
		b.setCaracteristica("elastico");
		b.setCodigo("wqwe223");
		b.setMarca("Kawasaki");
		b.setPais("Japon");

		RodamientoBean c = new RodamientoBean();
		c.setCaracteristica("elastico");
		c.setCodigo("wqwe223");
		c.setMarca("Yamaha");
		c.setPais("Japon");

		RodamientoBean a = new RodamientoBean();
		a.setCaracteristica("barato");
		a.setCodigo("AC54485");
		a.setMarca("Kawasaki");
		a.setPais("Taiwan");

		RodamientoBean d = new RodamientoBean();
		d.setCaracteristica("expansible");
		d.setCodigo("AC54485");
		d.setMarca("chinchulancha");
		d.setPais("Taiwan");

		RodamientoBean e = new RodamientoBean();
		e.setCaracteristica("expansible");
		e.setCodigo("XZY233");
		e.setMarca("Kawasaki");
		e.setPais("Japon");

		RodamientoBean f = new RodamientoBean();
		f.setCaracteristica("acero inoxidable");
		f.setCodigo("922763");
		f.setMarca("Banana");
		f.setPais("Brasil");

		RodamientoBean g = new RodamientoBean();
		g.setCaracteristica("Alta Calidad");
		g.setCodigo("osi838");
		g.setMarca("Kawasaki");
		g.setPais("Argentina");

		RodamientoBean h = new RodamientoBean();
		h.setCaracteristica("resistencia");
		h.setCodigo("938eu");
		h.setMarca("Kawasaki");
		h.setPais("Argentina");

		RodamientoBean i = new RodamientoBean();
		i.setCaracteristica("Acero Inoxidable");
		i.setCodigo("658jud5");
		i.setMarca("Kawasaki");
		i.setPais("Argentina");

		RodamientoBean j = new RodamientoBean();
		j.setCaracteristica("Alta Resistencia Termica");
		j.setCodigo("CDC999");
		j.setMarca("Yamaha");
		j.setPais("Taiwan");

		RodamientoBean k = new RodamientoBean();
		k.setCaracteristica("permeable");
		k.setCodigo("PP0564");
		k.setMarca("Yamaha");
		k.setPais("Japon");

		RodamientoBean l = new RodamientoBean();
		l.setCaracteristica("impermeable");
		l.setCodigo("AC54485");
		l.setMarca("Yamaha");
		l.setPais("Taiwan");

		RodamientoBean r1 = new RodamientoBean();
		r1.setCaracteristica("Permeable");
		r1.setCodigo("AAA001");
		r1.setMarca("Yamaha");
		r1.setPais("Japon");

		RodamientoBean r2 = new RodamientoBean();
		r2.setCaracteristica("Flexible");
		r2.setCodigo("XYZ127");
		r2.setMarca("Yamaha");
		r2.setPais("Argentina");

		RodamientoBean r3 = new RodamientoBean();
		r3.setCaracteristica("Acero Inoxidable");
		r3.setCodigo("AZZ012");
		r3.setMarca("Taranto");
		r3.setPais("Japon");

		// PROVEEDORES

		ProveedorBean proveedor = new ProveedorBean();
		proveedor.setCuit("80-34453244-6");
		proveedor.setNombre("Proveo Rodamientos s.a.");
		try {
			rmi.agregarProveedor("80-34453244-6", "Proveo Rodamientos s.a.");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("Proveedor 1 agredado");
		proveedor.setId(1);

		ProveedorBean pr2 = new ProveedorBean();
		pr2.setCuit("34536542");
		pr2.setNombre("Rodriguez s.a.");

		ProveedorBean pr1 = new ProveedorBean();
		pr1.setCuit("34538792");
		pr1.setNombre("sanchez s.a.");

		// MAPAS RODAMIENTOPRECIO
		ArrayList<MapaRodamientoPrecioBean> rodamientos = new ArrayList<MapaRodamientoPrecioBean>();

		MapaRodamientoPrecioBean A = new MapaRodamientoPrecioBean(a,
				(float) 12.00);
		rodamientos.add(A);
		MapaRodamientoPrecioBean B = new MapaRodamientoPrecioBean(b,
				(float) 5.70);
		rodamientos.add(B);
		MapaRodamientoPrecioBean C = new MapaRodamientoPrecioBean(c,
				(float) 7.50);
		rodamientos.add(C);
		MapaRodamientoPrecioBean D = new MapaRodamientoPrecioBean(d,
				(float) 12.00);
		rodamientos.add(D);
		MapaRodamientoPrecioBean E = new MapaRodamientoPrecioBean(e,
				(float) 32.70);
		rodamientos.add(E);
		MapaRodamientoPrecioBean F = new MapaRodamientoPrecioBean(f,
				(float) 7.50);
		rodamientos.add(F);
		MapaRodamientoPrecioBean G = new MapaRodamientoPrecioBean(g,
				(float) 12.00);
		rodamientos.add(G);
		MapaRodamientoPrecioBean H = new MapaRodamientoPrecioBean(h,
				(float) 59.00);
		rodamientos.add(H);
		MapaRodamientoPrecioBean I = new MapaRodamientoPrecioBean(i,
				(float) 7.50);
		rodamientos.add(I);
		MapaRodamientoPrecioBean J = new MapaRodamientoPrecioBean(j,
				(float) 30.00);
		rodamientos.add(J);
		MapaRodamientoPrecioBean K = new MapaRodamientoPrecioBean(k,
				(float) 6.75);
		rodamientos.add(K);
		MapaRodamientoPrecioBean L = new MapaRodamientoPrecioBean(l,
				(float) 10.50);
		rodamientos.add(L);

		MapaRodamientoPrecioBean mrp1 = new MapaRodamientoPrecioBean(r1, 15f);
		MapaRodamientoPrecioBean mrp2 = new MapaRodamientoPrecioBean(r2, 85f);
		MapaRodamientoPrecioBean mrp3 = new MapaRodamientoPrecioBean(r3, 11f);

		ArrayList<MapaRodamientoPrecioBean> Rodamientos1 = new ArrayList<MapaRodamientoPrecioBean>();
		Rodamientos1.add(mrp1);
		Rodamientos1.add(mrp2);
		Rodamientos1.add(mrp3);
		Rodamientos1.add(A);

		ArrayList<MapaRodamientoPrecioBean> Rodamientos2 = new ArrayList<MapaRodamientoPrecioBean>();
		Rodamientos1.add(L);
		Rodamientos1.add(A);
		Rodamientos1.add(J);

		// LISTAS PROVEEDOR

		ListasProveedorBean lp = new ListasProveedorBean();
		lp.setDescuento((float) 0.21);
		lp.setNombre("Lista d");
		lp.setIdLista(12);
		lp.setCondVenta(cvbList);
		lp.setProveedor(proveedor);
		lp.setMapaRodamientoPrecio(rodamientos);

		ListasProveedorBean lpb = new ListasProveedorBean();
		lpb.setNombre("lista a");
		lpb.setProveedor(pr2);
		lpb.setDescuento(0.11f);
		lpb.setIdLista(1);
		lpb.setMapaRodamientoPrecio(Rodamientos1);
		lpb.setCondVenta(cvsl);

		ListasProveedorBean lpb2 = new ListasProveedorBean();
		lpb2.setNombre("lista b");
		lpb2.setProveedor(pr1);
		lpb2.setDescuento(0.13f);
		lpb2.setIdLista(2);
		lpb2.setMapaRodamientoPrecio(Rodamientos1);
		lpb2.setCondVenta(cvsl);

		ListasProveedorBean lpb3 = new ListasProveedorBean();
		lpb3.setNombre("lista c");
		lpb3.setProveedor(proveedor);
		lpb3.setDescuento(0.17f);
		lpb3.setIdLista(3);
		lpb3.setMapaRodamientoPrecio(Rodamientos2);
		lpb3.setCondVenta(cvbList);

		ListasProveedorBean lpb4 = new ListasProveedorBean();
		lpb4.setNombre("lista e");
		lpb4.setProveedor(pr2);
		lpb4.setDescuento(0.25f);
		lpb4.setIdLista(4);
		lpb4.setMapaRodamientoPrecio(rodamientos);
		lpb4.setCondVenta(cvsl);

		ListasProveedorBean lpb5 = new ListasProveedorBean();
		lpb5.setNombre("lista f");
		lpb5.setProveedor(proveedor);
		lpb5.setDescuento(0.18f);
		lpb5.setIdLista(53);
		lpb5.setMapaRodamientoPrecio(Rodamientos1);
		lpb5.setCondVenta(cvbList);

		ListasProveedorBean lpb6 = new ListasProveedorBean();
		lpb6.setNombre("lista g");
		lpb6.setProveedor(pr1);
		lpb6.setDescuento(0.04f);
		lpb6.setIdLista(6);
		lpb6.setMapaRodamientoPrecio(Rodamientos2);
		lpb6.setCondVenta(cvbList);

		// Agrego 4 clientes:
		try {

			ClienteBean c1 = new ClienteBean();
			c1.setApellido("Attanasio");
			c1.setNombre("Joaquin");
			c1.setEmail("jAttanasio@dominio.com");
			c1.setTelefono("0-800-12345");
			ArrayList<Integer> condiciones2 = new ArrayList<Integer>();
			condiciones2.add(Integer.valueOf(2));
			rmi.agregarCliente(c1.getNombre(), c1.getApellido(), c1
					.getTelefono(), c1.getEmail(), condiciones2);
			System.out.print("Cliente 1 agregado\n");

			ClienteBean c2 = new ClienteBean();
			c2.setApellido("Favale");
			c2.setNombre("Matias Alejandro");
			c2.setEmail("matiasfavale@gmail.com");
			c2.setTelefono("4799-8799");
			rmi.agregarCliente(c2.getNombre(), c2.getApellido(), c2
					.getTelefono(), c2.getEmail(), null);
			System.out.print("Cliente 2 agregado\n");

			ClienteBean c3 = new ClienteBean();
			c3.setApellido("Onabehere");
			c3.setNombre("Joanna");
			c3.setEmail("joanna.onabehere@gmail.com");
			c3.setTelefono("4654-8763");
			ArrayList<Integer> condiciones3 = new ArrayList<Integer>();
			condiciones3.add(Integer.valueOf(1));
			rmi.agregarCliente(c3.getNombre(), c3.getApellido(), c3
					.getTelefono(), c3.getEmail(), condiciones3);
			System.out.print("Cliente 3 agregado\n");

			ClienteBean c4 = new ClienteBean();
			c4.setApellido("Pisano");
			c4.setNombre("Silvana");
			c4.setEmail("sil.pisano@gmail.com");
			c4.setTelefono("4684-3658");
			ArrayList<Integer> condiciones4 = new ArrayList<Integer>();
			condiciones4.add(Integer.valueOf(1));
			condiciones4.add(Integer.valueOf(2));
			rmi.agregarCliente(c4.getNombre(), c4.getApellido(), c4
					.getTelefono(), c4.getEmail(), condiciones4);
			System.out.print("Cliente 4 agregado\n");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		XStream xstream = new XStream(new DomDriver());
		try {
			xstream.alias("CondicionVentaBean", CondicionVentaBean.class);
			xstream.alias("MapaRodamientoPrecioBean",
					MapaRodamientoPrecioBean.class);
			xstream.alias("RodamientoBean", RodamientoBean.class);
			xstream.alias("ProveedorBean", ProveedorBean.class);
			xstream.toXML(lp, new FileOutputStream("Listaproveedor.xml"));
			xstream.toXML(lpb, new FileOutputStream("Listaproveedor1.xml"));
			xstream.toXML(lpb2, new FileOutputStream("Listaproveedor2.xml"));
			xstream.toXML(lpb3, new FileOutputStream("Listaproveedor3.xml"));
			xstream.toXML(lpb4, new FileOutputStream("Listaproveedor4.xml"));
			xstream.toXML(lpb5, new FileOutputStream("Listaproveedor5.xml"));
			xstream.toXML(lpb6, new FileOutputStream("Listaproveedor6.xml"));

			// ///////////Envio los xml al sistema para ser cargados

			// Cambiar path adecuadamente
			String path = "/Users/matiasfavale/Documents/DropBox/LenguajesVisuales2/"
					+ "aplicaciones-distribuidas-luno/TPO/ADTPO-GUIInterface/";

			rmi.agregarListaProveedor(path + "Listaproveedor.xml");
			System.out.print("ListaProveedor.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor1.xml");
//			System.out.print("ListaProveedor1.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor2.xml");
//			System.out.print("ListaProveedor2.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor3.xml");
//			System.out.print("ListaProveedor3.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor4.xml");
//			System.out.print("ListaProveedor4.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor5.xml");
//			System.out.print("ListaProveedor5.xml cargado\n");
//			rmi.agregarListaProveedor(path+"ListaProveedor6.xml");
//			System.out.print("ListaProveedor6.xml cargado\n");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.print("Operacion Finalizada");
	}
}
