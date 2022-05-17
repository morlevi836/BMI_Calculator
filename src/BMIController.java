import javax.swing.*;

public final class BMIController {
    public static void main(String[] args) {

        BMIView theView = new BMIView();
        BMIModel theModel = new BMIModel();

        theView.setTitle("BMI Calculator");
        theView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theView.setVisible(true);
        theView.setLocationRelativeTo(null);
        theView.setResizable(false);

        theView.addEnterListener(e -> {

            double height, actualWeight, idealWeight, age, bodyFrame, slimness, bmi;
            String status;

            try {
                actualWeight = theView.getUserWeight();
                height = theView.getUserHeight();
                age = theView.getUserAge();
                bodyFrame = theView.getUserBodyFrame();

                slimness = theModel.getUserSlimness(bodyFrame);
                bmi = theModel.getBMI(actualWeight, height);
                status = theModel.getStatus(bmi);
                idealWeight = theModel.getIdealWeight(height, age, slimness);

                theView.setBMI(bmi);
                theView.setStatus(status);
                theView.setActualWeight(actualWeight);
                theView.setIdealWeight(idealWeight);

            } catch (NumberFormatException ex) {
                theView.displayErrorMessage();
            }
        });
    }
}
