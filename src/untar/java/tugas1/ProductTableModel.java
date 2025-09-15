package untar.java.tugas1;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private ArrayList<ProductModel> products;

    public ProductTableModel(ArrayList<ProductModel> products){
        this.products = products;
    }

    @Override
    public int getRowCount(){
         return products.size();
    }

    @Override
    public int getColumnCount(){
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
    ProductModel p = products.get(rowIndex);
    switch (columnIndex){
        case 0: return p.getCode();
        case 1: return p.getName();
        case 2: return p.getQty();
        case 3: return p.getPrice();
    }
    return null;
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "Kode";
            case 1: return "Nama";
            case 2: return "Qty";
            case 3: return "Harga";
        }
        return super.getColumnName(column);
    }

    public void addProduct(ProductModel p){
        products.add(p);
        fireTableRowsInserted(products.size()-1, products.size()-1);
    }

    public void removeProduct(int index){
        if (index >= 0 && index < products.size()){
            products.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }
}