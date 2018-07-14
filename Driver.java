
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	
	Matrix mat1= getMatrix("matrix 1");
	Matrix mat2= getMatrix("matrix 2");
	
	Matrix mat3 =doOperation(mat1, mat2);
	String output = mat3.turnToString(mat3.elements);
	
	
	System.out.print(" \nmat 1"+mat1.turnToString(mat1.elements));
	System.out.print(" \nmat 2"+ mat2.turnToString(mat2.elements));
	System.out.print("\noutput"+output);
	
}
	static Matrix doOperation(Matrix mat1 , Matrix mat2) {
		
		Scanner input = new Scanner(System.in);
		
		boolean notValid = true;
		do{
			System.out.print("select number for operation: 1)addition 2)subtraction 3)dot product 4)hadmard product"); 
			int option = input.nextInt();
			if(option==1 || option==2 || option==4) {
				if(mat1.equalDimension(mat1, mat2)) {
					switch(option) {
					case 1: return mat1.add(mat2);
						
					case 2: return mat1.sub(mat2);
						
					case 4: return mat1.hadamard(mat2);
								
					}
					
				}
				else { 
                   		mat1= getMatrix("Matrix 1 next try");
					    mat2= getMatrix("Matrix 2 next try");
					 }	
				}
			else if(option == 3) {
					
					if(mat1.dotProductValidity(mat1,mat2)) {
						
						return mat1.dotProduct(mat2);
						
					}
               else { 
                   		mat1= getMatrix("Matrix 1");
					    mat2= getMatrix("Matrix 2");}
						
			}
				
			else {
					 
					 notValid=true;
				}
			
		
		} while(notValid);
		
	return null;	
	}
	static Matrix getMatrix(String name) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter row, columns respectively for: "+ name);
		int a= input.nextInt();
		int b= input.nextInt();

		return (new Matrix(a,b));
	}
}
