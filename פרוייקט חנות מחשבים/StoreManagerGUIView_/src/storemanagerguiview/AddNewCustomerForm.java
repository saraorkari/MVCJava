package storemanagerguiview;

import controller.Backend_DAO_List;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Customizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usern
 */
public class AddNewCustomerForm extends JFrame {

    private JButton jButtonOK;
    private JLabel jLabelID;
    private JLabel jLabelName;
    private JLabel jLabelAddress;
    private JTextField jTextFieldID;
    private JTextField jTextFieldName;
    private JTextField jTextFieldAddress;

    public AddNewCustomerForm() {

        jButtonOK = new JButton("OK");
        jLabelID = new JLabel("ID:");
        jLabelName = new JLabel("Name:");
        jLabelAddress = new JLabel("Address:");
        jTextFieldID = new JTextField();
        jTextFieldName = new JTextField();
        jTextFieldAddress = new JTextField();
        this.add(jLabelID);
        this.add(jTextFieldID);
        this.add(jLabelName);
        this.add(jTextFieldName);
        this.add(jLabelAddress);
        this.add(jTextFieldAddress);
        this.add(jButtonOK);
        getContentPane().setPreferredSize(new Dimension(400, 200));
        getContentPane().setLayout(new GridLayout(0, 2, 10, 10));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();

        jButtonOK.addActionListener((e) -> {

            try {
                if (jTextFieldID.getText().length() != 9) {
                    JOptionPane.showMessageDialog(AddNewCustomerForm.this, "id has to have 9 digits");
                    throw new Exception("id has to have 9 digits ");
                }

                if (jTextFieldName.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(AddNewCustomerForm.this, "Please enter your name");
                       throw new Exception("Please enter your name");
                }
                Customer c = new Customer(
                        Long.parseLong(jTextFieldID.getText()), jTextFieldName.getText(), jTextFieldAddress.getText());
                Backend_DAO_List.get_bdl_singleton().AddCustomer(c);
                JOptionPane.showMessageDialog(AddNewCustomerForm.this, "The customer is added succefully!");
            } 
            catch (Exception ex) {
                Logger.getLogger(AddNewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
