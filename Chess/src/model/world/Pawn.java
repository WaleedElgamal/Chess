package model.world;

import java.awt.Point;

import engine.Game;

public class Pawn extends Piece{
	public Pawn(String color) {
		super(color);
	}

	public void validateMoves() {
		int i = this.getLocation().x;
		int j = this.getLocation().y;
		if (this.getColor().equals("White")) {
			if (Game.getBoard()[i-1][j]==null) {
				getValidMoves().add(new Point(i-1,j));
				if (i==6) {
					if (Game.getBoard()[i-2][j]==null)
						getValidMoves().add(new Point(i-2,j));
				}
			}
			if (j-1>=0 && Game.getBoard()[i-1][j-1]!=null && !( (Piece) (Game.getBoard()[i-1][j-1])).getColor().equals(getColor())) {
				getValidMoves().add(new Point(i-1,j-1));
			}
			if ( j+1<=7 && Game.getBoard()[i-1][j+1]!=null && !( (Piece) (Game.getBoard()[i-1][j+1])).getColor().equals(getColor())) {
				getValidMoves().add(new Point(i-1,j+1));
			}
		}
		else {
			if (Game.getBoard()[i+1][j]==null) {
				getValidMoves().add(new Point(i+1,j));
				if (i==1) {
					if (Game.getBoard()[i+2][j]==null)
						getValidMoves().add(new Point(i+2,j));
				}
			}
			if (j-1>= 0 && Game.getBoard()[i+1][j-1]!=null && !( (Piece) (Game.getBoard()[i+1][j-1])).getColor().equals(getColor())) {
				getValidMoves().add(new Point(i+1,j-1));
			}
			if (j+1<=7 && Game.getBoard()[i+1][j+1]!=null && !( (Piece) (Game.getBoard()[i+1][j+1])).getColor().equals(getColor())) {
				getValidMoves().add(new Point(i+1,j+1));
			}
		}
	}
}
