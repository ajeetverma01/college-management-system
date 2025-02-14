import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class RemoveUser implements ActionListener
{
    JTextField t1;
    JFrame f3;
    Connection con;

    void userRemove()
    {
        f3 = new JFrame("Remove User");
        f3.setBounds(430, 200, 500, 400);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font1 = new Font("Arial", Font.BOLD, 23);
        Font font2 = new Font("Arial", Font.BOLD, 19);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        JButton b1 = new JButton("Remove");
        JButton b2 = new JButton("Back");
        b1.setBounds(100, 250, 100, 40);
        b2.setBounds(300, 250, 100, 40);
        b1.setForeground(new Color(45191));
        b2.setForeground(new Color(204, 0, 0));
        f3.add(b1);
        f3.add(b2);
        b1.setFont(font3);
        b2.setFont(font3);

        JLabel l1 = new JLabel("Enter Username:");
        JLabel l2 = new JLabel("<html><u>Remove User</u></html>");
        l2.setForeground(Color.BLUE);
        l2.setBounds(175, 50, 200, 40);
        l1.setBounds(65, 150, 165, 40);

        t1 = new JTextField();
        t1.setBounds(230, 150, 150, 40);
        t1.setForeground(new Color(0xFFDE9200, true));

        f3.add(t1);
        f3.add(l1);
        f3.add(l2);

        l1.setFont(font2);
        l2.setFont(font1);
        t1.setFont(font2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        JLabel whole = whole = new JLabel();
        whole.setBounds(0, 0, 650, 500);
        Icon icon = new ImageIcon(".\\src\\Images\\remove.png");
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
            try
            {
                String query = "delete from users where Name=?;";
                String uName = t1.getText();
                PreparedStatement pStmt = con.prepareStatement(query);
                pStmt.setString(1, uName);
                int rows = pStmt.executeUpdate();

                if (rows > 0)
                {
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "User removed.");
                } else {
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "Unknown user.");
                }
                con.close();
                pStmt.close();

            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}