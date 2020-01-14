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

	

	private ViewController viewController;
	private JPanel contentPane;
	private JLabel lblWelcomeToResult;
	private JLabel lblPleaseMakeOne;
	private JButton btnAdministrateStudents;
	private JButton btnAdministrateCourses;
	private JButton btnAdministrateResults;

	public ViewController getController() {
		return viewController;
	}

	public void setController(ViewController controller) {
		this.viewController = controller;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewController viewController = new ViewController();
					StartFrame frame = new StartFrame(viewController);
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
	public StartFrame(ViewController viewController) {
		this.viewController = viewController;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblWelcomeToResult = new JLabel("Welcome to Result Master");
		lblWelcomeToResult.setFont(new Font("Arial", Font.PLAIN, 25));
		lblWelcomeToResult.setBounds(15, 104, 330, 20);
		contentPane.add(lblWelcomeToResult);

		lblPleaseMakeOne = new JLabel("Please make one of the following choices");
		lblPleaseMakeOne.setBounds(15, 155, 340, 20);
		contentPane.add(lblPleaseMakeOne);

		btnAdministrateStudents = new JButton("Administrate Students");
		btnAdministrateStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.administrateStudents(viewController);
			}
		});
		btnAdministrateStudents.setBounds(15, 237, 209, 48);
		contentPane.add(btnAdministrateStudents);

		btnAdministrateCourses = new JButton("Administrate Courses");
		btnAdministrateCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.administrateCourses(viewController);
			}
		});
		btnAdministrateCourses.setBounds(15, 301, 209, 47);
		contentPane.add(btnAdministrateCourses);

		btnAdministrateResults = new JButton("Administrate Results");
		btnAdministrateResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.resultReports(viewController);
			}
		});
		btnAdministrateResults.setBounds(15, 364, 209, 48);
		contentPane.add(btnAdministrateResults);
	}
}
