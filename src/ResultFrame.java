import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import java.awt.Dimension;

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldScoreOutput;
	private JTextField textFieldResultOutput;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblAm;
	private JLabel lblM;
	private JLabel lblAvg;
	
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
	
	
	ViewController viewController;
	Result result;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find result");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(105, 15, 79, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblfindstudent = new JLabel("StudentId:");
		lblfindstudent.setBounds(10, 133, 103, 22);
		contentPane.add(lblfindstudent);
		
		JLabel lblCourseid = new JLabel("CourseId:");
		lblCourseid.setBounds(10, 178, 70, 22);
		contentPane.add(lblCourseid);
		
		JLabel lblExamid = new JLabel("ExamId:");
		lblExamid.setBounds(10, 222, 70, 22);
		contentPane.add(lblExamid);
		
		JComboBox comboBoxStudent = new JComboBox();
		comboBoxStudent.setBounds(112, 133, 118, 22);
		contentPane.add(comboBoxStudent);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 178, 118, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(112, 222, 118, 22);
		contentPane.add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 307, 231, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelFind = new JPanel();
		panelFind.setBounds(10, 307, 231, 147);
		contentPane.add(panelFind);
		panelFind.setLayout(null);
		
		JRadioButton rdbtnFindResult = new JRadioButton("Find result");
		buttonGroup.add(rdbtnFindResult);
		rdbtnFindResult.setBounds(10, 265, 109, 23);
		contentPane.add(rdbtnFindResult);
		
		rdbtnFindResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panelFind.setVisible(true);
				panel.setVisible(false);
			}
	});
		
		
		
		JRadioButton rdbtnRegisterResult = new JRadioButton("Register result");
		buttonGroup.add(rdbtnRegisterResult);
		rdbtnRegisterResult.setBounds(121, 265, 140, 23);
		contentPane.add(rdbtnRegisterResult);
		
		rdbtnRegisterResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panelFind.setVisible(false);
			}
		
		});	
			
		JLabel label_2 = new JLabel("Score:");
		label_2.setBounds(10, 28, 71, 17);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(94, 26, 96, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("Result:");
		label_3.setBounds(10, 59, 62, 18);
		panel.add(label_3);
		
		JLabel lblResponse = new JLabel("");
		lblResponse.setBounds(91, 122, 49, 14);
		panel.add(lblResponse);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 57, 96, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JInternalFrame internalFrameExamResults = new JInternalFrame("Exam Results");
		internalFrameExamResults.setVisible(false);
		internalFrameExamResults.setClosable(true);
		internalFrameExamResults.setBounds(267, 24, 206, 176);
		contentPane.add(internalFrameExamResults);
		internalFrameExamResults.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int score = Integer.parseInt(textField.getText());
			result.gradeCalculator();
			textField_1.setText(Character.toString(result.getLetterGrade()));
			String studentId =  comboBoxStudent.getSelectedItem().toString();
			String examId = comboBox_1.getSelectedItem().toString();
			viewController.registerResultForStudent(studentId, examId, score);
			lblResponse.setText("Result Registered");
		
			
			}
		});
		
		btnSave.setBounds(94, 88, 96, 23);
		panel.add(btnSave);
		
		
		JLabel lblStatistics = new JLabel("Statistics:");
		internalFrameExamResults.getContentPane().add(lblStatistics);
		
		Component rigidArea = Box.createRigidArea(new Dimension(150, 15));
		internalFrameExamResults.getContentPane().add(rigidArea);
		
		JLabel lblAverage = new JLabel("Average:");
		internalFrameExamResults.getContentPane().add(lblAverage);
		
		lblAvg = new JLabel("avg");
		internalFrameExamResults.getContentPane().add(lblAvg);
		
		JLabel lblAmountOfStudents = new JLabel("Amount of students who passed:");
		internalFrameExamResults.getContentPane().add(lblAmountOfStudents);
		
		lblAm = new JLabel("am");
		internalFrameExamResults.getContentPane().add(lblAm);
		
		JLabel lblMedian = new JLabel("Median:");
		internalFrameExamResults.getContentPane().add(lblMedian);
		
		lblM = new JLabel("m");
		internalFrameExamResults.getContentPane().add(lblM);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(112, 90, 118, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblStudentName = new JLabel("Student name:");
		lblStudentName.setBounds(10, 94, 103, 14);
		contentPane.add(lblStudentName);
		
		
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

		
		JButton btnExamResults = new JButton("Exam results");
		btnExamResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		internalFrameExamResults.setVisible(true);
		String examId = comboBox_1.getSelectedItem().toString();
		viewController.showStatistics(examId);
		
		
			}
		});	
		
		btnExamResults.setBounds(57, 113, 116, 23);
		panelFind.add(btnExamResults);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(384, 431, 89, 23);
		contentPane.add(btnReturn);
		
		
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
