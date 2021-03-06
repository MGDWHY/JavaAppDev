import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * ��� ��������� ������������� ������������� ��������� ��������� �������.
 * @version 1.00 2004-02-27
 * @author Cay Horstmann
 */
public class LocalInnerClassTest
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // ��������� ����������� �� ��� ���, ���� ������������
        // �� ������� �� ������ ��.
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * ����, ��������� ��������� ������� ����� ������������ ��������.
 */
class TalkingClock
{
    /**
     * ������ �����.
     * @param interval �������� ������� � ������������� ����� �����������
     * @param beep �������� true �������� �������� ������
     */
    public void start(int interval, final boolean beep)
    {
        class TimePrinter implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
