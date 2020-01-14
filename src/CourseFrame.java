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
		setBounds(100, 100, 346, 593);
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

		panelWrittenExams = new JPanel();
		panelWrittenExams.setVisible(false);

		panelCourseRegister = new JPanel();
		panelCourseRegister.setVisible(false);
		panelCourseRegister.setBounds(10, 11, 251, 454);
		contentPane.add(panelCourseRegister);
		panelCourseRegister.setLayout(null);

		panelChooseCourse = new JPanel();
		panelChooseCourse.setBounds(0, 183, 251, 60);
		panelChooseCourse.setVisible(false);

		panelCourseInfo = new JPanel();
		panelCourseInfo.setBounds(0, 254, 288, 81);
		panelCourseInfo.setVisible(false);

		panelEdit = new JPanel();
		panelEdit.setBounds(0, 351, 251, 34);
		panelEdit.setVisible(false);
		panelCourseRegister.add(panelEdit);
		panelEdit.setVisible(false);
		panelEdit.setLayout(null);

		JButton btnSaveEditCourse = new JButton("Save");
		btnSaveEditCourse.setBounds(151, 0, 100, 29);
		panelEdit.add(btnSaveEditCourse);
		btnSaveEditCourse.addActionListener(new ActionListener() {
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
				} catch (IllegalArgumentException exception) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoCourses();
				}
			}
		});
		panelCourseRegister.add(panelCourseInfo);
		panelCourseInfo.setLayout(null);

		JLabel lblCredits = new JLabel("Credits*:");
		lblCredits.setBounds(0, 5, 70, 20);
		panelCourseInfo.add(lblCredits);

		textFieldEditCredits = new JTextField();
		textFieldEditCredits.setBounds(105, 2, 146, 26);
		panelCourseInfo.add(textFieldEditCredits);
		textFieldEditCredits.setToolTipText("Only integer numbers");
		textFieldEditCredits.setColumns(10);

		JLabel lblCourseName = new JLabel("Name*:");
		lblCourseName.setBounds(0, 47, 99, 20);
		panelCourseInfo.add(lblCourseName);

		textFieldEditCourseName = new JTextField();
		textFieldEditCourseName.setBounds(105, 44, 146, 26);
		panelCourseInfo.add(textFieldEditCourseName);
		textFieldEditCourseName.setColumns(10);

		panelCourseActions = new JPanel();
		panelCourseActions.setBounds(0, 35, 251, 132);
		panelCourseRegister.add(panelCourseActions);

		JButton btnEditCourse = new JButton("Edit course");
		btnEditCourse.setBounds(0, 39, 200, 29);
		buttonGroupCourses.add(btnEditCourse);
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewEditCourse();
			}
		});

		JButton btnNewCourse = new JButton("Register new course");
		btnNewCourse.setBounds(0, 5, 200, 29);
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
		btnDeleteCourse.setBounds(0, 74, 200, 29);
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewDeleteCourse();
			}
		});
		panelCourseActions.add(btnDeleteCourse);
		panelCourseRegister.add(panelChooseCourse);

		comboBoxChooseCourse = new JComboBox<String>(viewController.getCourses());
		comboBoxChooseCourse.setBounds(104, 5, 147, 26);
		panelChooseCourse.setLayout(null);

		JLabel lblCourseIdChooseCourse = new JLabel("Course ID:");
		lblCourseIdChooseCourse.setBounds(0, 8, 77, 20);
		panelChooseCourse.add(lblCourseIdChooseCourse);
		panelChooseCourse.add(comboBoxChooseCourse);

		JLabel lblCourseRegister = new JLabel("Course Administration");
		lblCourseRegister.setBounds(0, 5, 205, 19);
		panelCourseRegister.add(lblCourseRegister);
		lblCourseRegister.setFont(new Font("Arial", Font.PLAIN, 20));

		panelDelete = new JPanel();
		panelDelete.setBounds(0, 254, 251, 81);
		panelDelete.setVisible(false);
		panelCourseRegister.add(panelDelete);
		panelDelete.setLayout(null);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(151, 16, 100, 29);
		btnDelete.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDelete.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelDelete.add(btnDelete);

		JButton btnGoBack_1 = new JButton("Go back");
		btnGoBack_1.setBounds(0, 401, 89, 29);
		panelCourseRegister.add(btnGoBack_1);

		panelAdd = new JPanel();
		panelAdd.setBounds(0, 351, 251, 52);
		panelCourseRegister.add(panelAdd);
		panelAdd.setVisible(false);
		panelAdd.setVisible(false);

		JButton btnAddNewCourse = new JButton("Save");
		btnAddNewCourse.setBounds(151, 0, 100, 29);
		btnAddNewCourse.setBackground(new Color(240, 240, 240));
		btnAddNewCourse.addActionListener(new ActionListener() {
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
				} catch (IllegalArgumentException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}
			}
		});
		panelAdd.setLayout(null);
		panelAdd.add(btnAddNewCourse);
		btnGoBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});
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
					} catch (NullPointerException exception) {
						viewController.showExceptionWindowForNoCourses();
					}
				}
			}
		});
		panelWrittenExams.setBounds(10, 11, 251, 464);
		contentPane.add(panelWrittenExams);
		panelWrittenExams.setLayout(null);

		panelUnregisterStudent = new JPanel();
		panelUnregisterStudent.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelUnregisterStudent);
		panelUnregisterStudent.setVisible(false);
		panelUnregisterStudent.setLayout(null);

		JLabel lblExamId_2 = new JLabel("Exam ID:");
		lblExamId_2.setBounds(0, 8, 67, 20);
		panelUnregisterStudent.add(lblExamId_2);

		comboBoxExamIDUnregister = new JComboBox<String>();
		comboBoxExamIDUnregister.setBounds(104, 5, 147, 26);
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
		lblStudentId_1.setBounds(0, 54, 82, 20);
		panelUnregisterStudent.add(lblStudentId_1);

		comboBoxStudentIDUnregister = new JComboBox<String>();
		comboBoxStudentIDUnregister.setBounds(104, 47, 147, 26);
		panelUnregisterStudent.add(comboBoxStudentIDUnregister);

		JButton btnUnregisterStudent = new JButton("Unregister student");
		btnUnregisterStudent.setBounds(88, 104, 163, 29);
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
					viewController.showExceptionWindowForNoStudent();
				}
			}
		});
		panelUnregisterStudent.add(btnUnregisterStudent);

		panelRegisterStudent = new JPanel();
		panelRegisterStudent.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelRegisterStudent);
		panelRegisterStudent.setVisible(false);
		panelRegisterStudent.setLayout(null);

		JLabel lblExamId_1 = new JLabel("Exam ID");
		lblExamId_1.setBounds(0, 8, 61, 20);
		panelRegisterStudent.add(lblExamId_1);

		comboBoxExamIDRegister = new JComboBox<String>();
		comboBoxExamIDRegister.setBounds(104, 5, 147, 26);
		panelRegisterStudent.add(comboBoxExamIDRegister);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(0, 45, 76, 20);
		panelRegisterStudent.add(lblStudentId);

		comboBoxStudentID = new JComboBox<String>(viewController.getStudents());
		comboBoxStudentID.setBounds(104, 42, 147, 26);
		panelRegisterStudent.add(comboBoxStudentID);

		JButton btnRegisterStudent = new JButton("Register student");
		btnRegisterStudent.setBounds(104, 89, 147, 29);
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String examID = comboBoxExamIDRegister.getSelectedItem().toString();
					String studentID = comboBoxStudentID.getSelectedItem().toString();
					viewController.registerStudentForExam(studentID, examID);
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
		panelExistingExam.setBounds(0, 190, 251, 194);
		panelWrittenExams.add(panelExistingExam);
		panelExistingExam.setVisible(false);
		panelExistingExam.setLayout(null);

		JLabel lblExamId = new JLabel("Exam ID:");
		lblExamId.setBounds(0, 8, 67, 20);
		panelExistingExam.add(lblExamId);

		comboBoxExamID = new JComboBox<String>();
		comboBoxExamID.setBounds(104, 5, 147, 26);
		panelExistingExam.add(comboBoxExamID);

		JButton btnRemoveFromCourse = new JButton("Remove from course");
		btnRemoveFromCourse.setBounds(64, 73, 187, 29);
		btnRemoveFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = viewController.showConfirmWindowForDeleting();
				if (choice == JOptionPane.YES_OPTION) {
					try {
						String courseCode = comboBoxCourseForExam.getSelectedItem().toString();
						String examID = comboBoxExamID.getSelectedItem().toString();
						viewController.removeExamFromCourse(courseCode, examID);
						lblResponse.setText("Exam removed from course.");
					} catch (NumberFormatException exception) {
						viewController.showExceptionWindowForEmptyFields();
					} catch (NullPointerException exception) {
						viewController.showExceptionWindowForNoExams();
					}

				}
			}
		});
		panelExistingExam.add(btnRemoveFromCourse);

		panelAddNewExam = new JPanel();
		panelAddNewExam.setBounds(0, 192, 251, 194);
		panelWrittenExams.add(panelAddNewExam);
		panelAddNewExam.setVisible(false);
		panelAddNewExam.setLayout(null);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(0, 9, 38, 20);
		panelAddNewExam.add(lblDate);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(46, 5, 202, 29);

		panelAddNewExam.add(datePicker);

		JLabel lblTime = new JLabel("Start time");
		lblTime.setBounds(0, 42, 69, 20);
		panelAddNewExam.add(lblTime);

		textFieldHours = new JTextField();
		textFieldHours.setBounds(79, 39, 76, 26);
		panelAddNewExam.add(textFieldHours);
		textFieldHours.setColumns(5);

		JLabel label = new JLabel(":");
		label.setBounds(160, 42, 6, 20);
		panelAddNewExam.add(label);

		textFieldMinutes = new JTextField();
		textFieldMinutes.setBounds(171, 39, 76, 26);
		panelAddNewExam.add(textFieldMinutes);
		textFieldMinutes.setColumns(5);

		Component horizontalStrut = Box.createHorizontalStrut(30);
		horizontalStrut.setBounds(58, 83, 30, 12);
		panelAddNewExam.add(horizontalStrut);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(0, 73, 59, 20);
		panelAddNewExam.add(lblLocation);

		comboBoxLocation = new JComboBox<String>(viewController.getLocations());
		comboBoxLocation.setBounds(104, 70, 147, 26);
		panelAddNewExam.add(comboBoxLocation);

		JButton btnAddExamTo = new JButton("Add exam to course");
		btnAddExamTo.setBounds(73, 124, 175, 29);
		btnAddExamTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date date = (Date) datePicker.getModel().getValue();
					String hours = textFieldHours.getText().toString();
					String minutes = textFieldMinutes.getText().toString();
					String location = comboBoxLocation.getSelectedItem().toString();
					String courseID = (String) comboBoxCourseForNewExam.getSelectedItem();
					viewController.addNewExamToCourse(date, hours, minutes, location, courseID);
					lblResponse.setText("Exam added to course.");
				} catch (DateTimeException exception) {
					viewController.showExceptionWindowForTimeParseException();
				} catch (NumberFormatException exception) {
					viewController.showExceptionWindowForTimeParseException();
				} catch (IllegalArgumentException exception) {
					viewController.showExceptionWindowForEmptyFields();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoCourses();
				} catch (ParseException exception) {
					viewController.showExceptionWindowForTimeParseException();
				}
			}
		});
		panelAddNewExam.add(btnAddExamTo);

		panelCourseForNewExam = new JPanel();
		panelCourseForNewExam.setBounds(0, 151, 251, 41);
		panelWrittenExams.add(panelCourseForNewExam);
		panelCourseForNewExam.setLayout(null);

		JLabel label_2 = new JLabel("Course ID:");
		label_2.setBounds(0, 8, 77, 20);
		panelCourseForNewExam.add(label_2);

		comboBoxCourseForNewExam = new JComboBox<String>(viewController.getCourses());
		comboBoxCourseForNewExam.setBounds(104, 5, 147, 26);
		panelCourseForNewExam.add(comboBoxCourseForNewExam);

		panelCourseForExam = new JPanel();
		panelCourseForExam.setBounds(0, 151, 251, 41);
		panelWrittenExams.add(panelCourseForExam);
		panelCourseForExam.setLayout(null);

		JLabel label_1 = new JLabel("Course ID:");
		label_1.setBounds(0, 8, 77, 20);
		panelCourseForExam.add(label_1);

		comboBoxCourseForExam = new JComboBox<String>(viewController.getCourses());
		comboBoxCourseForExam.setBounds(104, 5, 147, 26);
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

		JLabel lblNewLabel = new JLabel("Exam Administration");
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

		JButton btnGoBack_2 = new JButton("Go back");
		btnGoBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.viewBack();
			}
		});
		btnGoBack_2.setBounds(0, 418, 89, 34);
		panelWrittenExams.add(btnGoBack_2);

		panelWelcome = new JPanel();
		panelWelcome.setBounds(10, 11, 205, 203);
		contentPane.add(panelWelcome);
		panelWelcome.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(61, 5, 82, 24);
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 20));
		panelWelcome.add(lblWelcome);

		JButton btnOpenCourseRegister = new JButton("Course Administration");
		btnOpenCourseRegister.setBounds(0, 45, 205, 29);
		btnOpenCourseRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.openCourseRegister();
			}
		});
		panelWelcome.add(btnOpenCourseRegister);

		JButton btnOpenExamRegister = new JButton("Exam Administration");
		btnOpenExamRegister.setBounds(0, 79, 205, 29);
		btnOpenExamRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.openExamRegister();
			}
		});
		panelWelcome.add(btnOpenExamRegister);

		JButton btnViewAllCourses = new JButton("View all courses");
		btnViewAllCourses.setBounds(0, 112, 205, 29);
		btnViewAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.viewCourseData();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForIDError();
				}
			}
		});
		panelWelcome.add(btnViewAllCourses);

		JButton btnViewAllExams = new JButton("View all exams");
		btnViewAllExams.setBounds(0, 147, 205, 29);
		btnViewAllExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.viewExamData();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForIDError();
				}
			}
		});
		panelWelcome.add(btnViewAllExams);
		btnGoBack.setBounds(10, 509, 187, 29);
		contentPane.add(btnGoBack);

		lblResponse = new JLabel("");
		lblResponse.setBounds(10, 475, 251, 29);
		contentPane.add(lblResponse);

	}
}