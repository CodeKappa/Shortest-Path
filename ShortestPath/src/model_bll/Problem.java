package model_bll;

public class Problem 
{
	public int [][] world;
	public Tile start;
	public Tile finish;
	public Tile [] neighbours;
	public int rows;
	public int columns;
	
	public Problem(Tile start, Tile finish, int [][] world, Tile [] neighbours, int rows, int columns)
	{
		this.start = start;
		this.finish = finish;
		this.world = world;
		this.neighbours = neighbours;
		this.rows = rows;
		this.columns = columns;
	}
	
	public Problem()
	{
		this.start = null;
		this.finish = null;
		this.world = null;
		this.neighbours = null;
		this.rows = 0;
		this.columns = 0;
		
	}
}
