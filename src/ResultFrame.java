import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldScoreOutput;
	private JTextField textFieldResultOutput;
	private JTextField textFieldScoreInput;
	private JTextField textFieldResultInput;
	private JInternalFrame internalFrameExamResults;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblAm;
	private JLabel lblM;
	private JLabel lblAvg;
	private JComboBox<String> comboBoxChooseStudent;
	private JComboBox<String> comboBoxChooseCourse;
	private JComboBox<String> comboBoxChooseExam;

	public JLabel getLblAm() {
		return lblAm;
	}

	public void setLblAm(JLabel lblAm) {
		this.lblAm = lblAm;
	}

	public JLabel getLblM() {
		return lblM;
	}

	public void setLblM(JLabel lblM) {
		this.lblM = lblM;
	}

	public JLabel getLblAvg() {
		return lblAvg;
	}

	public void setLblAvg(JLabel lblAvg) {
		this.lblAvg = lblAvg;
	}

	public JComboBox<String> getComboBoxChooseStudent() {
		return comboBoxChooseStudent;
	}

	public void setComboBoxChooseStudent(JComboBox<String> comboBoxChooseStudent) {
		this.comboBoxChooseStudent = comboBoxChooseStudent;
	}

	public JComboBox<String> getComboBoxChooseCourse() {
		return comboBoxChooseCourse;
	}

	public void setComboBoxChooseCourse(JComboBox<String> comboBoxChooseCourse) {
		this.comboBoxChooseCourse = comboBoxChooseCourse;
	}

	public JComboBox<String> getComboBoxChooseExam() {
		return comboBoxChooseExam;
	}

	public void setComboBoxChooseExam(JComboBox<String> comboBoxChooseExam) {
		this.comboBoxChooseExam = comboBoxChooseExam;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewController viewController = new ViewController();
					ResultFrame frame = new ResultFrame(viewController);
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
	public ResultFrame(ViewController viewController) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 651, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFind = new JPanel();
		panelFind.setBounds(10, 269, 231, 170);
		contentPane.add(panelFind);
		panelFind.setLayout(null);
		panelFind.setVisible(false);

		JLabel label = new JLabel("Score:");
		label.setBounds(0, 5, 64, 20);
		panelFind.add(label);

		textFieldScoreOutput = new JTextField();
		textFieldScoreOutput.setBounds(106, 5, 96, 20);
		textFieldScoreOutput.setEditable(false);
		textFieldScoreOutput.setColumns(10);
		panelFind.add(textFieldScoreOutput);

		JLabel label_1 = new JLabel("Result:");
		label_1.setBounds(0, 39, 64, 20);
		panelFind.add(label_1);

		textFieldResultOutput = new JTextField();
		textFieldResultOutput.setBounds(106, 42, 96, 20);
		textFieldResultOutput.setEditable(false);
		textFieldResultOutput.setColumns(10);
		panelFind.add(textFieldResultOutput);

		JButton btnExamResults = new JButton("Overall exam results");
		btnExamResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String examId = comboBoxChooseExam.getSelectedItem().toString();
					viewController.showStatistics(examId);
					internalFrameExamResults.setVisible(true);
				} catch (java.lang.ArithmeticException exception) {
					viewController.showExceptionWindowForNoResult();
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForEmptyFields();
				}

			}
		});

		btnExamResults.setBounds(0, 129, 196, 29);
		panelFind.add(btnExamResults);

		JButton btnResultForStudent = new JButton("Result for Student");
		btnResultForStudent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					String examId = comboBoxChooseExam.getSelectedItem().toString();
					String studentId = comboBoxChooseStudent.getSelectedItem().toString();
					Integer result = viewController.findResultForStudent(studentId, examId);
					textFieldScoreOutput.setText(result.toString());
					textFieldResultOutput.setText(viewController.calculateGrade(result));
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoResult();
					textFieldScoreOutput.setText("");
					textFieldResultOutput.setText("");
				}
			}
		});
		btnResultForStudent.setBounds(0, 94, 196, 29);
		panelFind.add(btnResultForStudent);

		JLabel lblNewLabel = new JLabel("Result Administration");
		lblNewLabel.setBounds(10, 15, 220, 24);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JLabel lblfindstudent = new JLabel("Student:");
		lblfindstudent.setBounds(10, 226, 103, 22);
		contentPane.add(lblfindstudent);

		JLabel lblCourseid = new JLabel("Course:");
		lblCourseid.setBounds(10, 55, 70, 22);
		contentPane.add(lblCourseid);

		JLabel lblExamid = new JLabel("Exam:");
		lblExamid.setBounds(10, 99, 70, 22);
		contentPane.add(lblExamid);
		internalFrameExamResults = new JInternalFrame("Exam Results");
		internalFrameExamResults.setBounds(267, 24, 335, 176);
		internalFrameExamResults.setVisible(false);
		internalFrameExamResults.setClosable(true);
		contentPane.add(internalFrameExamResults);

		comboBoxChooseStudent = new JComboBox<String>(viewController.getStudents());
		comboBoxChooseStudent.setBounds(72, 226, 158, 22);
		contentPane.add(comboBoxChooseStudent);
		comboBoxChooseStudent.setVisible(false);

		comboBoxChooseCourse = new JComboBox<String>(viewController.getCourses());
		comboBoxChooseCourse.setBounds(72, 55, 158, 22);
		comboBoxChooseCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterExams((String) comboBoxChooseCourse.getSelectedItem());
				} catch (NullPointerException exception) {
					comboBoxChooseExam.setModel(new DefaultComboBoxModel<String>(new String[] { "empty" }));
				}
			}
		});
		;
		contentPane.add(comboBoxChooseCourse);

		comboBoxChooseExam = new JComboBox<String>();
		comboBoxChooseExam.setBounds(72, 99, 158, 22);
		comboBoxChooseExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					viewController.filterStudents((String) comboBoxChooseExam.getSelectedItem());
				} catch (NullPointerException exception) {
					comboBoxChooseStudent.setModel(new DefaultComboBoxModel<String>(new String[] { "empty" }));
				}
			}
		});
		;
		contentPane.add(comboBoxChooseExam);

		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(10, 307, 231, 147);
		contentPane.add(panelRegister);
		panelRegister.setLayout(null);
		panelRegister.setVisible(false);

		JRadioButton rdbtnFindResult = new JRadioButton("Find results");
		rdbtnFindResult.setBounds(0, 182, 197, 23);
		buttonGroup.add(rdbtnFindResult);
		contentPane.add(rdbtnFindResult);

		rdbtnFindResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);
				panelRegister.setVisible(false);
				comboBoxChooseStudent.setVisible(true);

			}
		});

		JRadioButton rdbtnRegisterResult = new JRadioButton("Register result");
		rdbtnRegisterResult.setBounds(0, 151, 140, 23);
		buttonGroup.add(rdbtnRegisterResult);
		contentPane.add(rdbtnRegisterResult);

		rdbtnRegisterResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegister.setVisible(true);
				panelFind.setVisible(false);
				comboBoxChooseStudent.setVisible(true);
			}

		});

		JLabel lblScoreRegister = new JLabel("Score:");
		lblScoreRegister.setBounds(10, 28, 71, 17);
		panelRegister.add(lblScoreRegister);

		textFieldScoreInput = new JTextField();
		textFieldScoreInput.setBounds(94, 26, 96, 20);
		textFieldScoreInput.setColumns(10);
		panelRegister.add(textFieldScoreInput);

		JLabel lblResultRegister = new JLabel("Result:");
		lblResultRegister.setBounds(10, 59, 62, 18);
		panelRegister.add(lblResultRegister);

		JLabel lblResponse = new JLabel("");
		lblResponse.setBounds(10, 122, 195, 14);
		panelRegister.add(lblResponse);

		textFieldResultInput = new JTextField();
		textFieldResultInput.setBounds(94, 57, 96, 20);
		textFieldResultInput.setEditable(false);
		textFieldResultInput.setColumns(10);
		panelRegister.add(textFieldResultInput);

		JButton btnSaveResultForStudent = new JButton("Save");
		btnSaveResultForStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int score = Integer.parseInt(textFieldScoreInput.getText());
					viewController.calculateGrade(score);
					textFieldResultInput.setText((viewController.calculateGrade(score)));
					String studentId = comboBoxChooseStudent.getSelectedItem().toString();
					String examId = comboBoxChooseExam.getSelectedItem().toString();
					viewController.registerResultForStudent(studentId, examId, score);
					lblResponse.setText("Result Registered");
				} catch (NullPointerException exception) {
					viewController.showExceptionWindowForNoStudent();
				} catch (IllegalArgumentException exception) {
					viewController.showExceptionWindowForWrongGrade();
				}

			}
		});

		btnSaveResultForStudent.setBounds(94, 88, 96, 23);
		panelRegister.add(btnSaveResultForStudent);
		internalFrameExamResults.getContentPane().setLayout(null);

		JLabel lblStatistics = new JLabel("Statistics:");
		lblStatistics.setBounds(5, 5, 67, 20);
		internalFrameExamResults.getContentPane().add(lblStatistics);

		Component rigidArea = Box.createRigidArea(new Dimension(150, 15));
		rigidArea.setBounds(77, 7, 227, 15);
		internalFrameExamResults.getContentPane().add(rigidArea);

		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(5, 30, 64, 20);
		internalFrameExamResults.getContentPane().add(lblAverage);

		lblAvg = new JLabel("avg");
		lblAvg.setBounds(74, 30, 77, 20);
		internalFrameExamResults.getContentPane().add(lblAvg);

		JLabel lblAmountOfStudents = new JLabel("Amount of students who passed:");
		lblAmountOfStudents.setBounds(5, 55, 234, 20);
		internalFrameExamResults.getContentPane().add(lblAmountOfStudents);

		lblAm = new JLabel("am");
		lblAm.setBounds(238, 55, 66, 20);
		internalFrameExamResults.getContentPane().add(lblAm);

		JLabel lblMedian = new JLabel("Median:");
		lblMedian.setBounds(5, 80, 56, 20);
		internalFrameExamResults.getContentPane().add(lblMedian);

		lblM = new JLabel("m");
		lblM.setBounds(63, 80, 77, 20);
		internalFrameExamResults.getContentPane().add(lblM);

		JButton btnReturnToMain = new JButton("Return to main menu");
		btnReturnToMain.setBounds(10, 492, 196, 29);
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewController.returnToMain();

			}
		});
		contentPane.add(btnReturnToMain);

	}

	
	
}