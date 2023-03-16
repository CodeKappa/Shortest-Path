package model_bll;

public class ModelOut
{
	public int matrixRows;
	public int matrixColumns;
	public TileType [][] matrix;
	public int gap;
	public int squareSize;
	
	public ModelOut(int matrixRows, int matrixColumns, TileType[][] matrix) 
	{
		this.matrixRows = matrixRows;
		this.matrixColumns = matrixColumns;
		this.matrix = matrix;
		
		this.gap = 1;
		
		int max;
		if(matrixRows > matrixColumns) max = matrixRows;
		else max = matrixColumns;
		
		this.squareSize = (700 / max) - 1;
	}	
}
