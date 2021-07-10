package com.yang.view.order;

import javax.swing.*;
import java.awt.*;

public class ReturnOrder extends JPanel {
    private static JLabel jLabelId = new JLabel("请输入订单号:");
    private static JTextField jTextField = new JTextField(10);
    public ReturnOrder() {
        init();
        this.setSize(600,450);
    }
    public void init(){
        this.setLayout(null);
        JPanel jPanel = new JPanel();
        jPanel.setBounds(0,0,600,50);
        jLabelId.setBounds(50,50,50,20);
        jLabelId.setFont(new Font("宋体", Font.PLAIN, 20));

        jTextField.setBounds(120,50,150,20);
        jTextField.setFont(new Font("宋体", Font.PLAIN, 20));

        jPanel.add(jLabelId);
        jPanel.add(jTextField);
        this.add(jPanel);
        JPanel jPanel1 = new JPanel();
        jPanel1.setBounds(0,50,600,400);
        jPanel1.add(new RetrunPrice());
        this.add(jPanel1);


    }
}
