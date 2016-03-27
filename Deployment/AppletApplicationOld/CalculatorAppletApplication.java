/**
   ����� � ������ ������!
   @version 1.31 2004-05-07
   @author Cay Horstmann
*/

/*
  ���� ��� ���������� ������� ������������ ���������
  appletviewer, �� ��� ��������� ��������� ���� �����������.
  
  <applet code="CalculatorAppletApplication.class" width="200" height="200">
  </applet>
*/

import javax.swing.*;

public class CalculatorAppletApplication extends CalculatorApplet
// ���������, ���������� ������������ � ��������, � �����������.
{
    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT = 200;
   
    public static void main(String[] args)
    {
        AppletFrame frame = new AppletFrame(new CalculatorApplet());
        frame.setTitle("CalculatorAppletApplication");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}