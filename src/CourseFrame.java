import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CourseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEditCredits;
	private JTextField textFieldEditCourseName;
	private ViewController viewController;
	private JPanel panelEdit;
	private JPanel panelAdd;
	private JTextField textFieldAddCredits;
	private JTextField textFieldAddName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewController viewController = new ViewController();
					CourseFrame frame = new CourseFrame(viewController);
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
	public CourseFrame(ViewController viewController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 251, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBoxCourseID = new JComboBox();
		comboBoxCourseID.setBounds(88, 5, 145, 22);
		panelEdit.add(comboBoxCourseID);
		
		JButton btnNewCourse = new JButton("New course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEdit.setVisible(false);
				panelAdd.setVisible(true);
			}
		});
		btnNewCourse.setBounds(10, 46, 89, 23);
		panel.add(btnNewCourse);
		
		JLabel lblCourseRegister = new JLabel("Course register");
		lblCourseRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseRegister.setBounds(75, 0, 104, 35);
		panel.add(lblCourseRegister);
		
		panelEdit = new JPanel();
		panelEdit.setBounds(10, 162, 251, 270);
		contentPane.add(panelEdit);
		
		JButton btnEditOrDelete = new JButton("Edit or delete course");
		btnEditOrDelete.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				panelEdit.setVisible(true);
				panelAdd.setVisible(false);
			}
		});
		btnEditOrDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.editOrDeleteCourse();
			}
		});
		btnEditOrDelete.setBounds(10, 87, 147, 23);
		panel.add(btnEditOrDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(182, 224, 51, 23);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				String credits = textFieldEditCredits.getText();
				String name = textFieldEditCourseName.getText();
				
				Course c = viewController.editCourse(courseCode, credits, name);
			}
		});
		panelEdit.setLayout(null);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(10, 47, 41, 14);
		panelEdit.add(lblCredits);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setBounds(10, 9, 68, 14);
		panelEdit.add(lblCourseId);
		panelEdit.add(btnEdit);
		JTextField textFieldEditCredits = new JTextField();
		textFieldEditCredits.setBounds(109, 44, 96, 20);
		panelEdit.add(textFieldEditCredits);
		textFieldEditCredits.setColumns(10);
		
		textFieldEditCredits = new JTextField();
		textFieldEditCredits.setBounds(109, 44, 96, 20);
		panelEdit.add(textFieldEditCredits);
		textFieldEditCredits.setColumns(10);

		JLabel lblCourseName = new JLabel("Course name:");
		lblCourseName.setBounds(10, 92, 73, 14);
		panelEdit.add(lblCourseName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				Course c = viewController.deleteCourse(courseCode);
				
			}
		});
		btnDelete.setBounds(18, 224, 65, 23);
		panelEdit.add(btnDelete);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(109, 89, 96, 20);
		panelEdit.add(textField_1);
		textField_1.setColumns(10);
		
		textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);
		
		JPanel panelWrittenExams = new JPanel();
		panelWrittenExams.setBounds(0, 0, 251, 270);
		panelEdit.add(panelWrittenExams);
		
		JLabel label_13 = new JLabel("Course ID:");
		panelWrittenExams.add(label_13);
		
		JComboBox comboBox_1 = new JComboBox();
		panelWrittenExams.add(comboBox_1);
		
		JTextField textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);

		panelAdd = new JPanel();
		panelAdd.setBounds(10, 162, 251, 270);
		contentPane.add(panelAdd);
		panelAdd.setLayout(null);
		
		JLabel label_11 = new JLabel("Credits:");
		label_11.setBounds(10, 33, 39, 14);
		panelAdd.add(label_11);
		
		textFieldAddCredits = new JTextField();
		textFieldAddCredits.setBounds(84, 36, 96, 20);
		textFieldAddCredits.setColumns(10);
		panelAdd.add(textFieldAddCredits);
		
		JLabel label_12 = new JLabel("Course name:");
		label_12.setBounds(6, 70, 68, 14);
		panelAdd.add(label_12);
		
		textFieldAddName = new JTextField();
		textFieldAddName.setBounds(84, 67, 96, 20);
		textFieldAddName.setColumns(10);
		panelAdd.add(textFieldAddName);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldAddName.getText();
				String credits = textFieldAddCredits.getText();
				viewController.addCourse(name, credits);
			}
		});
		btnAdd.setBounds(102, 223, 51, 23);
		panelAdd.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 11, 241, 140);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setBounds(36, 7, 96, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel);
		
		JRadioButton rdbtnAddNew = new JRadioButton("Add new to selected course");
		rdbtnAddNew.setBounds(6, 33, 202, 23);
		buttonGroup.add(rdbtnAddNew);
		panel_1.add(rdbtnAddNew);
		
		JRadioButton rdbtnAddExisting = new JRadioButton("Add/remove existing");
		rdbtnAddExisting.setBounds(6, 75, 162, 23);
		buttonGroup.add(rdbtnAddExisting);
		panel_1.add(rdbtnAddExisting);
		
		JPanel panelExistingExam = new JPanel();
		panelExistingExam.setBounds(271, 162, 241, 270);
		contentPane.add(panelExistingExam);
		
		JLabel lblExamId = new JLabel("Exam ID:");
		panelExistingExam.add(lblExamId);
		
		JComboBox comboBoxExamID = new JComboBox();
		panelExistingExam.add(comboBoxExamID);
		
		JButton btnAddToCourse = new JButton("Add to course");
		btnAddToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				String examID = comboBoxExamID.getSelectedItem().toString();
				viewController.addToCourse(courseCode, examID);
			}
		});
		panelExistingExam.add(btnAddToCourse);
		
		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				String examID = comboBoxExamID.getSelectedItem().toString();
				WrittenExam w = viewController.removeFromCourse(courseCode, examID);
			}
		});
		panelExistingExam.add(btnRemoveFromCourse);
		
		JPanel panelAddNew = new JPanel();
		panelAddNew.setBounds(522, 162, 241, 270);
		contentPane.add(panelAddNew);
	}
}
