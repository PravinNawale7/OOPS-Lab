/* Practical 12
Create a Restaurant Management System in Java
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class c extends Frame implements ActionListener {
    Label name, mobile, itemName, itemPrice, quantity;
    TextField nameField, mobileField, itemNameField, itemPriceField, quantityField;
    Button add, place;
    TextArea billArea;
    double totalBill;

    public RestaurantManagementSystem() {
        setTitle("Restaurant Management System");
        setSize(600, 400);
        setLayout(new BorderLayout());

        Panel p = new Panel(new GridLayout(2, 2, 10, 5));
        name = new Label("Name:");
        p.add(name);
        nameField = new TextField(20);
        p.add(nameField);
        mobile = new Label("Mobile No:");
        p.add(mobile);
        mobileField = new TextField(20);
        p.add(mobileField);
        add(p, BorderLayout.NORTH);

        Panel centerPanel = new Panel(new GridLayout(4, 2, 10, 5));
        itemName = new Label("Item Name:");
        centerPanel.add(itemName);
        itemNameField = new TextField(20);
        centerPanel.add(itemNameField);
        itemPrice = new Label("Item Price:");
        centerPanel.add(itemPrice);
        itemPriceField = new TextField(20);
        centerPanel.add(itemPriceField);
        quantity = new Label("Quantity:");
        centerPanel.add(quantity);
        quantityField = new TextField(20);
        centerPanel.add(quantityField);
        add = new Button("Add Item");
        centerPanel.add(new Label(""));
        centerPanel.add(add);
        add.addActionListener(this);
        add(centerPanel, BorderLayout.CENTER);

        billArea = new TextArea(10, 30);
        add(billArea, BorderLayout.EAST);

        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        place = new Button("Place Order");
        place.addActionListener(this);
        bottomPanel.add(place);
        add(bottomPanel, BorderLayout.SOUTH);

        totalBill = 0.0;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String itemName = itemNameField.getText();
            double itemPrice;
            int quantity;
            try {
                itemPrice = Double.parseDouble(itemPriceField.getText());
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                // If the input is not a valid number, display an error message
                JOptionPane.showMessageDialog(this, "Please enter valid item price and quantity.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            double subtotal = itemPrice * quantity;
            totalBill += subtotal;
            billArea.append(itemName + " - Rs" + itemPrice + " x " + quantity + " = Rs" + subtotal + "\n");
            itemNameField.setText("");
            itemPriceField.setText("");
            quantityField.setText("");
        } else if (e.getSource() == place) {
            String name = nameField.getText();
            String mobile = mobileField.getText();
            billArea.append("\nCustomer Name: " + name + "\nMobile No: " + mobile + "\nTotal Bill: Rs" + totalBill
                    + "\nThank you for your order!");
        }
    }

    public static void main(String[] args) {
        new RestaurantManagementSystem();
    }
}
