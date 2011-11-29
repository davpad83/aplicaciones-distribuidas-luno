package com.adtpo.cpr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.ro.IServicios;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		//empty
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		OficinaVentas.getInstancia().agregarCliente(BeanTransformer.toCliente(cliente));
	}
	
	@Override
	public void modificarCliente(ClienteBean cl) throws RemoteException, DataBaseInvalidDataException {
		OficinaVentas.getInstancia().modificarCliente(BeanTransformer.toCliente(cl));
	}

	@Override
	public void eliminarCliente(int idCliente) throws RemoteException, DataBaseInvalidDataException {
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		OficinaVentas.getInstancia().eliminarCliente(cl);
	}

	@Override
	public void agregarProveedor(ProveedorBean pb) throws RemoteException {
		CasaCentral.getInstancia().agregarProveedor(BeanTransformer.toProveedor(pb));
	}

	@Override
	public void eliminarProveedor(int idProveedor) throws RemoteException, DataBaseInvalidDataException{
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		CasaCentral.getInstancia().eliminarProveedor(prove);
	}

	@Override
	public void eliminarProveedor(String cuit) throws RemoteException, DataBaseInvalidDataException {
		Proveedor prove = new Proveedor();
		prove.setCuit(cuit);
		CasaCentral.getInstancia().eliminarProveedor(prove);
	}

	@Override
	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRodamiento(int idRodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void setPorcentajeDeGanancia(float porcentaje) throws RemoteException {
		CasaCentral.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	@Override
	public void nuevaCondicionVenta(CondicionVentaBean cvb)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
