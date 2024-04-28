package FoodThermalConductivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

public class SpecificHeat {
    private static JFrame frame, resultFrame;
    private static JPanel panel, resultPanel;
    private static JLabel CHOLabel, ProteinLabel, FatLabel, WaterLabel, AshLabel, SpecificHeat;
    private static JTextField CHO_field, Protein_field, Fat_field, Water_field, Ash_field;
    private static JButton submitButton;
    //private static String errorSum, fitSum;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowGUI();
            }
        });
    }

    public static void CreateAndShowGUI() {

        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Specific Heat");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel text = new JLabel("โปรแกรมคำนวณค่าความร้อนจำเพาะของผลิตภัณฑ์อาหาร (Heldmann and Singh, 1981)");
        text.setFont(new Font("Kanit", Font.BOLD, 16));
        text.setBounds(30, 30, 600, 40);
        panel.add(text);

        //CHO ---
        CHOLabel = new JLabel("% Carbohydrate : ");
        CHOLabel.setFont(new Font("Kanit", Font.PLAIN, 13));
        CHOLabel.setForeground(Color.BLACK);
        CHOLabel.setBounds(30, 70, 200, 30);
        panel.add(CHOLabel);

        CHO_field = new JTextField();
        CHO_field.setFont(new Font("Kanit", Font.PLAIN, 13));
        CHO_field.setForeground(Color.BLACK);
        CHO_field.setBounds(270, 70, 50, 30);
        panel.add(CHO_field);


        //Protein ---
        ProteinLabel = new JLabel("% Protein : ");
        ProteinLabel.setFont(new Font("Kanit", Font.PLAIN, 13));
        ProteinLabel.setForeground(Color.BLACK);
        ProteinLabel.setBounds(30, 110, 200, 30);
        panel.add(ProteinLabel);

        Protein_field = new JTextField();
        Protein_field.setFont(new Font("Kanit", Font.PLAIN, 13));
        Protein_field.setForeground(Color.BLACK);
        Protein_field.setBounds(270, 110, 50, 30);
        panel.add(Protein_field);


        //Fat ---
        FatLabel = new JLabel("% Fat : ");
        FatLabel.setFont(new Font("Kanit", Font.PLAIN, 13));
        FatLabel.setForeground(Color.BLACK);
        FatLabel.setBounds(30, 150, 200, 30);
        panel.add(FatLabel);

        Fat_field = new JTextField();
        Fat_field.setFont(new Font("Kanit", Font.PLAIN, 13));
        Fat_field.setForeground(Color.BLACK);
        Fat_field.setBounds(270, 150, 50, 30);
        panel.add(Fat_field);

        //Water ---
        WaterLabel = new JLabel("% Water : ");
        WaterLabel.setFont(new Font("Kanit", Font.PLAIN, 13));
        WaterLabel.setForeground(Color.BLACK);
        WaterLabel.setBounds(30, 190, 200, 30);
        panel.add(WaterLabel);

        Water_field = new JTextField();
        Water_field.setFont(new Font("Kanit", Font.PLAIN, 13));
        Water_field.setForeground(Color.BLACK);
        Water_field.setBounds(270, 190, 50, 30);
        panel.add(Water_field);

        //Ash ---
        AshLabel = new JLabel("% Ash : ");
        AshLabel.setFont(new Font("Kanit", Font.PLAIN, 13));
        AshLabel.setForeground(Color.BLACK);
        AshLabel.setBounds(30, 230, 200, 30);
        panel.add(AshLabel);

        Ash_field = new JTextField();
        Ash_field.setFont(new Font("Kanit", Font.PLAIN, 13));
        Ash_field.setForeground(Color.BLACK);
        Ash_field.setBounds(270, 230, 50, 30);
        panel.add(Ash_field);

        //Button

        submitButton = new JButton("Calculate !");
        submitButton.setFont(new Font("Kanit", Font.PLAIN, 13));
        submitButton.setForeground(Color.BLACK);
        submitButton.setBounds(270, 270, 200, 30);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String CHOStr = CHO_field.getText();
                double CHO = Double.parseDouble(CHOStr);

                String ProteinStr = Protein_field.getText();
                double Protein = Double.parseDouble(ProteinStr);

                String FatStr = Fat_field.getText();
                double Fat = Double.parseDouble(FatStr);

                String WaterStr = Water_field.getText();
                double Water = Double.parseDouble(WaterStr);

                String AshStr = Ash_field.getText();
                double Ash = Double.parseDouble(AshStr);

                double totalNutriDB = CHO + Protein + Fat + Water + Ash;
                /*if (totalNutriDB > 100) {
                    errorSum = "ผลรวมของปริมาณสารอาหารต้องไม่เกิน 100%";
                    System.out.println(errorSum);
                } else */
                double CHOCp = 1.424 * CHO / 100;
                double ProteinCp = 1.549 * Protein / 100;
                double FatCp = 1.675 * Fat / 100;
                double WaterCp = 4.187 * Water / 100;
                double AshCp = 0.837 * Ash / 100;
                double OverallCp = CHOCp + ProteinCp + FatCp + WaterCp + AshCp;

                resultFrame = new JFrame();
                resultFrame.setSize(500, 500);
                resultFrame.setTitle("ผลการคำนวณค่าความร้อนจำเพาะ");
                resultFrame.setLayout(null);
                resultFrame.setVisible(true);
                resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                resultPanel = new JPanel();
                resultPanel.setLayout(null);
                resultFrame.add(resultPanel);

                SpecificHeat = new JLabel("ค่าความร้อนจำเพาะของผลิตภัณฑ์อาหารชนิดนี้ เท่ากับ " + String.format("%4f", OverallCp));
                SpecificHeat.setBounds(30, 30, 500, 30);
                SpecificHeat.setFont(new Font("Kanit", Font.PLAIN, 16));
                SpecificHeat.setVisible(true);
                resultFrame.add(SpecificHeat);
            }

        });
        frame.pack();

    }
}

