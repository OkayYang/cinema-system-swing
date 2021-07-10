package com.yang.view.filmSale;

import com.yang.dao.OrderDao;
import com.yang.dao.SchedulDao;
import com.yang.dao.UserDao;
import com.yang.model.Order;
import com.yang.model.User;
import com.yang.services.SchedulService;
import com.yang.utils.MyBatisUtil;
import com.yang.view.login.LoginView;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class TicketCenter extends JPanel {
    public TicketCenter() {
        this.setSize(600,500);
        this.setLayout(null);
        Font font = new Font("宋体",Font.PLAIN,22);
        Font font1 = new Font("宋体",Font.PLAIN,15);

        final String[] s = SchedulService.showSid();
        final JComboBox jComboBox = new JComboBox(s);
        jComboBox.setBounds(130,230,100,30);
        jComboBox.setFont(font1);
        this.add(jComboBox);


        JLabel jLabel1 = new JLabel("用户姓名:");
        JLabel jLabel2 = new JLabel("手机号码:");
        JLabel jLabel3 = new JLabel("场次编号:");
        JButton button1 = new JButton("add");
        final JButton button2 = new JButton("clear");

        final JTextField field1 = new JTextField();
        final JTextField field2 = new JTextField();


        jLabel1.setBounds(5,50,130,30);
        jLabel2.setBounds(5,140,130,30);
        jLabel3.setBounds(5,230,130,30);

        button1.setBounds(380,380,100,30);
        button2.setBounds(500,380,100,30);
        field1.setBounds(150,50,260,30);
        field2.setBounds(150,140,260,30);

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        field1.setFont(font);
        field2.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(button1);
        this.add(button2);

        this.add(field1);
        this.add(field2);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String name = field1.getText();
                    String phone = field2.getText();
                    int fid =6001;
                    int id = jComboBox.getSelectedIndex();
                    if (s[id]!=null){
                        fid = Integer.parseInt(s[id]);
                    }

                    if ("".equals(name)||"".equals(phone)){
                        JOptionPane.showMessageDialog(TicketCenter.this,"信息不能为空！","提示",JOptionPane.PLAIN_MESSAGE);
                    }if (phone.length()<11||phone.length()>11){
                        JOptionPane.showMessageDialog(TicketCenter.this,"请输入长度为11位的手机号！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        SchedulService.buyTicket(name,phone,fid);
                        JOptionPane.showMessageDialog(TicketCenter.this,"添加成功！","提示",JOptionPane.PLAIN_MESSAGE);
                    }

                }catch (Exception e2){
                    JOptionPane.showMessageDialog(TicketCenter.this,"输入信息有误，请返回检查！","提示",JOptionPane.PLAIN_MESSAGE);

                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field1.setText("");
                field2.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }
}
