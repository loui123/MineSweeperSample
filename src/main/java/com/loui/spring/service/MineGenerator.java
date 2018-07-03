package com.loui.spring.service;

import java.util.Arrays;
import java.util.Random;

public class MineGenerator {
    Random rand;
    
	public MineGenerator() {
		rand = new Random();
	}
	
	public int[] generate(int totalSize,int mineNumber) {
		int[] array = initSortedArray(totalSize);
		array = shuffleArray(array);
		return Arrays.copyOf(array, mineNumber);
	}

	private int[] shuffleArray(int[] array) {
		int totalSize = array.length;
		for(int i=0;i<totalSize;i++) {
			int newPosition = rand.nextInt(totalSize);
			int tempValue = array[i];
			array[i] = array[newPosition];
			array[newPosition] = tempValue;
		}
		return array;
	}

	private int[] initSortedArray(int totalSize) {
		int[] array = new int[totalSize-1];
		for(int i=0;i<array.length;i++) {
			array[i]=i;
		}
		return array;
	}
}
