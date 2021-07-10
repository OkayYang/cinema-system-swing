package com.yang.view.order;

import javax.swing.*;
import java.awt.*;

public class RetrunPrice extends JPanel {

    public RetrunPrice() {
        this.setSize(new Dimension(600,400));
        JLabel lName = new JLabel("用户姓名:");
        JLabel lFame = new JLabel("电影名:");
        JLabel lSname = new JLabel("放映厅:");
        JLabel lBtime = new JLabel("购买时间:");
        JLabel lRprice = new JLabel("退款金额:");
        JTextField tName = new JTextField(6);
        JTextField tFame = new JTextField(6);
        JTextField tSname = new JTextField(6);
        JTextField tBame = new JTextField(6);
        JTextField tRprice = new JTextField(6);
        lName.setBounds(100,20,50,20);
        lFame.setBounds(100,50,50,20);
        lSname.setBounds(100,80,50,20);
        lBtime.setBounds(100,110,50,20);
        lRprice.setBounds(100,140,50,20);
        this.add(lName);
        this.add(lFame);
        this.add(lSname);
        this.add(lBtime);
        this.add(lRprice);
    }
}
