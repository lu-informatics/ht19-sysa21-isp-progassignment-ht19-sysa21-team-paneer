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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.Box;
import javax.swing.JLayeredPane;

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
		setBounds(100, 100, 336, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JButton btnGoBack = new JButton("Return to main menu");
		btnGoBack.setBounds(10, 555, 187, 29);
		btnGoBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
				viewController.returnToMain();
			}
		});

		panelCourseRegister = new JPanel();
		panelCourseRegister.setBounds(10, 10, 289, 535);
		panelCourseRegister.setVisible(false);
		contentPane.setLayout(null);

		panelWrittenExams = new JPanel();
		panelWrittenExams.setBounds(10, 10, 289, 444);
		panelWrittenExams.setVisible(false);
		
				panelWelcome = new JPanel();
				panelWelcome.setBounds(10, 11, 205, 337);
				contentPane.add(panelWelcome);
				panelWelcome.setLayout(null);
				
						JLabel lblWelcome = new JLabel("Welcome");
						lblWelcome.setBounds(0, 0, 82, 24);
						lblWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
						panelWelcome.add(lblWelcome);
						
								JButton btnOpenCourseRegister = new JButton("Administrate Courses");
								btnOpenCourseRegister.setBounds(6, 48, 199, 29);
								btnOpenCourseRegister.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										viewController.openCourseRegister();
									}
								});
								panelWelcome.add(btnOpenCourseRegister);
								
										JButton btnOpenExamRegister = new JButton("Administrate Exams");
										btnOpenExamRegister.setBounds(6, 93, 199, 29);
										btnOpenExamRegister.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												viewController.openExamRegister();
											}
										});
										panelWelcome.add(btnOpenExamRegister);
										
												JButton btnViewAllCourses = new JButton("View all courses");
												btnViewAllCourses.setBounds(6, 138, 199, 29);
												btnViewAllCourses.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														viewController.viewCourseData();
													}
												});
												panelWelcome.add(btnViewAllCourses);
												
														JButton btnViewAllExams = new JButton("View all exams");
														btnViewAllExams.setBounds(6, 189, 199, 29);
														btnViewAllExams.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																viewController.viewExamData();
															}
														});
														panelWelcome.add(btnViewAllExams);
		contentPane.add(panelWrittenExams);
		panelWrittenExams.setLayout(null);
		
				panelCourseForNewExam = new JPanel();
				panelCourseForNewExam.setBounds(0, 151, 279, 41);
				panelWrittenExams.add(panelCourseForNewExam);
				panelCourseForNewExam.setLayout(null);
				
						JLabel label_2 = new JLabel("Course ID:");
						label_2.setBounds(0, 8, 77, 20);
						panelCourseForNewExam.add(label_2);
						
								comboBoxCourseForNewExam = new JComboBox<String>(viewController.getCourses());
								comboBoxCourseForNewExam.setBounds(104, 5, 175, 26);
								panelCourseForNewExam.add(comboBoxCourseForNewExam);

		panelAddNewExam = new JPanel();
		panelAddNewExam.setBounds(0, 192, 279, 194);
		panelWrittenExams.add(panelAddNewExam);
		panelAddNewExam.setVisible(false);
		panelAddNewExam.setLayout(null);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(0, 5, 38, 20);
		panelAddNewExam.add(lblDate);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, viewController.getDateFormatter());
		datePicker.setBounds(77, 5, 202, 29);

		panelAddNewExam.add(datePicker);

		JLabel lblTime = new JLabel("Start time");
		lblTime.setBounds(0, 42, 69, 20);
		panelAddNewExam.add(lblTime);

		textFieldHours = new JTextField();
		textFieldHours.setBounds(111, 42, 76, 26);
		panelAddNewExam.add(textFieldHours);
		textFieldHours.setColumns(5);

		JLabel label = new JLabel(":");
		label.setBounds(192, 45, 6, 20);
		panelAddNewExam.add(label);

		textFieldMinutes = new JTextField();
		textFieldMinutes.setBounds(203, 42, 76, 26);
		panelAddNewExam.add(textFieldMinutes);
		textFieldMinutes.setColumns(5);

		Component horizontalStrut = Box.createHorizontalStrut(30);
		horizontalStrut.setBounds(72, 83, 30, 12);
		panelAddNewExam.add(horizontalStrut);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(0, 75, 59, 20);
		panelAddNewExam.add(lblLocation);

		comboBoxLocation = new JComboBox<String>(viewController.getLocations());
		comboBoxLocation.setBounds(104, 70, 175, 26);
		panelAddNewExam.add(comboBoxLocation);

		JButton btnAddExamTo = new JButton("Add exam to course");
		btnAddExamTo.setBounds(104, 125, 175, 29);
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
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (DateTimeException exception) {
					viewController.showExceptionWindowForTimeParseException();
				} catch (ParseException exception) {
					viewController.showExceptionWindowForNoAvailableIdentifier();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoCourses();
				} catch (IllegalArgumentException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelAddNewExam.add(btnAddExamTo);

		panelRegisterStudent = new JPanel();
		panelRegisterStudent.setBounds(0, 192, 279, 194);
		panelWrittenExams.add(panelRegisterStudent);
		panelRegisterStudent.setVisible(false);
		panelRegisterStudent.setLayout(null);

		JLabel lblExamId_1 = new JLabel("Exam ID");
		lblExamId_1.setBounds(0, 8, 61, 20);
		panelRegisterStudent.add(lblExamId_1);

		comboBoxExamIDRegister = new JComboBox<String>();
		comboBoxExamIDRegister.setBounds(104, 5, 175, 26);
		panelRegisterStudent.add(comboBoxExamIDRegister);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(0, 56, 76, 20);
		panelRegisterStudent.add(lblStudentId);

		comboBoxStudentID = new JComboBox<String>(viewController.getStudents());
		comboBoxStudentID.setBounds(104, 53, 175, 26);
		panelRegisterStudent.add(comboBoxStudentID);

		JButton btnRegisterStudent = new JButton("Register student");
		btnRegisterStudent.setBounds(104, 102, 147, 29);
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String examID = comboBoxExamIDRegister.getSelectedItem().toString();
					String studentID = comboBoxStudentID.getSelectedItem().toString();

					viewController.registerStudent(studentID, examID);
					lblResponse.setText("Student registered.");
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoExams();
				}
			}
		});
		panelRegisterStudent.add(btnRegisterStudent);

		panelExistingExam = new JPanel();
		panelExistingExam.setBounds(0, 190, 279, 194);
		panelWrittenExams.add(panelExistingExam);
		panelExistingExam.setVisible(false);
		panelExistingExam.setLayout(null);

		JLabel lblExamId = new JLabel("Exam ID:");
		lblExamId.setBounds(0, 8, 67, 20);
		panelExistingExam.add(lblExamId);

		comboBoxExamID = new JComboBox<String>();
		comboBoxExamID.setBounds(104, 5, 144, 26);
		panelExistingExam.add(comboBoxExamID);

		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.setBounds(72, 60, 179, 29);
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = viewController.showConfirmWindowForDeleting();
				if (choice == JOptionPane.YES_OPTION) {
					try {
						String courseCode = comboBoxCourseForExam.getSelectedItem().toString();
						String examID = comboBoxExamID.getSelectedItem().toString();
						viewController.removeFromCourse(courseCode, examID);
						lblResponse.setText("Exam removed from course.");
					} catch (NumberFormatException exception) {
						viewController.showExceptionWindowForEmptyFields();
					} catch (NullPointerException exception) {
						viewController.showExceptionWindowForUnlinkedExam();
					}
				}
			}
		});
		panelExistingExam.add(btnRemoveFromCourse);

		panelCourseForExam = new JPanel();
		panelCourseForExam.setBounds(0, 151, 279, 41);
		panelWrittenExams.add(panelCourseForExam);
		panelCourseForExam.setLayout(null);

		JLabel label_1 = new JLabel("Course ID:");
		label_1.setBounds(0, 8, 77, 20);
		panelCourseForExam.add(label_1);

		comboBoxCourseForExam = new JComboBox<String>(viewController.getCourses());
		comboBoxCourseForExam.setBounds(104, 5, 175, 26);
		comboBoxCourseForExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterExams((String) comboBoxCourseForExam.getSelectedItem());
				} catch (NullPointerException exception) {
					viewController.setExamModel(new DefaultComboBoxModel<String>(new String[] { "empty" }));
				}

			}
		});
		panelCourseForExam.add(comboBoxCourseForExam);

		panelWrittenExamActions = new JPanel();
		panelWrittenExamActions.setBounds(0, 0, 251, 151);
		panelWrittenExams.add(panelWrittenExamActions);
		panelWrittenExamActions.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panelWrittenExamActions.add(lblNewLabel);

		JRadioButton rdbtnAddNew = new JRadioButton("Add new exam to selected course");
		buttonGroup.add(rdbtnAddNew);
		panelWrittenExamActions.add(rdbtnAddNew);
		rdbtnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewNewExam();
			}

		});

		JRadioButton rdbtnRemoveExam = new JRadioButton("Remove an exam");
		buttonGroup.add(rdbtnRemoveExam);
		panelWrittenExamActions.add(rdbtnRemoveExam);
		rdbtnRemoveExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewRemoveExam();
			}

		});

		JRadioButton rdbtnRegisterStudentFor = new JRadioButton("Register student for exam");
		buttonGroup.add(rdbtnRegisterStudentFor);
		panelWrittenExamActions.add(rdbtnRegisterStudentFor);
		rdbtnRegisterStudentFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewRegisterStudent();
			}

		});

		JRadioButton rdbtnUnregisterStudentFor = new JRadioButton("Unregister student for exam");
		buttonGroup.add(rdbtnUnregisterStudentFor);
		panelWrittenExamActions.add(rdbtnUnregisterStudentFor);
		rdbtnUnregisterStudentFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewUnregisterStudent();
			}
		});

		panelUnregisterStudent = new JPanel();
		panelUnregisterStudent.setBounds(0, 192, 279, 194);
		panelWrittenExams.add(panelUnregisterStudent);
		panelUnregisterStudent.setVisible(false);
		panelUnregisterStudent.setLayout(null);

		JLabel lblExamId_2 = new JLabel("Exam ID:");
		lblExamId_2.setBounds(7, 8, 67, 20);
		panelUnregisterStudent.add(lblExamId_2);

		comboBoxExamIDUnregister = new JComboBox<String>();
		comboBoxExamIDUnregister.setBounds(104, 5, 175, 26);
		comboBoxExamIDUnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterStudents((String) comboBoxExamIDUnregister.getSelectedItem());
				} catch (NullPointerException exception) {
					comboBoxStudentIDUnregister.setModel(new DefaultComboBoxModel<String>(new String[] { "empty" }));
				}
			}
		});
		panelUnregisterStudent.add(comboBoxExamIDUnregister);

		JLabel lblStudentId_1 = new JLabel("Student ID:");
		lblStudentId_1.setBounds(7, 44, 82, 20);
		panelUnregisterStudent.add(lblStudentId_1);

		comboBoxStudentIDUnregister = new JComboBox<String>();
		comboBoxStudentIDUnregister.setBounds(104, 41, 175, 26);
		panelUnregisterStudent.add(comboBoxStudentIDUnregister);

		JButton btnUnregisterStudent = new JButton("Unregister student");
		btnUnregisterStudent.setBounds(104, 102, 147, 29);
		btnUnregisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String examID = comboBoxExamIDUnregister.getSelectedItem().toString();
					String studentID = comboBoxStudentIDUnregister.getSelectedItem().toString();

					viewController.unregisterStudent(studentID, examID);
					lblResponse.setText("Student unregistered.");
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForUnlinkedStudent();
				}
			}
		});
		panelUnregisterStudent.add(btnUnregisterStudent);

		JButton btnGoBack_2 = new JButton("Go back");
		btnGoBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});
		btnGoBack_2.setBounds(10, 402, 89, 34);
		panelWrittenExams.add(btnGoBack_2);
		contentPane.add(panelCourseRegister);

		panelChooseCourse = new JPanel();
		panelChooseCourse.setBounds(0, 226, 251, 60);
		panelChooseCourse.setVisible(false);
		panelCourseRegister.setLayout(null);

		JButton btnGoBack_1 = new JButton("Go back");
		btnGoBack_1.setBounds(0, 501, 89, 34);
		btnGoBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});

		panelDelete = new JPanel();
		panelDelete.setBounds(0, 297, 251, 199);
		panelDelete.setVisible(false);

		panelAdd = new JPanel();
		panelAdd.setBounds(0, 452, 251, 44);
		panelAdd.setVisible(false);

		panelEdit = new JPanel();
		panelEdit.setBounds(0, 452, 251, 34);
		panelEdit.setVisible(false);

		panelCourseInfo = new JPanel();
		panelCourseInfo.setBounds(0, 297, 251, 144);
		panelCourseInfo.setVisible(false);
		panelCourseRegister.add(panelCourseInfo);
		panelCourseInfo.setLayout(null);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(5, 8, 55, 20);
		panelCourseInfo.add(lblCredits);

		textFieldEditCredits = new JTextField();
		textFieldEditCredits.setBounds(105, 5, 146, 26);
		panelCourseInfo.add(textFieldEditCredits);
		textFieldEditCredits.setToolTipText("Only integer numbers");
		textFieldEditCredits.setColumns(10);

		JLabel lblCourseName = new JLabel("Name:");
		lblCourseName.setBounds(5, 36, 99, 20);
		panelCourseInfo.add(lblCourseName);

		textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(105, 33, 146, 26);
		panelCourseInfo.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);
		panelCourseRegister.add(panelEdit);
		panelEdit.setVisible(false);
		panelEdit.setLayout(null);

		JButton btnEdit = new JButton("Save changes");
		btnEdit.setBounds(124, 0, 127, 29);
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
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelCourseRegister.add(panelAdd);
		panelAdd.setVisible(false);

		JButton btnAdd = new JButton("Save");
		btnAdd.setBounds(186, 0, 65, 29);
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
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForCreditParseException();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelAdd.setLayout(null);
		panelAdd.add(btnAdd);
		panelCourseRegister.add(panelDelete);
		panelDelete.setLayout(null);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(147, 16, 104, 29);
		btnDelete.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDelete.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelDelete.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = viewController.showConfirmWindowForDeleting();
				if (choice == JOptionPane.YES_OPTION) {
					try {
						String courseCode = comboBoxChooseCourse.getSelectedItem().toString();
						viewController.deleteCourse(courseCode);
						lblResponse.setText("Course deleted.");
					} catch (NumberFormatException exception) {
						viewController.showExceptionWindowForEmptyFields();
					}
				}
			}
		});
		panelCourseRegister.add(btnGoBack_1);
		panelCourseRegister.add(panelChooseCourse);

		comboBoxChooseCourse = new JComboBox<String>(viewController.getCourses());
		comboBoxChooseCourse.setBounds(107, 5, 144, 26);
		panelChooseCourse.setLayout(null);

		JLabel lblCourseIdChooseCourse = new JLabel("Course ID:");
		lblCourseIdChooseCourse.setBounds(0, 8, 77, 20);
		panelChooseCourse.add(lblCourseIdChooseCourse);
		panelChooseCourse.add(comboBoxChooseCourse);

		JLabel lblCourseRegister = new JLabel("Administrate Courses");
		lblCourseRegister.setBounds(0, 5, 205, 19);
		panelCourseRegister.add(lblCourseRegister);
		lblCourseRegister.setFont(new Font("Arial", Font.PLAIN, 20));

		panelCourseActions = new JPanel();
		panelCourseActions.setBounds(0, 35, 251, 144);
		panelCourseRegister.add(panelCourseActions);

		JButton btnEditCourse = new JButton("Edit course");
		btnEditCourse.setBounds(0, 70, 127, 29);
		buttonGroupCourses.add(btnEditCourse);
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewEditCourse();
			}
		});

		JButton btnNewCourse = new JButton("New course");
		btnNewCourse.setBounds(0, 25, 127, 29);
		buttonGroupCourses.add(btnNewCourse);
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewNewCourse();
			}
		});
		panelCourseActions.setLayout(null);
		panelCourseActions.add(btnNewCourse);
		panelCourseActions.add(btnEditCourse);

		JButton btnDeleteCourse = new JButton("Delete course");
		btnDeleteCourse.setBounds(0, 115, 127, 29);
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewDeleteCourse();
			}
		});
		panelCourseActions.add(btnDeleteCourse);
		contentPane.add(btnGoBack);

		lblResponse = new JLabel("");
		lblResponse.setBounds(10, 521, 251, 29);
		contentPane.add(lblResponse);

	}
}