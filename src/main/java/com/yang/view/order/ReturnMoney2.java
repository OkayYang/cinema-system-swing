package com.yang.view.order;

import com.yang.service.Impl.OrderInforServiceImpl;
import com.yang.service.OrderInforService;
import com.yang.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReturnMoney2 extends Panel {

    private OrderInforService orderInforService= (OrderInforService) SpringUtil.getApplicationContext().getBean("orderInforService");
    public ReturnMoney2() {
        init();
        /*this.setBounds(0,100,600,450);*/
        this.setSize(600,450);
    }
    private void init(){
        JLabel label = new JLabel("提示:   双击订单进行退款!");
        label.setFont(new Font("宋体", Font.BOLD, 20));
        label.setForeground(Color.red);

        label.setBounds(220,20,200,100);
        this.add(label);
        // 表头（列名）
        Object[] columnNames = {"订单号", "用户姓名", "电影名", "放映厅", "放映时间","购买时间"};

        // 表格所有行数据
        final Object[][] rowData = orderInforService.showOrderInfor();

        // 创建 表格模型，指定 所有行数据 和 表头
        TableModel tableModel = new DefaultTableModel(rowData, columnNames);

        // 使用 表格模型 创建 表格

        final JTable table = new JTable(tableModel){
            //禁止单元格编辑
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //设置滚动面板
        table.setPreferredScrollableViewportSize(new Dimension(590, 300));
        JScrollPane scrollPane = new JScrollPane(table);
        //设置单一选中
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setShowGrid(true);
        JTableHeader jTableHeader = table.getTableHeader();
        //设置表头是否可移动
        jTableHeader.setReorderingAllowed(true);

        table.setSelectionBackground(Color.red);
        //设置指定列的宽度
        table.getColumnModel().getColumn(3).setPreferredWidth(110);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        this.add(scrollPane);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>=2){
                    int oid =(int) rowData[table.getSelectedRow()][0];

                    int opt = JOptionPane.showConfirmDialog(ReturnMoney2.this,
                            "是否确认退款该订单:"+oid+"?", "确认信息",
                            JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        if (orderInforService.returnMoney(oid)){
                            JOptionPane.showMessageDialog(ReturnMoney2.this,"退款成功，请刷新！","提示",JOptionPane.PLAIN_MESSAGE);
                        }else                             JOptionPane.showMessageDialog(ReturnMoney2.this,"退款失败！","提示",JOptionPane.PLAIN_MESSAGE);

                    }
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
    }
}

