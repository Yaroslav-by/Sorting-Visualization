package utility;

import java.awt.Color;
import java.util.Random;

import gui.GUI;

public class Utility extends Thread {

	public int[] getRandomArray() {
		
		Random random = new Random();
		int[] array = new int[100];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(1, 100);
		}
		
		return array;
	}
	
	public void bubbleSort(int[] array, GUI gui) {
		
		gui.disableButtons();
		Thread thread = new Thread(() -> {
			for (int i = 0; i < array.length; i++) {
				for (int j = array.length - 1; j > i; j--) {
					try {
						gui.getJLabel(j).setBackground(Color.red);	
						Thread.sleep(40);
						if (array[j] < array[j - 1]) {
							swap(array, j, j - 1);
						}
						gui.repaintArray();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
			gui.enableButtons();
		});
		
		thread.start();
		
	}
	
	public void selectionSort(int[] array, GUI gui) {
		Thread thread = new Thread(() -> {
			gui.disableButtons();
			for (int i = 0; i < array.length - 1; i++) {
				int min = array[i];
				for (int j = i + 1; j < array.length; j++) {
					try {
						gui.getJLabel(j).setBackground(Color.red);
						Thread.sleep(40);
						if (array[j] < min) {
							min = array[j];
							array[j] = array[i];
							array[i] = min;
						}
						gui.repaintArray();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			gui.enableButtons();
		});
		thread.start();
	}
	
	public void quickSort(int[] array, int from, int to, GUI gui) {
		gui.disableButtons();
		Thread thread = new Thread(() -> {
			if (from < to) {
				int divideIndex = partision(array, from, to, gui);
				quickSort(array, from, divideIndex - 1, gui);
				quickSort(array, divideIndex, to, gui);		
			}
			gui.enableButtons();
		});
		
		thread.start();

	}
	
	private int partision(int[] array, int from, int to, GUI gui) {
		int leftIndex = from;
		int rightIndex = to;
		int pivot = array[from + (to - from) / 2];
		gui.getJLabel(from + (to - from) / 2).setBackground(Color.red);
		
		while (leftIndex <= rightIndex) {
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while (array[leftIndex] < pivot) {
				leftIndex++;
			}
			
			while (array[rightIndex] > pivot) {
				rightIndex--;
			}
			
			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
			
			gui.repaintArray();
			
		}
		return leftIndex;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
}
