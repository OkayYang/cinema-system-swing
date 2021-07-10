package com.yang.view.home;



import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LeftPanel extends JPanel {
    static JLabel label1 = new JLabel("logo");
    static JButton btn1 = new JButton("用户订单管理");
    static JButton btn2 = new JButton("电影上映管理");
    static JButton btn3 = new JButton("电影售票中心");
    static JButton btn4 = new JButton("退款订单中心");

    public LeftPanel() {
        init();
    }
    private void init(){
        this.setLayout(null);
        this.setBounds(0,0,200,600);
        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/logo1.png")).getFile()));
        label1.setBounds(0,10,200,100);
        btn1.setBounds(50,150,100,50);
        btn2.setBounds(50,250,100,50);
        btn3.setBounds(50,350,100,50);
        btn4.setBounds(50,450,100,50);
        this.add(label1);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);


    }
}
