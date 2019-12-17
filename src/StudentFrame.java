import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class StudentFrame extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textField_NameInput;
	private JPanel addPanel;
	private JPanel editPanel;
	private JTextField textField_2;
	private ComboBox<String> studentBox;
	private JLabel lblResponse;

	ViewController viewController;
	private JTextField textFindStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewController viewController = new ViewController();
					StudentFrame frame = new StudentFrame(viewController);
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
	public StudentFrame(ViewController viewController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(253, 16, 357, 497);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setVisible(false);

		addPanel = new JPanel();
		layeredPane.add(addPanel, "name_526566720530800");
		addPanel.setLayout(null);
		addPanel.setVisible(false);

		JLabel lblStudentRegistration = new JLabel("Register new Student");
		lblStudentRegistration.setBounds(15, 48, 190, 20);
		addPanel.add(lblStudentRegistration);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(15, 109, 69, 20);
		addPanel.add(lblName);

		textField_NameInput = new JTextField();
		textField_NameInput.setBounds(114, 106, 178, 26);
		addPanel.add(textField_NameInput);
		textField_NameInput.setColumns(10);

		JLabel lblResponse = new JLabel("");
		lblResponse.setBounds(15, 253, 277, 20);
		addPanel.add(lblResponse);

		JLabel lblStudentId = new JLabel("");
		lblStudentId.setBounds(15, 340, 277, 20);
		addPanel.add(lblStudentId);

		JLabel lblNameRegistered = new JLabel("");
		lblNameRegistered.setBounds(15, 304, 277, 20);
		addPanel.add(lblNameRegistered);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameInput = textField_NameInput.getText();
				if (!nameInput.equals("")) {
					String studentId = viewController.generateStudentID();
					viewController.registerNewStudent(nameInput, studentId);
					lblResponse.setText("Student created:");
					lblNameRegistered.setText("Name: " + nameInput);
					lblStudentId.setText("New StudentID: " + studentId);
					textField_NameInput.setText(" ");
				} else {
					lblResponse.setText("error");
				}
			}
		}

		);
		btnSave.setBounds(177, 161, 115, 29);
		addPanel.add(btnSave);

		editPanel = new JPanel();
		layeredPane.add(editPanel, "name_526574109746900");
		editPanel.setLayout(null);

		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setBounds(15, 53, 115, 20);
		editPanel.add(lblEditStudent);

		JLabel lblChooseAStudent = new JLabel("Choose a student below");
		lblChooseAStudent.setBounds(15, 89, 210, 20);
		editPanel.add(lblChooseAStudent);
		
		JComboBox studentBox = new JComboBox();
		studentBox.setSize(309, 26);
		studentBox.setLocation(15, 125);
		editPanel.add(studentBox);

		textField_2 = new JTextField();
		textField_2.setBounds(159, 351, 146, 26);
		editPanel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblEnterNewName = new JLabel("Edit name");
		lblEnterNewName.setBounds(15, 354, 115, 20);
		editPanel.add(lblEnterNewName);

		JLabel showName = new JLabel("");
		showName.setBounds(15, 269, 69, 20);
		editPanel.add(showName);

		JLabel showID = new JLabel("");
		showID.setBounds(15, 319, 69, 20);
		editPanel.add(showID);

		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(159, 407, 146, 29);
		editPanel.add(btnSaveChanges);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentId = viewController.studentRegister.findStudent(showID.getText()).getStudentId();
				viewController.deleteStudent(studentId);
			}
		});
		btnDeleteStudent.setBounds(159, 452, 146, 29);
		editPanel.add(btnDeleteStudent);
		
		JLabel lblOrSearchBy = new JLabel("Or search by Student ID");
		lblOrSearchBy.setBounds(15, 175, 186, 20);
		editPanel.add(lblOrSearchBy);
		
		textFindStudent = new JTextField();
		textFindStudent.setBounds(15, 211, 146, 26);
		editPanel.add(textFindStudent);
		textFindStudent.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(190, 211, 79, 26);
		editPanel.add(btnSearch);
		editPanel.setVisible(false);

		JLabel lblStudentAdministration = new JLabel("Student Administration");
		lblStudentAdministration.setBounds(15, 69, 204, 20);
		contentPane.add(lblStudentAdministration);

		JButton btnRegisterNewStudent = new JButton("Register new Student");
		btnRegisterNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				editPanel.setVisible(false);
				addPanel.setVisible(true);
			}
		});
		btnRegisterNewStudent.setBounds(15, 174, 204, 29);
		contentPane.add(btnRegisterNewStudent);

		JButton btnFindStudent = new JButton("Edit Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.setVisible(true);
				addPanel.setVisible(false);
				editPanel.setVisible(true);

			}
		});
		btnFindStudent.setBounds(15, 240, 204, 29);
		contentPane.add(btnFindStudent);

	}

	
	
	
	}

