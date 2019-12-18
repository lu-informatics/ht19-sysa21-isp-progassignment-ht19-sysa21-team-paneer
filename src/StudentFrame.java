import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.Font;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FNameInput;
	private JPanel addPanel;
	private JPanel editPanel;
	private JTextField textField_EditName;

	public JLabel getLblResponse() {
		return lblResponse;
	}

	public void setLblResponse(JLabel lblResponse) {
		this.lblResponse = lblResponse;
	}

	private JLabel lblResponse;
	private JTextField textFindStudentById;

	ViewController viewController;
	private JTextField textField_LNameInput;

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
		
		this.viewController = viewController;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(253, 16, 357, 598);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setVisible(false);
		
		//Start Add student

		addPanel = new JPanel();
		layeredPane.add(addPanel, "name_526566720530800");
		addPanel.setLayout(null);
		addPanel.setVisible(false);

		JLabel lblStudentRegistration = new JLabel("Register new Student");
		lblStudentRegistration.setBounds(15, 48, 190, 20);
		addPanel.add(lblStudentRegistration);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(15, 109, 86, 20);
		addPanel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(15, 165, 86, 20);
		addPanel.add(lblLastName);

		textField_LNameInput = new JTextField();
		textField_LNameInput.setBounds(116, 162, 178, 26);
		addPanel.add(textField_LNameInput);
		textField_LNameInput.setColumns(10);

		textField_FNameInput = new JTextField();
		textField_FNameInput.setBounds(116, 106, 178, 26);
		addPanel.add(textField_FNameInput);
		textField_FNameInput.setColumns(10);

		JLabel lblResponse = new JLabel("");
		lblResponse.setBounds(15, 310, 277, 20);
		addPanel.add(lblResponse);

		JLabel lblStudentId = new JLabel("");
		lblStudentId.setBounds(15, 397, 277, 20);
		addPanel.add(lblStudentId);

		JLabel lblNameRegistered = new JLabel("");
		lblNameRegistered.setBounds(15, 361, 277, 20);
		addPanel.add(lblNameRegistered);
		
		//Registers new Student

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nameInput = textField_FNameInput.getText() + " " + textField_LNameInput.getText();
				String studentId = viewController.generateStudentID();
				viewController.registerNewStudent(studentId, nameInput);
				lblResponse.setText("Student created:");
				lblNameRegistered.setText("Name: " + viewController.findStudentName(studentId));
				lblStudentId.setText("Student ID: " + viewController.findStudentiD(studentId));
				textField_FNameInput.setText(" ");
				textField_LNameInput.setText(" ");}
				catch(NullPointerException nex) {
					lblResponse.setText("Something went wrong. Please contact admin.");

				}
			}
		}

		);
		btnSave.setBounds(177, 213, 115, 29);
		addPanel.add(btnSave);
		
		//Start Edit Student
		editPanel = new JPanel();
		layeredPane.add(editPanel, "name_526574109746900");
		editPanel.setLayout(null);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(178, 553, 146, 29);
		editPanel.add(btnDeleteStudent);
		btnDeleteStudent.setVisible(false);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(178, 455, 146, 29);
		editPanel.add(btnSaveChanges);
		btnSaveChanges.setVisible(false);
		
		textField_EditName = new JTextField();
		textField_EditName.setBounds(15, 456, 146, 26);
		editPanel.add(textField_EditName);
		textField_EditName.setColumns(10);
		textField_EditName.setVisible(false);
		
		JLabel lblStudentAdministration = new JLabel("Student Administration");
		lblStudentAdministration.setBounds(15, 69, 204, 20);
		contentPane.add(lblStudentAdministration);

	

		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setBounds(15, 53, 115, 20);
		editPanel.add(lblEditStudent);

		JLabel lblChooseAStudent = new JLabel("Choose a student below");
		lblChooseAStudent.setBounds(15, 89, 210, 20);
		editPanel.add(lblChooseAStudent);

		JLabel lblStudentFound = new JLabel("");
		lblStudentFound.setBounds(15, 283, 309, 20);
		editPanel.add(lblStudentFound);
		lblStudentFound.setVisible(false);

		JLabel lblEnterNewName = new JLabel("Enter new name");
		lblEnterNewName.setBounds(15, 416, 156, 20);
		editPanel.add(lblEnterNewName);
		lblEnterNewName.setVisible(false);

		JLabel showName = new JLabel("");
		showName.setBounds(15, 269, 69, 20);
		editPanel.add(showName);

		JLabel showID = new JLabel("");
		showID.setBounds(15, 336, 69, 20);
		editPanel.add(showID);

		JLabel lblNameFound = new JLabel("");
		lblNameFound.setBounds(15, 319, 254, 20);
		editPanel.add(lblNameFound);

		JComboBox studentBox = new JComboBox();
		studentBox.setSize(309, 26);
		studentBox.setLocation(15, 125);
		editPanel.add(studentBox);

		JLabel lblOrSearchBy = new JLabel("Or search by Student ID");
		lblOrSearchBy.setBounds(15, 175, 186, 20);
		editPanel.add(lblOrSearchBy);

		JLabel lblUseFormatS = new JLabel("Use format S10000-99999");
		lblUseFormatS.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblUseFormatS.setBounds(15, 233, 146, 20);
		editPanel.add(lblUseFormatS);

		textFindStudentById = new JTextField();
		textFindStudentById.setBounds(15, 211, 146, 26);
		editPanel.add(textFindStudentById);
		textFindStudentById.setColumns(10);

		JLabel labelIdFound = new JLabel("");
		labelIdFound.setBounds(15, 355, 254, 20);
		editPanel.add(labelIdFound);
		
//shows name and Id of the student searched for
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String input = textFindStudentById.getText();
				lblStudentFound.setVisible(true);
				labelIdFound.setVisible(true);
				lblNameFound.setVisible(true);
				lblStudentFound.setText("Student found:");
				labelIdFound.setText(viewController.findStudentiD(input));
				lblNameFound.setText(viewController.findStudentName(input));
				btnDeleteStudent.setVisible(true);
				btnSaveChanges.setVisible(true);
				textField_EditName.setVisible(true);
				lblEnterNewName.setVisible(true);}
				catch(NullPointerException nex) {
					lblStudentFound.setVisible(true);
					lblStudentFound.setText("No Student found");
					
				}
			}
		});

		btnSearch.setBounds(190, 211, 79, 26);
		editPanel.add(btnSearch);
		
		//Change name of Student
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.editStudent(textFindStudentById.getText(), textField_EditName.getText());
				lblStudentFound.setText("Student updated");
				labelIdFound.setText(viewController.findStudentiD(textFindStudentById.getText()));
				lblNameFound.setText(viewController.findStudentName(textFindStudentById.getText()));
			}
		});

		// Delete student
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.deleteStudent(
					viewController.studentRegister.findStudent(textFindStudentById.getText()).getStudentId());
					lblStudentFound.setText("Student deleted");
					labelIdFound.setVisible(false);
					lblNameFound.setVisible(false);
				} catch (NullPointerException nex) {
					lblStudentFound.setText("No student found");
					labelIdFound.setVisible(false);
					lblNameFound.setVisible(false);
				}
			}
		});
		
//Start buttons
		

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
