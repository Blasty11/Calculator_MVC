package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import model.ObservableModel;

public class CalculatorView extends Frame implements ObserverView {
	private static final long serialVersionUID = -2685981147248446400L;
	private Label num1Lbl;
	private Label num2Lbl;
	private Label resultLbl;

	private TextField num1Text;
	private TextField num2Text;
	private TextField resultText;

	private Button addBtn;
	private Button subBtn;
	
	public CalculatorView() {
		num1Lbl = new Label("Number 1");
		num2Lbl = new Label("Number 2");
		resultLbl = new Label("Result");
		
		num1Text = new TextField(10);
		num2Text = new TextField(10);
		resultText = new TextField(10);
		
		addBtn = new Button("Add");
		subBtn = new Button("Subtract");
		
		this.add(num1Lbl);
		this.add(num1Text);
		
		this.add(num2Lbl);
		this.add(num2Text);
		
		this.add(resultLbl);
		this.add(resultText);
		
		this.add(addBtn);
		this.add(subBtn);
		
		addBtn.setActionCommand("+");
		subBtn.setActionCommand("-");
		
		setSize(200, 200);
		setLocation(300, 300);
		
		setLayout(new FlowLayout());
		
		resultText.setEditable(false);
	}
	
	public double getFirstOperand() {
		return Double.parseDouble(num1Text.getText());
	}
	
	public double getSecondOperand() {
		return Double.parseDouble(num2Text.getText());
	}

	public Button getAddBtn() {
		return addBtn;
	}

	public Button getSubBtn() {
		return subBtn;
	}

	public void setActionListener(ActionListener al) {
		this.addBtn.addActionListener(al);
		this.subBtn.addActionListener(al);
		
	}
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}
	@Override
	public void update(ObservableModel o) {
		double result = o.getResult(); // pulls updates from the model, push model can also be used
		resultText.setText(result + "");
	}


}
