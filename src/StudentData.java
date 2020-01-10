import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentData extends JFrame {

	private JPanel contentPane;
	private JButton btnBackToMainMenu;
	private JTable tableStudent;
	
	
	public JTable getTableStudent() {
		return tableStudent;
	}

	public void setTableStudent(JTable tableStudent) {
		this.tableStudent = tableStudent;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					StudentData frame = new StudentData(new ViewController());
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
	public StudentData(ViewController viewController) {
		setTitle("Student Register");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));				
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableStudent = new JTable();
		tableStudent.setEnabled(false);
		tableStudent.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableStudent);
		
		JButton goBack = new JButton("Go back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.goBackFromStudentData();
			}
		});
		
		contentPane.add(goBack, BorderLayout.SOUTH);
	}
}
