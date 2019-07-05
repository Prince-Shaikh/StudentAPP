package studentApp;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EnrollScreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelOK;
	private JPanel panelDefault;
	private JComboBox<String> comboCourse;
	private JComboBox<String> comboStudent;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnSave;
	private JTextField textFieldMid;
	private JTextField textFieldFinal;
	private JTextField textFieldSeastional;
	private JTextField textFieldTotal;

	/**
	 * Create the frame.
	 */
	public EnrollScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Enroll Students");
		setBounds(100, 100, 1024, 567);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoursetInformation = new JLabel("ENROLL STUDENT");
		lblCoursetInformation.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCoursetInformation.setBounds(50, 13, 370, 50);
		contentPane.add(lblCoursetInformation);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setBounds(50, 85, 56, 16);
		contentPane.add(lblCourse);
		
//		Integer[] arr = {2,3};
		comboCourse = new JComboBox<String>();
		comboCourse.setBounds(150, 82, 250, 22);
		comboCourse.setEditable(false);
		comboCourse.setActionCommand("CourseCombo");
		comboCourse.addActionListener(this);
		contentPane.add(comboCourse);
		
		panelOK = new JPanel();
		panelOK.setBounds(12, 462, 982, 45);
		contentPane.add(panelOK);
		panelOK.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(862, 0, 120, 45);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("Cancel");
		panelOK.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(730, 0, 120, 45);
		btnSave.addActionListener(this);
		btnSave.setActionCommand("Save");
		panelOK.add(btnSave);
		
		panelDefault = new JPanel();
		panelDefault.setBounds(12, 462, 982, 45);
		contentPane.add(panelDefault);
		panelDefault.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(862, 0, 120, 45);
		btnClose.addActionListener(this);
		btnClose.setActionCommand("Close");
		panelDefault.add(btnClose);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(730, 0, 120, 45);
		btnDelete.addActionListener(this);
		btnDelete.setActionCommand("Delete");
		panelDefault.add(btnDelete);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(598, 0, 120, 45);
		btnEdit.addActionListener(this);
		btnEdit.setActionCommand("Edit");
		panelDefault.add(btnEdit);
		
		btnNew = new JButton("New");
		btnNew.setBounds(466, 0, 120, 45);
		btnNew.addActionListener(this);
		btnNew.setActionCommand("New");
		panelDefault.add(btnNew);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setBounds(50, 137, 56, 16);
		contentPane.add(lblStudent);
		
		comboStudent = new JComboBox<String>();
		comboStudent.setEditable(false);
		comboStudent.setBounds(150, 134, 250, 22);
		comboStudent.setActionCommand("StudentCombo");
		comboStudent.addActionListener(this);
		contentPane.add(comboStudent);
		
		JLabel lblMarks = new JLabel("MARKS");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMarks.setBounds(50, 198, 89, 16);
		contentPane.add(lblMarks);
		
		JLabel lblMid = new JLabel("MID EXAMS");
		lblMid.setBounds(50, 242, 77, 16);
		contentPane.add(lblMid);
		
		textFieldMid = new JTextField();
		textFieldMid.setBounds(150, 239, 116, 22);
		contentPane.add(textFieldMid);
		textFieldMid.setColumns(10);
		
		textFieldFinal = new JTextField();
		textFieldFinal.setColumns(10);
		textFieldFinal.setBounds(150, 271, 116, 22);
		contentPane.add(textFieldFinal);
		
		JLabel lblFinalExams = new JLabel("FINAL EXAMS");
		lblFinalExams.setBounds(50, 274, 89, 16);
		contentPane.add(lblFinalExams);
		
		textFieldSeastional = new JTextField();
		textFieldSeastional.setColumns(10);
		textFieldSeastional.setBounds(150, 306, 116, 22);
		contentPane.add(textFieldSeastional);
		
		JLabel lblSeasional = new JLabel("SEASIONAL");
		lblSeasional.setBounds(50, 309, 77, 16);
		contentPane.add(lblSeasional);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEnabled(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(150, 362, 116, 22);
		contentPane.add(textFieldTotal);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(50, 365, 77, 16);
		contentPane.add(lblTotal);
		
		panelOK.setVisible(false);
		panelDefault.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Close")) {
			this.dispose();
			
		}else if(command.equals("New")) {
			panelOK.setVisible(true);
			panelDefault.setVisible(false);
			
			comboStudent.setActionCommand("StudentCombo");
			comboCourse.setActionCommand("CourseCombo");
			btnSave.setActionCommand("Save");
			btnSave.setText("Save");
			
			disableElements();
			updateCourseItems();
			updateStudentItems();
			
		}else if(command.equals("Save")) {
		
			if(comboCourse.getSelectedIndex() !=0 ) {
				Student student;
				int course = comboCourse.getSelectedIndex()-1;				
				int[] marks = new int[3];
				
				int mid = 0,finalMarks = 0,seasional = 0;
				try {
					if(textFieldMid.getText().equals("") != true) {
						mid = Integer.parseInt(textFieldMid.getText());
					}
					if(textFieldFinal.getText().equals("") != true) {
						finalMarks = Integer.parseInt(textFieldFinal.getText());
					}
					if(textFieldSeastional.getText().equals("") != true) {
						seasional = Integer.parseInt(textFieldSeastional.getText());
					}

				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter integer in marks!!");
					return;
				}
				marks[0] = mid;
				marks[1] = finalMarks;
				marks[2] = seasional;
				int totalMarks = mid + finalMarks + seasional;
				if(comboStudent.getSelectedIndex() != 0) {
					int studentindex = comboStudent.getSelectedIndex()-1;
					student = App.students.get(studentindex); 
					App.courses.get(course).enrollStudent(student, marks);
					textFieldTotal.setText("" + totalMarks);
				}else {
					JOptionPane.showMessageDialog(null, "Please select a student!");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Select a course!");
			}
			
			
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
			
		}else if(command.equals("Edit")) {
			panelOK.setVisible(true);
			panelDefault.setVisible(false);
			
			comboStudent.setActionCommand("StudentComboEdit");
			comboCourse.setActionCommand("CourseComboEdit");
			btnSave.setActionCommand("Save");
			btnSave.setText("Save");
			
			disableElements();
			updateCourseItems();

		}else if(command.equals("Delete")) {
			panelOK.setVisible(true);
			panelDefault.setVisible(false);
			
			btnSave.setActionCommand("SaveDelete");
			btnSave.setText("Delete");
			
			
			comboCourse.setActionCommand("CourseComboEdit");
			comboStudent.setActionCommand("StudentComboEdit");
			
			disableElements();
			updateCourseItems();

		}else if(command.equals("Cancel")) {
			
			disableElements();
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
			
		}else if(command.equals("CourseCombo")) {
			String item = (String) comboCourse.getSelectedItem();
			
			if(item.equals("Courses") != true) {
				comboStudent.setEnabled(true);
				updateStudentItems();
			}
			
		}else if(command.equals("StudentCombo")) {
			String item = (String) comboStudent.getSelectedItem();
			
			if(item.equals("Student") != true) {
				textFieldMid.setEnabled(true);
				textFieldFinal.setEnabled(true);
				textFieldSeastional.setEnabled(true);
			}
		}else if(command.equals("StudentComboEdit")) {
			Courses course = App.courses.get(comboCourse.getSelectedIndex()-1);
			String item = (String) comboStudent.getSelectedItem();
			
			if(item.equals("Student") != true) {
				textFieldMid.setEnabled(true);
				textFieldFinal.setEnabled(true);
				textFieldSeastional.setEnabled(true);
				
				int studentindex = comboStudent.getSelectedIndex()-1;
				Student student = course.getEnrolledStudents()[studentindex]; 
				
				int[] marks = course.getStudentMarks(student);
				
				int mid = marks[0],finalMarks = marks[1],seasional = marks[2];

				int totalMarks = mid + finalMarks + seasional;
				
				
				textFieldMid.setText("" + mid);
				textFieldFinal.setText("" + finalMarks);
				textFieldSeastional.setText(""+seasional);
				textFieldTotal.setText("" + totalMarks);
			}

		}else if(command.equals("CourseComboEdit")) {
			String item = (String) comboCourse.getSelectedItem();
			
			if(item.equals("Courses") != true) {
				comboStudent.setEnabled(true);
				Courses course = App.courses.get(comboCourse.getSelectedIndex()-1);
				updateEnrolledStudents(course);
			}
		}else if(command.equals("SaveDelete")) {
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
			
			if(comboCourse.getSelectedIndex() !=0 ) {
				Student student;
				Courses course = App.courses.get(comboCourse.getSelectedIndex()-1);				
				
				if(comboStudent.getSelectedIndex() != 0) {
					student = course.getEnrolledStudents()[comboStudent.getSelectedIndex()-1];
					course.unEnrollStudent(student);
					JOptionPane.showMessageDialog(null, "Student Enrolment Deleted!");
				}else {
					JOptionPane.showMessageDialog(null, "Please select a student!");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Select a course!");
			}
			
		}
	}

	private void disableElements() {
		comboStudent.setEnabled(false);
		textFieldMid.setEnabled(false);
		textFieldFinal.setEnabled(false);
		textFieldSeastional.setEnabled(false);
	}
	
	private void updateEnrolledStudents(Courses course) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Students");
		Student[] arr = course.getEnrolledStudents();
		for(Student student: arr) {
			model.addElement(student.getName());
		}
		comboStudent.setModel(model);
		if(App.students.size()<1)
			comboStudent.setEnabled(false);
		
	}

	private void updateCourseItems() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Courses");
		for(Courses course: App.courses) {
			model.addElement(course.getTitle());
		}
		comboCourse.setModel(model);
		if(App.courses.size()<1)
			comboCourse.setEnabled(false);
		else
			comboCourse.setEnabled(true);
		
	}	
	private void updateStudentItems() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Students");
		for(Student student: App.students) {
			model.addElement(student.getName());
		}
		comboStudent.setModel(model);
		if(App.students.size()<1)
			comboStudent.setEnabled(false);
		
	}
}
