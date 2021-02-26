package edu.scu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
	//public static final int UP = 0;
	//public static final int DOWN=1;
	//public static final int LEFT=2;
	//public static final int RIGHT=3;
	
	int map[][];
	int winCondition=2048;
	int score=0;
	
	Game(){
		map = new int[4][4];
	}
	
	Game(int[][] data) {
		map=data;
	}
	
	Game(int winC){
		winCondition=winC;
	}
	Game(int[][] data, int winC){
		map=data;
		winCondition=winC;
	}
	
	public void randomGenerate() {
		List<int[]> positions = new ArrayList<int[]>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j]==0) {
					positions.add(new int[] {i,j});
				}
			}
		}
		if(positions.size()>0) {
			int[] random = positions.get((int)(Math.random()*positions.size()));
			map[random[0]][random[1]]=2;
		}
	}
	
	public void moveLeft() {
		mergeAndMoveLeft();
		randomGenerate();
		updateScore();
	}
	public void moveRight() {
		mergeAndMoveRight();
		randomGenerate();
		updateScore();
	}
	public void moveUp() {
		mergeAndMoveUp();
		randomGenerate();
		updateScore();
	}
	public void moveDown() {
		mergeAndMoveDown();
		randomGenerate();
		updateScore();
	}
	
	private int[] merge4Numbers(int[] nums) {
		//input numbers of a line or column, merge to the left, if the adjacent elements are equal
		int res[] = new int[4];
		int pos=0;
		List<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<4;i++) {
			if(nums[i]!=0)
				list.add(nums[i]);
		}
		while(list.size()>0) {
			if(list.size()==1) {
				res[pos++]=list.get(0);
				list.remove(0);
				continue;
			}
			else if(list.get(0)==list.get(1)) {
				//merge 2 numbers,then pop out two numbers in the list
				res[pos++]=list.get(0)*2;
				list.remove(1);
				list.remove(0);
			}
			else {
				res[pos++]=list.get(0);
				list.remove(0);
			}
		}
		
		
		return res;
	}
	
	private void updateScore() {
		int sum=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sum+=map[i][j];
			}
		}
		score=sum;
	}
	
	private void mergeAndMoveLeft() {
		for(int i=0;i<4;i++) {
			int line[] = new int[4];
			for(int j=0,k=0;j<4;j++) { //from left to right
				line[k++]=map[i][j];
			}
			int res[] = merge4Numbers(line);
			for(int j=0,k=0;j<4;j++) {
				map[i][j]=res[k++];
			}
		}
	}
	
	private void mergeAndMoveRight() {
		for(int i=0;i<4;i++) {
			int line[] = new int[4];
			for(int j=3,k=0;j>=0;j--) { //from right to left
				line[k++]=map[i][j];
			}
			int res[] = merge4Numbers(line);
			for(int j=3,k=0;j>=0;j--) {
				map[i][j]=res[k++];
			}
		}
	}
	
	private void mergeAndMoveUp() {
		for(int j=0;j<4;j++) {
			int line[] = new int[4];
			for(int i=0,k=0;i<4;i++) { //from top to bottom
				line[k++]=map[i][j];
			}
			int res[] = merge4Numbers(line);
			for(int i=0,k=0;i<4;i++) {
				map[i][j]=res[k++];
			}
		}
	}
	
	private void mergeAndMoveDown() {
		for(int j=0;j<4;j++) {
			int line[] = new int[4];
			for(int i=3,k=0;i>=0;i--) { //from bottom to top
				line[k++]=map[i][j];
			}
			int res[] = merge4Numbers(line);
			for(int i=3,k=0;i>=0;i--) {
				map[i][j]=res[k++];
			}
		}
	}
	
	
	
	public boolean isGameWin() {
		//if there is an element=winCondition, player win.
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j]==winCondition) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isGameLose() {
		//if the map is full and no matter which direction the player move to, the map is still the same, then player lose.
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j]==0)
					return false;
			}
		}
		if(isCantMove())
			return true;
		return false;
	}
	
	
	private boolean isCantMove() {
		//(assume that all of the box is not 0 now.)
		//if the map is still the same after trying to move in all directions, then the game is lose.
		
		int[][] temp = new int[4][4];// save the current map first, use it to store after testing.
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++)
				temp[i][j]=map[i][j];
		
		//move in different directions
		mergeAndMoveLeft();
		mergeAndMoveRight();
		mergeAndMoveUp();
		mergeAndMoveDown();
		
		//if the new map is different, player can still keep moving, return false
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(temp[i][j]!=map[i][j]) {
					map=temp;//restore data
					return false;
				}
			}
		}
		return true;
	}
}
