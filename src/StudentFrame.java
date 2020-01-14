import java.awt.CardLayout;
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 632, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(253, 16, 357, 478);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setVisible(false);

		// Start Add student Panel
		addPanel = new JPanel();
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

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.registerNewStudent(textField_FNameInput.getText(), textField_LNameInput.getText());
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

		// Start Edit Student Panel
		editPanel = new JPanel();
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

		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String studentName = comboBoxChooseStudent.getSelectedItem().toString();

					viewController.editStudent(studentName, textField_EditFName.getText(),
							textField_EditLName.getText());
					lblStudentUpdated.setText("Student changed:");
					lblNameChanged.setText(viewController.findStudentName(viewController.stripString(studentName)));
					textField_EditFName.setText("");
					textField_EditLName.setText("");
				} catch (IllegalArgumentException iex) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (NullPointerException nex) {
					viewController.showExceptionWindowForNoStudent();
				}
			}
		}

		);

		// Start Delete Student Panel
		deletePanel = new JPanel();
		layeredPane.add(deletePanel, "name_526566720530800");
		deletePanel.setVisible(false);
		deletePanel.setLayout(null);

		JLabel lblStudentDelete = new JLabel("Delete Student");
		lblStudentDelete.setBounds(15, 28, 190, 20);
		lblStudentDelete.setFont(new Font("Arial", Font.PLAIN, 17));
		deletePanel.add(lblStudentDelete);

		JLabel lblChooseAStudentToDelete = new JLabel("Choose a student below");
		lblChooseAStudentToDelete.setBounds(15, 63, 210, 20);
		deletePanel.add(lblChooseAStudentToDelete);

		comboBoxChooseStudentToDelete = new JComboBox<String>(viewController.getStudents());
		comboBoxChooseStudentToDelete.setBounds(15, 99, 309, 26);
		deletePanel.add(comboBoxChooseStudentToDelete);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(209, 176, 115, 29);
		btnDelete.setVisible(true);
		deletePanel.add(btnDelete);

		JLabel lbl_DeleteRespons = new JLabel("");
		lbl_DeleteRespons.setBounds(15, 272, 190, 20);
		deletePanel.add(lbl_DeleteRespons);

		

	btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = viewController.showConfirmWindowForDeleting();
				if (choice == JOptionPane.YES_OPTION) {
					try {
						String student = (String) comboBoxChooseStudentToDelete.getSelectedItem();
						viewController.deleteStudent(student);
						lbl_DeleteRespons.setText("Student deleted");

					} catch (NullPointerException nex) {
						viewController.showExceptionWindowForNoStudent();
						lblNameChanged.setVisible(false);
					}
				} else if (choice == JOptionPane.NO_OPTION) {
					lbl_DeleteRespons.setText("");
					{
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
		btnFindStudent.setBounds(15, 141, 204, 29);
		contentPane.add(btnFindStudent);

		JButton btnBackToStart = new JButton("Return to main menu");
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
		btnDeleteStudent.setBounds(15, 175, 204, 29);
		contentPane.add(btnDeleteStudent);

		JButton btnShowAllStudents = new JButton("View all students");
		btnShowAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				viewController.viewStudentData();}
				catch(NullPointerException exception) {
					viewController.showExceptionWindowForIDError();
				}
			}
		});
		btnShowAllStudents.setBounds(15, 208, 204, 29);
		contentPane.add(btnShowAllStudents);

	}

}
