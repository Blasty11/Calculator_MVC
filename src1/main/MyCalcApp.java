package main;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;
import java.util.Scanner;

public class MyCalcApp 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of calculator views: ");
        int numberOfViews = scanner.nextInt();
        
        CalculatorModel model = new CalculatorModel();
        
        for (int i = 0; i < numberOfViews; i++) 
        {
            CalculatorView view = new CalculatorView();
            new CalculatorController(model, view);
            view.setVisible(true);
        }
        
        scanner.close();
    }
}
