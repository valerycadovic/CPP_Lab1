package View;

import Model.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    private static Factory factory = new Factory(ProductType.VEHICLE);
    private static Shop shop = new Shop();
    private static Director director = new Director(factory);

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

        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        JLabel lblAdministration = new JLabel("Administration");
        lblAdministration.setFont(new Font("Arial", Font.PLAIN, 18));
        pane.add(lblAdministration, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        JLabel lblShop = new JLabel("Shop");
        lblShop.setFont(new Font("Arial", Font.PLAIN, 18));
        pane.add(lblShop, constraints);

        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.CENTER;
        JList<ProductType> listTypes = new JList<>(ProductType.values());
        pane.add(listTypes, constraints);

        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        pane.add(new JLabel("Types:"), constraints);

        constraints.gridx = 5;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        JButton btnChange = new JButton("Change Type");
        pane.add(btnChange, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        JButton btnSend = new JButton("Send Products To Shop");
        pane.add(btnSend, constraints);

        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        pane.add(new JLabel("Products:"), constraints);

        /*
        ArrayList<String> al = new ArrayList<>();
        for(IProduct p : shop.getProducts()){
            al.add(p.getName());
        }
        */

        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 4;
        constraints.ipady = 50;
        constraints.fill = GridBagConstraints.HORIZONTAL;


        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listProducts = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listProducts);
        pane.add(scroll, constraints);

        btnSend.addActionListener(e -> {
            factory.sendProductsToShop(shop);
            listModel.clear();
            for(IProduct p : shop.getProducts()){
                listModel.addElement(p.getName());
            }
        });

        btnChange.addActionListener(e -> {
            if(listTypes.getSelectedValue() == null)
                JOptionPane.showMessageDialog(pane, "Select any type!!");
            else {
                director.changeType(listTypes.getSelectedValue());
                JOptionPane.showMessageDialog(pane, "Product type was changed to " + listTypes.getSelectedValue());
            }
        });

        btnEmploy.addActionListener(e -> {
            factory.employ();
            lblWorkersCount.setText(Integer.toString(factory.getWorkersCount()));
        });

        btnRelease.addActionListener(e -> {
            IProduct product;
            try{
                product = factory.release();
                JOptionPane.showMessageDialog(pane, product.getName() + " created");
                btnSmoke.setVisible(true);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(pane, ex.getMessage());
            }

            lblProductsCount.setText(Integer.toString(factory.getProductsCount()));
        });

        btnSmoke.addActionListener(e -> {
            for(Employee w: factory.getEmployees()){
                if (w instanceof Worker)
                    ((Worker) w).smoke();
            }
            JOptionPane.showMessageDialog(pane, "ENJOOOOOOY");
            btnSmoke.setVisible(false);
        });

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Factory simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
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
