package untar.java.tugas1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class InventoryApp extends JFrame {
    private ArrayList<ProductModel> products;
    private ProductTableModel tableModel;

    public InventoryApp(){
        products = new ArrayList<>();
        tableModel = new ProductTableModel(products);

        setTitle("Inventory App (Memory Only)");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4,2));
        JTextField codeField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField priceField = new JTextField();

        inputPanel.add(new JLabel ("Kode:"));
        inputPanel.add(codeField);
        inputPanel.add(new JLabel ("Nama:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel ("Qty:"));
        inputPanel.add(qtyField);
        inputPanel.add(new JLabel ("Harga:"));
        inputPanel.add(priceField);

        JButton addButton = new JButton ("Tambah");
        addButton.setPreferredSize(new Dimension(225, 20));
        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        addPanel.add(addButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(addPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);


        JTable table = new JTable(tableModel);
        JScrollPane scrollpane = new JScrollPane(table);
        add(scrollpane, BorderLayout.CENTER);

        JButton deleteButton = new JButton("Hapus Produk Terpilih");
        add(deleteButton, BorderLayout.SOUTH);

       
        addButton.addActionListener(e -> {
            String code = codeField.getText();
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            double price = Double.parseDouble(priceField.getText());

            ProductModel p = new ProductModel(code, name, qty, price);
            tableModel.addProduct(p);

            codeField.setText("");
            nameField.setText("");
            qtyField.setText("");
            priceField.setText("");
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeProduct(selectedRow);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryApp().setVisible(true);
        });
    }

}