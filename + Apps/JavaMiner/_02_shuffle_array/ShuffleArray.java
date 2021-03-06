class ShuffleArray{
    
    public static final int MR = 10;
    public static final int MC = 10;
    int status = 0; // ������ ������ ����
    int nMin = 0; // ��� ������������ ���
    int nFlag = 0; // ���� �� ���������
    
    public static void main(String[] args){
        
        int row,col;
        int[][] Pole  = new int[MR+2][MC+2]; 

        for(row = 0; row <= MR+1; row++)
            for(col = 0; col <= MC+1; col++)
                Pole[row][col] = -3;		
        
        for(row = 1; row <= MR; row++)
            for(col = 1; col <= MC; col++)
                Pole[row][col] = 0;
	
	int n = 0; // ���������� ���
	M1:
	for(row = 1; row <= MR; row++){
	    for(col = 1; col <= MC; col++){
		double rand = Math.random(); // ���������� ��������� �����    
		Pole[row][col] = (int)(10*rand % MR);
		if(Pole[row][col] == 9){
			n++;
		}
		if(n == 10) break M1;
	    }
	}

        // �������� ���������� ��� � �������� �������
        int k;
        for(row = 1; row <= MR; row++)
            for(col = 1; col <= MC; col++)
                if(Pole[row][col] != 9){
                    k = 0;
                    if(Pole[row-1][col-1] == 9) k++;
                    if(Pole[row-1][col] == 9) k++;
                    if(Pole[row-1][col+1] == 9) k++;
                    if(Pole[row][col-1] == 9) k++;
                    if(Pole[row][col+1] == 9) k++;
                    if(Pole[row+1][col-1] == 9) k++;
                    if(Pole[row+1][col] == 9) k++;
                    if(Pole[row+1][col+1] == 9) k++;
                    Pole[row][col] = k;
                }
	
        // ����� �������
        for(row = 0; row <= MR+1; row++){
            for(col = 0; col <= MC+1; col++){
                System.out.print(Pole[row][col]+" ");
            }
            System.out.println();
        }
        
    }
    
}