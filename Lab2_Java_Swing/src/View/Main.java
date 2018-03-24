package View;
import Model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    private static Factory factory = new Factory(ProductType.VEHICLE);

    /**
     * <h1>Adds components to Grid</h1>
     *
     * @param pane
     *          window object container
     */
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.CENTER;
        JLabel lblFactory = new JLabel("Factory");
        lblFactory.setFont(new Font("Arial", Font.PLAIN, 18));
        pane.add(lblFactory, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblProducts = new JLabel("Products: ");
        pane.add(lblProducts, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JLabel lblProductsCount = new JLabel("0");
        pane.add(lblProductsCount, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        JButton btnEmploy = new JButton("Employ");
        pane.add(btnEmploy, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        JButton btnRelease = new JButton("Release");
        pane.add(btnRelease, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.CENTER;
        JLabel lblWorkers = new JLabel("Workers");
        lblWorkers.setFont(new Font("Arial", Font.PLAIN, 18));
        pane.add(lblWorkers, constraints);


        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 2;
        constraints.gridy = 1;

        constraints.gridwidth = 1;
        pane.add(new JLabel("Count: "), constraints);


        constraints.gridx = 3;
        constraints.gridy = 1;
        JLabel lblWorkersCount = new JLabel("0");
        pane.add(lblWorkersCount, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.EAST;
        JButton btnSmoke = new JButton("Smoke");
        btnSmoke.setVisible(false);
        pane.add(btnSmoke, constraints);

        btnEmploy.addActionListener(e -> {
            factory.employ();
            lblWorkersCount.setText(Integer.toString(factory.getWorkersCount()));
        });

        btnRelease.addActionListener(e -> {
            Vehicle vehicle;
            try{
                vehicle = (Vehicle) factory.release();
                JOptionPane.showMessageDialog(pane, vehicle.getName() + " created");
                btnSmoke.setVisible(true);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(pane, ex.getMessage());
            }

            lblProductsCount.setText(Integer.toString(factory.getProductsCount()));
        });

        btnSmoke.addActionListener(e -> {
            for(Worker w: factory.getWorkers()){
                w.smoke();
            }
            JOptionPane.showMessageDialog(pane, "ENJOOOOOOY");
            btnSmoke.setVisible(false);
        });

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Find out remainder and quotient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setResizable(false);

        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
