package com.loui.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.loui.spring.model.MapSize;
import com.loui.spring.model.MineSweeper;
import com.loui.spring.service.impl.MineSweeperServiceImpl;

public class MineSweeperServiceTest {

	MineSweeperServiceImpl mineSweeperService;
	
    @Before
    public void setup() {
    	mineSweeperService = new MineSweeperServiceImpl();
    }
    
	@Test
	public void mineSweeperInDefaultSmallMap() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper();
		int[][] maps = mineSweeper.getMap();
		assertEquals("Small Map - y size is 9", maps.length, 9);
		assertEquals("Small Map - x size is 9",  maps[0].length, 9);
	}

	@Test
	public void mineSweeperInSmallMap() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper(MapSize.SMALL);
		int[][] maps = mineSweeper.getMap();
		assertEquals("Small Map - y size is 9", maps.length, 9);
		assertEquals("Small Map - x size is 9",  maps[0].length, 9);
	}
	
	@Test
	public void mineSweeperInMiddelMap() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper(MapSize.MIDDLE);
		int[][] maps = mineSweeper.getMap();
		assertEquals("Middle Map - y size is 16",  maps.length, 16);
		assertEquals("Middle Map - x size is 16",  maps[0].length, 16);
	}

	@Test
	public void mineSweeperInLargeMap() {
		MineSweeper mineSweeper = mineSweeperService.createMineSweeper(MapSize.LARGE);
		int[][] maps = mineSweeper.getMap();
		assertEquals("Large Map - y size is 16",  maps.length, 16);
		assertEquals("Large Map - x size is 30",  maps[0].length, 30);
	}
}
