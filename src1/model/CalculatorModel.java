package model;

import java.util.ArrayList;
import java.util.List;

import view.ObserverView;

public class CalculatorModel implements ObservableModel {

	private List<ObserverView> observerViews;
	
	private double result;
	
	public CalculatorModel() {
		observerViews = new ArrayList<>();
	}

	public void addObserver(ObserverView o) {
		observerViews.add(o);
	}

	public void deleteObserver(ObserverView o) {
		for (ObserverView d : observerViews) {
			if (d == o) {
				observerViews.remove(o);
				return;
			}
		}
	}

	public void notifyObservers() {
		for (ObserverView d : observerViews) {
			d.update(this);
		}
	}

	public void add(double a, double b) {
		result = a + b;
		notifyObservers();
	}

	public void subtract(double a, double b) {
		result = a - b;
		notifyObservers();
	}

	@Override
	public double getResult() {
		return result;
	}
}
