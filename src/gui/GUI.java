package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import utility.Utility;

public class GUI extends JFrame {

	private JPanel contentPane;
	private int[] array;
	private JLabel[] labelsArray = new JLabel[100];
	private Utility utility = new Utility();
	
	private JButton bubbleSortButton;
	private JButton selectionSortButton;
	private JButton quickSortButton;
	private JButton newArrayButton;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public GUI() {
		
		setTitle("Visualization of algorithms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 720);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		First array initialization 
		array = utility.getRandomArray();
		for (int i = 0; i < array.length; i++) {
			JLabel label = new JLabel(String.valueOf(array[i]));
			label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			label.setBackground(Color.LIGHT_GRAY);
			label.setOpaque(true);
			label.setBorder(new LineBorder(Color.black, 3));
			label.setBounds(i * 19 + 5, getSize().height - array[i] * 5 - 40, 17, array[i] * 5);
			labelsArray[i] = label;
			contentPane.add(label);
		}
		
//		Font
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		
//		Buttons
		bubbleSortButton = new JButton("Bubble Sort");
		bubbleSortButton.setBounds(100, 50, 150, 50);
		bubbleSortButton.setFont(font);
		bubbleSortButton.setFocusable(false);
		bubbleSortButton.addActionListener((e) -> utility.bubbleSort(array, this));
		contentPane.add(bubbleSortButton);
		
		selectionSortButton = new JButton("Selection Sort");
		selectionSortButton.setBounds(300, 50, 150, 50);
		selectionSortButton.setFont(font);
		selectionSortButton.setFocusable(false);
		selectionSortButton.addActionListener((e) -> utility.selectionSort(array, this));
		contentPane.add(selectionSortButton);
		
		quickSortButton = new JButton("Quick Sort");
		quickSortButton.setBounds(500, 50, 150, 50);
		quickSortButton.setFont(font);
		quickSortButton.setFocusable(false);
		quickSortButton.addActionListener((e) -> utility.quickSort(array, 0, array.length - 1, this));
		contentPane.add(quickSortButton);
		
		newArrayButton = new JButton("New Array");
		newArrayButton.setBounds(1650, 50, 150, 50);
		newArrayButton.setFont(font);
		newArrayButton.setFocusable(false);
		newArrayButton.addActionListener((e) -> {
			
			array = utility.getRandomArray();
			repaintArray();
			
		});
		contentPane.add(newArrayButton);
		
	}
	
	public JLabel getJLabel(int index) {
		return labelsArray[index];
	}
	
	public void repaintArray() {
		for (int i = 0; i < labelsArray.length; i++) {
			labelsArray[i].setText(String.valueOf(array[i]));
			labelsArray[i].setBounds(i * 19 + 5, getSize().height - array[i] * 5 - 40, 17, array[i] * 5);
			labelsArray[i].setBackground(Color.LIGHT_GRAY);
		}
		repaint();
	}

	public void disableButtons() {
		bubbleSortButton.setEnabled(false);
		selectionSortButton.setEnabled(false);
		quickSortButton.setEnabled(false);
		newArrayButton.setEnabled(false);
	}
	
	public void enableButtons() {
		bubbleSortButton.setEnabled(true);
		selectionSortButton.setEnabled(true);
		quickSortButton.setEnabled(true);
		newArrayButton.setEnabled(true);
	}
}

