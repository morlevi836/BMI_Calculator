import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class BMIView extends JFrame {

    private final JPanel MainPanel = new JPanel();
    private final JPanel North = new JPanel();
    private final JPanel East = new JPanel();
    private final JPanel EastPanel1 = new JPanel();
    private final JPanel EastPanel2 = new JPanel();
    private final JPanel West = new JPanel();
    private final JPanel Center = new JPanel();
    private final JPanel South = new JPanel();
    private final JPanel Panel = new JPanel();

    private final ButtonGroup group = new ButtonGroup();

    private final JButton enterButton = new JButton("Calculate!");

    private final JTextField firstNameText = new JTextField();
    private final JTextField lastNameText = new JTextField();
    private final JTextField actualWeightText = new JTextField();
    private final JTextField ageText = new JTextField();

    private final JRadioButton male = new JRadioButton("male");
    private final JRadioButton female = new JRadioButton("female");

    private final JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 150, 190, 150);

    private final String[] bodyTypes = {"small", "medium", "large"};

    private final JComboBox<String> bodyFrame = new JComboBox<>(bodyTypes);

    // Create Labels for BMI and statusLabel
    private final JLabel title = new JLabel("BMI Calculator");
    private final JLabel firstName = new JLabel("First Name:");
    private final JLabel lastName = new JLabel("Last Name:");
    private final JLabel age = new JLabel("*Age:");
    private final JLabel gender = new JLabel("Gender:");
    private final JLabel jlHeight = new JLabel("*Height:");
    private final JLabel jlActualWeight = new JLabel("*Actual Weight (in kg):");
    private final JLabel jlBodyFrame = new JLabel("*Body Frame:");
    private final JLabel results = new JLabel("Results:");
    private final JLabel BMIResult = new JLabel("BMI:");
    private final JLabel statusResult = new JLabel("Status:");
    private final JLabel actualWeightResult = new JLabel("Actual Weight:");
    private final JLabel idealWeightResult = new JLabel("Ideal Weight:");
    private final JLabel BMILabel = new JLabel("(BMI)");
    private final JLabel statusLabel = new JLabel("(status)");
    private final JLabel actualWeightLabel = new JLabel("(Actual Weight)");
    private final JLabel idealWeightLabel = new JLabel("(Ideal Weight)");

    public BMIView() {
        this.setBounds(0, 0, 550, 500);

        MainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(MainPanel);

        North.setBackground(new Color(255, 204, 102));
        North.setBounds(0, 0, 500, 50);
        MainPanel.add(North);

        West.setBackground(new Color(255, 204, 102));
        West.setBounds(5, 50, 150, 300);
        West.setLayout(new GridLayout(9, 1));
        MainPanel.add(West);

        Center.setBackground(new Color(255, 204, 102));
        Center.setBounds(165, 50, 150, 310);
        Center.setLayout(new GridLayout(6, 1));
        Center.setBorder(new TitledBorder("*Required field"));
        MainPanel.add(Center);

        EastPanel1.setBackground(new Color(255, 204, 102));
        EastPanel2.setBackground(new Color(255, 204, 102));
        EastPanel2.setLayout(new GridLayout(6, 2));
        East.setLayout(new GridLayout(2, 1));
        East.setBounds(325, 50, 200, 360);
        East.add(EastPanel1);
        East.add(EastPanel2);
        MainPanel.add(East);

        South.setBackground(new Color(255, 204, 102));
        South.setBounds(60, 370, 350, 50);
        MainPanel.add(South);

        Panel.setBackground(new Color(255, 204, 102));
        MainPanel.add(Panel);

        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        North.add(title);

        West.add(firstName);
        West.add(firstNameText);

        West.add(lastName);
        West.add(lastNameText);

        West.add(age);
        West.add(ageText);

        group.add(male);
        group.add(female);
        West.add(gender);
        West.add(male);
        West.add(female);

        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(5);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        Center.add(jlHeight);
        Center.add(heightSlider);

        Center.add(jlActualWeight);
        Center.add(actualWeightText);

        Center.add(jlBodyFrame);
        Center.add(bodyFrame);

        EastPanel1.add(results);

        EastPanel2.add(BMIResult);
        EastPanel2.add(BMILabel);

        EastPanel2.add(statusResult);
        EastPanel2.add(statusLabel);

        EastPanel2.add(actualWeightResult);
        EastPanel2.add(actualWeightLabel);

        EastPanel2.add(idealWeightResult);
        EastPanel2.add(idealWeightLabel);

        South.add(enterButton);
    }

    public double getUserAge() {
        return Double.parseDouble(ageText.getText());
    }

    public double getUserWeight() {
        return Double.parseDouble(actualWeightText.getText());
    }

    public double getUserHeight() {
        return Double.parseDouble(String.valueOf(heightSlider.getValue()));
    }

    public double getUserBodyFrame() {
        return Double.parseDouble(String.valueOf(bodyFrame.getSelectedIndex()));
    }

    public void setActualWeight(double actualWeight) {
        actualWeightLabel.setText(String.format("%.2f", actualWeight));
    }

    public void setIdealWeight(double idealWeight) {
        idealWeightLabel.setText(String.format("%.2f", idealWeight));
    }

    public void setBMI(double BMI) {
        BMILabel.setText(String.format("%.2f", BMI));
    }

    public void setStatus(String status) {
        statusLabel.setText(String.format("%s", status));
    }

    void addEnterListener(ActionListener listenForEnterButton) {
        enterButton.addActionListener(listenForEnterButton);
    }

    void displayErrorMessage() {
        if (actualWeightText.getText().equals("") || ageText.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Some required fields are not filled.");
    }
}
