package JavaApplication17;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ProductFrame extends JFrame {
   
// table
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTable table = new JTable();
    private final DefaultTableModel dtm = new DefaultTableModel();
    
// label
    private final JLabel titleLabel = new JLabel("Product");
// connection
    private final Connect conn;
    private final ResultSet rs = null;
    private final ResultSetMetaData rsm = null;
    private Vector<String> headerTable = new Vector<String>();
    private Vector<Vector<String>> dataTable = new Vector<Vector<String>>();
    
    public ProductFrame() throws SQLException {
        this.conn = new Connect();
        createForm();
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
        scrollPane.setViewportView(table);
        table.setModel(dtm);

        
        this.setVisible(true);
        
    }
    
    void refreshData(){
        
       
    }
    
    private void createForm() {
    this.setTitle("Product Form");
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    }
        
}

    
