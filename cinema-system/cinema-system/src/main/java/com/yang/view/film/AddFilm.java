package com.yang.view.film;

import javax.swing.*;
import java.awt.*;

public class AddFilm extends JPanel {
    public AddFilm() {
        this.setSize(600,500);
        this.setLayout(null);
        Font font = new Font("宋体",Font.PLAIN,18);


        JLabel jLabel1 = new JLabel("电影名称:");
        JLabel jLabel2 = new JLabel("电影类型:");
        JLabel jLabel3 = new JLabel("电影价格:");
        JLabel jLabel4 = new JLabel("上映时间:");
        JLabel jLabel5 = new JLabel("放映时间:");
        JLabel jLabel6 = new JLabel("上映地区:");
        JButton button1 = new JButton("add");
        JButton button2 = new JButton("clear");

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JTextField field6 = new JTextField();


        jLabel1.setBounds(0,50,100,30);
        jLabel4.setBounds(0,150,100,30);
        jLabel6.setBounds(0,250,100,30);
        jLabel2.setBounds(300,50,100,30);
        jLabel5.setBounds(300,150,100,30);
        jLabel3.setBounds(300,250,100,30);
        button1.setBounds(380,380,100,30);
        button2.setBounds(500,380,100,30);
        field1.setBounds(85,50,200,30);
        field2.setBounds(385,50,200,30);
        field3.setBounds(385,250,200,30);
        field4.setBounds(85,150,200,30);
        field5.setBounds(385,150,200,30);
        field6.setBounds(85,250,200,30);

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        field1.setFont(font);
        field2.setFont(font);
        field3.setFont(font);
        field4.setFont(font);
        field5.setFont(font);
        field6.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);
        this.add(jLabel6);
        this.add(button1);
        this.add(button2);

        this.add(field1);
        this.add(field2);
        this.add(field3);
        this.add(field4);
        this.add(field5);
        this.add(field6);



    }
}
