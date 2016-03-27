/**
   ������ ��� ��������� ��������.
   @version 1.22 2004-05-07
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.net.*;
import javax.swing.*;

public class Bookmark extends JApplet 
{
    public void init()
    {
        Box box = Box.createVerticalBox();
        ButtonGroup group = new ButtonGroup();

        int i = 1;
        String urlString;

        // ������ ���������� link.n
        while ((urlString = getParameter("link." + i)) != null)
        {
            try
            {
                final URL url = new URL(urlString);
                // �������� ������������� ��� ������ ������.
                JRadioButton button = new JRadioButton(urlString);
                box.add(button);
                group.add(button);
                // ����� ������������� �������� � �����������
                // � ������ ������ ���������������� ���������.
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        AppletContext context = getAppletContext();
                        context.showDocument(url, "right");
                    }
                });
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            i++;
        }
        add(box);
    }
}