package storemanagerguiview;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usern
 */
public class AddNewCustomerForm extends JFrame{
    
private JButton jButtonOK; 
private JLabel  jLabelID; 
private JLabel  jLabelName; 
private JLabel  jLabelAddress; 
private JTextField    jTextFieldID; 
private JTextField   jTextFieldName; 
private JTextField   jTextFieldAddress;

public AddNewCustomerForm() {
    
    jButtonOK = new JButton("OK"); 
    jLabelID = new JLabel("ID:"); 
    jLabelName = new JLabel("Name:"); 
    jLabelAddress = new JLabel("Address:"); 
    jTextFieldID = new JTextField(); 
    jTextFieldName = new JTextField(); 
    jTextFieldAddress = new JTextField();
      this.setPreferredSize(new Dimension(400, 200)); 
      this.add(jLabelID);
      this.add(jButtonOK);
      this.add(jLabelName);
      this.add(jLabelAddress);
      this.add(jTextFieldID);
      this.add(jTextFieldName);
      this.add(jTextFieldAddress);
      getContentPane().setLayout(new GridLayout(0,2,10,10)); 
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
    this.pack();  

}
  
    
 



}
