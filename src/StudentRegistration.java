import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class StudentRegistration implements ActionListener
{
    JFrame f1;
    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton jb1, jb2, jb3;
    Font font1, font2, font3;
    Connection con = null;
    String gender;


    void studentReg()
    {
        f1 = new JFrame("Student Registration");
        f1.setSize(810, 720);
        f1.setLocation(300, 5);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBackground(new Color(125, 194, 253, 255));

        font1 = new Font("Arial", Font.BOLD, 28);
        font2 = new Font("Arial", Font.BOLD, 16);
        font3 = new Font("Arial", Font.BOLD, 16);

        l1 = new JLabel("<html><u>Student Admission</u></html>");
        l1.setBounds(310, 0, 300, 100);
        l1.setForeground(Color.blue);
        l1.setFont(font1);
        f1.add(l1);

        l2 = new JLabel("Name:");
        l3 = new JLabel("Roll number:");
        l4 = new JLabel("Class");
        l5 = new JLabel("Mobile no.:");
        l6 = new JLabel("Email:");
        l7 = new JLabel("Father's Name:");
        l8 = new JLabel("Mother's Name:");
        l9 = new JLabel("Religion:");
        l10 = new JLabel("Address:");
        l11 = new JLabel("Pin:");
        l12 = new JLabel("Gender");

        l2.setBounds(200, 90, 140, 50);
        l3.setBounds(200, 130, 140, 50);
        l4.setBounds(200, 170, 140, 50);
        l5.setBounds(200, 210, 140, 50);
        l12.setBounds(200, 250, 140, 50);
        l6.setBounds(200, 290, 140, 50);
        l7.setBounds(200, 330, 140, 50);
        l8.setBounds(200, 370, 150, 50);
        l9.setBounds(200, 410, 140, 50);
        l10.setBounds(200, 450, 140, 50);
        l11.setBounds(200, 490, 140, 50);

        l2.setFont(font2);
        l3.setFont(font2);
        l4.setFont(font2);
        l5.setFont(font2);
        l6.setFont(font2);
        l7.setFont(font2);
        l8.setFont(font2);
        l9.setFont(font2);
        l10.setFont(font2);
        l11.setFont(font2);
        l12.setFont(font2);

        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l5.setForeground(Color.RED);
        l6.setForeground(Color.RED);
        l7.setForeground(Color.RED);
        l8.setForeground(Color.RED);
        l9.setForeground(Color.RED);
        l10.setForeground(Color.RED);
        l11.setForeground(Color.RED);
        l12.setForeground(Color.RED);

        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);
        f1.add(l9);
        f1.add(l10);
        f1.add(l11);
        f1.add(l12);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();

        t1.setBounds(345, 90, 190, 30);
        t2.setBounds(345, 130, 190, 30);
        t3.setBounds(345, 170, 190, 30);
        t4.setBounds(345, 210, 190, 30);
        t5.setBounds(345, 500, 190, 30);
        t6.setBounds(345, 300, 190, 30);
        t7.setBounds(345, 340, 190, 30);
        t8.setBounds(345, 380, 190, 30);
        t9.setBounds(345, 420, 190, 30);
        t10.setBounds(345, 460, 190, 30);

        t1.setFont(font2);
        t2.setFont(font2);
        t3.setFont(font2);
        t4.setFont(font2);
        t5.setFont(font2);
        t6.setFont(font2);
        t7.setFont(font2);
        t8.setFont(font2);
        t9.setFont(font2);
        t10.setFont(font2);

        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);
        f1.add(t5);
        f1.add(t6);
        f1.add(t7);
        f1.add(t8);
        f1.add(t9);
        f1.add(t10);

        jb1 = new JRadioButton("Male");
        jb2 = new JRadioButton("Female");
        jb3 = new JRadioButton("Other");
        jb1.setBounds(340, 255, 80, 30);
        jb2.setBounds(420, 255, 80, 30);
        jb3.setBounds(500, 255, 80, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);
        f1.add(jb1);
        f1.add(jb2);
        f1.add(jb3);
        jb1.setFont(font3);
        jb2.setFont(font3);
        jb3.setFont(font3);

        jb1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gender = "Male";
            }
        });

        jb2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gender = "Female";
            }
        });

        jb3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gender = "Other";
            }
        });

        b1 = new JButton("Back");
        b2 = new JButton("Clear");
        b3 = new JButton("Save");
        b1.setBounds(400, 550, 100, 50);
        b2.setBounds(280, 550, 100, 50);
        b3.setBounds(520, 550, 100, 50);
        b1.setBackground(new Color(255, 204, 204));
        b2.setBackground(new Color(255, 255, 204));
        b3.setBackground(new Color(204, 255, 204));
        b1.setFont(font2);
        b2.setFont(font2);
        b3.setFont(font2);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        JLabel whole = new JLabel();
        whole.setBounds(0, 0, 810, 720);
        Icon icon = new ImageIcon(".\\src\\Images\\newS.png");
        whole.setIcon(icon);
        f1.add(whole);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("Back"))
        {
            f1.dispose();
            AdminInterface ai = new AdminInterface();
            ai.adminCommand();
        }

        if (e.getActionCommand().equalsIgnoreCase("Save"))
        {
            try
            {
                con = ConnectionProvider.getConnection();
                String query = "insert into students(RollNumber,name,class,Mobile,Gender,Email,FatherName,MotherName,Religion,Address,pin) values(?,?,?,?,?,?,?,?,?,?,?);";
                String name = t1.getText();
                int roll = Integer.parseInt(t2.getText());
                String cls = t3.getText();
                long mob = Long.parseLong(t4.getText());
                String email = t6.getText();
                String father = t7.getText();
                String mother = t8.getText();
                String rel = t9.getText();
                String add = t10.getText();
                int pin = Integer.parseInt(t5.getText());

                PreparedStatement pStmt = con.prepareStatement(query);
                pStmt.setInt(1, roll);
                pStmt.setString(2, name);
                pStmt.setString(3, cls);
                pStmt.setInt(4, (int) mob);
                pStmt.setString(5, gender);
                pStmt.setString(6, email);
                pStmt.setString(7, father);
                pStmt.setString(8, mother);
                pStmt.setString(9, rel);
                pStmt.setString(10, add);
                pStmt.setInt(11, pin);

                int row = pStmt.executeUpdate();
                if (row > 0)
                {
                    JFrame f2 = new JFrame();
                    JOptionPane.showMessageDialog(f2, "Student Added");
                }

                con.close();
                pStmt.close();
            }
            catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Same roll number of two students.");
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid details.");
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("Clear"))
        {
            if (!t1.getText().isEmpty() || !t2.getText().isEmpty()
                    || !t3.getText().isEmpty() || !t4.getText().isEmpty()
                    || !t5.getText().isEmpty() || !t6.getText().isEmpty()
                    || !t7.getText().isEmpty() || !t8.getText().isEmpty()
                    || !t9.getText().isEmpty() || !t10.getText().isEmpty())
            {
                try
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                }
                catch (Exception ae) {
                    throw new RuntimeException(ae);
                }
            }
        }
    }
}