package controer;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HibernateHelper;
import view.VentanaPrincipal;




public class controer {
	VentanaPrincipal view;
	HibernateHelper model;
	
	
	controer() {
		
		view = new VentanaPrincipal();
		model = new HibernateHelper();	

		launchMainWindow();		
		
		loadCategories();	
		
		actionSave();
}
	private void launchMainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private void actionSave() {
		view.getBtnSaveQuestion().addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sQuestion;
				String sCategory;
				int id;
				
				sQuestion = view.gettQuestion().getText();
				sCategory = (String) view.getCategory().getSelectedItem();
				id = model.getLastQuestion().getIdQuestion();
				System.out.println(id);
				id++;
				
				System.out.println("save question:"+id+ " "+sQuestion+ " "+sCategory);
				model.addQuestion(id,sQuestion,sCategory,null);				
			}
		});
	}


	private void loadCategories() {
		view.getCategory().addItem("Matemáticas");
		view.getCategory().addItem("Historia");
	}
}

