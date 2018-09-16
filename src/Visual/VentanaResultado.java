package Visual;
import persistencia.Propiedades;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ValueObjet.Examen;
import logica.Excepciones.objetos.Exc_AccessoBD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaResultado extends JFrame {

	private JPanel contentPane;
	private JTextField txtfcedula;
	private JTextField txtfcalificacion;
	public VentanaResultadoController micontrolador ;
	public String codigoseleccionado;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaResultado frame = new VentanaResultado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public VentanaResultado() throws ClassNotFoundException, SQLException, Exc_AccessoBD  {
		micontrolador = new VentanaResultadoController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Por favor, seleccione un examen: ");
		lblNewLabel.setBounds(10, 191, 256, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 30, 89, 32);
		contentPane.add(lblCedula);
		
		JLabel lblCalificacion = new JLabel("Calificacion");
		lblCalificacion.setBounds(10, 89, 89, 32);
		contentPane.add(lblCalificacion);
		
		txtfcedula = new JTextField();
		txtfcedula.setBounds(79, 34, 127, 25);
		contentPane.add(txtfcedula);
		txtfcedula.setColumns(10);
		
		txtfcalificacion = new JTextField();
		txtfcalificacion.setColumns(10);
		txtfcalificacion.setBounds(79, 92, 127, 26);
		contentPane.add(txtfcalificacion);
		
		JButton btningresar = new JButton("Ingresar Calificacion");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtfcalificacion.getText() != null && txtfcedula.getText() != null && codigoseleccionado != null ) {
					int calificacion = Integer.parseInt(txtfcalificacion.getText());
					int cedula = Integer.parseInt(txtfcedula.getText());
					micontrolador.IngresarResultado(codigoseleccionado,cedula,calificacion);
					JOptionPane.showMessageDialog(null, "Resulato ingresado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No pueden haber campos vacios y debe seleccionar al menos un examen", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		btningresar.setBounds(10, 144, 195, 23);
		contentPane.add(btningresar);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 234, 298, 181);
		contentPane.add(scrollPane1);
		String[] Columnas = {"Examenes"};
		String[][] Datos= null;
		DefaultTableModel model= new DefaultTableModel(Datos,Columnas);
		table_1 = new JTable(model);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedrowindex = table_1.getSelectedRow();
				codigoseleccionado = model.getValueAt(selectedrowindex, 0).toString();
			}
		});
		scrollPane1.setViewportView(table_1);		
		LinkedList <Examen> examenes = null;
		
		examenes = micontrolador.ListarExamenes();
		if(examenes!= null) {
			
			for (int i = 0; i < examenes.size(); i++) {

				Object[] rowdata = {examenes.get(i).getCodigo()};
				model.addRow(rowdata);
			}
		
	}
}
	
}
