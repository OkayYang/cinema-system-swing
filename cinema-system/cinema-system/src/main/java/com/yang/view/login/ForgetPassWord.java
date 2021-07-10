package com.yang.view.login;

import com.yang.services.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class  ForgetPassWord extends Dialog {


    JLabel  lName,  lPasswd, lConPasswd;
    JTextField txtName;
    JButton btnSubmit, btnClear;
    JPasswordField pfPasswd, pfConPasswd;
    Font defFont = new Font("宋体", Font.PLAIN, 20);

    public ForgetPassWord(Frame owner) {
        super(owner);
        init();
        this.setTitle("修改密码");
        this.setSize(500, 400);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void init() {


        lName = new JLabel("用户名 :");
        lName.setBounds(60, 70, 200, 30);
        lName.setFont(defFont);
        add(lName);
        txtName = new JTextField();
        txtName.setFont(defFont);
        txtName.setBounds(250, 70, 200, 30);
        add(txtName);




        lPasswd = new JLabel("新密码 :");
        lPasswd.setBounds(60, 150, 200, 30);
        lPasswd.setFont(defFont);
        add(lPasswd);
        pfPasswd = new JPasswordField();
        pfPasswd.setFont(defFont);
        pfPasswd.setBounds(250, 150, 200, 30);
        add(pfPasswd);

        lConPasswd = new JLabel("确认密码 :");
        lConPasswd.setBounds(60, 190, 200, 30);
        lConPasswd.setFont(defFont);
        add(lConPasswd);
        pfConPasswd = new JPasswordField();
        pfConPasswd.setFont(defFont);
        pfConPasswd.setBounds(250, 190, 200, 30);
        add(pfConPasswd);




        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(defFont);
        btnSubmit.setBackground(Color.green);

        btnSubmit.setBounds(80, 250, 100, 30);
        add(btnSubmit);
        btnSubmit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = ForgetPassWord.this.txtName.getText();
                String password = String.valueOf(ForgetPassWord.this.pfPasswd.getPassword());
                String repassword = String.valueOf(ForgetPassWord.this.pfConPasswd.getPassword());
                System.out.println(password);
                System.out.println(repassword);
                if ("".equals(name)||
                        "".equals(password)||
                        "".equals(repassword)){
                    JOptionPane.showMessageDialog(ForgetPassWord.this,"账号密码不能为空！","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else if (!password.equals(repassword)){
                    JOptionPane.showMessageDialog(ForgetPassWord.this,"两次输入密码不一致！","提示",JOptionPane.PLAIN_MESSAGE);
                }else {
                    if (LoginService.updateAdmin(name,password)){
                        JOptionPane.showMessageDialog(ForgetPassWord.this,"修改成功即将跳转！","提示",JOptionPane.PLAIN_MESSAGE);
                        ForgetPassWord.this.dispose();
                    }else JOptionPane.showMessageDialog(ForgetPassWord.this,"用户名不存在，请重试！","提示",JOptionPane.PLAIN_MESSAGE);
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

        btnClear = new JButton("Clear");
        btnClear.setFont(defFont);
        btnClear.setBounds(300, 250, 100, 30);
        add(btnClear);
        btnClear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ForgetPassWord.this.txtName.setText("");
                ForgetPassWord.this.pfConPasswd.setText("");
                ForgetPassWord.this.pfPasswd.setText("");
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
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ForgetPassWord.this.dispose();
            }});

    }






}