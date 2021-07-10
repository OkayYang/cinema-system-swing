package com.yang.view.order;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

class ReturnMoney extends JPanel {
    public ReturnMoney() {
        this.setSize(600,500);
        this.setLayout(null);
        //退票信息窗口设置
        JInternalFrame jip = new JInternalFrame("退票信息",false,false,false,false);
        jip.setBounds(2,2,670,440);
        jip.setLayout(null);
        jip.setVisible(true);
        this.add(jip, BorderLayout.CENTER);
        //信息显示窗口
        JTextField jtf = new JTextField("小王",30);
        jtf.setBounds(190,100,330,30);
        jip.add(jtf);
        JLabel lb = new JLabel("姓名：");
        lb.setBounds(120,100,70,30);
        jip.add(lb);

        JTextField jtf1 = new JTextField("小王",30);
        jtf1.setBounds(190,150,330,30);
        jip.add(jtf1);
        JLabel lb1 = new JLabel("手机号：");
        lb1.setBounds(120,150,70,30);
        jip.add(lb1);

        JTextField jtf2 = new JTextField("小王",30);
        jtf2.setBounds(190,200,330,30);
        jip.add(jtf2);
        JLabel lb2 = new JLabel("退款金额：");
        lb2.setBounds(120,200,70,30);
        jip.add(lb2);

        String s[] = {"6001","6002","6003","6004","6005","6006"};
        JComboBox jc = new JComboBox(s);
        jc.setBounds(190,50,330,30);
        jip.add(jc);
        JLabel lb3 = new JLabel("订单号：");
        lb3.setBounds(120,50,70,30);
        jip.add(lb3);

        JButton jb= new JButton("确认退款");
        jb.setBounds(120,300,400,40);
        jip.add(jb);


    }


}
