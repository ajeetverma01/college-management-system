import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class RemoveStudent implements ActionListener
{
    JTextField t1;
    JFrame f3;
    Connection con = null;

    void studentRemove()
    {
        f3 = new JFrame("Remove Student");
        f3.setBounds(430, 200, 500, 400);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font1 = new Font("Arial", Font.BOLD, 23);
        Font font2 = new Font("Arial", Font.BOLD, 19);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        JButton b1 = new JButton("Remove");
        JButton b2 = new JButton("Back");
        b1.setBounds(100, 250, 100, 40);
        b2.setBounds(300, 250, 100, 40);
        f3.add(b1);
        f3.add(b2);
        b1.setFont(font3);
        b2.setFont(font3);

        JLabel l1 = new JLabel("Enter Roll no:");
        JLabel l2 = new JLabel("<html><u>Remove Student</u></html>");
        l2.setForeground(Color.blue);
        l2.setBounds(175, 50, 200, 40);
        l1.setBounds(80, 150, 150, 40);

        t1 = new JTextField();
        t1.setBounds(230, 150, 150, 40);
        f3.add(t1);
        f3.add(l1);
        f3.add(l2);

        l1.setFont(font2);
        l2.setFont(font1);
        t1.setFont(font2);

        b1.setForeground(new Color(45191));
        b2.setForeground(new Color(204, 0, 0));

        b1.addActionListener(this);
        b2.addActionListener(this);

        JLabel whole = whole = new JLabel();
        whole.setBounds(0, 0, 650, 500);
        Icon icon = new ImageIcon(".\\src\\Images\\removeS.png");
        whole.setIcon(icon);
        f3.add(whole);
        f3.setLayout(null);
        f3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Back"))
        {
            f3.dispose();
            AdminInterface ai = new AdminInterface();
            ai.adminCommand();
        }
        if (e.getActionCommand().equalsIgnoreCase("Remove"))
        {
            con = ConnectionProvider.getConnection();
            String query = "Delete from students where RollNumber=?;";
            try
            {
                int roll = Integer.parseInt(t1.getText());
                PreparedStatement pStmt = con.prepareStatement(query);
                pStmt.setInt(1, roll);
                int row = pStmt.executeUpdate();
                if (row > 0)
                {
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "Student deleted.");
                } else
                {
                    JFrame f4 = new JFrame();
                    JOptionPane.showMessageDialog(f4, "Invalid roll number.");
                }
                con.close();
                pStmt.close();
            } catch (SQLException | NumberFormatException ex)
            {
                JFrame f4 = new JFrame();
                JOptionPane.showMessageDialog(f4, "Invalid roll number.");
            }
        }
    }
}