package studentApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class App extends JFrame implements ActionListener{

	protected static ArrayList<Student> students = new ArrayList<>(); 
	protected static ArrayList<Courses> courses = new ArrayList<>();
	
	private JPanel contentPane;
	private JButton btnStudent,btnCourses,btnReports;
	private JButton buttonCourseRegister;
	private JPanel panelTop;
	private JPanel panelBottom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		
		setTitle("Student Information System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 567);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 10, 0));
		
		panelTop = new JPanel();
		contentPane.add(panelTop);
		panelTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblStudentInformaionSystem = new JLabel("Student Informaion System");
		panelTop.add(lblStudentInformaionSystem);
		lblStudentInformaionSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformaionSystem.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		panelBottom = new JPanel();
		contentPane.add(panelBottom);
		panelBottom.setLayout(new GridLayout(0, 4, 10, 0));
		
		btnStudent = new JButton("STUDENTS");
		panelBottom.add(btnStudent);
		btnStudent.setForeground(SystemColor.text);
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStudent.setBackground(SystemColor.inactiveCaption);
		btnStudent.addActionListener(this);
		btnStudent.setActionCommand("Students");
		
		btnCourses = new JButton("COURSES");
		panelBottom.add(btnCourses);
		btnCourses.setForeground(SystemColor.text);
		btnCourses.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCourses.setBackground(SystemColor.inactiveCaption);
		btnCourses.addActionListener(this);
		btnCourses.setActionCommand("Courses");
		
		buttonCourseRegister = new JButton("Enroll Students");
		panelBottom.add(buttonCourseRegister);
		buttonCourseRegister.setForeground(Color.WHITE);
		buttonCourseRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonCourseRegister.setBackground(SystemColor.inactiveCaption);
		buttonCourseRegister.setActionCommand("Enroll");
		buttonCourseRegister.addActionListener(this);
		
		btnReports = new JButton("REPORTS");
		panelBottom.add(btnReports);
		btnReports.setForeground(SystemColor.text);
		btnReports.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReports.setBackground(SystemColor.inactiveCaption);
		btnReports.addActionListener(this);
		btnReports.setActionCommand("Reports");
		
		addDummyData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Students")) {
			StudentScreen screen = new StudentScreen();
			screen.setVisible(true);
			
		}else if(command.equals("Courses")) {
			CoursesScreen screen = new CoursesScreen();
			screen.setVisible(true);
			
		}else if(command.equals("Enroll")) {
			EnrollScreen screen = new EnrollScreen();
			screen.setVisible(true);
			
		}else if(command.equals("Reports")) {
			ReportsScreen screen = new ReportsScreen();
			screen.setVisible(true);
		}
		
	}
	private void addDummyData() {
		students.add(new Student("Moiz Uddin Shaikh", "Faheem Uddin Shaikh", "Male", 46774, 2 ));
		students.add(new Student("ALi Haider", "Shoukat Khan", "Male", 2, 6 ));
		students.add(new Student("Zara Shaheen", "Shaheen Ali", "Female", 4, 5 ));
		students.add(new Student("Sana Zubair", "Zubair Khan", "Female", 8, 2 ));
		
		
		courses.add(new Courses("HUM-101", "Object Orented Programming", "Dr. Bakhtiar", 3));
		courses.add(new Courses("HUM-102", "Pak Studies", "Mr. Naeem", 2));
		courses.add(new Courses("HUM-103", "ECC", "Afzal Khan", 2));
		courses.add(new Courses("HUM-104", "ICT", "Mr. Mirza Amir", 3));
		courses.add(new Courses("HUM-105", "PF", "Dr. Bakhtiar", 3));
	}
}
