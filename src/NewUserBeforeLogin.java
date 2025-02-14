import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class NewUserBeforeLogin implements ActionListener
{
    JFrame f1;
    Font font1,font2,font3;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2,b3;
    JTextField t1, t2,t3,t4,t5;
    Connection con;

    void insert()
    {
        f1=new JFrame("New User");
        f1.setSize(600,600);
        f1.setLocation(380,80);

        font1=new Font("Arial",Font.BOLD,23);
        font2=new Font("Arial",Font.BOLD,19);
        font3=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("<html><u>New User Registration</u></html>");
        l1.setBounds(240,10,200,100);
        l1.setForeground(Color.blue);
        l1.setFont(font1);
        f1.add(l1);

        l2=new JLabel("Enter User ID:");
        l3=new JLabel("Enter Name:");
        l4=new JLabel("Enter Password:");
        l2.setBounds(40,100,200,50);
        l3.setBounds(40,160,200,50);
        l4.setBounds(40,220,200,50);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        l2.setFont(font2);
        l3.setFont(font2);
        l4.setFont(font2);

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t1.setBounds(240,100,200,40);
        t2.setBounds(240,160,200,40);
        t3.setBounds(240,220,200,40);
        t1.setFont(font2);
        t2.setFont(font2);
        t3.setFont(font2);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);

        l5=new JLabel("Enter phone:");
        l6=new JLabel("Enter Email:");
        l5.setBounds(40,280,200,50);
        l6.setBounds(40,340,200,50);
        f1.add(l5);
        f1.add(l6);
        l5.setFont(font2);
        l6.setFont(font2);

        t4=new JTextField();
        t5=new JTextField();
        t4.setBounds(240,280,200,40);
        t5.setBounds(240,340,200,40);
        t4.setFont(font2);
        t5.setFont(font2);
        f1.add(t4);
        f1.add(t5);

        b1=new JButton("Save");
        b2=new JButton("Back");
        b3=new JButton("Clear");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b1.setFont(font3);
        b2.setFont(font3);
        b3.setFont(font3);
        b1.setBounds(340,440,100,40);
        b2.setBounds(230,440,100,40);
        b3.setBounds(120,440,100,40);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        b1.setForeground(new Color(45191));
        b2.setForeground(new Color(204,0,0));

        JLabel whole=new JLabel();
        whole.setBounds(0,0,650,500);
        Icon icon = new ImageIcon(".\\src\\Images\\ss.png");
        whole.setIcon(icon);
        f1.add(whole);

        f1.setLayout(null);
        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Clear"))
        {
            t1.setText("");
            t2.setText("");
            t2.setText("");
        }

        if (e.getActionCommand().equalsIgnoreCase("Save"))
        {
            try
            {
                con=ConnectionProvider.getConnection();
                String query="insert into users(UserID,Name,Password,Phone,Email) values(?,?,?,?,?);";
                String uID =t1.getText();
                String name =t2.getText();
                String passWd =t3.getText();
                String phone =t4.getText();
                String email= t5.getText();

                PreparedStatement pStmt=con.prepareStatement(query);
                pStmt.setString(1, uID);
                pStmt.setString(2, name);
                pStmt.setString(3, passWd);
                pStmt.setString(4, phone);
                pStmt.setString(5, email);
                int row=pStmt.executeUpdate();

                if (row>0)
                {
                    JFrame f2=new JFrame();
                    JOptionPane.showMessageDialog(f2,"User Added");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                }
                con.close();
                pStmt.close();

            }
            catch (SQLIntegrityConstraintViolationException ex)
            {
                JOptionPane.showMessageDialog(null,"Same ID of two Users.");
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("Back"))
        {
            f1.dispose();
            UserLogin u=new UserLogin();
            u.loginForm();
            f1.dispose();
        }
    }
}

