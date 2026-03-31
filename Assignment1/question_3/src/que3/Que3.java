/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package que3;

/**
 *
 * @author root
 */
import java.util.Hashtable;
import java.util.Scanner;

public class Que3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataTable table = null;

        try {
            System.out.print("Enter rows: ");
            int r = sc.nextInt();
            System.out.print("Enter columns: ");
            int c = sc.nextInt();
            table = new DataTable(r, c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert Cell Value");
            System.out.println("2. Display Table");
            System.out.println("3. Insert Row");
            System.out.println("4. Delete Row");
            System.out.println("5. Insert Column");
            System.out.println("6. Delete Column");
            System.out.println("7. Set Colors & Font");
            System.out.println("8. Populate from Hashtable");
            System.out.println("9. Exit");

            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Row: ");
                        int r = sc.nextInt();
                        System.out.print("Column: ");
                        int c = sc.nextInt();
                        System.out.print("Value: ");
                        sc.nextLine();
                        String val = sc.nextLine();
                        table.insertValue(r, c, val);
                        break;

                    case 2:
                        table.display();
                        break;

                    case 3:
                        System.out.print("Position: ");
                        table.insertRow(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Position: ");
                        table.deleteRow(sc.nextInt());
                        break;

                    case 5:
                        System.out.print("Position: ");
                        table.insertColumn(sc.nextInt());
                        break;

                    case 6:
                        System.out.print("Position: ");
                        table.deleteColumn(sc.nextInt());
                        break;

                    case 7:
                        System.out.print("Foreground: ");
                        table.setForeground(sc.next());
                        System.out.print("Background: ");
                        table.setBackground(sc.next());
                        System.out.print("Font: ");
                        table.setFont(sc.next());
                        break;

                    case 8:
                        Hashtable<Integer, String> ht = new Hashtable<>();
                        ht.put(1, "A");
                        ht.put(2, "B");
                        ht.put(3, "C");
                        ht.put(4, "D");
                        table.populateFromHashtable(ht);
                        break;

                    case 9:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

