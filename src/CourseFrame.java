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

public class CourseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ViewController viewController;
	private JPanel panelEdit;
	private JPanel panelAdd;
	private JTextField textFieldAddCourseID;
	private JTextField textFieldAddCredits;
	private JTextField textFieldAddName;

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
		setBounds(100, 100, 717, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 251, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewCourse = new JButton("New course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		panelEdit.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(51, 16, 0, 0);
		panelEdit.add(label_4);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(10, 47, 41, 14);
		panelEdit.add(lblCredits);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setBounds(10, 9, 68, 14);
		panelEdit.add(lblCourseId);
		panelEdit.add(btnEdit);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(205, 16, 0, 0);
		panelEdit.add(label_8);
		
		textField = new JTextField();
		textField.setBounds(109, 44, 96, 20);
		panelEdit.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(119, 44, 0, 0);
		panelEdit.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 5, 145, 22);
		panelEdit.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setBounds(159, 44, 0, 0);
		panelEdit.add(label);
		
		JLabel lblCourseName = new JLabel("Course name:");
		lblCourseName.setBounds(10, 92, 73, 14);
		panelEdit.add(lblCourseName);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(233, 44, 0, 0);
		panelEdit.add(label_9);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(18, 224, 65, 23);
		panelEdit.add(btnDelete);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(100, 71, 0, 0);
		panelEdit.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(105, 71, 0, 0);
		panelEdit.add(label_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(110, 71, 0, 0);
		panelEdit.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(115, 71, 0, 0);
		panelEdit.add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 89, 96, 20);
		panelEdit.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(221, 71, 0, 0);
		panelEdit.add(label_5);
		
		JPanel panelWrittenExams = new JPanel();
		panelWrittenExams.setBounds(0, 0, 251, 270);
		panelEdit.add(panelWrittenExams);
		
		JLabel label_13 = new JLabel("Course ID:");
		panelWrittenExams.add(label_13);
		
		JComboBox comboBox_1 = new JComboBox();
		panelWrittenExams.add(comboBox_1);
		
		panelAdd = new JPanel();
		panelAdd.setBounds(10, 162, 251, 270);
		contentPane.add(panelAdd);
		panelAdd.setLayout(null);
		
		JLabel label_10 = new JLabel("Course ID:");
		label_10.setBounds(10, 8, 52, 14);
		panelAdd.add(label_10);
		
		textFieldAddCourseID = new JTextField();
		textFieldAddCourseID.setBounds(84, 5, 96, 20);
		textFieldAddCourseID.setColumns(10);
		panelAdd.add(textFieldAddCourseID);
		
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
		btnAdd.setBounds(102, 223, 51, 23);
		panelAdd.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 11, 241, 140);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Written exams");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel);
		
		JPanel panelExam = new JPanel();
		panelExam.setBounds(271, 162, 241, 270);
		contentPane.add(panelExam);
		
		JLabel lblExamId = new JLabel("Exam ID:");
		panelExam.add(lblExamId);
		
		JComboBox comboBox_2 = new JComboBox();
		panelExam.add(comboBox_2);
		
		JButton btnAddToCourse = new JButton("Add to course");
		panelExam.add(btnAddToCourse);
		
		JButton btnRemoveFromCourse = new JButton("Remove from course");
		panelExam.add(btnRemoveFromCourse);
	}
}
