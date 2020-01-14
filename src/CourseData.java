import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseData extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JTable tableCourse;
	private JButton btnGoBack;
	
	public JTable getTableCourse() {
		return tableCourse;
	}

	public void setTableCourse(JTable tableCourse) {
		this.tableCourse = tableCourse;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseData frame = new CourseData(new ViewController());
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
	public CourseData(ViewController viewController) {
		setTitle("Course Register");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableCourse = new JTable();
		tableCourse.setEnabled(false);
		tableCourse.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableCourse);
		
		btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.goBackFromCourseData();
			}
		});
		contentPane.add(btnGoBack, BorderLayout.SOUTH);
	}

}
