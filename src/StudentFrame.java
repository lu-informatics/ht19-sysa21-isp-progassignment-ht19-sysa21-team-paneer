import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JPanel registerPane; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel addStudent = new Panel();
		addStudent.setBounds(287, 28, 298, 461);
		contentPane.add(addStudent);
		addStudent.setVisible(false);
		addStudent.setLayout(null);
		
		Panel editStudent = new Panel();
		editStudent.setBounds(0, 10, 298, 460);
		contentPane.add(editStudent);
		editStudent.setVisible(false);
		editStudent.setEnabled(true);
		editStudent.setLayout(null);

		
		
		JLabel lblStudentAdministration = new JLabel("Student Administration");
		lblStudentAdministration.setBounds(15, 41, 204, 20);
		contentPane.add(lblStudentAdministration);
		
		JButton btnRegisterNewStudent = new JButton("Register new Student");
		btnRegisterNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent.setVisible(true);
			}
		});
		btnRegisterNewStudent.setBounds(15, 129, 204, 29);
		contentPane.add(btnRegisterNewStudent);
		
		JButton btnFindStudent = new JButton("Edit Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editStudent.setVisible(true);
			}
		});
		btnFindStudent.setBounds(15, 208, 204, 29);
		contentPane.add(btnFindStudent);
		
		
		
		JLabel lblRegisterNewStudent = new JLabel("Register new student");
		lblRegisterNewStudent.setBounds(75, 5, 148, 20);
		addStudent.add(lblRegisterNewStudent);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 92, 69, 20);
		addStudent.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(137, 89, 146, 26);
		addStudent.add(textField);
		textField.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(15, 165, 107, 20);
		addStudent.add(lblStudentId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 162, 146, 26);
		addStudent.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(137, 274, 115, 29);
		addStudent.add(btnSave);
		
		
		
		JLabel lblFindStudent = new JLabel("Edit Student");
		lblFindStudent.setBounds(104, 5, 89, 20);
		editStudent.add(lblFindStudent);
		
		JLabel lblChooseStudentTo = new JLabel("Choose Student to edit");
		lblChooseStudentTo.setBounds(15, 50, 206, 20);
		editStudent.add(lblChooseStudentTo);
		
		JLabel lblHrSkaEn = new JLabel("H\u00C4R SKA EN COMBO BOX VARA");
		lblHrSkaEn.setBounds(15, 109, 233, 20);
		editStudent.add(lblHrSkaEn);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 219, 146, 26);
		editStudent.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(15, 197, 69, 20);
		editStudent.add(lblName_1);
		
		JLabel lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setBounds(15, 276, 89, 20);
		editStudent.add(lblStudentId_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(15, 299, 146, 26);
		editStudent.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(15, 370, 89, 29);
		editStudent.add(btnSave_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(132, 370, 89, 29);
		editStudent.add(btnDelete);
	}
}
