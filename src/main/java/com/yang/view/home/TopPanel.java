package com.yang.view.home;

import com.yang.view.film.AddFilm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(TopPanel.this,"小二正在快马加鞭完善中....！","提示",JOptionPane.PLAIN_MESSAGE);

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
