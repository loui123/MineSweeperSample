package com.loui.spring.model;

import com.loui.spring.service.MineGenerator;
/*
 * The MapSize means,
 * 		9 x 9 cells, 10 mines for "SMALL" game.
 * 		16 x 16 cells, 40 mines for "MIDDLE" game.
 * 		30 x 16 cells, 99 mines for "LARGE" game.
 * 
 * In the two dimension Map, 
 *    the 0 value means the safe field.
 *    the 1 value means the mine field.
 */
public class MineSweeper {
	private int[][] map = new int[9][9];
	
	public MineSweeper(MapSize mapSize){
		switch(mapSize) {
			case SMALL:
				asSmallCase();
				break;
			case MIDDLE:
				asMiddleCase();
				break;
			case LARGE:
				asLargeCase();
				break;
		}
	}

	public MineSweeper(){
		asSmallCase();
	}

	public int[][] getMap() {
		return map;
	}

	private void asSmallCase() {
		MineGenerator mineGenerator = new MineGenerator();
		map = new int[9][9];
		int[] minePositions = mineGenerator.generate(81, 10);
		setMines(minePositions, 9, 9);
	}

	private void asMiddleCase() {
		MineGenerator mineGenerator = new MineGenerator();
		map = new int[16][16];
		int[] minePositions = mineGenerator.generate(256, 40);
		setMines(minePositions, 16, 16);
	}

	private void asLargeCase() {
		MineGenerator mineGenerator = new MineGenerator();
		map = new int[30][16];
		int[] minePositions = mineGenerator.generate(480, 99);
		setMines(minePositions, 30, 16);
	}

	private void setMines(int[] minePositions, int xSize, int ySize) {
		for(int i=0;i<minePositions.length;i++) {
			int xDimension = minePositions[i] % xSize;
			int yDimension = minePositions[i] / ySize;
			map[xDimension][yDimension] = 1;
		}
	}
}
