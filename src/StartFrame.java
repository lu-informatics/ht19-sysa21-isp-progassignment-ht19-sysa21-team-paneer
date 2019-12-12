import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ViewController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private ViewController controller;
	private JLabel lblWelcomeToResult;
	private JLabel lblPleaseMakeOne;
	private JButton btnAdministrateStudents;
	private JButton btnAdministrateCourses;
	private JButton btnResultReports;
	
	public JLabel getLblWelcomeToResult() {
		return lblWelcomeToResult;
	}

	public JLabel getLblPleaseMakeOne() {
		return lblPleaseMakeOne;
	}

	public JButton getBtnAdministrateStudents() {
		return btnAdministrateStudents;
	}

	public JButton getBtnAdministrateCourses() {
		return btnAdministrateCourses;
	}

	public JButton getBtnResultReports() {
		return btnResultReports;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public ViewController getController() {
		return controller;
	}

	public void setController(ViewController controller) {
		this.controller = controller;
	}

	
	

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
		controller = new ViewController(this);
		this.setController(controller);
		
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
		btnAdministrateStudents.setBounds(66, 236, 209, 48);
		contentPane.add(btnAdministrateStudents);
		
		btnAdministrateCourses = new JButton("Administrate Courses");
		btnAdministrateCourses.setBounds(66, 300, 209, 47);
		contentPane.add(btnAdministrateCourses);
		
		btnResultReports = new JButton("Result Reports");
		btnResultReports.setBounds(66, 363, 209, 48);
		contentPane.add(btnResultReports);
	}
}
