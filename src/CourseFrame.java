import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
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
	private JTextField textFieldHours;
	private JTextField textFieldMinutes;
	private final ButtonGroup buttonGroupCourses = new ButtonGroup();

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
		setBounds(100, 100, 844, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCourseRegister = new JPanel();
		panelCourseRegister.setBounds(10, 11, 251, 140);
		contentPane.add(panelCourseRegister);
		panelCourseRegister.setLayout(null);
		
		
		
		
		
		JLabel lblCourseRegister = new JLabel("Course register");
		lblCourseRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseRegister.setBounds(75, 0, 104, 35);
		panelCourseRegister.add(lblCourseRegister);
		
		panelEdit = new JPanel();
		panelEdit.setBounds(10, 187, 251, 245);
		contentPane.add(panelEdit);
		
		
		JComboBox comboBoxCourseID = new JComboBox();
		comboBoxCourseID.setBounds(88, 5, 145, 22);
		panelEdit.add(comboBoxCourseID);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(190, 211, 51, 23);
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
		textFieldEditCredits.setToolTipText("Only integers, please");
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
		btnDelete.setBounds(10, 211, 65, 23);
		panelEdit.add(btnDelete);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(109, 89, 96, 20);
		panelEdit.add(textField_1);
		textField_1.setColumns(10);
		
		textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);
		
		JTextField textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 5, 96, 22);
		panelEdit.add(comboBox);

		panelAdd = new JPanel();
		panelAdd.setBounds(10, 187, 251, 245);
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
		btnAdd.setBounds(104, 211, 51, 23);
		panelAdd.add(btnAdd);
		
		JPanel panelWrittenExams = new JPanel();
		panelWrittenExams.setBounds(271, 11, 241, 165);
		contentPane.add(panelWrittenExams);
		panelWrittenExams.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setBounds(36, 7, 96, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelWrittenExams.add(lblNewLabel);
		
		JPanel panelAddNewExam = new JPanel();
		panelAddNewExam.setBounds(271, 187, 241, 245);
		contentPane.add(panelAddNewExam);
		
		JPanel panelChooseCourse = new JPanel();
		panelChooseCourse.setBounds(10, 187, 251, 102);
		contentPane.add(panelChooseCourse);
		
		JPanel panelExistingExam = new JPanel();
		panelExistingExam.setBounds(271, 187, 241, 245);
		contentPane.add(panelExistingExam);
		panelExistingExam.setLayout(null);

		JPanel panelRegisterStudent = new JPanel();
		panelRegisterStudent.setBounds(271, 187, 241, 245);
		contentPane.add(panelRegisterStudent);
		
		JPanel panelUnregisterStudent = new JPanel();
		panelUnregisterStudent.setBounds(271, 187, 241, 245);
		contentPane.add(panelUnregisterStudent);
		
		JRadioButton rdbtnNewCourse = new JRadioButton("New course");
		buttonGroupCourses.add(rdbtnNewCourse);
		rdbtnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdd.setVisible(true);
				
				panelEdit.setVisible(false);
				panelExistingExam.setVisible(false);
				panelAddNewExam.setVisible(false);
				panelChooseCourse.setVisible(false);
				panelUnregisterStudent.setVisible(false);
				panelRegisterStudent.setVisible(false);
			}
		});
		rdbtnNewCourse.setBounds(10, 46, 89, 23);
		panelCourseRegister.add(rdbtnNewCourse);
		
		JRadioButton rdbtnEditOrDelete = new JRadioButton("Edit or delete course");
		buttonGroupCourses.add(rdbtnEditOrDelete);
		rdbtnEditOrDelete.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				panelEdit.setVisible(true);
				panelAdd.setVisible(false);
				
				panelExistingExam.setVisible(false);
				panelAddNewExam.setVisible(false);
				panelChooseCourse.setVisible(false);
				panelUnregisterStudent.setVisible(false);
				panelRegisterStudent.setVisible(false);
			}
		});
		rdbtnEditOrDelete.setBounds(10, 87, 147, 23);
		panelCourseRegister.add(rdbtnEditOrDelete);
		
		JRadioButton rdbtnAddNew = new JRadioButton("Add new to selected course");
		rdbtnAddNew.setBounds(6, 33, 202, 23);
		buttonGroup.add(rdbtnAddNew);
		panelWrittenExams.add(rdbtnAddNew);
		rdbtnAddNew.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				panelAddNewExam.setVisible(true);
				panelChooseCourse.setVisible(true);
				
				panelEdit.setVisible(false);
				panelAdd.setVisible(false);
				panelExistingExam.setVisible(false);
				panelUnregisterStudent.setVisible(false);
				panelRegisterStudent.setVisible(false);
			}
	           
		});
		
		JRadioButton rdbtnAddExisting = new JRadioButton("Add/remove existing");
		rdbtnAddExisting.setBounds(6, 59, 162, 23);
		buttonGroup.add(rdbtnAddExisting);
		panelWrittenExams.add(rdbtnAddExisting);
		rdbtnAddExisting.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				panelExistingExam.setVisible(true);
				panelChooseCourse.setVisible(true);
				
				panelEdit.setVisible(false);
				panelAdd.setVisible(false);
				panelAddNewExam.setVisible(false);
				panelUnregisterStudent.setVisible(false);
				panelRegisterStudent.setVisible(false);
			}
	           
		});
		
		JRadioButton rdbtnRegisterStudentFor = new JRadioButton("Register student for exam");
		buttonGroup.add(rdbtnRegisterStudentFor);
		rdbtnRegisterStudentFor.setBounds(6, 85, 229, 29);
		panelWrittenExams.add(rdbtnRegisterStudentFor);
		rdbtnRegisterStudentFor.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				panelRegisterStudent.setVisible(true);
				panelChooseCourse.setVisible(true);
				
				panelEdit.setVisible(false);
				panelAdd.setVisible(false);
				panelExistingExam.setVisible(false);
				panelAddNewExam.setVisible(false);
				panelUnregisterStudent.setVisible(false);
			}
	           
		});
		
		JRadioButton rdbtnUnregisterStudentFor = new JRadioButton("Unregister student for exam");
		buttonGroup.add(rdbtnUnregisterStudentFor);
		rdbtnUnregisterStudentFor.setBounds(6, 117, 202, 29);
		panelWrittenExams.add(rdbtnUnregisterStudentFor);
		rdbtnUnregisterStudentFor.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				panelUnregisterStudent.setVisible(true);
				panelChooseCourse.setVisible(true);
				
				panelEdit.setVisible(false);
				panelAdd.setVisible(false);
				panelExistingExam.setVisible(false);
				panelAddNewExam.setVisible(false);
				panelRegisterStudent.setVisible(false);
			}
		});

		JLabel lblExamId = new JLabel("Exam ID:");
		lblExamId.setBounds(10, 19, 44, 14);
		panelExistingExam.add(lblExamId);
		
		JComboBox comboBoxExamID = new JComboBox();
		comboBoxExamID.setBounds(75, 11, 156, 31);
		panelExistingExam.add(comboBoxExamID);
		
		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.setBounds(10, 228, 147, 31);
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				String examID = comboBoxExamID.getSelectedItem().toString();
				WrittenExam w = viewController.removeFromCourse(courseCode, examID);
			}
		});
		panelExistingExam.add(btnRemoveFromCourse);
		
		JButton btnAddToCourse = new JButton("Add to course");
		btnAddToCourse.setBounds(10, 186, 104, 31);
		btnAddToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxCourseID.getSelectedItem().toString();
				String examID = comboBoxExamID.getSelectedItem().toString();
				viewController.addToCourse(courseCode, examID);
			}
		});
		panelExistingExam.add(btnAddToCourse);
	
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JLabel lblDate = new JLabel("Date:");
		panelAddNewExam.add(lblDate);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		 
		panelAddNewExam.add(datePicker);
		
		JLabel lblTime = new JLabel("Time");
		panelAddNewExam.add(lblTime);
		
		textFieldHours = new JTextField();
		panelAddNewExam.add(textFieldHours);
		textFieldHours.setColumns(10);
		
		JLabel label = new JLabel(":");
		panelAddNewExam.add(label);
		
		textFieldMinutes = new JTextField();
		panelAddNewExam.add(textFieldMinutes);
		textFieldMinutes.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		panelAddNewExam.add(lblLocation);
		
		JComboBox comboBoxLocation = new JComboBox();
		panelAddNewExam.add(comboBoxLocation);
		
		JButton btnAddExamTo = new JButton("Add exam to course");
		btnAddExamTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelAddNewExam.add(btnAddExamTo);
		
		
		
		JLabel lblCourseIdChooseCourse = new JLabel("Course ID:");
		panelChooseCourse.add(lblCourseIdChooseCourse);
		
		JComboBox comboBoxChooseCourse = new JComboBox();
		panelChooseCourse.add(comboBoxChooseCourse);
		
		
		JLabel lblExamId_1 = new JLabel("Exam ID");
		panelRegisterStudent.add(lblExamId_1);
		
		JComboBox comboBoxRegisterExamID = new JComboBox();
		panelRegisterStudent.add(comboBoxRegisterExamID);
		
		JLabel lblStudentId = new JLabel("Student ID");
		panelRegisterStudent.add(lblStudentId);
		
		JComboBox comboBoxStudentID = new JComboBox();
		panelRegisterStudent.add(comboBoxStudentID);
		
		JButton btnRegisterStudent = new JButton("Register student");
		panelRegisterStudent.add(btnRegisterStudent);
		
		JLabel lblExamId_2 = new JLabel("Exam ID:");
		panelUnregisterStudent.add(lblExamId_2);
		
		JComboBox comboBox_1 = new JComboBox();
		panelUnregisterStudent.add(comboBox_1);
		
		JLabel lblStudentId_1 = new JLabel("Student ID:");
		panelUnregisterStudent.add(lblStudentId_1);
		
		JComboBox comboBox_2 = new JComboBox();
		panelUnregisterStudent.add(comboBox_2);
		
		JButton btnUnregisterStudent = new JButton("Unregister student");
		panelUnregisterStudent.add(btnUnregisterStudent);
	}
}
