package model_bll;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class ShortestPathModel 
{
	static final Tile [] adjacentNeighbours = {new Tile(-1,0), new Tile(0,1), new Tile(1,0), new Tile(0,-1)}; 
	static final Tile [] horseNeighbours = {new Tile(-2, 1), new Tile(-1, 2), new Tile(1, 2), new Tile(2, 1), new Tile(2, -1), new Tile(1, -2), new Tile(-1, -2), new Tile(-2, -1)}; 
	static Tile [] neighbours = horseNeighbours; 
	
	public static void changeNeighbours(String neighbour)
	{
		if(neighbour.equals("Horse Movement"))
			neighbours = horseNeighbours;
		else 
			neighbours = adjacentNeighbours;
	}
	
	static void makeMatrixBorder(TileType [][] matrix, int matrixRows, int matrixColumns)
	{
		for(int i = 0; i <= matrixRows+1; i++)
			matrix[i][0] = matrix[i][matrixColumns+1] = TileType.OBSTACLE;
		for(int i = 0; i <= matrixColumns+1; i++)
			matrix[0][i] = matrix[matrixRows+1][i] = TileType.OBSTACLE;
	}
	
	static int[] StringToInt (String input)
	{
		String[] strArray = input.split("\\s+");
		int[] intArray = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++) {
		    intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}
	
	public static Problem parseData(String input)
	{
		int [] arr = StringToInt(input);
		int row, col, index;
		
		index = 0;
		int matrixRows = arr[index++];
		int matrixColumns = arr[index++];
		Tile start = new Tile(arr[index], arr[index+1]);
		Tile finish= new Tile(arr[index+2], arr[index+3]);
		index += 4;
		
		TileType [][] matrix = new TileType[matrixRows+2][matrixColumns+2];
		
		for(int i = 1; i <= matrixRows; i++)
		{
			for(int j = 1; j <= matrixColumns; j++)
			{
				matrix[i][j] = TileType.EMPTY;
			}
		}
		
		if(arr.length % 2 == 1 || arr.length < 6) 
		{
			JOptionPane.showMessageDialog(null, "Invalid Input");
			return new Problem();
		}
		for(int i = 1; i <= (arr.length - 6) / 2; i++)
		{
			row = arr[index++];
			col = arr[index++];
			matrix[row][col] = TileType.OBSTACLE;
		}
		
		matrix[start.x][start.y] = TileType.START;
		matrix[finish.x][finish.y] = TileType.FINISH;
		
		makeMatrixBorder(matrix, matrixRows, matrixColumns);
		
		int [][] world = new int[matrixRows+2][matrixColumns+2];
		for(int i = 0; i <= matrixRows+1; i++)
		{
			for(int j = 0; j <= matrixColumns+1; j++)
			{
				if(matrix[i][j] == TileType.OBSTACLE)
					world[i][j] = -1;
				else
					world[i][j] = 0;
			}
		}
		
		return new Problem(start, finish, world, neighbours, matrixRows, matrixColumns);
	}
	
	public static ModelOut encodeData(int [][] world, Tile start, Tile finish, int rows, int columns)
	{
		Tile cCurent;
		int xAxis, yAxis;
		
		TileType [][] matrix = new TileType[rows+2][columns+2];
		
		for(int i = 0; i <= rows + 1; i++)
		{
			for(int j = 0; j <= columns + 1; j++)
			{
				if(world[i][j] == -1) matrix[i][j] = TileType.OBSTACLE;
				else matrix[i][j] = TileType.EMPTY;
				
			}
		}
		
		if(world[finish.x][finish.y] != 0)
		{
			int x = world[finish.x][finish.y];
			cCurent = new Tile (finish.x, finish.y);
			while(x != world[start.x][start.y])
			{
				for(int i = 0; i < neighbours.length; i++)
				{
					xAxis = cCurent.x + neighbours[i].x;
					yAxis = cCurent.y + neighbours[i].y;
					if(xAxis > 0 && xAxis <= rows && yAxis > 0 && yAxis <= columns && world[xAxis][yAxis] == x-1)
					{
						if(matrix[xAxis][yAxis] != TileType.FINISH)
							matrix[xAxis][yAxis] = TileType.PATH;
						x = world[xAxis][yAxis];
						cCurent.x = xAxis;
						cCurent.y = yAxis;
						break;
					}
				}
			}
		}
		
		matrix[start.x][start.y] = TileType.START;
		matrix[finish.x][finish.y] = TileType.FINISH;
		
		return new ModelOut(rows, columns, matrix);
	}
	
	public ModelOut findShortestPath(Problem problem)
	{
		int [][] maze = new int[problem.rows+2][problem.columns+2];
				
		maze = problem.world;
		
		Queue <Tile> queue = new LinkedList<Tile>();
		Tile cCurent;
		int xAxis, yAxis;
		
		queue.add(problem.start);
		maze[problem.start.x][problem.start.y] = 1;
		
		while(queue.isEmpty() == false && maze[problem.finish.x][problem.finish.y] == 0)
		{			
			cCurent = queue.remove();
			
			for(int i = 0; i < neighbours.length; i++)
			{
				xAxis = cCurent.x + neighbours[i].x;
				yAxis = cCurent.y + neighbours[i].y;
				if(xAxis > 0 && xAxis <= problem.rows && yAxis > 0 && yAxis <= problem.columns && maze[xAxis][yAxis] == 0)
				{
					maze[xAxis][yAxis] = maze[cCurent.x][cCurent.y] + 1;
					queue.add(new Tile(xAxis,yAxis));
				}
			}
		}
		
		return encodeData(maze, problem.start, problem.finish, problem.rows, problem.columns);
	}
	
	
	public String GenerateObstacles()
	{
		String string = new String("");
		int row,col;
		
		row = (int)(Math.random() * 100000000) % 100 + 10;
		col = (int)(Math.random() * 100000000) % 100 + 10;	
		
		int matrixRows = row;
		int matrixColumns = col;
		int nrObstacles = (int)(Math.random() * 100000000) % (matrixRows * matrixColumns / 2) + matrixRows * matrixColumns / 100;
		TileType [][] matrix = new TileType[matrixRows][matrixColumns];
		
		for(int i = 0; i < matrixRows; i++)
		{
			for(int j = 0; j < matrixColumns; j++)
			{
				matrix[i][j] = TileType.EMPTY;
			}
		}
				
		for(int i = 0; i < nrObstacles; i++)
		{
			row = (int)(Math.random() * 100000000) % matrixRows;
			col = (int)(Math.random() * 100000000) % matrixColumns;
			matrix[row][col] = TileType.OBSTACLE;
		}
		
		row = (int)(Math.random() * 100000000) % matrixRows;
		col = (int)(Math.random() * 100000000) % matrixColumns;	
		Tile start = new Tile(row, col);
		
		row = (int)(Math.random() * 100000000) % matrixRows;
		col = (int)(Math.random() * 100000000) % matrixColumns;
		Tile finish= new Tile(row, col);
		
		string += Integer.toString(matrixRows) + " " + Integer.toString(matrixColumns) + "\n\n";
		
		string += Integer.toString(start.x+1) + " " + Integer.toString(start.y+1) + "\n";
		string += Integer.toString(finish.x+1) + " " + Integer.toString(finish.y+1) + "\n\n";
		
		nrObstacles = 0;
		for(int i = 0; i < matrixRows; i++)
			for(int j = 0; j < matrixColumns; j++)
				if(matrix[i][j] == TileType.OBSTACLE)
					nrObstacles++;
		
		for(int i = 0; i < matrixRows; i++)
			for(int j = 0; j < matrixColumns; j++)
				if(matrix[i][j] == TileType.OBSTACLE)
					string += Integer.toString(i+1) + " " + Integer.toString(j+1) + "\n";
		
		return string;
	}
}
