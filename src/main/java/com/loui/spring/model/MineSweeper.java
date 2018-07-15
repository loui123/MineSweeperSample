package com.loui.spring.model;

import com.loui.spring.service.MapGenerator;

/*
 * The MapSize means,
 * 		9 x 9 cells, 10 mines for "SMALL" game.
 * 		16 x 16 cells, 40 mines for "MIDDLE" game.
 * 		30 x 16 cells, 99 mines for "LARGE" game.
 * 
 * In the two dimension Map, 
 *    the 0 value means the safe field.
 *    the n value means the tip field.
 *    the 9 value means the mine field.
 */
public class MineSweeper {
	private int[][] map;

	public MineSweeper(MapSize mapSize) {
		switch (mapSize) {
			case SMALL:
				map = setMap(9, 9, 10);
				break;
			case MIDDLE:
				map = setMap(16, 16, 40);
				break;
			case LARGE:
				map = setMap(30, 16, 99);
				break;
		}
	}

	public MineSweeper() {
		map = setMap(9, 9, 10);
	}

	public int[][] getMap() {
		return map;
	}

	private int[][] setMap(int xSize, int ySize, int mineNumber) {
		MapGenerator mapGenerator = new MapGenerator(xSize, ySize, mineNumber);
		return mapGenerator.generate();
	}
}
