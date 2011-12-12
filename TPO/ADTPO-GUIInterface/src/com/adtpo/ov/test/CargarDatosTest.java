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

public class CargarDatosTest {

	private static ClienteRmi rmi;

	public static void main(String[] args) {

		try {
			rmi = new ClienteRmi();
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
		RodamientoBean rod1 = new RodamientoBean();
		rod1.setCaracteristica("elastico");
		rod1.setCodigo("wqwe223");
		rod1.setMarca("Kawasaki");
		rod1.setPais("Japon");

		RodamientoBean rod2 = new RodamientoBean();
		rod2.setCaracteristica("elastico");
		rod2.setCodigo("wqwe223");
		rod2.setMarca("Yamaha");
		rod2.setPais("Japon");

		RodamientoBean rod3 = new RodamientoBean();
		rod3.setCaracteristica("barato");
		rod3.setCodigo("AC54485");
		rod3.setMarca("Kawasaki");
		rod3.setPais("Taiwan");

		RodamientoBean rod4 = new RodamientoBean();
		rod4.setCaracteristica("expansible");
		rod4.setCodigo("AC54485");
		rod4.setMarca("chinchulancha");
		rod4.setPais("Taiwan");

		RodamientoBean rod5 = new RodamientoBean();
		rod5.setCaracteristica("expansible");
		rod5.setCodigo("XZY233");
		rod5.setMarca("Kawasaki");
		rod5.setPais("Japon");

		RodamientoBean rod6 = new RodamientoBean();
		rod6.setCaracteristica("acero inoxidable");
		rod6.setCodigo("922763");
		rod6.setMarca("Banana");
		rod6.setPais("Brasil");

		RodamientoBean rod7 = new RodamientoBean();
		rod7.setCaracteristica("Alta Calidad");
		rod7.setCodigo("osi838");
		rod7.setMarca("Kawasaki");
		rod7.setPais("Argentina");

		RodamientoBean rod8 = new RodamientoBean();
		rod8.setCaracteristica("resistencia");
		rod8.setCodigo("938eu");
		rod8.setMarca("Kawasaki");
		rod8.setPais("Argentina");

		RodamientoBean rod9 = new RodamientoBean();
		rod9.setCaracteristica("Acero Inoxidable");
		rod9.setCodigo("658jud5");
		rod9.setMarca("Kawasaki");
		rod9.setPais("Argentina");

		RodamientoBean rod10 = new RodamientoBean();
		rod10.setCaracteristica("Alta Resistencia Termica");
		rod10.setCodigo("CDC999");
		rod10.setMarca("Yamaha");
		rod10.setPais("Taiwan");

		RodamientoBean rod11 = new RodamientoBean();
		rod11.setCaracteristica("permeable");
		rod11.setCodigo("PP0564");
		rod11.setMarca("Yamaha");
		rod11.setPais("Japon");

		RodamientoBean rod12 = new RodamientoBean();
		rod12.setCaracteristica("impermeable");
		rod12.setCodigo("AC54485");
		rod12.setMarca("Yamaha");
		rod12.setPais("Taiwan");

		RodamientoBean rod13 = new RodamientoBean();
		rod13.setCaracteristica("Permeable");
		rod13.setCodigo("AAA001");
		rod13.setMarca("Yamaha");
		rod13.setPais("Japon");

		RodamientoBean rod14 = new RodamientoBean();
		rod14.setCaracteristica("Flexible");
		rod14.setCodigo("XYZ127");
		rod14.setMarca("Yamaha");
		rod14.setPais("Argentina");

		RodamientoBean rod15 = new RodamientoBean();
		rod15.setCaracteristica("Acero Inoxidable");
		rod15.setCodigo("AZZ012");
		rod15.setMarca("Taranto");
		rod15.setPais("Japon");

		// PROVEEDORES

		ProveedorBean prove1 = new ProveedorBean();
//		prove1.setCuit("80-34453244-6");
//		prove1.setNombre("Proveo Rodamientos s.a.");

		ProveedorBean prove2 = new ProveedorBean();
//		prove2.setCuit("34536542");
//		prove2.setNombre("Rodriguez s.a.");

		ProveedorBean prove3 = new ProveedorBean();
//		prove3.setCuit("34538792");
//		prove3.setNombre("sanchez s.a.");

		try {
			rmi.agregarProveedor("80-34453244-6", "Proveo Rodamientos s.a.");
			System.out.println("Proveedor 1 agendado");
			rmi.agregarProveedor("34536542", "Rodriguez s.a.");
			System.out.println("Proveedor 2 agendado");
			rmi.agregarProveedor("345365423", "sanchez s.a.");
			System.out.println("Proveedor 3 agendado");

			prove1.setId(1);
			prove2.setId(2);
			prove3.setId(3);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// MAPAS RODAMIENTOPRECIO

		MapaRodamientoPrecioBean mrp1 = new MapaRodamientoPrecioBean(rod3,
				(float) 12.00);
		MapaRodamientoPrecioBean mrp2 = new MapaRodamientoPrecioBean(rod1,
				(float) 5.70);
		MapaRodamientoPrecioBean mrp3 = new MapaRodamientoPrecioBean(rod2,
				(float) 7.50);
		MapaRodamientoPrecioBean mrp4 = new MapaRodamientoPrecioBean(rod4,
				(float) 12.00);
		MapaRodamientoPrecioBean mrp5 = new MapaRodamientoPrecioBean(rod5,
				(float) 32.70);
		MapaRodamientoPrecioBean mrp6 = new MapaRodamientoPrecioBean(rod6,
				(float) 7.50);
		MapaRodamientoPrecioBean mrp7 = new MapaRodamientoPrecioBean(rod7,
				(float) 12.00);
		MapaRodamientoPrecioBean mrp8 = new MapaRodamientoPrecioBean(rod8,
				(float) 59.00);
		MapaRodamientoPrecioBean mrp9 = new MapaRodamientoPrecioBean(rod9,
				(float) 7.50);
		MapaRodamientoPrecioBean mrp10 = new MapaRodamientoPrecioBean(rod10,
				(float) 30.00);
		MapaRodamientoPrecioBean mrp11 = new MapaRodamientoPrecioBean(rod11,
				(float) 6.75);
		MapaRodamientoPrecioBean mrp12 = new MapaRodamientoPrecioBean(rod12,
				(float) 10.50);
		MapaRodamientoPrecioBean mrp13 = new MapaRodamientoPrecioBean(rod13,
				(float) 15);
		MapaRodamientoPrecioBean mrp14 = new MapaRodamientoPrecioBean(rod14,
				(float) 85);
		MapaRodamientoPrecioBean mrp15 = new MapaRodamientoPrecioBean(rod15,
				(float) 11);

		ArrayList<MapaRodamientoPrecioBean> mapRodList1 = new ArrayList<MapaRodamientoPrecioBean>();
		mapRodList1.add(mrp1);
		mapRodList1.add(mrp2);
		mapRodList1.add(mrp3);
		mapRodList1.add(mrp4);
		mapRodList1.add(mrp5);
		mapRodList1.add(mrp6);
		mapRodList1.add(mrp7);
		mapRodList1.add(mrp8);
		mapRodList1.add(mrp9);
		mapRodList1.add(mrp10);
		mapRodList1.add(mrp11);
		mapRodList1.add(mrp12);

		ArrayList<MapaRodamientoPrecioBean> mapaRodList2 = new ArrayList<MapaRodamientoPrecioBean>();
		mapaRodList2.add(mrp13);
		mapaRodList2.add(mrp14);
		mapaRodList2.add(mrp15);
		mapaRodList2.add(mrp1);

		ArrayList<MapaRodamientoPrecioBean> mapaRodList3 = new ArrayList<MapaRodamientoPrecioBean>();
		mapaRodList3.add(mrp12);
		mapaRodList3.add(mrp1);
		mapaRodList3.add(mrp10);

		// LISTAS PROVEEDOR

		ListasProveedorBean lpb1 = new ListasProveedorBean();
		lpb1.setDescuento((float) 0.21);
		lpb1.setNombre("Lista d");
//		lpb1.setCondVenta(cvbList);
		lpb1.setProveedor(prove1);
		lpb1.setMapaRodamientoPrecio(mapRodList1);

		ListasProveedorBean lpb2 = new ListasProveedorBean();
		lpb2.setNombre("lista a");
		lpb2.setProveedor(prove2);
		lpb2.setDescuento((float) 0.11);
		lpb2.setMapaRodamientoPrecio(mapaRodList2);
//		lpb2.setCondVenta(cvsl);

		ListasProveedorBean lpb3 = new ListasProveedorBean();
		lpb3.setNombre("lista b");
		lpb3.setProveedor(prove3);
		lpb3.setDescuento((float) 0.13);
		lpb3.setMapaRodamientoPrecio(mapaRodList2);
//		lpb3.setCondVenta(cvsl);

		ListasProveedorBean lpb4 = new ListasProveedorBean();
		lpb4.setNombre("lista c");
		lpb4.setProveedor(prove1);
		lpb4.setDescuento((float) 0.17);
		lpb4.setMapaRodamientoPrecio(mapaRodList3);
//		lpb4.setCondVenta(cvbList);

		ListasProveedorBean lpb5 = new ListasProveedorBean();
		lpb5.setNombre("lista e");
		lpb5.setProveedor(prove2);
		lpb5.setDescuento((float) 0.25);
		lpb5.setMapaRodamientoPrecio(mapRodList1);
//		lpb5.setCondVenta(cvsl);

		ListasProveedorBean lpb6 = new ListasProveedorBean();
		lpb6.setNombre("lista f");
		lpb6.setProveedor(prove1);
		lpb6.setDescuento((float) 0.18);
		lpb6.setMapaRodamientoPrecio(mapaRodList2);
//		lpb6.setCondVenta(cvbList);

		ListasProveedorBean lpb7 = new ListasProveedorBean();
		lpb7.setNombre("lista g");
		lpb7.setProveedor(prove3);
		lpb7.setDescuento((float) 0.04);
		lpb7.setMapaRodamientoPrecio(mapaRodList3);
//		lpb7.setCondVenta(cvbList);

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
			xstream.toXML(lpb1, new FileOutputStream("Listaproveedor1.xml"));
			xstream.toXML(lpb2, new FileOutputStream("Listaproveedor2.xml"));
			xstream.toXML(lpb3, new FileOutputStream("Listaproveedor3.xml"));
			xstream.toXML(lpb4, new FileOutputStream("Listaproveedor4.xml"));
			xstream.toXML(lpb5, new FileOutputStream("Listaproveedor5.xml"));
			xstream.toXML(lpb6, new FileOutputStream("Listaproveedor6.xml"));
			xstream.toXML(lpb7, new FileOutputStream("Listaproveedor7.xml"));

			/////////////Envio los xml al sistema para ser cargados

			// Cambiar path adecuadamente
			String path = "C:\\Users\\Joaco\\Desktop\\TPO\\ADTPO-GUIInterface\\";

			rmi.agregarListaProveedor(path + "Listaproveedor1.xml");
			System.out.print("ListaProveedor1.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor2.xml");
			System.out.print("ListaProveedor2.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor3.xml");
			System.out.print("ListaProveedor3.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor4.xml");
			System.out.print("ListaProveedor4.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor5.xml");
			System.out.print("ListaProveedor5.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor6.xml");
			System.out.print("ListaProveedor6.xml cargado\n");
			rmi.agregarListaProveedor(path + "ListaProveedor7.xml");
			System.out.print("ListaProveedor7.xml cargado\n");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.print("Operacion Finalizada");
	}
}
