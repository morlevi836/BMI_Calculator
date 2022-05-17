import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public record BMIController(BMIView theView, BMIModel theModel) {

    public BMIController(BMIView theView, BMIModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addEnterListener(new EnterListener());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BMIController) obj;
        return Objects.equals(this.theView, that.theView) &&
                Objects.equals(this.theModel, that.theModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theView, theModel);
    }

    @Override
    public String toString() {
        return "BMIController[" +
                "theView=" + theView + ", " +
                "theModel=" + theModel + ']';
    }


    class EnterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

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
        }
    }
}
