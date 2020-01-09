import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FNameInput;
	private JPanel addPanel;
	private JPanel editPanel;
	private JPanel deletePanel;
	private JTextField textField_EditFName;
	private JComboBox<String> comboBoxChooseStudent;
	private JComboBox<String> comboBoxChooseStudentToDelete;

	public JLabel getLblResponse() {
		return lblResponse;
	}

	public void setLblResponse(String response) {
		lblResponse.setText(response);
		;
	}

	public JComboBox<String> getComboBoxChooseStudent() {
		return comboBoxChooseStudent;
	}

	public void setComboBoxChooseStudent(JComboBox<String> comboBoxChooseStudent) {
		this.comboBoxChooseStudent = comboBoxChooseStudent;
	}

	public JComboBox<String> getComboBoxChooseStudentToDelete() {
		return comboBoxChooseStudentToDelete;
	}

	public void setComboBoxChooseStudentToDelete(JComboBox<String> comboBoxChooseStudentToDelete) {
		this.comboBoxChooseStudentToDelete = comboBoxChooseStudentToDelete;
	}

	private JLabel lblResponse;

	ViewController viewController;
	private JTextField textField_LNameInput;
	private JTextField textField_EditLName;

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
		setBounds(100, 100, 632, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(253, 16, 357, 478);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setVisible(false);

		// Start Add student

		addPanel = new JPanel();
		addPanel.setBackground(Color.WHITE);
		layeredPane.add(addPanel, "name_526566720530800");
		addPanel.setLayout(null);
		addPanel.setVisible(false);

		JLabel lblStudentRegistration = new JLabel("Register new Student");
		lblStudentRegistration.setFont(new Font("Arial", Font.PLAIN, 17));
		lblStudentRegistration.setBounds(15, 28, 190, 20);
		addPanel.add(lblStudentRegistration);

		JLabel lblFirstName = new JLabel("First name*");
		lblFirstName.setBounds(15, 109, 86, 20);
		addPanel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name*");
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

		// Registers new Student

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.registerNewStudent(textField_FNameInput.getText(),textField_LNameInput.getText() );
					lblResponse.setText("Student created");
					textField_FNameInput.setText("");
					textField_LNameInput.setText("");
				} catch (IllegalArgumentException iex) {
					viewController.showExceptionWindowForEmptyFields();
				}

				catch (NullPointerException nex) {
					viewController.showExceptionWindowForIDError();

				}
			}
		}

		);
		btnSave.setBounds(177, 213, 115, 29);
		addPanel.add(btnSave);

		// Start Edit Student
		editPanel = new JPanel();
		editPanel.setBackground(Color.WHITE);
		layeredPane.add(editPanel, "name_526574109746900");
		editPanel.setLayout(null);

		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEditStudent.setBounds(15, 27, 115, 20);
		editPanel.add(lblEditStudent);

		JLabel lblChooseAStudent = new JLabel("Choose a student below");
		lblChooseAStudent.setBounds(15, 63, 210, 20);
		editPanel.add(lblChooseAStudent);

		JLabel lblStudentAdministration = new JLabel("Student Administration");
		lblStudentAdministration.setFont(new Font("Arial", Font.PLAIN, 20));
		lblStudentAdministration.setBounds(15, 40, 223, 29);
		contentPane.add(lblStudentAdministration);

		JLabel lblStudentUpdated = new JLabel("");
		lblStudentUpdated.setBounds(15, 372, 309, 20);
		editPanel.add(lblStudentUpdated);
		lblStudentUpdated.setVisible(true);

		JLabel lblEnterNewFName = new JLabel("First name*");
		lblEnterNewFName.setBounds(15, 210, 156, 20);
		editPanel.add(lblEnterNewFName);
		lblEnterNewFName.setVisible(true);

		JLabel lblNameChanged = new JLabel("");
		lblNameChanged.setBounds(15, 403, 309, 20);
		editPanel.add(lblNameChanged);

		JLabel lblEditNamesLeave = new JLabel("Enter new name");
		lblEditNamesLeave.setBounds(15, 176, 309, 20);
		editPanel.add(lblEditNamesLeave);
		lblEditNamesLeave.setVisible(true);

		JLabel lblNewLastname = new JLabel("Last name*");
		lblNewLastname.setBounds(15, 235, 115, 20);
		editPanel.add(lblNewLastname);
		lblNewLastname.setVisible(true);

		textField_EditLName = new JTextField();
		textField_EditLName.setBounds(178, 232, 146, 26);
		editPanel.add(textField_EditLName);
		textField_EditLName.setColumns(10);
		textField_EditLName.setVisible(true);

		comboBoxChooseStudent = new JComboBox<String>(viewController.getStudents());	
		comboBoxChooseStudent.setSize(309, 26);
		comboBoxChooseStudent.setLocation(15, 99);
		editPanel.add(comboBoxChooseStudent);

		textField_EditFName = new JTextField();
		textField_EditFName.setBounds(178, 207, 146, 26);
		editPanel.add(textField_EditFName);
		textField_EditFName.setColumns(10);
		textField_EditFName.setVisible(true);

		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(178, 285, 146, 29);
		editPanel.add(btnSaveChanges);
		btnSaveChanges.setVisible(true);

		// Change name of Student
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ 
			String studentName = comboBoxChooseStudent.getSelectedItem().toString();
				
				viewController.editStudent(studentName, textField_EditFName.getText(), textField_EditLName.getText());
				lblStudentUpdated.setText("Student changed:");
				lblNameChanged.setText(viewController.findStudentName(viewController.stripString(studentName)));
				textField_EditFName.setText("");
				textField_EditLName.setText("");}
				catch(IllegalArgumentException iex) {
					viewController.showExceptionWindowForEmptyFields();
				}
				catch(NullPointerException nex) {
					viewController.showExceptionWindowForNoStudent();
				}
			}
		}

		);

		// Start Delete Student

		deletePanel = new JPanel();
		deletePanel.setBackground(Color.WHITE);
		layeredPane.add(deletePanel, "name_526566720530800");
		deletePanel.setLayout(null);
		deletePanel.setVisible(false);

		JLabel lblStudentDelete = new JLabel("Delete Student");
		lblStudentDelete.setFont(new Font("Arial", Font.PLAIN, 17));
		lblStudentDelete.setBounds(15, 28, 190, 20);
		deletePanel.add(lblStudentDelete);

		JLabel lblChooseAStudentToDelete = new JLabel("Choose a student below");
		lblChooseAStudentToDelete.setBounds(15, 63, 210, 20);
		deletePanel.add(lblChooseAStudentToDelete);

		comboBoxChooseStudentToDelete = new JComboBox<String>(viewController.getStudents());

		comboBoxChooseStudentToDelete.setSize(309, 26);
		comboBoxChooseStudentToDelete.setLocation(15, 99);
		deletePanel.add(comboBoxChooseStudentToDelete);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setVisible(true);
		btnDelete.setBounds(209, 176, 115, 29);
		deletePanel.add(btnDelete);

		JLabel lbl_DeleteRespons = new JLabel("");
		lbl_DeleteRespons.setBounds(15, 272, 190, 20);
		deletePanel.add(lbl_DeleteRespons);

		comboBoxChooseStudentToDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				comboBoxChooseStudentToDelete = (JComboBox<String>) e.getSource();


			}
		});

		// Delete student from register
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = viewController.showConfirmWindowForDeleting();
				if (choice == JOptionPane.YES_OPTION) {
					try {
						String student = (String) comboBoxChooseStudentToDelete.getSelectedItem();
						viewController.deleteStudent(student);
						lblStudentUpdated.setText(student);
						btnDelete.setVisible(true);
						lbl_DeleteRespons.setText("Student deleted");

					} catch (NullPointerException nex) {
						lbl_DeleteRespons.setText("No student found");
						
						lblNameChanged.setVisible(false);
					}
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
				deletePanel.setVisible(false);
			}
		});
		btnRegisterNewStudent.setBounds(15, 108, 204, 29);
		contentPane.add(btnRegisterNewStudent);

		JButton btnFindStudent = new JButton("Edit Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.setVisible(true);
				addPanel.setVisible(false);
				editPanel.setVisible(true);
				deletePanel.setVisible(false);
			}
		});
		btnFindStudent.setBounds(15, 153, 204, 29);
		contentPane.add(btnFindStudent);

		JButton btnBackToStart = new JButton("Back to main menu");
		btnBackToStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewController.returnToMain();

			}
		});
		btnBackToStart.setBounds(15, 449, 204, 29);
		contentPane.add(btnBackToStart);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.setVisible(true);
				addPanel.setVisible(false);
				editPanel.setVisible(false);
				deletePanel.setVisible(true);
			}
		});
		btnDeleteStudent.setBounds(15, 198, 204, 29);
		contentPane.add(btnDeleteStudent);
		
		JButton btnShowAllStudents = new JButton("Show all students");
		btnShowAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewStudentData();
			}
		});
		btnShowAllStudents.setBounds(15, 243, 204, 29);
		contentPane.add(btnShowAllStudents);

	}

}
