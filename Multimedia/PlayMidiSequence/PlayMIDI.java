// ������������ MIDI-�������������������
import javax.sound.midi.*;
import java.io.*;

public class PlayMIDI
{
    public PlayMIDI(String s) { play(s); }

    public void play(String file)
    {
        try
        {
            File f = new File(file);
            
            // �������� ��������� ��-���������
            Sequencer sequencer = MidiSystem.getSequencer();
            
            // ���������, ������� �� ���������
            if (sequencer == null)
            {
                System.err.println("Sequencer is not supported");
                System.exit(0);
            }
            
            // ��������� ���������
            sequencer.open();
            
            // �������� MIDI-������������������ �� �����
            Sequence seq = MidiSystem.getSequence(f);
            
            // ���������� ������������������ � ���������
            sequencer.setSequence(seq);
            
            // �������� ������������
            sequencer.start();
            
            // ����� ���� ������� �������� �� ����� ������������, � ����� ����������
            Thread.sleep(sequencer.getTickLength());
            sequencer.stop();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        String s = "doom.mid";
        if (args.length > 0)
            s = args[0];
        new PlayMIDI(s);
    }
}