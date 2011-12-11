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

public class CargarListaProveedorTest {

	private static ClienteRmi rmi;

	public static void main(String[] args) {

		// Cambiar path adecuadamente
		String path = "/Users/matiasfavale/Documents/DropBox/LenguajesVisuales2/"
				+ "aplicaciones-distribuidas-luno/TPO/ADTPO-GUIInterface/";

		try {
			rmi  = new ClienteRmi();
			rmi.agregarListaProveedor(path+"ListaProveedor1.xml");
			System.out.print("ListaProveedor1.xml cargado\n");
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}
}