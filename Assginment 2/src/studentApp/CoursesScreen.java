package studentApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CoursesScreen extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panelOK;
	private JPanel panelDefault;
	private JTextField textFieldTitle;
	private JTextField textFieldCODE;
	private JTextField textFieldTeacher;
	private JComboBox<Integer> comboCreditHours;
	private JButton btnAdd;
	private JButton btnEdit;
	/**
	 * Create the frame.
	 */
	public CoursesScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Courses");
		setBounds(100, 100, 1024, 567);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoursetInformation = new JLabel("Course Information");
		lblCoursetInformation.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCoursetInformation.setBounds(50, 13, 370, 50);
		contentPane.add(lblCoursetInformation);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(50, 121, 56, 16);
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(154, 118, 272, 22);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblCode = new JLabel("CODE");
		lblCode.setBounds(50, 85, 56, 16);
		contentPane.add(lblCode);
		
		textFieldCODE = new JTextField();
		textFieldCODE.setBounds(154, 82, 160, 22);
		contentPane.add(textFieldCODE);
		textFieldCODE.setColumns(10);
			
		JLabel lblSemster = new JLabel("Credit Hours");
		lblSemster.setBounds(50, 206, 83, 16);
		contentPane.add(lblSemster);
		
		Integer[] arr = {2,3};
		comboCreditHours = new JComboBox<Integer>(arr);
		comboCreditHours.setBounds(154, 203, 116, 22);
		comboCreditHours.setEditable(false);
		contentPane.add(comboCreditHours);
		
		textFieldTeacher = new JTextField();
		textFieldTeacher.setColumns(10);
		textFieldTeacher.setBounds(154, 159, 272, 22);
		contentPane.add(textFieldTeacher);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(50, 162, 83, 16);
		contentPane.add(lblTeacher);
		
		panelOK = new JPanel();
		panelOK.setBounds(12, 462, 982, 45);
		contentPane.add(panelOK);
		panelOK.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(862, 0, 120, 45);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("Cancel");
		panelOK.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(730, 0, 120, 45);
		btnSave.addActionListener(this);
		btnSave.setActionCommand("Save");
		panelOK.add(btnSave);
		
		panelDefault = new JPanel();
		panelDefault.setBounds(12, 462, 982, 45);
		contentPane.add(panelDefault);
		panelDefault.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(0, 0, 120, 45);
		btnSearch.addActionListener(this);
		btnSearch.setActionCommand("Search");
		panelDefault.add(btnSearch);
		
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
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(466, 0, 120, 45);
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("Add");
		panelDefault.add(btnAdd);
		
		if(App.courses.size()-1 >= 0) 
			fillForm(App.courses.size()-1);
		else 
			btnAdd.doClick();
		
		panelOK.setVisible(false);
		panelDefault.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Close")) {
			this.dispose();
			
		}else if(command.equals("Add")) {
			panelOK.setVisible(true);
			panelDefault.setVisible(false);
			
			textFieldCODE.setText("");
			textFieldTitle.setText("");
			textFieldTeacher.setText("");
			comboCreditHours.setSelectedIndex(0);
			
		}else if(command.equals("Save")) {

			String code;
			
			if(textFieldCODE.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Course must have a code!");
				btnAdd.doClick();
				
				panelOK.setVisible(false);
				panelDefault.setVisible(true);
				
				return;
			}else {
				code = textFieldCODE.getText();
			}
			String title = textFieldTitle.getText();
			String teacher = textFieldTeacher.getText();
			
			int creditHours = (int) comboCreditHours.getSelectedItem();
		
			App.courses.add(new Courses(code, title, teacher, creditHours));
		
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
			
		}else if(command.equals("Edit")) {
			String code = ""; 
			code = JOptionPane.showInputDialog(null, "Enter Course Code");
			if(code != null) {
				int index = searchCourse(code);
				if(index != -1) {
					fillForm(index);
					
					panelOK.setVisible(true);
					panelDefault.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "No Course with CODE: "+code+" exist in the database.");
				}
			}

		}else if(command.equals("Delete")) {
			String code = ""; 
			code = JOptionPane.showInputDialog(null, "Enter Course CODE to Delete");
			
			if(code != null) {
				int index = searchCourse(code);
				if(index != -1) {
					App.courses.remove(index);
					JOptionPane.showMessageDialog(null, "Recored Deleted!");
				}else 
					JOptionPane.showMessageDialog(null, "No course with CODE: "+code+" exist in the database.");
			}

		}else if(command.equals("Search")) {
			btnEdit.doClick();
			
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
			
			
		}else if(command.equals("Cancel")) {
			
			if(App.students.size()-1 >= 0) 
				fillForm(App.students.size()-1);
			else 
				btnAdd.doClick();
			
			panelOK.setVisible(false);
			panelDefault.setVisible(true);
		}
		
		
		
	}
	private void fillForm(int index) {
		Courses course = App.courses.get(index);
		
		textFieldCODE.setText(""+course.getCode());
		textFieldTitle.setText(course.getTitle());
		textFieldTeacher.setText(course.getTeacher());
		
		comboCreditHours.setSelectedItem(course.getCreditHours());
		
	}
	private int searchCourse(String code) {
		for(int i = 0; i<App.courses.size();i++) {
			if(App.courses.get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}
}
