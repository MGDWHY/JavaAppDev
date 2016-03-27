/* ������� ������, ������� ������������� �����
�������� � ���� � ������� ������. */

import java.awt.*;
import java.applet.*;
/*
<applet code="Sample" width="300" height="50">
</applet>
 */

public class Sample extends Applet
{
    private String msg;

    // ������������� ���� �������� � ����
    @Override public void init()
    {
        setBackground(Color.cyan);
        setForeground(Color.red);
        msg = "Inside init() --";
    }

    // �������������� ������ ��� ������
    @Override public void start()
    {
        msg += " Inside start() --";
    }

    // ���������� msg � ���� �������
    @Override public void paint(Graphics g)
    {
        msg += " Inside paint().";
        g.drawString(msg, 10, 30);
    }
}
