package JavaApplication17;
import com.mysql.jdbc.Connection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;

public class insertForm extends JFrame{
    private final JPanel panel;
    private final JLabel nama;
    private final JLabel type;
    private final JLabel price;
    private final JLabel stock;
    private final JTextField inputNama;
    private final JComboBox combo1;
    private final JButton btn1;

public insertForm(){
    Container c;
    c = getContentPane();
    c.setLayout(null);
    
    panel = new JPanel();

    nama = new JLabel("Name ");
    nama.setBounds(20, 15, 100, 30);


    type = new JLabel("Type ");
    type.setBounds(20, 55, 100, 30);
    price = new JLabel("Price");
    price.setBounds(20, 95, 100, 30);
    stock = new JLabel("Stock");
    stock.setBounds(20, 135, 100, 30);

    inputNama = new JTextField();
    inputNama.setBounds(100, 20, 200, 25);

    combo1 = new JComboBOx();
    combo1.setBounds(100, 60, 200, 25);
    combo1.addItem("");
    combo1.addItem("Drink");
    combo1.addItem("Food");

    //spin1 = new JSpinner();
    SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 200000, 1);  
    JSpinner spin1 = new JSpinner(model1);
    spin1.setBounds(100, 100, 200, 25);
    
    
    SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0,100, 1);  
    JSpinner spin2 = new JSpinner(model2);
    
    spin2.setBounds(100, 140, 200, 25);

    btn1 = new JButton("INSERT");
    btn1.setBounds(150, 180, 90, 30);

    c.add(nama);
    c.add(type);
    c.add(price);
    c.add(stock);
    c.add(inputNama);
    c.add(combo1);
    c.add(spin1);
    c.add(spin2);
    c.add(btn1);
    
    c.setVisible(true);
    
    btn1.addActionListener((ActionEvent ae) -> {
        Integer Price = (Integer) model1.getValue();
        Integer Stock = (Integer) model2.getValue();
        
        if (inputNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Pengguna Harus Diisi!");
        } else if (combo1.getSelectedItem()==("")){
            JOptionPane.showMessageDialog(null, "Type harus dipilih");
        } else if (Price < 1 || Price > 20000){
            JOptionPane.showMessageDialog(null, "price harus diantara 1 dan 200000");
        } else if (Stock < 1 || Stock > 100){
            JOptionPane.showMessageDialog(null, "Stok harus diantara 1 dan 100");
        }else {
            try {
            String sql = "INSERT INTO product VALUES (+id,'"+inputNama.getText()+"','"+combo1.getSelectedItem()+"','"+spin1.getValue()+"','"+spin2.getValue()+"')";
            java.sql.Connection conn=(Connection)Connect.Connect();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    });
}
    public static void main(String[] args) throws SQLException{
    Connect testCon = new Connect();
    testCon.getClass();
    insertForm frame = new insertForm();
    frame.setTitle("Product Form");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
    
    

    }

    private static class JComboBOx extends JComboBox {

        public JComboBOx() {
        }
    }

}


