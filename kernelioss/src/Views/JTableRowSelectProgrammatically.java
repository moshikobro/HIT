package Views;
import javax.swing.undo.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Contollers.CoursesController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JTableRowSelectProgrammatically extends JPanel {
    public JTableRowSelectProgrammatically() {
        initializePanel();
    }

    private void initializePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(475, 250));

        CoursesController controller=new CoursesController();
        TableModel  tm=controller.GetData().getModel();
        final JTable table = new JTable(tm);

        table.setFillsViewportHeight(true);
        JScrollPane pane = new JScrollPane(table);

 
        JButton remove = new JButton("הסר");
        JButton clear = new JButton("נקה בחירה");
        JButton add = new JButton("הוסף");
        JButton save = new JButton("שמור שינויים");

        // Enables row selection mode and disable column selection
        // mode.
        
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        // Select rows based on the input.
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	if(table.getSelectedRow() != -1)
            	{
           	int result= JOptionPane.showConfirmDialog(null,"האם אתה בטוח שברצונך להסיר את הקורס?","הודעת מערכת", JOptionPane.YES_NO_CANCEL_OPTION);
           	 if(result == 0)//yes
             {
           		((DefaultTableModel) tm).removeRow(table.getSelectedRow());
             }
         else if(result == 1)//no
             {
        	 JOptionPane.getRootFrame().dispose();
             }
         else if (result == 2)//cancel
             {
        	 JOptionPane.getRootFrame().dispose();
             }
         else if (result == -1)//x
             {
        	 JOptionPane.getRootFrame().dispose();
             }
            	}
            	else
            	{
            		 JOptionPane.showMessageDialog(null,"אנא בחר שורה","הודעת מערכת",1);
            	}
            }
        });

        // Clears row selection
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.removeRowSelectionInterval(0, table.getRowCount() - 1);
               // field1.setText("");
                //field2.setText("");
            }
        });

        // Add one more row after the last selected row.
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
           

               
            }
        });

        JPanel command = new JPanel(new FlowLayout());
       // command.add(label1);
     //   command.add(field1);
     //   command.add(label2);
     //   command.add(field2);
        command.add(remove);
        command.add(clear);
        command.add(add);
        command.add(save);

        add(pane, BorderLayout.CENTER);
        add(command, BorderLayout.SOUTH);
    }
}
