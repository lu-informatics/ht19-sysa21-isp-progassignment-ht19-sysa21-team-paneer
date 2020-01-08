import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.DateTimeException;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.Box;

public class CourseFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textFieldEditCourseName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldHours;
	private JTextField textFieldMinutes;
	private JTextField textFieldEditCredits;
	private JLabel lblResponse;
	private JComboBox<String> comboBoxChooseCourse;
	private JComboBox<String> comboBoxExamID;
	private JComboBox<String> comboBoxExamIDRegister;
	private JComboBox<String> comboBoxExamIDUnregister;
	private JComboBox<String> comboBoxStudentID;
	private JComboBox<String> comboBoxStudentIDUnregister;
	private JComboBox<String> comboBoxCourseForExam;
	private JComboBox<String> comboBoxCourseForNewExam;
	private JComboBox<String> comboBoxLocation;
	private final ButtonGroup buttonGroupCourses = new ButtonGroup();
	private JPanel panelCourseForNewExam;
	private JPanel panelEdit;
	private JPanel panelAdd;
	private JPanel contentPane;
	private JPanel panelExistingExam;
	private JPanel panelCourseRegister;
	private JPanel panelCourseActions;
	private JPanel panelChooseCourse;
	private JPanel panelDelete;
	private JPanel panelWrittenExams;
	private JPanel panelWrittenExamActions;
	private JPanel panelCourseForExam;
	private JPanel panelUnregisterStudent;
	private JPanel panelAddNewExam;
	private JPanel panelRegisterStudent;
	private JPanel panelWelcome;
	private JPanel panelCourseInfo;

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
	public JComboBox<String> getComboBoxLocation() {
		return comboBoxLocation;
	}

	public void setComboBoxLocation(JComboBox<String> comboBoxLocation) {
		this.comboBoxLocation = comboBoxLocation;
	}

	public JPanel getPanelEdit() {
		return panelEdit;
	}

	public void setPanelEdit(JPanel panelEdit) {
		this.panelEdit = panelEdit;
	}

	public JPanel getPanelAdd() {
		return panelAdd;
	}

	public void setPanelAdd(JPanel panelAdd) {
		this.panelAdd = panelAdd;
	}

	public JPanel getPanelExistingExam() {
		return panelExistingExam;
	}

	public void setPanelExistingExam(JPanel panelExistingExam) {
		this.panelExistingExam = panelExistingExam;
	}

	public JPanel getPanelCourseRegister() {
		return panelCourseRegister;
	}

	public void setPanelCourseRegister(JPanel panelCourseRegister) {
		this.panelCourseRegister = panelCourseRegister;
	}

	public JPanel getPanelCourseActions() {
		return panelCourseActions;
	}

	public void setPanelCourseActions(JPanel panelCourseActions) {
		this.panelCourseActions = panelCourseActions;
	}

	public JPanel getPanelChooseCourse() {
		return panelChooseCourse;
	}

	public void setPanelChooseCourse(JPanel panelChooseCourse) {
		this.panelChooseCourse = panelChooseCourse;
	}

	public JPanel getPanelDelete() {
		return panelDelete;
	}

	public void setPanelDelete(JPanel panelDelete) {
		this.panelDelete = panelDelete;
	}

	public JPanel getPanelWrittenExams() {
		return panelWrittenExams;
	}

	public void setPanelWrittenExams(JPanel panelWrittenExams) {
		this.panelWrittenExams = panelWrittenExams;
	}

	public JPanel getPanelWrittenExamActions() {
		return panelWrittenExamActions;
	}

	public void setPanelWrittenExamActions(JPanel panelWrittenExamActions) {
		this.panelWrittenExamActions = panelWrittenExamActions;
	}

	public JPanel getPanelCourseForExam() {
		return panelCourseForExam;
	}

	public void setPanelCourseForExam(JPanel panelCourseForExam) {
		this.panelCourseForExam = panelCourseForExam;
	}

	public JPanel getPanelUnregisterStudent() {
		return panelUnregisterStudent;
	}

	public void setPanelUnregisterStudent(JPanel panelUnregisterStudent) {
		this.panelUnregisterStudent = panelUnregisterStudent;
	}

	public JPanel getPanelAddNewExam() {
		return panelAddNewExam;
	}

	public void setPanelAddNewExam(JPanel panelAddNewExam) {
		this.panelAddNewExam = panelAddNewExam;
	}

	public JPanel getPanelRegisterStudent() {
		return panelRegisterStudent;
	}

	public void setPanelRegisterStudent(JPanel panelRegisterStudent) {
		this.panelRegisterStudent = panelRegisterStudent;
	}

	public JPanel getPanelWelcome() {
		return panelWelcome;
	}

	public void setPanelWelcome(JPanel panelWelcome) {
		this.panelWelcome = panelWelcome;
	}
	public JPanel getPanelCourseInfo() {
		return panelCourseInfo;
	}

	public void setPanelCourseInfo(JPanel panelCourseInfo) {
		this.panelCourseInfo = panelCourseInfo;
	}

	public JComboBox<String> getComboBoxCourseForExam() {
		return comboBoxCourseForExam;
	}

	public void setComboBoxCourseForExam(JComboBox<String> comboBoxCourseForExam) {
		this.comboBoxCourseForExam = comboBoxCourseForExam;
	}

	public JComboBox<String> getComboBoxCourseForNewExam() {
		return comboBoxCourseForNewExam;
	}

	public void setComboBoxCourseForNewExam(JComboBox<String> comboBoxCourseForNewExam) {
		this.comboBoxCourseForNewExam = comboBoxCourseForNewExam;
	}

	public JPanel getPanelCourseForNewExam() {
		return panelCourseForNewExam;
	}

	public void setPanelCourseForNewExam(JPanel panelCourseForNewExam) {
		this.panelCourseForNewExam = panelCourseForNewExam;
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

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 346, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JButton btnGoBack = new JButton("Return to main menu");
		btnGoBack.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
				viewController.returnToMain();
			}
		});
		btnGoBack.setBounds(10, 561, 187, 29);
		contentPane.add(btnGoBack);

		lblResponse = new JLabel("");
		lblResponse.setBounds(10, 521, 251, 29);
		contentPane.add(lblResponse);

		panelCourseRegister = new JPanel();
		panelCourseRegister.setVisible(false);
		panelCourseRegister.setBounds(10, 10, 251, 444);
		contentPane.add(panelCourseRegister);
		panelCourseRegister.setLayout(null);

		JLabel lblCourseRegister = new JLabel("Course register");
		lblCourseRegister.setBounds(76, 5, 99, 19);
		panelCourseRegister.add(lblCourseRegister);
		lblCourseRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));

		panelCourseActions = new JPanel();
		panelCourseActions.setBounds(0, 35, 251, 81);
		panelCourseRegister.add(panelCourseActions);

		JButton btnEditCourse = new JButton("Edit course");
		buttonGroupCourses.add(btnEditCourse);
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				viewController.viewEditCourse();
			}
		});

		JButton btnNewCourse = new JButton("New course");
		buttonGroupCourses.add(btnNewCourse);
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewNewCourse();
			}
		});
		panelCourseActions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelCourseActions.add(btnNewCourse);
		panelCourseActions.add(btnEditCourse);

		JButton btnDeleteCourse = new JButton("Delete course");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewDeleteCourse();
			}
		});
		panelCourseActions.add(btnDeleteCourse);

		panelChooseCourse = new JPanel();
		panelChooseCourse.setVisible(false);
		panelChooseCourse.setBounds(0, 118, 251, 60);
		panelCourseRegister.add(panelChooseCourse);

		comboBoxChooseCourse = new JComboBox<String>(viewController.getCourses());

		JLabel lblCourseIdChooseCourse = new JLabel("Course ID:");
		panelChooseCourse.add(lblCourseIdChooseCourse);
		panelChooseCourse.add(comboBoxChooseCourse);

		panelDelete = new JPanel();
		panelDelete.setVisible(false);
		panelDelete.setBounds(0, 189, 251, 199);
		panelCourseRegister.add(panelDelete);
		panelDelete.setLayout(new BorderLayout(0, 0));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDelete.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelDelete.add(btnDelete, BorderLayout.SOUTH);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxChooseCourse.getSelectedItem().toString();
					viewController.deleteCourse(courseCode);
					lblResponse.setText("Course deleted.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});

		panelAdd = new JPanel();
		panelAdd.setVisible(false);
		panelAdd.setBounds(0, 344, 251, 44);
		panelCourseRegister.add(panelAdd);
		panelAdd.setVisible(false);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(240, 240, 240));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textFieldEditCourseName.getText();
					String credits = textFieldEditCredits.getText();
					viewController.addCourse(name, credits);
					lblResponse.setText("Course added.");
					textFieldEditCourseName.setText("");
					textFieldEditCredits.setText("");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForCreditParseException();
				}
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelAdd.add(btnAdd);

		JButton btnGoBack_1 = new JButton("Go back");
		btnGoBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});
		btnGoBack_1.setBounds(86, 399, 89, 34);
		panelCourseRegister.add(btnGoBack_1);

		panelEdit = new JPanel();
		panelEdit.setVisible(false);
		panelEdit.setBounds(0, 344, 251, 44);
		panelCourseRegister.add(panelEdit);
		panelEdit.setVisible(false);
		panelEdit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnEdit = new JButton("Edit");
		panelEdit.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxChooseCourse.getSelectedItem().toString();
					String credits = textFieldEditCredits.getText();
					String name = textFieldEditCourseName.getText();

					viewController.editCourse(courseCode, credits, name);
					lblResponse.setText("Course edited.");
					textFieldEditCourseName.setText("");
					textFieldEditCredits.setText("");
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForCreditParseException();
				}
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});

		panelCourseInfo = new JPanel();
		panelCourseInfo.setVisible(false);
		panelCourseInfo.setBounds(0, 189, 205, 157);
		panelCourseRegister.add(panelCourseInfo);
		FlowLayout flowLayout = (FlowLayout) panelCourseInfo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);


		JLabel lblCredits = new JLabel("Credits:");
		panelCourseInfo.add(lblCredits);

		textFieldEditCredits = new JTextField();
		panelCourseInfo.add(textFieldEditCredits);
		textFieldEditCredits.setToolTipText("Only integer numbers");
		textFieldEditCredits.setColumns(10);


		JLabel lblCourseName = new JLabel("Course name:");
		panelCourseInfo.add(lblCourseName);

		textFieldEditCourseName = new JTextField();
		panelCourseInfo.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);


		panelWelcome = new JPanel();
		panelWelcome.setBounds(10, 11, 205, 155);
		contentPane.add(panelWelcome);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelWelcome.add(lblWelcome);

		JButton btnOpenCourseRegister = new JButton("Open course register");
		btnOpenCourseRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.openCourseRegister();
			}
		});
		panelWelcome.add(btnOpenCourseRegister);

		JButton btnOpenExamRegister = new JButton("Open exam register");
		btnOpenExamRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.openExamRegister();
			}
		});
		panelWelcome.add(btnOpenExamRegister);

		JButton btnViewAllCourses = new JButton("View all courses");
		btnViewAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewCourseData();
			}
		});
		panelWelcome.add(btnViewAllCourses);

		JButton btnViewAllExams = new JButton("View all exams");
		btnViewAllExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewExamData();
			}
		});
		panelWelcome.add(btnViewAllExams);

		panelWrittenExams = new JPanel();
		panelWrittenExams.setVisible(false);
		panelWrittenExams.setBounds(10, 10, 251, 444);
		contentPane.add(panelWrittenExams);
		panelWrittenExams.setLayout(null);

		panelWrittenExamActions = new JPanel();
		panelWrittenExamActions.setBounds(0, 0, 251, 151);
		panelWrittenExams.add(panelWrittenExamActions);
		panelWrittenExamActions.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelWrittenExamActions.add(lblNewLabel);

		JRadioButton rdbtnAddNew = new JRadioButton("Add new exam to selected course");
		buttonGroup.add(rdbtnAddNew);
		panelWrittenExamActions.add(rdbtnAddNew);
		rdbtnAddNew.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				viewController.viewNewExam();
			}

		});

		JRadioButton rdbtnRemoveExam = new JRadioButton("Remove an exam");
		buttonGroup.add(rdbtnRemoveExam);
		panelWrittenExamActions.add(rdbtnRemoveExam);
		rdbtnRemoveExam.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				viewController.viewRemoveExam();
			}

		});

		JRadioButton rdbtnRegisterStudentFor = new JRadioButton("Register student for exam");
		buttonGroup.add(rdbtnRegisterStudentFor);
		panelWrittenExamActions.add(rdbtnRegisterStudentFor);
		rdbtnRegisterStudentFor.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				viewController.viewRegisterStudent();
			}

		});

		JRadioButton rdbtnUnregisterStudentFor = new JRadioButton("Unregister student for exam");
		buttonGroup.add(rdbtnUnregisterStudentFor);
		panelWrittenExamActions.add(rdbtnUnregisterStudentFor);
		rdbtnUnregisterStudentFor.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				viewController.viewUnregisterStudent();
			}
		});

		panelCourseForExam = new JPanel();
		panelCourseForExam.setBounds(0, 151, 251, 41);
		panelWrittenExams.add(panelCourseForExam);

		JLabel label_1 = new JLabel("Course ID:");
		panelCourseForExam.add(label_1);

		comboBoxCourseForExam = new JComboBox<String>(viewController.getCourses());
		comboBoxCourseForExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterExams((String) comboBoxCourseForExam.getSelectedItem());
				}
				catch (NullPointerException exception) {
					viewController.setExamModel(new DefaultComboBoxModel<String>(new String[] {"empty"}));
				}

			}
		});
		panelCourseForExam.add(comboBoxCourseForExam);

		panelUnregisterStudent = new JPanel();
		panelUnregisterStudent.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelUnregisterStudent);
		panelUnregisterStudent.setVisible(false);

		JLabel lblExamId_2 = new JLabel("Exam ID:");
		panelUnregisterStudent.add(lblExamId_2);

		comboBoxExamIDUnregister = new JComboBox<String>();
		comboBoxExamIDUnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterStudents((String)comboBoxExamIDUnregister.getSelectedItem());
				} catch (NullPointerException exception) {
					comboBoxStudentIDUnregister.setModel(new DefaultComboBoxModel<String>(new String[] {"empty"}));
				}
			}
		});
		panelUnregisterStudent.add(comboBoxExamIDUnregister);

		JLabel lblStudentId_1 = new JLabel("Student ID:");
		panelUnregisterStudent.add(lblStudentId_1);

		comboBoxStudentIDUnregister = new JComboBox<String>();
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

		panelExistingExam = new JPanel();
		panelExistingExam.setBounds(0, 190, 251, 194);
		panelWrittenExams.add(panelExistingExam);
		panelExistingExam.setVisible(false);
		panelExistingExam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblExamId = new JLabel("Exam ID:");
		panelExistingExam.add(lblExamId);

		comboBoxExamID = new JComboBox<String>();
		panelExistingExam.add(comboBoxExamID);

		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String courseCode = comboBoxCourseForExam.getSelectedItem().toString();
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

		panelRegisterStudent = new JPanel();
		panelRegisterStudent.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelRegisterStudent);
		panelRegisterStudent.setVisible(false);

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
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoExams();
				}
			}
		});
		panelRegisterStudent.add(btnRegisterStudent);

		JButton btnGoBack_2 = new JButton("Go back");
		btnGoBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});
		btnGoBack_2.setBounds(86, 399, 89, 34);
		panelWrittenExams.add(btnGoBack_2);

		panelCourseForNewExam = new JPanel();
		panelCourseForNewExam.setBounds(0, 151, 251, 41);
		panelWrittenExams.add(panelCourseForNewExam);

		JLabel label_2 = new JLabel("Course ID:");
		panelCourseForNewExam.add(label_2);

		comboBoxCourseForNewExam = new JComboBox<String>(viewController.getCourses());
		panelCourseForNewExam.add(comboBoxCourseForNewExam);

		panelAddNewExam = new JPanel();
		panelAddNewExam.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelAddNewExam);
		panelAddNewExam.setVisible(false);

		JLabel lblDate = new JLabel("Date:");
		panelAddNewExam.add(lblDate);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, viewController.getDateFormatter());

		panelAddNewExam.add(datePicker);

		JLabel lblTime = new JLabel("Start time");
		panelAddNewExam.add(lblTime);

		textFieldHours = new JTextField();
		panelAddNewExam.add(textFieldHours);
		textFieldHours.setColumns(5);

		JLabel label = new JLabel(":");
		panelAddNewExam.add(label);

		textFieldMinutes = new JTextField();
		panelAddNewExam.add(textFieldMinutes);
		textFieldMinutes.setColumns(5);

		Component horizontalStrut = Box.createHorizontalStrut(30);
		panelAddNewExam.add(horizontalStrut);

		JLabel lblLocation = new JLabel("Location");
		panelAddNewExam.add(lblLocation);

		comboBoxLocation = new JComboBox<String>(viewController.getLocations());
		panelAddNewExam.add(comboBoxLocation);

		JButton btnAddExamTo = new JButton("Add exam to course");
		btnAddExamTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = (Date) datePicker.getModel().getValue();
					String hours = textFieldHours.getText().toString();
					String minutes = textFieldMinutes.getText().toString();
					String location = comboBoxLocation.getSelectedItem().toString();
					String examID = viewController.generateExamID().toString();
					String courseID = (String) comboBoxCourseForNewExam.getSelectedItem();
					viewController.addNewExamToCourse(date, hours, minutes, location, examID, courseID);
					lblResponse.setText("Exam added to course.");
				}
				catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
				catch (DateTimeException exception) {
					viewController.showExceptionWindowForTimeParseException();
				}
				catch (IntegerParseException exception) {
					viewController.showExceptionWindowForTimeParseException();
				} catch (ParseException exception) {
					viewController.showExceptionWindowForNoAvailableIdentifier();
				}
				catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoCourses();
				} catch (EmptyFieldException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}

			}
		});
		panelAddNewExam.add(btnAddExamTo);

	}
}
