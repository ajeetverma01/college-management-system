import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminInterface implements ActionListener
{
    JFrame f1;
    Font font1,font2,font3,heading;
    JLabel l1,l3,l4;
    JLabel u1,u2,u3,u4,s1,s2,s3,s4;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    String admin="Admin";
    Connection con=null;

    void getName(String n)
    {
        this.admin=n;
    }

    void adminCommand()
    {

        f1=new JFrame("Admin");
        f1.setSize(1000,700);
        f1.setLocation(180,0);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.getContentPane().setBackground(new Color(255, 255, 255, 255));

        heading=new Font("Arial",Font.BOLD,30);
        font1=new Font("Arial",Font.BOLD,23);
        font2=new Font("Arial",Font.BOLD,19);
        font3=new Font("Arial",Font.BOLD,15);

        l1=new JLabel("<html><u>Welcome "+ admin +"</u></html>");
        l1.setBounds(400,0,300,100);
        l1.setForeground(Color.blue);
        l1.setFont(heading);
        f1.add(l1);

        l4=new JLabel("_____________________________________________________________________________________________________________________________________________");
        l4.setBounds(0,310,1000,20);
        f1.add(l4);
        l4.setForeground(new Color(0x9F0000));

        u1 =new JLabel();
        u2=new JLabel();
        u3=new JLabel();
        u4=new JLabel();
        s1=new JLabel();
        s2=new JLabel();
        s3=new JLabel();
        s4=new JLabel();

        u1.setBounds(20,90,170,170);
        f1.add(u1);
        Icon i1 = new ImageIcon(".\\src\\Images\\IMG\\AllUser.png");
        u1.setIcon(i1);


        u2.setBounds(275,90,170,170);
        Icon i2 = new ImageIcon(".\\src\\Images\\IMG\\newUser.png");
        u2.setIcon(i2);
        f1.add(u2);

        u3.setBounds(540,90,170,170);
        Icon i3 = new ImageIcon(".\\src\\Images\\IMG\\changeUser.png");
        u3.setIcon(i3);
        f1.add(u3);

        u4.setBounds(765,90,170,170);
        Icon i4 = new ImageIcon(".\\src\\Images\\IMG\\RemoveUser.png");
        u4.setIcon(i4);
        f1.add(u4);

        s1.setBounds(20, 330, 170, 170);
        f1.add(s1);
        Icon i5 = new ImageIcon(".\\src\\Images\\IMG\\AllStudent.png");
        s1.setIcon(i5);
        s2.setBounds(275,330,170,170);
        Icon i6 = new ImageIcon(".\\src\\Images\\IMG\\newStudent.png");
        s2.setIcon(i6);
        f1.add(s2);
        s3.setBounds(540,330,170,170);
        Icon i7 = new ImageIcon(".\\src\\Images\\IMG\\SearchStudent.png");
        s3.setIcon(i7);
        f1.add(s3);
        s4.setBounds(785,330,170,170);
        Icon i8 = new ImageIcon(".\\src\\Images\\IMG\\RemoveStudent.png");
        s4.setIcon(i8);
        f1.add(s4);

        u1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                allUsers();
            }
        });

        u2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                NewUserRegistration n=new NewUserRegistration();
                n.newUserReg();
            }
        });

        u3.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                ChangeUser cu=new ChangeUser();
                cu.userChange();
            }
        });

        u4.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                RemoveUser ru=new RemoveUser();
                ru.userRemove();
            }
        });

        s1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                allStudents();
            }
        });
        s2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                StudentRegistration s=new StudentRegistration();
                s.studentReg();
            }
        });

        s3.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                SearchStudent ss = new SearchStudent();
                ss.studentSearch();
            }
        });

        s4.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                f1.dispose();
                RemoveStudent rs=new RemoveStudent();
                rs.studentRemove();
            }
        });

        b1=new JButton("Remove Student");//Remove Student by roll no.
        b2=new JButton("Add new User");
        b3=new JButton("All Users");
        b4=new JButton("All Students");
        b5=new JButton("Add new Student");
        b6=new JButton("Log out");
        b7=new JButton("Back");
        b8=new JButton("Change user");
        b9=new JButton("Remove user"); //Remove user by userID
        b10=new JButton("Search Student");
        b11=new JButton("Exit");

        b1.setBounds(790,510,160,40);
        b2.setBounds(280,270,160,40);
        b3.setBounds(40,270,140,40);
        b4.setBounds(40,510,140,40);
        b5.setBounds(280,510,160,40);
        b6.setBounds(280,580,100,40);
        b7.setBounds(450,580,100,40);
        b8.setBounds(550,270,150,40);
        b9.setBounds(790,270,140,40);
        b10.setBounds(550,510,150,40);
        b11.setBounds(620,580,100,40);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        f1.add(b6);
        f1.add(b7);
        f1.add(b8);
        f1.add(b9);
        f1.add(b10);
        f1.add(b11);

        b1.setFont(font3);
        b2.setFont(font3);
        b3.setFont(font3);
        b4.setFont(font3);
        b5.setFont(font3);
        b6.setFont(font3);
        b7.setFont(font3);
        b8.setFont(font3);
        b9.setFont(font3);
        b10.setFont(font3);
        b11.setFont(font3);

        b6.setForeground(new Color(204,0,0));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);


        f1.setLayout(null);
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Exit"))
        {
            f1.dispose();
            System.exit(0);
        }

        if (e.getActionCommand().equalsIgnoreCase("Back"))
        {
            f1.dispose();
            UserLogin u=new UserLogin();
            u.loginForm();
        }

        if (e.getActionCommand().equalsIgnoreCase("Log out"))
        {
            f1.dispose();
            UserLogin u=new UserLogin();
            u.loginForm();
        }

        if (e.getActionCommand().equalsIgnoreCase("Add new Student"))
        {
            f1.dispose();
            StudentRegistration s=new StudentRegistration();
            s.studentReg();
        }

        if (e.getActionCommand().equalsIgnoreCase("Search student"))
        {
            f1.dispose();
            SearchStudent ss = new SearchStudent();
            ss.studentSearch();
        }

        if (e.getActionCommand().equalsIgnoreCase("Remove Student"))
        {
            f1.dispose();
            RemoveStudent rs=new RemoveStudent();
            rs.studentRemove();
        }

        if (e.getActionCommand().equalsIgnoreCase("All Users"))
        {
            allUsers();
        }

        if (e.getActionCommand().equalsIgnoreCase("Add new User"))
        {
            f1.dispose();
            NewUserRegistration n=new NewUserRegistration();
            n.newUserReg();
        }

        if (e.getActionCommand().equalsIgnoreCase("Change user"))
        {
            f1.dispose();
            ChangeUser cu=new ChangeUser();
            cu.userChange();
        }

        if (e.getActionCommand().equalsIgnoreCase("Remove user"))
        {
            f1.dispose();
            RemoveUser ru=new RemoveUser();
            ru.userRemove();
        }

        if (e.getActionCommand().equalsIgnoreCase("All students"))
        {
            allStudents();
        }
    }

    void allUsers()
    {
        con=ConnectionProvider.getConnection();
        JFrame f2 = new JFrame("All users");
        DefaultTableModel tm=new DefaultTableModel();
        JTable table=new JTable(tm);
        table.setRowHeight(20);
        table.setFont(font3);
        JScrollPane scrollPane = new JScrollPane(table);
        f2.getContentPane().add(scrollPane);

        try
        {
            String query = "select * from users;";
            Statement stmt =con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 1; i<= columns; i++)
            {
                tm.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next())
            {
                Object[] rowData = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    rowData[i - 1] = rs.getObject(i);
                }
                tm.addRow(rowData);
            }

            con.close();
            stmt.close();
        }
        catch (Exception ae)
        {
            throw new RuntimeException(ae);
        }

        f2.setBounds(300,200,730,300);
        f2.setVisible(true);
    }

    void allStudents()
    {
        con=ConnectionProvider.getConnection();
        JFrame f2 = new JFrame("All Students");
        DefaultTableModel tm=new DefaultTableModel();
        JTable table=new JTable(tm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowHeight(20);
        table.setFont(font3);
        f2.getContentPane().add(scrollPane);

        try
        {
            String query = "select * from Students;";
            Statement stmt =con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 1; i<= columns; i++)
            {
                tm.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next())
            {
                Object[] rowData = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    rowData[i - 1] = rs.getObject(i);
                }
                tm.addRow(rowData);
            }
            con.close();
            stmt.close();
        }
        catch (Exception ae)
        {
            throw new RuntimeException(ae);
        }

        f2.setBounds(80,200,1200,300);
        f2.setVisible(true);
    }
}