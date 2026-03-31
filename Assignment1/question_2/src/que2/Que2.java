package que2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Que2 extends JFrame {

    // ===== Address Class =====
    class Address {
        String name, homeAddress, homePhone;
        String businessAddress, businessPhone;
        String fax, mobile, pager;

        Address(String name, String homeAddress, String homePhone,
                String businessAddress, String businessPhone,
                String fax, String mobile, String pager) {
            this.name = name;
            this.homeAddress = homeAddress;
            this.homePhone = homePhone;
            this.businessAddress = businessAddress;
            this.businessPhone = businessPhone;
            this.fax = fax;
            this.mobile = mobile;
            this.pager = pager;
        }
    }

    // ===== Collection =====
    ArrayList<Address> addressList = new ArrayList<>();

    // ===== GUI Components =====
    JTextField txtName, txtHomeAddr, txtHomePhone,
            txtBusinessAddr, txtBusinessPhone,
            txtFax, txtMobile, txtPager;

    JTable table;
    DefaultTableModel tableModel;

    // ===== Constructor =====
    public Que2() {
        setTitle("Address Book");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- Input Panel --------
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));

        txtName = new JTextField();
        txtHomeAddr = new JTextField();
        txtHomePhone = new JTextField();
        txtBusinessAddr = new JTextField();
        txtBusinessPhone = new JTextField();
        txtFax = new JTextField();
        txtMobile = new JTextField();
        txtPager = new JTextField();

        inputPanel.add(new JLabel("Name"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Home Address"));
        inputPanel.add(txtHomeAddr);
        inputPanel.add(new JLabel("Home Phone"));
        inputPanel.add(txtHomePhone);
        inputPanel.add(new JLabel("Business Address"));
        inputPanel.add(txtBusinessAddr);
        inputPanel.add(new JLabel("Business Phone"));
        inputPanel.add(txtBusinessPhone);
        inputPanel.add(new JLabel("Fax"));
        inputPanel.add(txtFax);
        inputPanel.add(new JLabel("Mobile"));
        inputPanel.add(txtMobile);
        inputPanel.add(new JLabel("Pager"));
        inputPanel.add(txtPager);

        add(inputPanel, BorderLayout.WEST);

        // -------- Table --------
        String[] cols = {
                "Name", "Home Addr", "Home Phone",
                "Business Addr", "Business Phone",
                "Fax", "Mobile", "Pager"
        };

        tableModel = new DefaultTableModel(cols, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // -------- Buttons --------
        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnFind = new JButton("Find");
        JButton btnDisplay = new JButton("Display");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnFind);
        buttonPanel.add(btnDisplay);

        add(buttonPanel, BorderLayout.SOUTH);

        // -------- Actions --------
        btnAdd.addActionListener(e -> addAddress());
        btnUpdate.addActionListener(e -> updateAddress());
        btnDelete.addActionListener(e -> deleteAddress());
        btnFind.addActionListener(e -> findAddress());
        btnDisplay.addActionListener(e -> displayTable());

        setVisible(true);
    }

    // ===== Methods =====
    void addAddress() {
        Address a = new Address(
                txtName.getText(),
                txtHomeAddr.getText(),
                txtHomePhone.getText(),
                txtBusinessAddr.getText(),
                txtBusinessPhone.getText(),
                txtFax.getText(),
                txtMobile.getText(),
                txtPager.getText()
        );
        addressList.add(a);
        displayTable();   // auto display after insert
        clearFields();
    }

    void updateAddress() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Address a = addressList.get(row);
            a.name = txtName.getText();
            a.homeAddress = txtHomeAddr.getText();
            a.homePhone = txtHomePhone.getText();
            a.businessAddress = txtBusinessAddr.getText();
            a.businessPhone = txtBusinessPhone.getText();
            a.fax = txtFax.getText();
            a.mobile = txtMobile.getText();
            a.pager = txtPager.getText();
            displayTable();
        }
    }

    void deleteAddress() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            addressList.remove(row);
            displayTable();
            clearFields();
        }
    }

    void findAddress() {
        String name = JOptionPane.showInputDialog(this, "Enter name to find");
        for (int i = 0; i < addressList.size(); i++) {
            if (addressList.get(i).name.equalsIgnoreCase(name)) {
                table.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Record not found");
    }

    void displayTable() {
        tableModel.setRowCount(0);
        for (Address a : addressList) {
            tableModel.addRow(new Object[]{
                    a.name, a.homeAddress, a.homePhone,
                    a.businessAddress, a.businessPhone,
                    a.fax, a.mobile, a.pager
            });
        }
    }

    void clearFields() {
        txtName.setText("");
        txtHomeAddr.setText("");
        txtHomePhone.setText("");
        txtBusinessAddr.setText("");
        txtBusinessPhone.setText("");
        txtFax.setText("");
        txtMobile.setText("");
        txtPager.setText("");
    }

    public static void main(String[] args) {
        new Que2();
    }
}
