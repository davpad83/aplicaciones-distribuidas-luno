
package com.adtpo.cpr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hql.ConsultasHQL;
import com.adtpo.cpr.ro.IConsultas;

public class ConsultasImpl extends UnicastRemoteObject implements IConsultas{

	private static final long serialVersionUID = -3560261702113313260L;

	protected ConsultasImpl() throws RemoteException {
		//empty
	}

	@Override
	public ProveedorBean getProveedor(int idProveedor) throws RemoteException, Exception {
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		return BeanTransformer.toProveedorBean(CasaCentral.getInstancia()
				.getProveedor(prove));
	}
	@Override
	public ClienteBean getCliente(int idCliente) throws RemoteException {
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		try {
			return BeanTransformer.toClienteBean(OficinaVentas.getInstancia().getCliente(cl));
		} catch (DataBaseInvalidDataException e) {
			System.err.print(e.mensaje);
		}
		return null;
	}
	
	@Override
	public ArrayList<ProveedorBean> getProveedores()
			throws RemoteException {
		return BeanTransformer.toProveedorBeanList(ConsultasHQL.getInstancia().getProveedores());
	}

	@Override
	public float getPorcentajeGanancia() throws RemoteException{
		return CasaCentral.getInstancia().getPorcentajeGanancia();
	}

	@Override
	public ArrayList<ListasProveedorBean> getListasProveedor(int idProveedor)
			throws RemoteException {
		return BeanTransformer.toListasProveedorBeanList(CasaCentral.getInstancia().getListasProveedor(idProveedor));
	}

}
