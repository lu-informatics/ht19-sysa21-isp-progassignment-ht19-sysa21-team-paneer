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

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToResult = new JLabel("Welcome to Result Master");
		lblWelcomeToResult.setFont(new Font("Arial", Font.PLAIN, 25));
		lblWelcomeToResult.setBounds(66, 103, 330, 20);
		contentPane.add(lblWelcomeToResult);
		
		JLabel lblPleaseMakeOne = new JLabel("Please make one of the following choices");
		lblPleaseMakeOne.setBounds(66, 154, 340, 20);
		contentPane.add(lblPleaseMakeOne);
		
		JButton btnAdministrateStudents = new JButton("Administrate Students");
		btnAdministrateStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAdministrateStudents.setBounds(66, 236, 209, 48);
		contentPane.add(btnAdministrateStudents);
		
		JButton btnAdministrateCourses = new JButton("Administrate Courses");
		btnAdministrateCourses.setBounds(66, 300, 209, 47);
		contentPane.add(btnAdministrateCourses);
		
		JButton btnResultReports = new JButton("Result Reports");
		btnResultReports.setBounds(66, 363, 209, 48);
		contentPane.add(btnResultReports);
	}
}
