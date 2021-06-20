package others;

import java.util.ArrayList;
import java.util.HashMap;

class Point {
	int row;
	int column;
	Point(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
public class Robot {
	
	ArrayList<Point> getPath(boolean[][] maze){
		if(maze == null || maze.length == 0) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int lastRow = maze.length - 1;
		int lastCol = maze[0].length -1;
		if(getPath(maze, lastRow, lastCol, path, cache)) {
			return path;
		}
		return null;
	}

	private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
			HashMap<Point, Boolean> cache) {
		if(col<0 || row <0 || !maze[row][col]) return false;
		Point p = new Point(row, col);
		if(cache.containsKey(p)) return cache.get(p);
		boolean isAtOrigin = col == 0 && row == 0;
		boolean success = false;
		
		if(isAtOrigin || getPath(maze, row - 1, col, path, cache) || getPath(maze, row, col-1, path, cache)) {
			path.add(p);
			success = true;
		}
		cache.put(p, success);
		
		return success;
	}

}
