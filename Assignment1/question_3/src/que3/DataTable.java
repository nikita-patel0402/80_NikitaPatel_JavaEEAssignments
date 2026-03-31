/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package que3;

/**
 *
 * @author root
 */
import java.util.Hashtable;
import java.util.Scanner;

// ===== Interface =====
interface Featurable {
    void setForeground(String color);
    void setBackground(String color);
    void setFont(String font);
    String getForeground();
    String getBackground();
    String getFont();
}

// ===== Custom Exception =====
class TableException extends Exception {
    public TableException(String msg) {
        super(msg);
    }
}

// ===== DataTable Class =====
public class DataTable implements Featurable {

    private int rows, cols;
    private String[][] table;
    private String foreground = "Black";
    private String background = "White";
    private String font = "Arial";

    // Constructor
    public DataTable(int rows, int cols) throws TableException {
        if (rows > 200 || cols > 200) {
            throw new TableException("Rows or Columns cannot exceed 200");
        }
        this.rows = rows;
        this.cols = cols;
        table = new String[rows][cols];
    }

    // Insert value
    public void insertValue(int r, int c, String value) {
        table[r][c] = value;
    }

    // Display table
    public void display() {
        System.out.println("\nTable Data:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((table[i][j] == null ? "-" : table[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    // Insert row
    public void insertRow(int pos) throws TableException {
        if (rows + 1 > 200)
            throw new TableException("Cannot insert more than 200 rows");

        String[][] newTable = new String[rows + 1][cols];
        for (int i = 0, ni = 0; i < rows + 1; i++) {
            if (i == pos) continue;
            newTable[i] = table[ni++];
        }
        table = newTable;
        rows++;
    }

    // Delete row
    public void deleteRow(int pos) {
        String[][] newTable = new String[rows - 1][cols];
        for (int i = 0, ni = 0; i < rows; i++) {
            if (i == pos) continue;
            newTable[ni++] = table[i];
        }
        table = newTable;
        rows--;
    }

    // Insert column
    public void insertColumn(int pos) throws TableException {
        if (cols + 1 > 200)
            throw new TableException("Cannot insert more than 200 columns");

        String[][] newTable = new String[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0, nj = 0; j < cols + 1; j++) {
                if (j == pos) continue;
                newTable[i][j] = table[i][nj++];
            }
        }
        table = newTable;
        cols++;
    }

    // Delete column
    public void deleteColumn(int pos) {
        String[][] newTable = new String[rows][cols - 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0, nj = 0; j < cols; j++) {
                if (j == pos) continue;
                newTable[i][nj++] = table[i][j];
            }
        }
        table = newTable;
        cols--;
    }

    // Populate from Hashtable
    public void populateFromHashtable(Hashtable<Integer, String> data) {
        int index = 0;
        for (String value : data.values()) {
            table[index / cols][index % cols] = value;
            index++;
            if (index >= rows * cols) break;
        }
    }

    // ===== Featurable methods =====
    public void setForeground(String color) { foreground = color; }
    public void setBackground(String color) { background = color; }
    public void setFont(String font) { this.font = font; }

    public String getForeground() { return foreground; }
    public String getBackground() { return background; }
    public String getFont() { return font; }
}
