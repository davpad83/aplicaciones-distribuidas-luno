package com.adtpo.ov.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.ov.clienteRmi.ClienteRmi;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Test {

	private static ClienteRmi rmi;

	// public static void main(String[] args){
	//		
	// try {
	// rmi = new ClienteRmi();
	//			
	// //Agrego 4 clientes:
	// ClienteBean c0 = new ClienteBean();
	// c0.setApellido("Eliminar");
	// c0.setNombre("Cliente Para");
	// c0.setEmail("eliminar@x.com");
	// c0.setTelefono("4979-7979");
	// // rmi.agregarCliente(c0.getNombre(), c0.getApellido(), c0.getTelefono(),
	// c0.getEmail());
	//			
	// ClienteBean c1 = new ClienteBean();
	// c1.setApellido("Attanasio");
	// c1.setNombre("Joaquin tarado");
	// c1.setEmail("melacomo@yque.com");
	// c1.setTelefono("0-800-telachupo");
	// // rmi.agregarCliente(c1.getNombre(), c1.getApellido(), c1.getTelefono(),
	// c1.getEmail());
	// System.out.print("Cliente 1 agregado");
	//		
	// ClienteBean c2 = new ClienteBean();
	// c2.setApellido("Favale");
	// c2.setNombre("Matias Alejandro");
	// c2.setEmail("matiasfavale@gmail.com");
	// c2.setTelefono("4799-8799");
	// // rmi.agregarCliente(c2.getNombre(), c2.getApellido(), c2.getTelefono(),
	// c2.getEmail());
	// System.out.print("Cliente 2 agregado");
	//		
	// ClienteBean c3 = new ClienteBean();
	// c3.setApellido("Onabehere");
	// c3.setNombre("Joanna");
	// c3.setEmail("joanna.onabehere@gmail.com");
	// c3.setTelefono("4654-8763");
	// // rmi.agregarCliente(c3.getNombre(), c3.getApellido(), c3.getTelefono(),
	// c3.getEmail());
	// System.out.print("Cliente 3 agregado");
	//		
	// ClienteBean c4 = new ClienteBean();
	// c4.setApellido("Pisano");
	// c4.setNombre("Silvana");
	// c4.setEmail("sil.pisano@gmail.com");
	// c4.setTelefono("4684-3658");
	// // rmi.agregarCliente(c4.getNombre(), c4.getApellido(), c4.getTelefono(),
	// c4.getEmail());
	// System.out.print("Cliente 4 agregado");
	//		
	// Runtime.getRuntime().exec("pause");
	//		
	// //Elimino 1 Cliente
	// rmi.eliminarCliente(1);
	// System.out.print("Cliente con id 1 eliminado");
	//		
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//		
	// System.out.print("Operacion finalizada");
	// }

	public static void main(String[] args) {
		ListasProveedorBean lp = new ListasProveedorBean();
		lp.setDescuento((float) 0.21);
		lp.setIdLista(123);
		lp.setNombre("Lista test");

		ProveedorBean proveedor = new ProveedorBean();
		proveedor.setCuit("80-34453244-6");
		proveedor.setDescuento((float) 0.05);
		proveedor.setNombre("Proveo Rodamientos s.a.");
		proveedor.setId(74415);
		lp.setProveedor(proveedor);

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

		lp.setMapaRodamientoPrecio(rodamientos);

		XStream xstream = new XStream(new DomDriver());
		try {
			xstream.toXML(lp, new FileOutputStream("xmlPrueba.xml"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.print("Archivo xml creado");
	}
}
