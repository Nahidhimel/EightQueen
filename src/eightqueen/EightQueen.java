/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueen;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Nahid H Himel
 */
public class EightQueen {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Point> queenSpots = new ArrayList<Point>();

	public static void main(String[] args) {
		ArrayList<Point> chessBoard = new ArrayList<Point>();
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				chessBoard.add(new Point(i, j));
			}
		}
		placeQueens(chessBoard, 8);
	}

	public static boolean placeQueens(ArrayList<Point> chessboard, int queen) {
		if (queen == 0) {
			for (Point p : queenSpots) {
				System.out.print("(" + p.x + ", " + p.y + ");");
			}
			System.out.println();
			return true;
		}
		for (int i = 1; i <= 8; i++) {
			if (chessboard.contains(new Point(queen, i))) {
				ArrayList<Point> newBoard = addQueen(chessboard, new Point(
						queen, i));
				placeQueens(newBoard, queen - 1);
				queenSpots.remove(new Point(queen, i));
			}
		}
		return false;
	}

	public static ArrayList<Point> addQueen(ArrayList<Point> chessboard, Point p) {
		ArrayList<Point> newBoard = new ArrayList<Point>();
		queenSpots.add(p);
		for (Point q : chessboard) {
			if (q.x != p.x && q.y != p.y && (q.x - p.y) != (p.x - q.y)
					&& (q.x - q.y) != (p.x - p.y)) {
				newBoard.add(q);
			}
		}
		return newBoard;
	}
}
