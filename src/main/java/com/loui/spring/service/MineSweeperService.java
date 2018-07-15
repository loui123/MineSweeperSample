package com.loui.spring.service;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;

public interface MineSweeperService {
	public MineSweeper createMineSweeper();

	public MineSweeper createMineSweeper(MapSize mapSize);
}
