package que4;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.io.File;

public class Que4 extends JFrame {

    // ===== Fields =====
    JTextField txtId, txtName, txtHomeAddr, txtHomePhone,
            txtBusinessAddr, txtBusinessPhone,
            txtFax, txtMobile, txtPager,
            txtChildren, txtIncome, txtImage;

    JComboBox<String> cmbMarital;
    JLabel lblAvg;

    JButton btnAdd, btnSave, btnDelete, btnFind, btnAvg, btnBrowse;

    Connection con;

    public Que4() {

        // ===== Layout =====
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Components =====
        txtId = new JTextField();
        txtName = new JTextField();
        txtHomeAddr = new JTextField();
        txtHomePhone = new JTextField();
        txtBusinessAddr = new JTextField();
        txtBusinessPhone = new JTextField();
        txtFax = new JTextField();
        txtMobile = new JTextField();
        txtPager = new JTextField();
        txtChildren = new JTextField();
        txtIncome = new JTextField();
        txtImage = new JTextField();

        cmbMarital = new JComboBox<>(new String[]{"Single", "Married"});
        lblAvg = new JLabel("Average Income:");

        btnAdd = new JButton("Clear");
        btnSave = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnFind = new JButton("Find");
        btnAvg = new JButton("Avg Income");
        btnBrowse = new JButton("Browse Image");

        // ===== Form Rows =====
        int y = 0;
        addRow("ID", txtId, gbc, y++);
        addRow("Name", txtName, gbc, y++);
        addRow("Home Address", txtHomeAddr, gbc, y++);
        addRow("Home Phone", txtHomePhone, gbc, y++);
        addRow("Business Address", txtBusinessAddr, gbc, y++);
        addRow("Business Phone", txtBusinessPhone, gbc, y++);
        addRow("Fax", txtFax, gbc, y++);
        addRow("Mobile", txtMobile, gbc, y++);
        addRow("Pager", txtPager, gbc, y++);
        addRow("Marital Status", cmbMarital, gbc, y++);
        addRow("No. of Children", txtChildren, gbc, y++);
        addRow("Annual Income", txtIncome, gbc, y++);

        // ===== Image Row =====
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0;
        add(new JLabel("Image"), gbc);

        JPanel imgPanel = new JPanel(new BorderLayout(5, 0));
        imgPanel.add(txtImage, BorderLayout.CENTER);
        imgPanel.add(btnBrowse, BorderLayout.EAST);

        gbc.gridx = 1;
        gbc.weightx = 1;
        add(imgPanel, gbc);
        y++;

        // ===== Buttons =====
        JPanel btnPanel = new JPanel(new GridLayout(2, 3, 6, 6));
        btnPanel.add(btnAdd);
        btnPanel.add(btnSave);
        btnPanel.add(btnDelete);
        btnPanel.add(btnFind);
        btnPanel.add(btnAvg);
        btnPanel.add(lblAvg);

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 2;
        add(btnPanel, gbc);

        // ===== JDBC =====
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/retaildb",
                    "root",
                    "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ===== Events =====
        btnAdd.addActionListener(e -> clearFields());
        btnSave.addActionListener(e -> saveRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnFind.addActionListener(e -> findRecord());
        btnAvg.addActionListener(e -> showAverage());

        btnBrowse.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                txtImage.setText(file.getAbsolutePath());
            }
        });

        // ===== Frame =====
        setTitle("Customer Management System");
        setSize(520, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // ===== Helper =====
    void addRow(String label, JComponent field, GridBagConstraints gbc, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0;
        add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        add(field, gbc);
    }

    // ===== Logic =====
    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtHomeAddr.setText("");
        txtHomePhone.setText("");
        txtBusinessAddr.setText("");
        txtBusinessPhone.setText("");
        txtFax.setText("");
        txtMobile.setText("");
        txtPager.setText("");
        txtChildren.setText("");
        txtIncome.setText("");
        txtImage.setText("");
    }

    void saveRecord() {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(name, home_address, home_phone, business_address, business_phone, " +
                            "fax, mobile, pager, marital_status, children, annual_income, image) " +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, txtName.getText());
            ps.setString(2, txtHomeAddr.getText());
            ps.setString(3, txtHomePhone.getText());
            ps.setString(4, txtBusinessAddr.getText());
            ps.setString(5, txtBusinessPhone.getText());
            ps.setString(6, txtFax.getText());
            ps.setString(7, txtMobile.getText());
            ps.setString(8, txtPager.getText());
            ps.setString(9, cmbMarital.getSelectedItem().toString());
            ps.setInt(10, Integer.parseInt(txtChildren.getText()));
            ps.setDouble(11, Double.parseDouble(txtIncome.getText()));
            ps.setString(12, txtImage.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Saved");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void deleteRecord() {
        try {
            PreparedStatement ps =
                    con.prepareStatement("DELETE FROM customer WHERE id=?");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void findRecord() {
        try {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM customer WHERE id=?");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtName.setText(rs.getString("name"));
                txtHomeAddr.setText(rs.getString("home_address"));
                txtHomePhone.setText(rs.getString("home_phone"));
                txtBusinessAddr.setText(rs.getString("business_address"));
                txtBusinessPhone.setText(rs.getString("business_phone"));
                txtFax.setText(rs.getString("fax"));
                txtMobile.setText(rs.getString("mobile"));
                txtPager.setText(rs.getString("pager"));
                cmbMarital.setSelectedItem(rs.getString("marital_status"));
                txtChildren.setText(rs.getString("children"));
                txtIncome.setText(rs.getString("annual_income"));
                txtImage.setText(rs.getString("image"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showAverage() {
    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT AVG(annual_income) " +
            "FROM customer WHERE marital_status='Married'"
        );

        if (rs.next()) {
            lblAvg.setText("Average Income: " + rs.getDouble(1));
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


    public static void main(String[] args) {
        new Que4();
    }
}
