// ����������� �����-������
import javax.sound.sampled.*;
import java.io.*;

public class PlayAudioLine
{
    public PlayAudioLine(String s) { play(s); }

    public void play(String file)
    {
        SourceDataLine line = null;
        AudioInputStream ais = null;
        byte[] b = new byte[2048];  // ����� ������
        try
        {
            File f = new File(file);
            
            // ������� ������� ����� ������ �� ����� f
            ais = AudioSystem.getAudioInputStream(f);
            
            // ��������� �� ������ ���������� � ������� ������ �����
            AudioFormat af = ais.getFormat();
            
            // ������� ��� ���������� � ������ info
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            
            // ���������, �������� �� ����� ������ ������ �����
            if (!AudioSystem.isLineSupported(info))
            {
                System.err.println("Line is not supported");
                System.exit(0);
            }
            
            // �������� ������� �����
            line = (SourceDataLine) AudioSystem.getLine(info);
            
            // ��������� �����
            line.open(af);
            
            // �������� ������������
            line.start();
            
            // ���� ��������� ������ � ������
            int num = 0;
            
            // ��� �� ����� ��������� �����
            while ((num = ais.read(b)) != -1)
            {
                line.write(b, 0, num);
            }
            
            // "�������" �����, ���������� ������� �����
            line.drain();
            
            // ��������� �����
            ais.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        
        // ������������� ������������
        line.stop();
        
        // ��������� �����
        line.close();
    }

    public static void main(String[] args)
    {
        String s = "gong.wav";
        if (args.length > 0)
        {
            s = args[0];
        }
        new PlayAudioLine(s);
    }
}