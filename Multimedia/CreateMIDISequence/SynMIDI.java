// �������� MIDI-������������������
import javax.sound.midi.*;
import java.io.*;

public class SynMIDI
{
    public SynMIDI() { play(synth()); }

    public Sequence synth()
    {
        Sequence seq = null;
        try
        {
            // ������������������ ����� ����������� �� 10 MIDI-������� �� ���� ������������� � ��������
            seq = new Sequence(Sequence.PPQ, 10);
            
            // ������� � ������������������ ���� �������
            Track tr = seq.createTrack();
            for (int k = 0; k < 100; k++)
            {
                ShortMessage msg = new ShortMessage();
                // ��������� MIDI-���� �� ������ 10 �� 109
                msg.setMessage(ShortMessage.NOTE_ON, 10 + k, 93);
                // ����� ����������� ���� ����� ������ 5 ��������
                tr.add(new MidiEvent(msg, 5*k));
                msg = null;
            }
        }
        catch (Exception e)
        {
            System.err.println("From synth(): " + e);
            System.exit(0);
        }
        return seq;
    }

    public void play(Sequence seq)
    {
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            if (sequencer == null)
            {
                System.err.println("Sequencer is not supported");
                System.exit(0);
            }
            sequencer.open();
            sequencer.setSequence(seq);
            sequencer.startRecording();
            int[] type = MidiSystem.getMidiFileTypes(seq);
            MidiSystem.write(seq, type[0], new File("gammas.mid"));
        }
        catch (Exception e)
        {
            System.err.println("From play(): " + e);
        }
    }

    public static void main(String[] args)
    {
        new SynMIDI();
    }
}