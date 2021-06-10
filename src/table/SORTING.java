package table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SORTING {
    private JPanel rootPanel;
    private JTextField textInputAngka2;
    private JButton buttonCek;
    private JTable tableHasil;
    private JTextField textInputAngka1;
    private DefaultTableModel tableModel;
    private boolean added = false;


    public SORTING() {
        this.initComponent();

        buttonCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) tableHasil.getModel();

                String input = textInputAngka2.getText();
                int jumlah = Integer.parseInt(textInputAngka1.getText());
                String[] agn = input.split(",");

                if (textInputAngka1.getText().length()>3){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Data Terlalu Banyak \n Maksimal Input : 999",
                            "PERHATIAN!!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (agn.length > jumlah || agn.length < jumlah){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Jumlah Angka Tidak Sesuai Limit yang DiInput",
                            "PERHATIAN!!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    tableModel.addRow(new Object[] { input, jumlah});
                    textInputAngka1.setText(" ");
                    textInputAngka2.setText(" ");
                }

                    if (!added) {
                    for (int i = 0; i < jumlah; i++) {
                        model.addRow(new Object[]{});
                    }
                    added = true;
                }
                int a = 0;
                for (int i : BubbleSort.getas(input, jumlah)){
                    model.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : BubbleSort.getdes(input, jumlah)){
                    model.setValueAt(i, b, 1);
                    b++;
                }
            }
        });

    }

    private void initComponent() {
        Object[] tableColumn = {
                "Ascending",
                "Descending"
        };
        Object[][] initData = new Object[][]{

        };
        tableModel = new DefaultTableModel(initData, tableColumn);
                // set model table
        tableHasil.setModel(tableModel);
                // menampilkan sorting disetiap kolom
        tableHasil.setAutoCreateRowSorter(true);
                // menghidupkan single selectiion
        tableHasil.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    public JPanel getRootPanel() {
        return rootPanel;
    }

}

