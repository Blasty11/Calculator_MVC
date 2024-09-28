package model;

import view.ObserverView;

public interface ObservableModel {
	void addObserver(ObserverView o);
	void deleteObserver(ObserverView o);
	void notifyObservers();
	double getResult();
}
