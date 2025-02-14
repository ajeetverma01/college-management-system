import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UserLogin implements ActionListener
{
    Connection con=null;
    JFrame f1;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,whole;
    Font font1,font2,font3;
    JTextField t1,t2;

    void loginForm()
    {
        f1=new JFrame("User Login");
        f1.setSize(650,500);
        f1.setLocation(380,130);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        font1=new Font("Arial",Font.BOLD,23);
        font2=new Font("Arial",Font.BOLD,19);
        font3=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("<html><u>User Login</u></html>");
        l1.setBounds(250,20,200,100);
        l1.setForeground(Color.blue);
        l1.setFont(font1);
        f1.add(l1);

        l2=new JLabel("Enter Username: ");
        l3=new JLabel("Enter Password: ");
        l2.setBounds(80,110,200,60);
        l3.setBounds(80,150,200,60);
        l2.setFont(font2);
        l3.setFont(font2);
        f1.add(l2);
        f1.add(l3);

        t1=new JTextField();
        t2=new JPasswordField();
        t1.setBounds(240,115,200,40);
        t2.setBounds(240,155,200,40);
        t1.setForeground(Color.red);
        t2.setForeground(Color.red);
        f1.add(t1);
        f1.add(t2);
        t1.setFont(font2);
        t2.setFont(font2);

        b1=new JButton("Login");
        b4=new JButton("Clear");
        b2=new JButton("New Login");
        b3=new JButton("Exit");
        b1.setBounds(340,200,100,40);
        b4.setBounds(240,200,90,40);
        b2.setBounds(130,340,140,50);
        b3.setBounds(465,340,70,50);
        b1.setForeground(new Color(45191));
        b4.setForeground(new Color(204,0,0));
        f1.add(b1);
        f1.add(b4);
        b1.setFont(font3);
        b4.setFont(font3);
        f1.add(b2);
        f1.add(b3);
        b2.setFont(font3);
        b3.setFont(font3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        whole=new JLabel();
        whole.setBounds(0,0,650,500);
        Icon icon = new ImageIcon(".\\src\\Images\\Login3.png");
        whole.setIcon(icon);
        f1.add(whole);

        f1.setLayout(null);
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Login"))
        {
            con=ConnectionProvider.getConnection();
            String query="select * from users;";
            try
            {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while (rs.next()) {
                    String uName=rs.getString("Name");
                    String psw=rs.getString("password");
                    if (t1.getText().equals(uName) && t2.getText().equals(psw)) {
                        f1.dispose();
                        AdminInterface ai = new AdminInterface();
                        ai.getName(uName);
                        ai.adminCommand();
                        break;
                    }
                }

                con.close();
                stmt.close();
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("Clear"))
        {
            t1.setText("");
            t2.setText("");
        }

        if (e.getActionCommand().equalsIgnoreCase("Exit"))
        {
            f1.dispose();
            System.exit(0);
        }

        if (e.getActionCommand().equalsIgnoreCase("New Login"))
        {
            f1.dispose();
            NewUserBeforeLogin n=new NewUserBeforeLogin();
            n.insert();
        }
    }
}
