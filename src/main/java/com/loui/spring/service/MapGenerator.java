package com.loui.spring.service;

public class MapGenerator {
	private final int xSize;
	private final int ySize;
	private final int mineNumber;
	
	public MapGenerator(int xSize,int ySize,int mineNumber) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.mineNumber = mineNumber;
	}

	public int[][] generate() {
		MineGenerator mineGenerator = new MineGenerator();
		int[][] map = new int[ySize][xSize];
		int[] minePositions = mineGenerator.generate(xSize * ySize, mineNumber);
		setMines(minePositions, map);
		return map;
	}

	private void setResultNumber(int[][] map, int x, int y)
	{
		if(x<0 || y<0 || x>=xSize || y>=ySize || map[y][x] == 9) return;
		map[y][x]++;
	}

	private void setMines(int[] minePositions, int[][] map) {
		for(int i=0;i<minePositions.length;i++) {
			int xDimension = minePositions[i] % xSize;
			int yDimension = minePositions[i] / xSize;
			map[yDimension][xDimension] = 9;
			setResultNumber(map, xDimension-1, yDimension);
			setResultNumber(map, xDimension+1, yDimension);
			setResultNumber(map, xDimension, yDimension+1);
			setResultNumber(map, xDimension, yDimension-1);
			setResultNumber(map, xDimension-1, yDimension-1);
			setResultNumber(map, xDimension+1, yDimension-1);
			setResultNumber(map, xDimension-1, yDimension+1);
			setResultNumber(map, xDimension+1, yDimension+1);
		}
	}
}