package com.getjavajob.training.algo08.nemchinovr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        Main bp = new Main();
        bp.makeGui();
    }

    public void makeGui() {
        JFrame frame = new JFrame(" Конвертор Пирсона ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Панель", new FirstPanel());
        frame.getContentPane().add(jtp);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    class FirstPanel extends JPanel implements ActionListener {
        NumberFormat nf;
        JTextField amountText, paymentText, periodText, rateText, areaText;
        JButton dolt;

        public FirstPanel() {
            GridBagLayout gbag = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();
            setLayout(gbag);
            JLabel heading = new JLabel("Концентрация веществ");
            JLabel amountLab = new JLabel("Концентрация исходная 1: ");
            JLabel periodLab = new JLabel("Концентрация исходная 2: ");
            JLabel areaLabel = new JLabel("Концентрация получаемой смеси: ");
            JLabel rateLab = new JLabel("Отношение 1:");
            JLabel paymentLab = new JLabel("Отношение 2: ");
            amountText = new JTextField(10);
            periodText = new JTextField(10);
            areaText = new JTextField(10);
            paymentText = new JTextField(10);
            rateText = new JTextField(10);
            paymentText.setEditable(false);
            rateText.setEditable(false);
            dolt = new JButton("Вычислить");
            gbc.weighty = 1.0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbag.setConstraints(heading, gbc);
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(amountLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(amountText, gbc);
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(periodLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(periodText, gbc);
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(rateLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(rateText, gbc);
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(paymentLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(paymentText, gbc);
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(areaLabel, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(areaText, gbc);
            gbc.anchor = GridBagConstraints.CENTER;
            gbag.setConstraints(dolt, gbc);
            add(heading);
            add(amountLab);
            add(amountText);
            add(periodLab);
            add(periodText);
            add(areaLabel);
            add(areaText);
            add(dolt);
            add(rateLab);
            add(rateText);
            add(paymentLab);
            add(paymentText);
            amountText.addActionListener(this);
            dolt.addActionListener(this);
            periodText.addActionListener(this);
            rateText.addActionListener(this);
            nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
        }

        public void actionPerformed(ActionEvent e) {
            double resultWidth;
            double resultHeight;
            String xString = amountText.getText();
            String yString = periodText.getText();
            String zString = areaText.getText();
            try {
                if (xString.length() != 0 && yString.length() != 0 && zString.length() != 0) {
                    double xSource = Double.parseDouble(xString);
                    double ySource = Double.parseDouble(yString);
                    double zDouble = Double.parseDouble(zString);
                    double k1, k2;
                    k1 = Math.abs(xSource-zDouble);
                    k2 = Math.abs(ySource-zDouble);
                    double min = Math.min(k1, k2);
                    resultWidth = Math.abs(xSource-zDouble)/min;
                    resultHeight = Math.abs(ySource-zDouble)/min;
                    paymentText.setText(nf.format(resultHeight));
                    rateText.setText(nf.format(resultWidth));
                }
            } catch (Exception e1) {
                System.out.println("Exception!!!");
            }
        }
    }
}
