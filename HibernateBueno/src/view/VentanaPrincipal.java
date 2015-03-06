package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	private static final String TEXT_BUTTON_SAVE = "Guardar";
	private static final String TEXT_BUTTON_DELETE = "Borrar";
	private static final String TEXT_BUTTON_UPDATE = "Actualizar";
	private static final String TEXT_BUTTON_CLEAN = "Limpiar";
	private static final String TITLE = "Hibernate Quizit";
	private static final String MANAGER_TAB = "Question Manager";
	private static final String TEXT_BUTTON_BUSCAR = "Buscar Id";

	private static final int WITH = 500;
	private static final int HEIGHT = 300;

	private JTextField tQuestion;
	private JTextField tAnswer1;
	private JTextField tAnswer2;
	private JTextField tAnswer3;
	private JTextField tAnswer4;
	private JTextField tId;

	private JButton btnSaveQuestion;
	private JButton btnDeleteQuestion;
	private JButton btnUpdateQuestion;
	private JButton btnCleanQuestion;
	private JButton btnBuscarId;

	private JCheckBox chCorrect1;
	private JCheckBox checkBox;

	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;

	public VentanaPrincipal() {
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout. This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.

		setTitle(TITLE);
		setSize(WITH, HEIGHT);
		setBackground(Color.gray);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab(MANAGER_TAB, panel1);

		tabbedPane.addTab("Questions", panel2);
		tabbedPane.addTab("Categories", panel3);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
	}

	public void createPage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(panel1);
		panel1.setLayout(null);

		tQuestion = new JTextField();
		tQuestion.setBounds(35, 31, 261, 42);
		panel1.add(tQuestion);
		tQuestion.setColumns(10);

		tAnswer1 = new JTextField();
		tAnswer1.setBounds(37, 108, 86, 20);
		panel1.add(tAnswer1);
		tAnswer1.setColumns(10);

		tAnswer2 = new JTextField();
		tAnswer2.setBounds(230, 108, 86, 20);
		panel1.add(tAnswer2);
		tAnswer2.setColumns(10);

		tAnswer3 = new JTextField();
		tAnswer3.setBounds(37, 158, 86, 20);
		panel1.add(tAnswer3);
		tAnswer3.setColumns(10);

		tAnswer4 = new JTextField();
		tAnswer4.setBounds(230, 158, 86, 20);
		panel1.add(tAnswer4);
		tAnswer4.setColumns(10);

		tId = new JTextField();
		tId.setBounds(440, 100, 23, 23);
		panel1.add(tId);
		tId.setColumns(10);

		btnSaveQuestion = new JButton(TEXT_BUTTON_SAVE);
		btnSaveQuestion.setBounds(35, 200, 86, 23);
		panel1.add(btnSaveQuestion);

		btnDeleteQuestion = new JButton(TEXT_BUTTON_DELETE);
		btnDeleteQuestion.setBounds(131, 200, 86, 23);
		panel1.add(btnDeleteQuestion);

		btnUpdateQuestion = new JButton(TEXT_BUTTON_UPDATE);
		btnUpdateQuestion.setBounds(230, 200, 86, 23);
		panel1.add(btnUpdateQuestion);

		btnCleanQuestion = new JButton(TEXT_BUTTON_CLEAN);
		btnCleanQuestion.setBounds(333, 200, 86, 23);
		panel1.add(btnCleanQuestion);

		btnBuscarId = new JButton(TEXT_BUTTON_BUSCAR);
		btnBuscarId.setBounds(397, 135, 90, 23);
		panel1.add(btnBuscarId);

		category = new JComboBox();
		category.setBounds(321, 31, 103, 20);
		panel1.add(category);

		 chCorrect1 = new JCheckBox("");
		chCorrect1.setBounds(129, 108, 37, 23);

		panel1.add(chCorrect1);

		 checkBox = new JCheckBox("");
		checkBox.setBounds(129, 157, 37, 23);
		panel1.add(checkBox);

		checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(323, 107, 37, 23);
		panel1.add(checkBox_1);

		 checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(323, 155, 37, 23);
		panel1.add(checkBox_2);

	}

	public void createPage2() {
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());

		panel2.add(new JButton("North"), BorderLayout.NORTH);
		panel2.add(new JButton("South"), BorderLayout.SOUTH);
		panel2.add(new JButton("East"), BorderLayout.EAST);
		panel2.add(new JButton("West"), BorderLayout.WEST);
		panel2.add(new JButton("Center"), BorderLayout.CENTER);
	}

	public void createPage3() {
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3, 2));

		panel3.add(new JLabel("Field 1:"));
		panel3.add(new TextArea());
		panel3.add(new JLabel("Field 2:"));
		panel3.add(new TextArea());
		panel3.add(new JLabel("Field 3:"));
		panel3.add(new TextArea());
	}

	private JComboBox category;

	public JComboBox getCategory() {
		return category;
	}

	public void setCategory(JComboBox category) {
		this.category = category;
	}

	public JButton getBtnSaveQuestion() {
		return btnSaveQuestion;
	}

	public void setBtnSaveQuestion(JButton btnSaveQuestion) {
		this.btnSaveQuestion = btnSaveQuestion;
	}

	public JButton getBtnUpdateQuestion() {
		return btnUpdateQuestion;
	}

	public void setBtnUpdateQuestion(JButton btnUpdateQuestion) {
		this.btnUpdateQuestion = btnUpdateQuestion;
	}

	public JButton getBtnCleanQuestion() {
		return btnCleanQuestion;
	}

	public void setBtnCleanQuestion(JButton btnCleanQuestion) {
		this.btnCleanQuestion = btnCleanQuestion;
	}

	public JButton getBtnBuscarId() {
		return btnBuscarId;
	}

	public void setBtnBuscarId(JButton btnBuscarId) {
		this.btnBuscarId = btnBuscarId;
	}

	public JButton getBtnDeleteQuestion() {
		return btnDeleteQuestion;
	}

	public void setBtnDeleteQuestion(JButton btnDeleteQuestion) {
		this.btnDeleteQuestion = btnDeleteQuestion;
	}

	public JTextField gettQuestion() {
		return tQuestion;
	}

	public void settQuestion(String tQuestion) {
		this.tQuestion.setText(tQuestion);
	}

	public JTextField gettAnswer1() {
		return tAnswer1;
	}

	public void settAnswer1(String tAnswer1) {
		this.tAnswer1.setText(tAnswer1);
	}

	public JTextField gettAnswer2() {
		return tAnswer2;
	}

	public void settAnswer2(String tAnswer2) {
		this.tAnswer2.setText(tAnswer2);
	}

	public JTextField gettAnswer3() {
		return tAnswer3;
	}

	public void settAnswer3(String tAnswer3) {
		this.tAnswer3.setText(tAnswer3);
	}

	public JTextField gettAnswer4() {
		return tAnswer4;
	}

	public void settAnswer4(String tAnswer4) {
		this.tAnswer4.setText(tAnswer4);
	}

	public JTextField getTId() {
		return tId;
	}

	public void setTId(String id) {
		this.tId.setText(id);;
	}

	public JCheckBox getChCorrect1() {
		return chCorrect1;
		}
		public void setChCorrect1(boolean check) {
		this.chCorrect1.setSelected(check);
		}
		public JCheckBox getCheckBox() {
		return checkBox;
		}
		public void setCheckBox(boolean check) {
		this.checkBox.setSelected(check);
		}
		public JCheckBox getCheckBox_1() {
		return checkBox_1;
		}
		public void setCheckBox_1(boolean check) {
		this.checkBox_1.setSelected(check);
		}
		public JCheckBox getCheckBox_2() {
		return checkBox_2;
		}
		public void setCheckBox_2(boolean check) {
		this.checkBox_2.setSelected(check);
		}

}
