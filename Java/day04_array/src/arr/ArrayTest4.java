package arr;
import java.util.*;

public class ArrayTest4 {
	public static void main(String[] args) {
		int[][] arr = new int[2][3];
		int i=0,j=0;
		
		for(i=0;i<2;i++){
			for(j=0;j<3;j++){
				arr[i][j]=i+j;
			}
		}
		
		for(i=0;i<arr.length;i++){			// �� arr.length 
			for(j=0;j<arr[0].length;j++){	// �� arr[0].length -> c���� �ٸ��� ���ϴ�.
				System.out.print("arr["+i+"]["+j+"] = "+arr[i][j]+"\t");
			}
			System.out.println("");
		}
		
	}
}