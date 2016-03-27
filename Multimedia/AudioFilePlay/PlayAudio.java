// ������������ �����-�����.
import javax.sound.sampled.*;
import java.io.*;

public class PlayAudio
{
    public PlayAudio(String s) throws InterruptedException
    {
        play(s);
    }

    public void play(String file) throws InterruptedException
    {
        Clip line = null;
        try
        {
            // ������� ������, �������������� ����
            File f = new File(file);
            
            // �������� ���������� � ������� ������ �����
            AudioFileFormat aff = AudioSystem.getAudioFileFormat(f);
            
            // �������� ���������� � ������� ������ �����
            AudioFormat af = aff.getFormat();
            
            // �������� ��� ���������� ������, �������� �������� � ������
            DataLine.Info info = new DataLine.Info(Clip.class, af);
            
            // ���������, ����� �� ����������� ����� ������
            if (!AudioSystem.isLineSupported(info))
            {
                System.err.println("Line is not supported");
                System.exit(0);
            }
            
            // �������� ����� ����� � ������
            line = (Clip) AudioSystem.getLine(info);
            
            // ������� ����� ������ �� �����
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            
            // ��������� �����
            line.open(ais);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        // �������� ������������
        line.start();
        // ����� ���� ������� �������� �� ��������� ������������ ��� ���������� ��� ��������� �������
        Thread.sleep(10000);
        line.stop();
        // �� ��������� ������������ ��������� �����
        line.close();
    }

    public static void main(String[] args) throws InterruptedException
    {
        if (args.length != 1)
        {
            System.out.println("Usage: Java PlayAudio finename");
        }
        new PlayAudio(args[0]);
    }
}