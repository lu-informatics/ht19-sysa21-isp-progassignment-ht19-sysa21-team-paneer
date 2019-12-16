import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {
	//Problemområdeskomponenter
	private CourseRegister courseRegister = new CourseRegister();
	private StudentRegister studentRegister = new StudentRegister();
	private ExamRegister examRegister = new ExamRegister();
	
	//Controllerklassen
	private ViewController controller;
	
	
	public ViewController getController() {
		return controller;
	}

	public void setController(ViewController controller) {
		this.controller = controller;
	}

	//Gränssnittsobjekt
	private JPanel contentPane;
	private JLabel lblWelcomeToResult;
	private JLabel lblPleaseMakeOne;
	private JButton btnAdministrateStudents;
	private JButton btnAdministrateCourses;
	private JButton btnResultReports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		controller = new ViewController(this, courseRegister, studentRegister, examRegister);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeToResult = new JLabel("Welcome to Result Master");
		lblWelcomeToResult.setFont(new Font("Arial", Font.PLAIN, 25));
		lblWelcomeToResult.setBounds(66, 103, 330, 20);
		contentPane.add(lblWelcomeToResult);
		
		lblPleaseMakeOne = new JLabel("Please make one of the following choices");
		lblPleaseMakeOne.setBounds(66, 154, 340, 20);
		contentPane.add(lblPleaseMakeOne);
		
		btnAdministrateStudents = new JButton("Administrate Students");
		btnAdministrateStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.administrateStudents();
			}
		});
		btnAdministrateStudents.setBounds(66, 236, 209, 48);
		contentPane.add(btnAdministrateStudents);
		
		btnAdministrateCourses = new JButton("Administrate Courses");
		btnAdministrateCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.administrateCourses();
			}
		});
		btnAdministrateCourses.setBounds(66, 300, 209, 47);
		contentPane.add(btnAdministrateCourses);
		
		btnResultReports = new JButton("Result Reports");
		btnResultReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.resultReports();
			}
		});
		btnResultReports.setBounds(66, 363, 209, 48);
		contentPane.add(btnResultReports);
	}
}
