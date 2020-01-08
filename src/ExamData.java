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

@SuppressWarnings("serial")
public class ExamData extends JFrame {

	private JPanel contentPane;
	private JTable tableExamData;
	private JButton btnGoBack;

	public JTable getTableExamData() {
		return tableExamData;
	}

	public void setTableExamData(JTable tableExamData) {
		this.tableExamData = tableExamData;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamData frame = new ExamData(new ViewController());
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
	public ExamData(ViewController viewController) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableExamData = new JTable();
		tableExamData.setEnabled(false);
		tableExamData.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableExamData);
		
		btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewController.goBackFromExamData();
			}
		});
		contentPane.add(btnGoBack, BorderLayout.SOUTH);
	}

}
