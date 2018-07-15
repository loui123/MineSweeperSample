package com.loui.spring.service.impl;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;
import com.loui.spring.service.MineSweeperService;

public class MineSweeperServiceImpl implements MineSweeperService{
	
	public MineSweeperServiceImpl() {
		
	}
	
	@Override
	public MineSweeper createMineSweeper() {
		return new MineSweeper();
	}

	@Override
	public MineSweeper createMineSweeper(MapSize mapSize) {
		return new MineSweeper(mapSize);
	}
}
