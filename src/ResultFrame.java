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

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldScoreOutput;
	private JTextField textFieldResultOutput;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	
	ViewController viewController;

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
	public ResultFrame() {
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
		lblfindstudent.setBounds(10, 93, 103, 14);
		contentPane.add(lblfindstudent);
		
		JLabel lblCourseid = new JLabel("CourseId:");
		lblCourseid.setBounds(10, 156, 48, 14);
		contentPane.add(lblCourseid);
		
		JLabel lblExamid = new JLabel("ExamId:");
		lblExamid.setBounds(10, 226, 48, 14);
		contentPane.add(lblExamid);
		
		JComboBox comboBoxStudent = new JComboBox();
		comboBoxStudent.setBounds(76, 89, 118, 22);
		contentPane.add(comboBoxStudent);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 152, 118, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(76, 222, 118, 22);
		contentPane.add(comboBox_1);
		
		JRadioButton rdbtnFindResult = new JRadioButton("Find result");
		buttonGroup.add(rdbtnFindResult);
		rdbtnFindResult.setBounds(10, 265, 109, 23);
		contentPane.add(rdbtnFindResult);
		
		JRadioButton rdbtnRegisterResult = new JRadioButton("Register result");
		buttonGroup.add(rdbtnRegisterResult);
		rdbtnRegisterResult.setBounds(121, 265, 109, 23);
		contentPane.add(rdbtnRegisterResult);
		
		JPanel panelFind = new JPanel();
		panelFind.setBounds(10, 305, 231, 147);
		contentPane.add(panelFind);
		panelFind.setLayout(null);
		
		JLabel label = new JLabel("Score:");
		label.setBounds(0, 8, 31, 14);
		panelFind.add(label);
		
		textFieldScoreOutput = new JTextField();
		textFieldScoreOutput.setBounds(65, 5, 96, 20);
		textFieldScoreOutput.setEditable(false);
		textFieldScoreOutput.setColumns(10);
		panelFind.add(textFieldScoreOutput);
		
		JLabel label_1 = new JLabel("Result:");
		label_1.setBounds(0, 45, 35, 14);
		panelFind.add(label_1);
		
		textFieldResultOutput = new JTextField();
		textFieldResultOutput.setBounds(65, 42, 96, 20);
		textFieldResultOutput.setEditable(false);
		textFieldResultOutput.setColumns(10);
		panelFind.add(textFieldResultOutput);
		
		JButton btnExamResults = new JButton("Exam results");
		btnExamResults.setBounds(65, 113, 95, 23);
		panelFind.add(btnExamResults);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 305, 231, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("Score:");
		label_2.setBounds(29, 8, 31, 14);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(65, 5, 96, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("Result:");
		label_3.setBounds(25, 39, 35, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(65, 36, 96, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JInternalFrame internalFrameExamResults = new JInternalFrame("Exam Results");
		internalFrameExamResults.setBounds(290, 15, 206, 407);
		contentPane.add(internalFrameExamResults);
		
		JLabel lblStatistics = new JLabel("Statistics:");
		internalFrameExamResults.getContentPane().add(lblStatistics, BorderLayout.NORTH);
		
		table = new JTable();
		table.setShowGrid(false);
		internalFrameExamResults.getContentPane().add(table, BorderLayout.CENTER);
		internalFrameExamResults.setVisible(true);
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
