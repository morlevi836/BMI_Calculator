import javax.swing.*;

public class BMIMain {

    public static void main(String[] args) {

        BMIView theView = new BMIView();

        BMIModel theModel = new BMIModel();

        BMIController theController = new BMIController(theView, theModel);

        theView.setTitle("BMI Calculator");
        theView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theView.setVisible(true);
        theView.setLocationRelativeTo(null);
        theView.setResizable(false);
    }
}