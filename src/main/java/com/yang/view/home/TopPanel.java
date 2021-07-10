package com.yang.view.home;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public TopPanel() throws HeadlessException {
        init();
        this.setSize(600,80);
        this.setLayout(null);
    }
    private void init(){
        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(100,20,300,30);
        jTextField.setFont(new Font(null, Font.PLAIN, 20));
        JButton jButton = new JButton("查询");
        jButton.setBounds(420,20,75,30);
        this.add(jTextField);
        this.add(jButton);
    }
}
