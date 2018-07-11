package com.loui.spring.service;

/*
* In the two dimension Map, 
*    the 0 value means the safe field.
*    the 1~8 value means the tip field.
*    the 9 value means the mine field.
*/
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
		setMinesAndAnswers(minePositions, map);
		return map;
	}

	private void setMinesAndAnswers(int[] minePositions, int[][] map) {
		for(int i=0;i<minePositions.length;i++) {
			int xDimension = minePositions[i] % xSize;
			int yDimension = minePositions[i] / xSize;
			map[yDimension][xDimension] = 9;
			setAnswers(map, xDimension, yDimension);
		}
	}

	private void setAnswers(int[][] map, int xDimension, int yDimension) {
		calculateAnswer(map, xDimension-1, yDimension);
		calculateAnswer(map, xDimension+1, yDimension);
		calculateAnswer(map, xDimension, yDimension+1);
		calculateAnswer(map, xDimension, yDimension-1);
		calculateAnswer(map, xDimension-1, yDimension-1);
		calculateAnswer(map, xDimension+1, yDimension-1);
		calculateAnswer(map, xDimension-1, yDimension+1);
		calculateAnswer(map, xDimension+1, yDimension+1);
	}

	private void calculateAnswer(int[][] map, int x, int y) {
		if(x<0 || y<0 || x>=xSize || y>=ySize || map[y][x] == 9) return;
		map[y][x]++;
	}
}
