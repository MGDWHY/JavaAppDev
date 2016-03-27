// GetData.java :   ��������� ��������� ������ �� ������ ByteBuffer
import java.nio.*;

public class GetData
{
    private static final int BSIZE = 1024;

    public static void main(String[] args)
    {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // ��� ��������� ����� ����������� ������
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                System.out.println("nonzero");
        System.out.println("i = " + i);
        bb.rewind();
        // ��������� � ��������� ���������� ������
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.println(c + " ");
        System.out.println();
        bb.rewind();
        // ��������� � ��������� ����� ���� short:
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());
        bb.rewind();
        // ��������� � ��������� ����� ���� int:
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();
        // ��������� � ��������� ����� ���� long:
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();
        // ��������� � ��������� ����� ���� float:
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();
        // ��������� � ��������� ����� ���� double:
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
/* Output:
i = 1025
H o w d y !
12390
99471142
99471142
9.9471144E7
9.9471142E7
*///:~
