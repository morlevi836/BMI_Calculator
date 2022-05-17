public class BMIModel {

    public double getBMI(double weight, double height) {
        height *= 0.01;
        return weight / (Math.pow(height, 2));
    }

    public double getUserSlimness(double bodyFrame) {
        if (bodyFrame == 0)
            return 0.9;
        else if (bodyFrame == 1)
            return 1;
        else if (bodyFrame == 2)
            return 1.1;
        return 0;
    }

    public String getStatus(double bmi) {
        if (bmi < 15)
            return "Anorexic";
        else if (15 < bmi && bmi < 18.5)
            return "Underweight ";
        else if (18.5 < bmi && bmi < 24.9)
            return "Normal ";
        else if (25.0 < bmi && bmi < 29.9)
            return "Overweight ";
        else if (30 < bmi && bmi < 35)
            return "Obese";
        else
            return "Extreme Obese";
    }

    public double getIdealWeight(double height, double age, double slimness) {
        return (height - 100.0 + (age / 10.0)) * 0.9 * slimness;
    }
}
