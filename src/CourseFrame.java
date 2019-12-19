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
		
		JPanel panelCourseRegister = new JPanel();
		panelCourseRegister.setBounds(10, 11, 251, 140);
		contentPane.add(panelCourseRegister);
		panelCourseRegister.setLayout(null);
		
		
		
		JButton btnNewCourse = new JButton("New course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEdit.setVisible(false);
				panelAdd.setVisible(true);
			}
		});
		btnNewCourse.setBounds(10, 46, 89, 23);
		panelCourseRegister.add(btnNewCourse);
		
		JLabel lblCourseRegister = new JLabel("Course register");
		lblCourseRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseRegister.setBounds(75, 0, 104, 35);
		panelCourseRegister.add(lblCourseRegister);
		
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
		panelCourseRegister.add(btnEditOrDelete);
		
		JComboBox comboBoxCourseID = new JComboBox();
		comboBoxCourseID.setBounds(88, 5, 145, 22);
		panelEdit.add(comboBoxCourseID);
		
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
		
		JTextField textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 5, 96, 22);
		panelEdit.add(comboBox);

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
		
		JPanel panelWrittenExams = new JPanel();
		panelWrittenExams.setBounds(271, 11, 241, 140);
		contentPane.add(panelWrittenExams);
		panelWrittenExams.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setBounds(36, 7, 96, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelWrittenExams.add(lblNewLabel);
		
		JRadioButton rdbtnAddNew = new JRadioButton("Add new to selected course");
		rdbtnAddNew.setBounds(6, 33, 202, 23);
		buttonGroup.add(rdbtnAddNew);
		panelWrittenExams.add(rdbtnAddNew);
		
		JRadioButton rdbtnAddExisting = new JRadioButton("Add/remove existing");
		rdbtnAddExisting.setBounds(6, 75, 162, 23);
		buttonGroup.add(rdbtnAddExisting);
		panelWrittenExams.add(rdbtnAddExisting);
		
		JPanel panelExistingExam = new JPanel();
		panelExistingExam.setBounds(271, 162, 241, 270);
		contentPane.add(panelExistingExam);
		panelExistingExam.setLayout(null);
		
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
		
		JPanel panelAddNewExam = new JPanel();
		panelAddNewExam.setBounds(522, 162, 241, 270);
		contentPane.add(panelAddNewExam);
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
		
		JLabel lblLocation = new JLabel("Location");
		panelAddNewExam.add(lblLocation);
		
		JComboBox comboBoxLocation = new JComboBox();
		panelAddNewExam.add(comboBoxLocation);
	}
}
