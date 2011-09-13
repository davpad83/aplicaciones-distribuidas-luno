package uade.ejercicio.clase5.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import uade.ejercicio.clase5.interfaces.IAdministracion;
import uade.ejercicio.clase5.interfaces.IConsultas;
import uade.ejercicio.clase5.beans.AlumnoBean;
import uade.ejercicio.clase5.beans.DireccionBean;
import uade.ejercicio.clase5.beans.MateriaBean;
import uade.ejercicio.clase5.beans.ProfesorBean;
import uade.ejercicio.clase5.events.EventHandling;




/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Principal extends javax.swing.JFrame implements Observer{

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem agregarMateria;
	private JMenuItem eliminarMateria;
	private JPanel panelCenter = new JPanel();
	private JPanel panelRight = new JPanel();
	private JPanel panelLeft = new JPanel();
	private JLabel jLabel1;
	private JLabel intro;
	private JMenu admAlumnos;
	private JMenu admProfesores;
	private JMenu admMaterias;
	private JMenuItem agregarProfesor;
	private JMenuItem agregarAlumno;
	private JMenuItem eliminarAlumno;
	private JMenu asociaciones;
	private JMenu consultas;
	private JMenuItem obtenerAlumno;
	private JMenuItem obtenerProfesor;
	private JMenuItem obtenerCurso;
	private JMenuItem obtenerMateria;
	
	private JMenuItem listarAlumnos;
	private JMenuItem listarProfesores;
	private JMenuItem listarMaterias;
	private JMenuItem listarCursos;
	
	private JMenuBar jMenuBar1;
	private JMenuItem eliminarProfesor;
	private JMenu jMenu1;
	JButton aceptar = new JButton("Aceptar");
	JButton cancelar = new JButton("Cancelar");
	
	private static JFrame message = new JFrame();
	private static final String successMessage= "La operaci—n fue realizada con ƒxito";
	private static final String failureMessage= "No se pudo completar la operacion";
	
	//Datos del negocio
	
	//Alumno
		private JTextField legajoAlumno;
		private JTextField nombreAlumno;
		private JComboBox estadoAlumno;
		
		private AlumnoBean alumnoPedido;
		private ArrayList<AlumnoBean> listaAlumnos;
		
		//Materia
		private JTextField nombreMateria;
		private JTextField numeroMateria;
		
		//Profesor
		private JTextField legajoProfesor;
		private DireccionBean direccionProfesor;
		private JTextField vinculado;
		
		//Direccion
		private JTextField calleDireccion;
		private JTextField numeroDireccion;
		private JTextField cpDireccion;
		private JTextField localidadDireccion;
		private JTextField pisoDireccion;
		private JTextField deptoDireccion;
		
		//Curso	
		private JTextField numeroCurso;
		private JTextField profesor;
		private JTextField materia;
		private JTextField capacidad;
		private ArrayList<AlumnoBean> alumnos;
		
		
		private JMenuItem asignarAlumnoCurso;		
		
		private static EventHandling eventos = new EventHandling();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Principal inst = new Principal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setBackground(Color.LIGHT_GRAY);
				inst.setSize(700,500);
			}
		});
	}
	
	public Principal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Sistema Universidad");
			getContentPane().setLayout(thisLayout);
			
			getContentPane().add(BorderLayout.WEST, panelLeft);
			getContentPane().add(BorderLayout.CENTER, panelCenter);
			getContentPane().add(BorderLayout.EAST, panelRight);

			panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
			panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
			panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.SOUTH);
				jLabel1.setText("Copyright Matias Favale");
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
			}
			{
				jMenu1 = new JMenu();
				jMenu1.setText("Administracion");
				jMenuBar1.add(jMenu1);
				{
					admMaterias = new JMenu();
					jMenu1.add(admMaterias);
					admMaterias.setText("Materias");
					{
						agregarMateria = new JMenuItem();
						admMaterias.add(agregarMateria);
						agregarMateria.setText("Agregar Materia");
						agregarMateria.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								{
									clearScreen();
									panelCenter.setBackground(Color.white);
									
									intro = new JLabel("Agregar Materia");
									panelLeft.setAlignmentY(CENTER_ALIGNMENT);

									JLabel lnombre = new JLabel("Nombre de Materia: ");
									JLabel lnumero = new JLabel("Numero de Materia: ");
									nombreMateria = new JTextField();
									numeroMateria = new JTextField();
									
									panelCenter.add(lnombre);
									panelCenter.add(nombreMateria);
									panelCenter.add(lnumero);
									panelCenter.add(numeroMateria);
									
									panelRight.add(aceptar);
									panelRight.add(cancelar);
		
									panelLeft.add(intro);
			
									panelLeft.setVisible(true);
									panelCenter.setVisible(true);
									panelRight.setVisible(true);
									nombreMateria.requestFocus();
									
									getContentPane().validate();
								
									aceptar.addActionListener(new AgregarMateriaListener());

								}
							}
						});
						
					}
					{
						eliminarMateria = new JMenuItem();
						admMaterias.add(eliminarMateria);
						eliminarMateria.setText("Eliminar Materia");
						eliminarMateria.addActionListener(new ActionListener(){
							
							public void actionPerformed(ActionEvent e){
								clearScreen();
								panelCenter.setBackground(Color.white);
								
								intro = new JLabel("Eliminar Materia");
								JLabel lnumero = new JLabel("Numero de Materia: ");
								numeroMateria = new JTextField();
								
								panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
								
								panelCenter.add(lnumero);
								panelCenter.add(numeroMateria);
								
								panelLeft.add(intro);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
																
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								
								aceptar.addActionListener(new EliminarMateriaListener());
							}
						});
					}
				}
				{
					admProfesores = new JMenu();
					jMenu1.add(admProfesores);
					admProfesores.setText("Profesores");
					{
						agregarProfesor = new JMenuItem();
						admProfesores.add(agregarProfesor);
						agregarProfesor.setText("Agregar Profesor");
						agregarProfesor.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								clearScreen();
								intro = new JLabel("Agregar Profesor");
								
								panelCenter.setBackground(Color.white);
								JLabel intro = new JLabel("Agregar Profesor");
								JLabel lnumeroLU = new JLabel("Numero de Legajo: ");
								
								JLabel lcalle = new JLabel("Direccion: \n Calle: ");
								JLabel lnumero = new JLabel("Numero: ");
								JLabel lcp = new JLabel("Codigo Postal: ");
								JLabel llocalidad = new JLabel("Localidad: ");
								JLabel lpiso = new JLabel("Piso: ");
								JLabel ldepto = new JLabel("Departamento: ");
								
								legajoProfesor = new JTextField();
								calleDireccion = new JTextField();
								numeroDireccion = new JTextField();
								cpDireccion = new JTextField();
								localidadDireccion = new JTextField();
								pisoDireccion = new JTextField();
								deptoDireccion = new JTextField();
								
								
								panelLeft.add(intro);
								panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
								
								panelCenter.add(lnumeroLU);
								panelCenter.add(legajoProfesor);
								panelCenter.add(lcalle);
								panelCenter.add(calleDireccion);
								panelCenter.add(lnumero);
								panelCenter.add(numeroDireccion);
								panelCenter.add(lcp);
								panelCenter.add(cpDireccion);
								panelCenter.add(llocalidad);
								panelCenter.add(localidadDireccion);
								panelCenter.add(lpiso);
								panelCenter.add(pisoDireccion);
								panelCenter.add(ldepto);
								panelCenter.add(deptoDireccion);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
															
								aceptar.addActionListener(new AgregarProfesorListener());
							}
						});
					}
					{
						eliminarProfesor = new JMenuItem();
						admProfesores.add(eliminarProfesor);
						eliminarProfesor.setText("Eliminar Profesor");
						eliminarProfesor.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								clearScreen();
								panelCenter.setBackground(Color.white);
							
								intro = new JLabel("Eliminar Profesor");
								
								JLabel lnumeroLU = new JLabel("Numero de legajo: ");
								
								legajoProfesor = new JTextField();
								
								panelLeft.add(intro);
								panelCenter.add(lnumeroLU);
								panelCenter.add(legajoProfesor);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								aceptar.addActionListener(new EliminarProfesorListener());
							}
						});
					}
				}
				{
					admAlumnos = new JMenu();
					jMenu1.add(admAlumnos);
					admAlumnos.setText("Alumnos");
					{
						agregarAlumno = new JMenuItem();
						admAlumnos.add(agregarAlumno);
						agregarAlumno.setText("Agregar Alumno");
						agregarAlumno.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								clearScreen();
								panelCenter.setBackground(Color.white);
							
								intro = new JLabel("Agregar Alumno");
								
								String[] opcionesEstado= {"Activo", "Inactivo"};
								
								JLabel lnumeroLU = new JLabel("Numero de legajo: ");
								JLabel lnombre = new JLabel("Nombre: ");
								JLabel lestado = new JLabel("Numero de legajo: ");
								
								legajoAlumno = new JTextField();
								nombreAlumno = new JTextField();
								estadoAlumno = new JComboBox();
								
								for(int i=0; i<opcionesEstado.length; i++)
									estadoAlumno.addItem(opcionesEstado[i]);
								
								panelLeft.add(intro);
								
								panelCenter.add(lnumeroLU);
								panelCenter.add(legajoAlumno);
								panelCenter.add(lnombre);
								panelCenter.add(nombreAlumno);
								panelCenter.add(lestado);
								panelCenter.add(estadoAlumno);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								aceptar.addActionListener(new AgregarAlumnoListener());
							}
						});
					}
					{
						eliminarAlumno = new JMenuItem();
						admAlumnos.add(eliminarAlumno);
						eliminarAlumno.setText("Eliminar Alumno");
						eliminarAlumno.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								clearScreen();
								panelCenter.setBackground(Color.white);
							
								intro = new JLabel("Eliminar Alumno");
								
								JLabel llegajo = new JLabel("Legajo: ");
								legajoAlumno = new JTextField();
											
								
								panelLeft.add(intro);
								panelCenter.add(llegajo);
								panelCenter.add(legajoAlumno);
										
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								aceptar.addActionListener(new EliminarAlumnoListener());
							}
						});
					}
				}
			}
			{
				asociaciones = new JMenu();
				jMenuBar1.add(asociaciones);
				asociaciones.setText("Asociaciones");
				{
					asignarAlumnoCurso = new JMenuItem();
					asociaciones.add(asignarAlumnoCurso);
					asignarAlumnoCurso.setText("Asignar un Alumno a un Curso");
					asignarAlumnoCurso.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							clearScreen();
							panelCenter.setBackground(Color.white);
							
								JComboBox opcionesAlumno= new JComboBox();
								JComboBox opcionesCurso= new JComboBox();
								
//								consulta.listarAlumnos();
//								consulta.listarCursos();
							
						}
					});
				}
			}
			{
				consultas = new JMenu();
				jMenuBar1.add(consultas);
				consultas.setText("Consultas");
				{
					obtenerAlumno = new JMenuItem();
					consultas.add(obtenerAlumno);
					obtenerAlumno.setText("Obtener Alumno");
					
					obtenerAlumno.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							clearScreen();
							panelCenter.setBackground(Color.white);
							
							intro = new JLabel("Obtener Alumno");
							intro.setAlignmentY(CENTER_ALIGNMENT);
							
							JButton obtener = new JButton("Obtener");
							
							
							JLabel llegajo = new JLabel("Legajo: ");
							JLabel lnombre = new JLabel("Nombre: ");
							JLabel lestado = new JLabel("Estado: ");
							
							legajoAlumno = new JTextField();
							nombreAlumno = new JTextField();
							estadoAlumno = new JComboBox();
							
							
							panelLeft.add(intro);
							panelCenter.add(llegajo);
							panelCenter.add(legajoAlumno);
							panelCenter.add(lnombre);
							panelCenter.add(nombreAlumno);
							panelCenter.add(lestado);
							panelCenter.add(estadoAlumno);
							panelRight.add(obtener);
							panelRight.add(cancelar);
							
							getContentPane().validate();
							panelLeft.setVisible(true);
							panelCenter.setVisible(true);
							panelRight.setVisible(true);
							
							obtener.addActionListener(new obtenerAlumnoPorClaveListener());
							
						}
					});
					
				}
				{
					listarAlumnos = new JMenuItem();
					consultas.add(listarAlumnos);
					listarAlumnos.setText("Listar Alumnos");
					listarAlumnos.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								clearScreen();
								panelCenter.setBackground(Color.white);
								
								intro = new JLabel("Listar Alumnos");
								intro.setAlignmentY(CENTER_ALIGNMENT);
								
								JTextArea data = new JTextArea(alumnos.size(), 3);
								
								data.setEditable(false);
								
								alumnos = eventos.listarAlumnos();
								AlumnoBean alu = null;
								Iterator<AlumnoBean> ite = alumnos.iterator();
								while(ite.hasNext()){
									alu = ite.next();
									data.append((alu.toString()));
									data.append("\n-----------------------------\n");
								}
								
								panelLeft.add(intro);
								panelCenter.add(data);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelLeft.setVisible(true);
							}
					});
				}
			}
			{
				cancelar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						clearScreen();
					}
				});
			}
			pack();
			this.setSize(446, 331);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

	class AgregarMateriaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//debug
			System.out.println(nombreMateria.getText() + numeroMateria.getText());
			
			eventos.agregarMateriaEvent(nombreMateria.getText(), numeroMateria.getText());			
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarMateriaListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				eventos.eliminarMateriaEvent(numeroMateria.getText());
				mostrarMensajeExitoso();
			}
	}
	
	class AgregarProfesorListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			direccionProfesor = new DireccionBean();
			direccionProfesor.setCalle(calleDireccion.getText());
			direccionProfesor.setCp(cpDireccion.getText());
			direccionProfesor.setDepto(deptoDireccion.getText());
			direccionProfesor.setLocalidad(localidadDireccion.getText());
			direccionProfesor.setNumero(Integer.parseInt(numeroDireccion.getText()));
			direccionProfesor.setPiso(Integer.parseInt(pisoDireccion.getText()));
			
			eventos.agregarProfesorEvent(Integer.parseInt(legajoProfesor.getText()), direccionProfesor);
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarProfesorListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			eventos.eliminarProfesorEvent(Integer.parseInt(legajoProfesor.getText()));
			mostrarMensajeExitoso();
		}
	}
	
	class AgregarAlumnoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			eventos.agregarAlumnoEvent(Integer.parseInt(legajoAlumno.getText()), nombreAlumno.getText(), 
					(String) estadoAlumno.getSelectedItem());
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarAlumnoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			eventos.eliminarAlumnoEvent(Integer.parseInt(legajoAlumno.getText()));
			mostrarMensajeExitoso();
		}
	}
	
	class obtenerAlumnoPorClaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			alumnoPedido = eventos.obtenerAlumno(Integer.parseInt(legajoAlumno.getText()));
			
			JTextArea ta = new JTextArea();
			ta.setEditable(false);
				
			ta.setText(alumnoPedido.toString());
				
			panelCenter.removeAll();
			panelRight.removeAll();
			panelCenter.add(ta);
				
			getContentPane().validate();
			panelCenter.setVisible(true);
		}
	}
	
	private static void mostrarMensajeExitoso(){
		JOptionPane.showMessageDialog(message, successMessage);
	}
	
	private void clearScreen(){
		panelCenter.removeAll();
		panelRight.removeAll();
		panelLeft.removeAll();
		panelCenter.setBackground(Color.LIGHT_GRAY);
		getContentPane().validate();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}

