import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class SearchStudent implements ActionListener
{
    JTextField t1, t2;
    JFrame f3;
    Connection con = null;

    void studentSearch()
    {
        f3 = new JFrame("Search Student");
        f3.setBounds(430, 100, 500, 400);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font1 = new Font("Arial", Font.BOLD, 23);
        Font font2 = new Font("Arial", Font.BOLD, 19);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        JButton b1 = new JButton("Search");
        JButton b2 = new JButton("Back");
        b1.setBounds(100, 250, 100, 40);
        b2.setBounds(300, 250, 100, 40);
        f3.add(b1);
        f3.add(b2);
        b1.setFont(font3);
        b2.setFont(font3);
        b1.setForeground(new Color(45191));
        b2.setForeground(new Color(204, 0, 0));

        JLabel l1 = new JLabel("Enter Roll no:");
        JLabel l3 = new JLabel("Enter name:");
        JLabel l2 = new JLabel("<html><u>Search Student</u></html>");
        l2.setForeground(Color.DARK_GRAY);
        l2.setBounds(175, 50, 200, 40);
        l1.setBounds(80, 130, 150, 40);
        l3.setBounds(80, 180, 150, 40);

        t1 = new JTextField();
        l2.setForeground(Color.BLUE);
        t1.setBounds(230, 130, 150, 40);

        f3.add(t1);
        f3.add(l1);
        f3.add(l2);
        f3.add(l3);

        l1.setFont(font2);
        l2.setFont(font1);
        t1.setFont(font2);
        l3.setFont(font2);

        t2 = new JTextField("Optional");
        t2.setForeground(Color.gray);
        t2.setBounds(230, 180, 150, 40);

        t2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (t2.getText().equals("Optional"))
                {
                    t2.setText("");
                    t2.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e)
            {
                if (t2.getText().isEmpty())
                {
                    t2.setForeground(Color.gray);
                    t2.setText("Optional");
                }
            }
        });

        f3.add(t2);
        t2.setFont(font2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        JLabel whole = whole = new JLabel();
        whole.setBounds(0, 0, 650, 500);
        Icon icon = new ImageIcon(".\\src\\Images\\searchS.png");
        whole.setIcon(icon);
        f3.add(whole);
        f3.setLayout(null);
        f3.setVisible(true);
        f3.setLayout(null);
        f3.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Back"))
        {
            f3.dispose();
            AdminInterface ai = new AdminInterface();
            ai.adminCommand();
        }

        if (e.getActionCommand().equalsIgnoreCase("Search"))
        {
            con = ConnectionProvider.getConnection();
            JFrame f2 = new JFrame("All Students");
            DefaultTableModel tm = new DefaultTableModel();
            JTable table = new JTable(tm);
            JScrollPane scrollPane = new JScrollPane(table);
            f2.getContentPane().add(scrollPane);

            try
            {
                String query = "select * from students where RollNumber=?;";
                int val = Integer.parseInt(t1.getText());
                String name = t2.getText();
                if (name != "optional" && !name.isEmpty())
                {
                    query = "select * from Students where rollNumber=? or name=?;";
                }

                PreparedStatement pStmt = con.prepareStatement(query);
                pStmt.setInt(1, val);
                pStmt.setString(2, name);
                ResultSet rs = pStmt.executeQuery();
                int columns = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columns; i++)
                {
                    tm.addColumn(rs.getMetaData().getColumnName(i));
                }
                while (rs.next())
                {
                    Object[] rowData = new Object[columns];
                    for (int i = 1; i <= columns; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    tm.addRow(rowData);

                }
                con.close();
                pStmt.close();
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for roll number.");
                return;
            }

            f2.setBounds(300, 200, 900, 300);
            f2.setVisible(true);
        }
    }
}
