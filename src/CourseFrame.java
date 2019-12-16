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

public class CourseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ViewController viewController;

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
		
		JPanel panelEdit = new JPanel();
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
		
		JLabel lblCourseId = new JLabel("Course ID");
		panelEdit.add(lblCourseId);
		
		JComboBox comboBox = new JComboBox();
		panelEdit.add(comboBox);
		
		JLabel lblCourseName = new JLabel("Course name");
		panelEdit.add(lblCourseName);
		
		textField = new JTextField();
		textField.setEditable(false);
		panelEdit.add(textField);
		textField.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits");
		panelEdit.add(lblCredits);
		
		textField_1 = new JTextField();
		panelEdit.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelEdit.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		panelEdit.add(btnDelete);
	}
}
