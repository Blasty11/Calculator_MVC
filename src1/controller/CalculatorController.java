package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {

	private CalculatorModel model;
	private CalculatorView view;

	/**
	 * Glues the Model and a default View
	 * Binds the default View to ActionListner and WindowsListener
	 * @param m
	 * @param v
	 */
	public CalculatorController(CalculatorModel m, CalculatorView v) {
		this.model = m;
		this.view = v;
		m.addObserver(v);
		this.view.setActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String operation = e.getActionCommand();
				double a = view.getFirstOperand();
				double b = view.getSecondOperand();
				switch (operation) {
				case "+":
					model.add(a, b);
					break;
				case "-":
					model.subtract(a, b);
					break;
				default:
				}
			}
		});
		this.view.setWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				view.dispose();
			}
		});
	}
	
	/*
	class CalculationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String operation = e.getActionCommand();
			double a = view.getFirstOperand();
			double b = view.getSecondOperand();
			double result = 0 ;
			switch (operation) {
			case "+":
				result = model.add(a, b);
				break;
			case "-":
				result = model.subtract(a, b);
				break;
			default:
			}
			view.updateResult(result);
		}
	}
	*/
}
