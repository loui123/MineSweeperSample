package com.loui.spring.service.impl;

import java.util.Arrays;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;
import com.loui.spring.service.MineSweeperService;

public class MineSweeperServiceImpl implements MineSweeperService{
	
	public MineSweeperServiceImpl() {
		
	}
	
	@Override
	public MineSweeper createMineSweeper() {
		MineSweeper mineSweeper = new MineSweeper();
		return mineSweeper;
	}

	@Override
	public MineSweeper createMineSweeper(MapSize mapSize) {
		MineSweeper mineSweeper = new MineSweeper(mapSize);
		return mineSweeper;
	}

	@Override
	public void printMineSweeper(MineSweeper mineSweeper) {
		 for (int[] arr : mineSweeper.getMap()) {
	        System.out.println(Arrays.toString(arr));
	     }
	}
}
