package com.yang.view.retrun;

import com.yang.services.OrderInforService;
import com.yang.services.ReturnInforService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;

public class ReturnInfor extends JPanel {
    public ReturnInfor() {
        init();
        /*this.setBounds(220,90,600,500);*/
        this.setSize(600,450);
    }
    private void init(){
        // 表头（列名）
        Object[] columnNames = {"订单号", "用户姓名", "电影名", "放映厅", "放映时间","退款时间"};

        // 表格所有行数据
        Object[][] rowData = ReturnInforService.showReturnInfor();

        // 创建 表格模型，指定 所有行数据 和 表头
        TableModel tableModel = new DefaultTableModel(rowData, columnNames);

        // 使用 表格模型 创建 表格

        JTable table = new JTable(tableModel){
            //禁止单元格编辑
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //设置滚动面板
        table.setPreferredScrollableViewportSize(new Dimension(590, 440));
        JScrollPane scrollPane = new JScrollPane(table);

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
    }


}
