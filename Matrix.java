import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

public class Matrix {
	//fields
	
	final int row;
	final int col;
	 
	final int[][] elements;
	
	Matrix(){
		this(2,2);
		
	}
	Matrix(int row, int col){
		
		this.col=col;
		this.row=row;
		this.elements= IntStream.range(0, row).mapToObj(i -> new Random().ints(col,-100, 100).toArray()).toArray(int[][]:: new);
		
	}
	
	Matrix(int[][] input){
		this.row= input.length;
		this.col=input[0].length;
		this.elements = Arrays.stream(input).map(i -> Arrays.copyOf(i,i.length)).toArray(int[][]::new);
		
		
	}
	public Matrix add(Matrix otherMatrix) {
	 return new Matrix(IntStream.range(0,row).mapToObj(i -> IntStream.range(0, col).map(j -> elements[i][j]+ otherMatrix.elements[i][j]).toArray()).toArray(int[][]::new));
	
	}
	public Matrix sub(Matrix otherMatrix){
		return new Matrix(IntStream.range(0,row).mapToObj(i -> IntStream.range(0, col).map(j -> elements[i][j]- otherMatrix.elements[i][j]).toArray()).toArray(int[][]::new));
	}
	public Matrix dotProduct(Matrix input) {
		return new Matrix(IntStream.range(0,this.row ).mapToObj(x -> IntStream.range(0,input.col).map(y -> IntStream.range(0, this.col)
				
				.map(z -> this.elements[x][z] * input.elements[z][y]).reduce(0,(a,b)-> a+b)).toArray()).toArray(int[][]::new));
		
	}
	public Matrix hadamar(Matrix otherMatrix) {
		return new Matrix(IntStream.range(0,this.row).mapToObj(x -> IntStream.range(0,otherMatrix.col).map(y -> this.elements[x][y]* otherMatrix.elements[x][y]).reduce(0,(a,b)-> a+b)).toArray()).toArray(int[][]::new));
		
	}
	public String turnToString(int[][] elements) {
		
		return ( Arrays.stream(elements).map(x -> Arrays.stream(x).mapToObj(y -> String.format("%6d", y)).reduce("\n",(a,b) -> a+b)).reduce("\n",(a,b) -> a+b));
	}
	public boolean equalDimension(Matrix mat1, Matrix mat2) {
		return (mat1.col == mat2.col && mat1.row == mat2.row);
		
	}
	public boolean dotProductValidity(Matrix mat1, Matrix mat2){
		return (mat1.col == mat2.row);
		
	}
	@Override
	public Matrix clone() throws CloneNotSupportedException
	{
		return new Matrix(this.elements);
	}
	
	public boolean equalArrays(Matrix otherMatrix) {
		return(Arrays.equals(elements, otherMatrix.elements));
		
	}
}
