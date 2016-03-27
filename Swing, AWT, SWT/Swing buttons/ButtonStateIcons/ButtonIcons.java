// ����������� ���������� ��� ����������� �� ������
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class ButtonIcons implements ActionListener
{
  
    private JLabel jlab;   
    private JButton jbtnFirst; 
    private JButton jbtnSecond; 
  
    public ButtonIcons()
    {
        // �������� ����������, ������������ JButton.
        ImageIcon myIcon = new ImageIcon("myIcon.gif"); 
        ImageIcon myDisIcon = new ImageIcon("myDisIcon.gif"); 
        ImageIcon myROIcon = new ImageIcon("myROIcon.gif"); 
        ImageIcon myPIcon = new ImageIcon("myPIcon.gif"); 
  
        // �������� ������ ���������� JFrame.
        JFrame jfrm = new JFrame("Use Button Icons");  
  
        // ��������� ���������� ���������� FlowLayout.
        jfrm.getContentPane().setLayout(new FlowLayout());  
  
        // ��������� ���������� ������� ������.
        jfrm.setSize(220, 100);  
  
        // ���������� ��������� ��� �������� ���������� �������������.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        // �������� ��������� �����.
        jlab = new JLabel("Press a button.");  
  
        // �������� ���� ������. ��� ��� �������� ����������� �� ���������.
        jbtnFirst = new JButton("First", myIcon);  
        jbtnSecond = new JButton("Second", myIcon);  
 
        // ��������� �����������, ������������� ��� ��������� �� ������ ������� ����.
        jbtnFirst.setRolloverIcon(myROIcon); 
        jbtnSecond.setRolloverIcon(myROIcon); 
  
        // ��������� �����������, ������������� �� ���������������� ������.
        jbtnFirst.setPressedIcon(myPIcon); 
        jbtnSecond.setPressedIcon(myPIcon); 
 
        // ��������� �����������, ������������� �� ������������������ ������.
        jbtnFirst.setDisabledIcon(myDisIcon); 
        jbtnSecond.setDisabledIcon(myDisIcon); 
 
        // ���������� � �������� ������������ �������.
        jbtnFirst.addActionListener(this); 
        jbtnSecond.addActionListener(this); 
  
        // ��������� ������ � ������ ������ �����������.
        jfrm.getContentPane().add(jbtnFirst);   
        jfrm.getContentPane().add(jbtnSecond);   
  
        // ��������� ����� � ������ ������ �����������.
        jfrm.getContentPane().add(jlab);
  
        // ����������� ������.
        jfrm.setVisible(true);  
    }
  
    // ��������� ������� ������
    public void actionPerformed(ActionEvent ae)
    {
     
        if (ae.getActionCommand().equals("First"))
        {
            jlab.setText("First button was pressed.");  
            if (jbtnSecond.isEnabled())
            {
                jlab.setText("Second button is disabled.");
                jbtnSecond.setEnabled(false);
            }
            else
            {
                jlab.setText("Second button is enabled.");
                jbtnSecond.setEnabled(true);
            }
        }
        else
        {
            jlab.setText("Second button was pressed. ");
        }
    }
  
    public static void main(String args[])
    {
        // �������� ������ � ������ ��������� �������.
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonIcons();
            }
        });
    }
}