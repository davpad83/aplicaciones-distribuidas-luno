package uade.ejercicio.clase1.vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import uade.ejercicio.clase1.controlador.AdministracionImpl;
import uade.ejercicio.clase1.controlador.IAdministracion;
import uade.ejercicio.clase1.controlador.IConsultas;
import uade.ejercicio.clase1.negocio.Alumno;
import uade.ejercicio.clase1.negocio.Direccion;
import uade.ejercicio.clase1.negocio.Materia;
import uade.ejercicio.clase1.negocio.Profesor;




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
public class Principal extends javax.swing.JFrame {

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
	private static final String successMessage= "La operación fue realizada con éxito";
	private static final String failureMessage= "No se pudo completar la operacion";
	
	//Datos del negocio
	
	//Alumno
		AlumnoView alumno = null;
		private int legajoAlumno;
		private String nombreAlumno;
		private String estadoAlumno;
		
		//Materia
		private String nombreMateria;
		private String numeroMateria;
		
		//Profesor
		private int legajoProfesor;
		private Direccion direccionProfesor;
		private List<MateriaView> vinculado;
		
		//Direccion
		private String calleDireccion;
		private int numeroDireccion;
		private String cpDireccion;
		private String localidadDireccion;
		private int pisoDireccion;
		private String deptoDireccion;
		
		//Curso	
		private int numeroCurso;
		private ProfesorView profesor;
		private MateriaView materia;
		private int capacidad;
		private ArrayList<AlumnoView> alumnos;
		
		
		private JMenuItem asignarAlumnoCurso;		
		private static final IAdministracion admin = new AdministracionImpl();	
	
	
		private static IConsultas consulta;
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
									JTextField nombre = new JTextField();
									JTextField numero = new JTextField();
									
									panelCenter.add(lnombre);
									panelCenter.add(nombre);
									panelCenter.add(lnumero);
									panelCenter.add(numero);
									
									panelRight.add(aceptar);
									panelRight.add(cancelar);
		
									panelLeft.add(intro);
			
									getContentPane().validate();
									panelLeft.setVisible(true);
									panelCenter.setVisible(true);
									panelRight.setVisible(true);
									
									nombreMateria = nombre.getText();
									numeroMateria = numero.getText();
									
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
								JTextField numero = new JTextField();
								
								panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
								
								panelCenter.add(lnumero);
								panelCenter.add(numero);
								
								panelLeft.add(intro);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
																
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								numeroMateria = numero.getText();
								
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
								
								JTextField numeroLU = new JTextField();
								JTextField calle = new JTextField();
								JTextField numero = new JTextField();
								JTextField cp = new JTextField();
								JTextField localidad = new JTextField();
								JTextField piso = new JTextField();
								JTextField depto = new JTextField();
								
								panelLeft.add(intro);
								panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
								
								panelCenter.add(lnumeroLU);
								panelCenter.add(numeroLU);
								panelCenter.add(lcalle);
								panelCenter.add(calle);
								panelCenter.add(lnumero);
								panelCenter.add(numero);
								panelCenter.add(lcp);
								panelCenter.add(cp);
								panelCenter.add(llocalidad);
								panelCenter.add(localidad);
								panelCenter.add(lpiso);
								panelCenter.add(piso);
								panelCenter.add(ldepto);
								panelCenter.add(depto);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
															
								legajoProfesor = Integer.parseInt(numeroLU.getText());
								calleDireccion = calle.getText();
								numeroDireccion = Integer.parseInt(numero.getText());
								cpDireccion = cp.getText();
								localidadDireccion = localidad.getText();
								pisoDireccion = Integer.parseInt(piso.getText());
								deptoDireccion = depto.getText();
								
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
								
								JTextField numeroLU = new JTextField();
								
								panelLeft.add(intro);
								panelCenter.add(lnumeroLU);
								panelCenter.add(numeroLU);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								legajoProfesor = Integer.parseInt(numeroLU.getText());
						
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
								
								JTextField numeroLU = new JTextField();
								JTextField nombre = new JTextField();
								JComboBox estado = new JComboBox();
								
								for(int i=0; i<opcionesEstado.length; i++)
									estado.addItem(opcionesEstado[i]);
								
								panelLeft.add(intro);
								
								panelCenter.add(lnumeroLU);
								panelCenter.add(numeroLU);
								panelCenter.add(lnombre);
								panelCenter.add(nombre);
								panelCenter.add(lestado);
								panelCenter.add(estado);
								
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								legajoAlumno = Integer.parseInt(numeroLU.getText());
								nombreAlumno = nombre.getText(); 
								estadoAlumno = (String) estado.getSelectedItem();
								
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
								JTextField legajo = new JTextField();
											
								
								panelLeft.add(intro);
								panelCenter.add(llegajo);
								panelCenter.add(legajo);
								panelRight.add(aceptar);
								panelRight.add(cancelar);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
								panelLeft.setVisible(true);
								
								legajoAlumno = Integer.parseInt(legajo.getText());
						
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
								
								consulta.listarAlumnos();
								consulta.listarCursos();
							
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
							
							
							
							JLabel llegajo = new JLabel("Legajo: ");
							JLabel lnombre = new JLabel("Nombre: ");
							JLabel lestado = new JLabel("Estado: ");
							
							JTextField legajo = new JTextField();
							JTextField nombre = new JTextField();
							JTextField estado = new JTextField();
							
							aceptar.setText("Obtener");							
							
							panelLeft.add(intro);
							panelCenter.add(llegajo);
							panelCenter.add(legajo);
							panelCenter.add(lnombre);
							panelCenter.add(nombre);
							panelCenter.add(lestado);
							panelCenter.add(estado);
							panelRight.add(aceptar);
							panelRight.add(cancelar);
							
							getContentPane().validate();
							panelLeft.setVisible(true);
							panelCenter.setVisible(true);
							panelRight.setVisible(true);
							
							if(!legajo.getText().isEmpty()){
								legajoAlumno = Integer.parseInt(legajo.getText());
								aceptar.addActionListener(new obtenerAlumnoPorClaveListener());
								JTextArea ta = new JTextArea();
							
								ta.setText(alumno.toString());
								
								panelCenter.removeAll();
								panelRight.removeAll();
								panelCenter.add(ta);
								getContentPane().validate();
								panelCenter.setVisible(true);
							}
//							else
							
							
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
								
								ArrayList<Alumno> alumnos = consulta.listarAlumnos();
								
								JTextArea data = new JTextArea(alumnos.size(), 3);
								JScrollPane sp = new JScrollPane(data);
								
								sp.setAutoscrolls(true);
								
								data.append("Legajo          |  Nombre                        |  Estado          |\n");
								
								int i=0;
								while(i < alumnos.size()){ 
										data.append(String.valueOf(alumnos.get(i).getLegajo()));
										data.append(" | ");
										data.append(alumnos.get(i).getNombre());
										data.append(" | ");
										data.append(alumnos.get(i).getEstado());
										data.append("\n");
										i++;
								}
								
								panelLeft.add(intro);
								panelCenter.add(sp);
								
								getContentPane().validate();
								panelCenter.setVisible(true);
								panelRight.setVisible(true);
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
			admin.agregarMateria(nombreMateria, numeroMateria);			
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarMateriaListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				admin.eliminarMateria(numeroMateria);
				mostrarMensajeExitoso();
			}
	}
	
	class AgregarProfesorListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			direccionProfesor = new Direccion(calleDireccion, numeroDireccion, cpDireccion
					, localidadDireccion, pisoDireccion, deptoDireccion);
			admin.agregarProfesor(legajoProfesor, direccionProfesor);
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarProfesorListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			admin.eliminarProfesor(legajoProfesor);
			mostrarMensajeExitoso();
		}
	}
	
	class AgregarAlumnoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			admin.agregarAlumno(legajoAlumno, nombreAlumno, estadoAlumno);
			mostrarMensajeExitoso();
		}
	}
	
	class EliminarAlumnoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			admin.eliminarAlumno(legajoAlumno);
			mostrarMensajeExitoso();
		}
	}
	
	class obtenerAlumnoPorClaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			alumno = consulta.mostrarAlumnoPorClave(legajoAlumno);
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
}

