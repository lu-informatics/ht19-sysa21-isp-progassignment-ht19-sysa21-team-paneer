import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class CourseFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEditCourseName;
	private JPanel panelEdit;
	private JPanel panelAdd;
	private JTextField textFieldAddCredits;
	private JTextField textFieldAddName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldHours;
	private JTextField textFieldMinutes;
	private JLabel lblResponse;
	
	private JComboBox<String> comboBoxCourseID;
	private JComboBox<String> comboBoxChooseCourse;
	private JComboBox<String> comboBoxExamID;
	private JComboBox<String> comboBoxExamIDRegister;
	private JComboBox<String> comboBoxExamIDUnregister;
	private JComboBox<String> comboBoxStudentID;
	private JComboBox<String> comboBoxStudentIDUnregister;
	private final ButtonGroup buttonGroupCourses = new ButtonGroup();
	private DefaultComboBoxModel<String> examModel;

	public DefaultComboBoxModel<String> getExamModel() {
		return examModel;
	}

	public void setExamModel(DefaultComboBoxModel<String> examModel) {
		this.examModel = examModel;
	}
	

	public JComboBox<String> getComboBoxCourseID() {
		return comboBoxCourseID;
	}

	public void setComboBoxCourseID(JComboBox<String> comboBoxCourseID) {
		this.comboBoxCourseID = comboBoxCourseID;
	}

	public JComboBox<String> getComboBoxChooseCourse() {
		return comboBoxChooseCourse;
	}

	public void setComboBoxChooseCourse(JComboBox<String> comboBoxChooseCourse) {
		this.comboBoxChooseCourse = comboBoxChooseCourse;
	}

	public JComboBox<String> getComboBoxExamID() {
		return comboBoxExamID;
	}

	public void setComboBoxExamID(JComboBox<String> comboBoxExamID) {
		this.comboBoxExamID = comboBoxExamID;
	}

	public JComboBox<String> getComboBoxExamIDRegister() {
		return comboBoxExamIDRegister;
	}

	public void setComboBoxExamIDRegister(JComboBox<String> ComboBoxExamIDRegister) {
		this.comboBoxExamIDRegister = ComboBoxExamIDRegister;
	}

	public JComboBox<String> getComboBoxExamIDUnregister() {
		return comboBoxExamIDUnregister;
	}

	public void setComboBoxExamIDUnregister(JComboBox<String> comboBoxExamIDUnregister) {
		this.comboBoxExamIDUnregister = comboBoxExamIDUnregister;
	}

	public JComboBox<String> getComboBoxStudentID() {
		return comboBoxStudentID;
	}

	public void setComboBoxStudentID(JComboBox<String> comboBoxStudentID) {
		this.comboBoxStudentID = comboBoxStudentID;
	}

	public JComboBox<String> getComboBoxStudentIDUnregister() {
		return comboBoxStudentIDUnregister;
	}

	public void setComboBoxStudentIDUnregister(JComboBox<String> comboBoxStudentIDUnregister) {
		this.comboBoxStudentIDUnregister = comboBoxStudentIDUnregister;
	}

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
		setBounds(100, 100, 543, 481);
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
		panelEdit.setBounds(10, 187, 251, 211);
		contentPane.add(panelEdit);
		panelEdit.setVisible(false);
		
		
		comboBoxCourseID = new JComboBox<String>(viewController.getCourses());
		comboBoxCourseID.setBounds(88, 5, 145, 22);
		panelEdit.add(comboBoxCourseID);
		
		JTextField textFieldEditCredits = new JTextField();
		textFieldEditCredits.setToolTipText("Only integer numbers");
		textFieldEditCredits.setBounds(109, 44, 96, 20);
		panelEdit.add(textFieldEditCredits);
		textFieldEditCredits.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(190, 171, 51, 29);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxCourseID.getSelectedItem().toString();
					String credits = textFieldEditCredits.getText();
					String name = textFieldEditCourseName.getText();
					try {
						viewController.editCourse(courseCode, credits, name);
						lblResponse.setText("Course edited.");
					} catch (IntegerParseException e1) {
						viewController.showExceptionWindowForCreditParseException();
					}
					
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
				
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
		

		JLabel lblCourseName = new JLabel("Course name:");
		lblCourseName.setBounds(10, 92, 73, 14);
		panelEdit.add(lblCourseName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxCourseID.getSelectedItem().toString();
					viewController.deleteCourse(courseCode);
					lblResponse.setText("Course deleted.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		btnDelete.setBounds(10, 171, 73, 29);
		panelEdit.add(btnDelete);
		
		textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(109, 89, 96, 20);
		panelEdit.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);

		panelAdd = new JPanel();
		panelAdd.setBounds(10, 187, 251, 211);
		contentPane.add(panelAdd);
		panelAdd.setLayout(null);
		panelAdd.setVisible(false);
		
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
		btnAdd.setBackground(new Color(240, 240, 240));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textFieldAddName.getText();
					String credits = textFieldAddCredits.getText();
					String courseCode = viewController.generateCourseID();
					try {
						viewController.addCourse(courseCode, name, credits);
						lblResponse.setText("Course added.");
					} catch (IntegerParseException e1) {
						viewController.showExceptionWindowForCreditParseException();
					}
					
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		btnAdd.setBounds(104, 171, 51, 29);
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
		panelAddNewExam.setBounds(271, 187, 241, 211);
		contentPane.add(panelAddNewExam);
		panelAddNewExam.setVisible(false);
		
		JPanel panelChooseCourse = new JPanel();
		panelChooseCourse.setBounds(10, 187, 251, 102);
		contentPane.add(panelChooseCourse);
		panelChooseCourse.setVisible(false);
		
		JPanel panelExistingExam = new JPanel();
		panelExistingExam.setBounds(271, 187, 241, 211);
		contentPane.add(panelExistingExam);
		panelExistingExam.setVisible(false);

		JPanel panelRegisterStudent = new JPanel();
		panelRegisterStudent.setBounds(271, 187, 241, 211);
		contentPane.add(panelRegisterStudent);
		panelRegisterStudent.setVisible(false);
		
		JPanel panelUnregisterStudent = new JPanel();
		panelUnregisterStudent.setBounds(271, 187, 241, 211);
		contentPane.add(panelUnregisterStudent);
		panelUnregisterStudent.setVisible(false);
		
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
		panelExistingExam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblExamId = new JLabel("Exam ID:");
		panelExistingExam.add(lblExamId);
		
		comboBoxExamID = new JComboBox<String>(viewController.getExams());
		panelExistingExam.add(comboBoxExamID);
		
		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxChooseCourse.getSelectedItem().toString();
					String examID = comboBoxExamID.getSelectedItem().toString();
					viewController.removeFromCourse(courseCode, examID);
					lblResponse.setText("Exam removed from course.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForUnlinkedExam();
				}
				

			}
		});
		panelExistingExam.add(btnRemoveFromCourse);
		
		JButton btnAddToCourse = new JButton("Add to course");
		btnAddToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseCode = comboBoxChooseCourse.getSelectedItem().toString();
				String examID = comboBoxExamID.getSelectedItem().toString();
				viewController.addToCourse(courseCode, examID);
				lblResponse.setText("Exam added to course.");
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
		
		JComboBox<String> comboBoxLocation = new JComboBox<String>(viewController.getLocations());
		panelAddNewExam.add(comboBoxLocation);
		
		comboBoxChooseCourse = new JComboBox<String>(viewController.getCourses());
		panelChooseCourse.add(comboBoxChooseCourse);
		
		JButton btnAddExamTo = new JButton("Add exam to course");
		btnAddExamTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = null;
				String hours = null;
				String minutes = null;
				String location = null;
				String examID = null;
				String courseID = null;
				try {
					date = (Date) datePicker.getModel().getValue();
					hours = textFieldHours.getText().toString();
					minutes = textFieldMinutes.getText().toString();
					location = comboBoxLocation.getSelectedItem().toString();
					examID = viewController.generateExamID().toString();
					courseID = (String) comboBoxChooseCourse.getSelectedItem();
					try {
						viewController.addNewExamToCourse(date, hours, minutes, location, examID, courseID);
						lblResponse.setText("Exam added to course.");
					} catch (IntegerParseException e1) {
						viewController.showExceptionWindowForTimeParseException();
					}
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelAddNewExam.add(btnAddExamTo);
		
		JLabel lblCourseIdChooseCourse = new JLabel("Course ID:");
		panelChooseCourse.add(lblCourseIdChooseCourse);
		
		JLabel lblExamId_1 = new JLabel("Exam ID");
		panelRegisterStudent.add(lblExamId_1);
		
		comboBoxExamIDRegister = new JComboBox<String>();
		panelRegisterStudent.add(comboBoxExamIDRegister);
		
		JLabel lblStudentId = new JLabel("Student ID");
		panelRegisterStudent.add(lblStudentId);
		
		comboBoxStudentID = new JComboBox<String>(viewController.getStudents());
		panelRegisterStudent.add(comboBoxStudentID);
		
		JButton btnRegisterStudent = new JButton("Register student");
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String examID = comboBoxExamIDRegister.getSelectedItem().toString();
				String studentID = comboBoxStudentID.getSelectedItem().toString();
				
				viewController.registerStudent(studentID, examID);
				lblResponse.setText("Student registered.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelRegisterStudent.add(btnRegisterStudent);
		
		JLabel lblExamId_2 = new JLabel("Exam ID:");
		panelUnregisterStudent.add(lblExamId_2);
		
		comboBoxExamIDUnregister = new JComboBox<String>();
		panelUnregisterStudent.add(comboBoxExamIDUnregister);
		
		JLabel lblStudentId_1 = new JLabel("Student ID:");
		panelUnregisterStudent.add(lblStudentId_1);
		
		comboBoxStudentIDUnregister = new JComboBox<String>(viewController.getStudents());
		panelUnregisterStudent.add(comboBoxStudentIDUnregister);
		
		JButton btnUnregisterStudent = new JButton("Unregister student");
		btnUnregisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String examID = comboBoxExamIDUnregister.getSelectedItem().toString();
				String studentID = comboBoxStudentIDUnregister.getSelectedItem().toString();
				
				viewController.unregisterStudent(studentID, examID);
				lblResponse.setText("Student unregistered.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForUnlinkedStudent();
				}
			}
		});
		panelUnregisterStudent.add(btnUnregisterStudent);
		
		JButton btnGoBack = new JButton("Return to main menu");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.returnToMain();
			}
		});
		btnGoBack.setBounds(361, 403, 151, 29);
		contentPane.add(btnGoBack);
		
		lblResponse = new JLabel("");
		lblResponse.setBounds(10, 403, 251, 29);
		contentPane.add(lblResponse);
	}
}
