package com.adtpo.admin.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class AbstractInternalFrame extends JInternalFrame {

	protected static final String lblSpace = ": ";
	
	protected JButton aceptar = new JButton("Aceptar");
	protected JButton cancelar = new JButton("Cancelar");
	protected JButton restablecerCampos = new JButton("Restablecer");
	
	protected JPanel center = new JPanel();
	protected JPanel south = new JPanel();
	
	private GridBagConstraints constraints = new GridBagConstraints();
	
	public AbstractInternalFrame(){
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		getContentPane().add(center, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);
		
		center.setLayout(new GridBagLayout());
		constraints.insets = new Insets(3,3,3,3);
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));
        south.add(Box.createHorizontalGlue()); // botones alineados a la derecha
        south.add(Box.createRigidArea(new Dimension(10, 0))); // separaci—n entre botones
        south.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		
		setVisible(true);
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		restablecerCampos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Component c: center.getComponents()){
					if(c instanceof JTextField){
						JTextField ct = (JTextField) c;
						ct.setText("");
					}else if(c instanceof JComboBox){
						JComboBox jcb = (JComboBox) c;
						jcb.setSelectedItem(jcb.getItemAt(1));
					}
				}
			}
		});
	}
	
	public void addField(String label, JComponent component) {
        addField(new JLabel(label), component);
    }
	
	public void addField(JLabel label, JComponent component) {
        constraints.gridx = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        Class<?> clazz = component.getClass();

        constraints.fill = GridBagConstraints.NONE;
        if(JScrollPane.class == clazz)
            constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        else
            constraints.anchor = GridBagConstraints.LINE_END;
        center.add(label, constraints);

        constraints.gridx = 1;

        if(JScrollPane.class == clazz) {
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.BOTH;
            center.add(component, constraints);
        } else if(JTextField.class == clazz) {
            JTextField textField = (JTextField) component;
            if(textField.getColumns() == 0) {
                // si no se ha especificado un nœmero de columnas
                // el componente ser‡ tan ancho como la quepa en la ventana
                constraints.fill = GridBagConstraints.HORIZONTAL;
                textField.setColumns(10);
            } else {
                // esto arregla un problema que ocurre
                // cuando el componente no cabe en anchura
                textField.setMinimumSize(textField.getPreferredSize());
                constraints.anchor = GridBagConstraints.LINE_START;
            }
            center.add(component, constraints);
        } else {
            constraints.anchor = GridBagConstraints.LINE_START;
            center.add(component, constraints);
        }
        label.setLabelFor(component); // accesibilidad

        constraints.gridy++;
    }
}
