package controer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import model.Answer;
import model.HibernateHelper;
import model.Question;
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

		actionSearch();

		actionDelete();
		
		actionClean();
		
		actionUpdate();
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
				String answer1;
				String answer2;
				String answer3;
				String answer4;
				boolean a1;
				boolean a2;
				boolean a3;
				boolean a4;

				sQuestion = view.gettQuestion().getText();
				sCategory = (String) view.getCategory().getSelectedItem();
				id = model.getLastQuestion().getIdQuestion();
				id++;
				System.out.println("save question:" + id + " " + sQuestion
						+ " " + sCategory);
				model.addQuestion(id, sQuestion, sCategory, null);
				answer1 = view.gettAnswer1().getText();
				answer2 = view.gettAnswer2().getText();
				answer3 = view.gettAnswer3().getText();
				answer4 = view.gettAnswer4().getText();
				a1 = view.getChCorrect1().isSelected();
				a2 = view.getCheckBox().isSelected();
				a3 = view.getCheckBox_1().isSelected();
				a4 = view.getCheckBox_2().isSelected();
				id = model.getLastAnswer().getIdAnswer();
				id++;
				Question lastQuestion = model.getLastQuestion();
				model.addAnswer(id, lastQuestion, answer1, a1);
				id++;
				model.addAnswer(id, model.getLastQuestion(), answer2, a2);
				id++;
				model.addAnswer(id, model.getLastQuestion(), answer3, a3);
				id++;
				model.addAnswer(id, model.getLastQuestion(), answer4, a4);
			}
		});
	}

	private void actionSearch() {
		view.getBtnBuscarId().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id;
				id = Integer.parseInt(view.getTId().getText());
				Question question = model.getQuestion(id);

				ArrayList<Answer> aAnswer = new ArrayList<>();
				for (Answer answer : question.getAnswers()) {
					aAnswer.add(answer);
				}
				Collections.sort(aAnswer, new Comparator<Answer>() {
					public int compare(Answer answer1, Answer answer2) {
						return answer1.getIdAnswer() - answer2.getIdAnswer();
					}
				});

				view.settQuestion(question.getText());
				view.getCategory().setSelectedItem(question.getCategory());
				view.settAnswer1(aAnswer.get(0).getText().toString());
				view.settAnswer2(aAnswer.get(1).getText().toString());
				view.settAnswer3(aAnswer.get(2).getText().toString());
				view.settAnswer4(aAnswer.get(3).getText().toString());
				view.setChCorrect1(aAnswer.get(0).getIsCorrect());
				view.setCheckBox(aAnswer.get(1).getIsCorrect());
				view.setCheckBox_1(aAnswer.get(2).getIsCorrect());
				view.setCheckBox_2(aAnswer.get(3).getIsCorrect());

			}
		});
	}

	private void actionDelete() {
		view.getBtnDeleteQuestion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id;
				id = Integer.parseInt(view.getTId().getText());
				System.out.println(id);
				Question question = model.getQuestion(id);

				ArrayList<Answer> aAnswer = new ArrayList<>();
				for (Answer answer : question.getAnswers()) {
					aAnswer.add(answer);
				}
				Collections.sort(aAnswer, new Comparator<Answer>() {
					public int compare(Answer answer1, Answer answer2) {
						return answer1.getIdAnswer() - answer2.getIdAnswer();
					}
				});

				model.deleteAnswer(aAnswer.get(0).getIdAnswer());
				model.deleteAnswer(aAnswer.get(1).getIdAnswer());
				model.deleteAnswer(aAnswer.get(2).getIdAnswer());
				model.deleteAnswer(aAnswer.get(3).getIdAnswer());
				model.deleteQuestion(id);

				model.deleteQuestion(id);

				System.out.println("Pregunta Borrada");

			}
		});
	}
	
	private void actionClean() {
		view.getBtnCleanQuestion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.settAnswer1("");
				view.settAnswer2("");
				view.settAnswer3("");
				view.settAnswer4("");
				
				view.settQuestion("");
				
				view.setChCorrect1(false);
				view.setCheckBox(false);
				view.setCheckBox_1(false);
				view.setCheckBox_2(false);
				
				view.setTId("");

			}
		});
	}
	
	private void actionUpdate() {
		view.getBtnUpdateQuestion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
	
				int id;
				String answer1;
				String answer2;
				String answer3;
				String answer4;
				boolean a1;
				boolean a2;
				boolean a3;
				boolean a4;
				

				id=Integer.parseInt(view.getTId().getText());
				Question question=model.getQuestion(id);
				Set<Answer> sAnswers = question.getAnswers();
				ArrayList<Answer> mAnswers = new ArrayList<>();
				for(Answer a: question.getAnswers()){
				mAnswers.add(a);
				}
				Collections.sort(mAnswers, new Comparator<Answer>() {
				public int compare(Answer answer1, Answer answer2) {
				return answer1.getIdAnswer()- answer2.getIdAnswer();
				}
				});
				
				answer1 = view.gettAnswer1().getText();
				answer2 = view.gettAnswer2().getText();
				answer3 = view.gettAnswer3().getText();
				answer4 = view.gettAnswer4().getText();
				a1 = view.getChCorrect1().isSelected();
				a2 = view.getCheckBox().isSelected();
				a3 = view.getCheckBox_1().isSelected();
				a4 = view.getCheckBox_2().isSelected();
				
				model.updateQuestion(question);
				model.updateAnswer(new Answer(mAnswers.get(0).getIdAnswer(), question, answer1, a1));
				model.updateAnswer(new Answer(mAnswers.get(1).getIdAnswer(), question, answer2, a2));
				model.updateAnswer(new Answer(mAnswers.get(2).getIdAnswer(), question, answer3, a3));
				model.updateAnswer(new Answer(mAnswers.get(3).getIdAnswer(), question, answer4, a4));
				System.out.println("Actualizado");
				
			}
		});
	}

	private void loadCategories() {
		view.getCategory().addItem("Matemáticas");
		view.getCategory().addItem("Historia");
	}
}
