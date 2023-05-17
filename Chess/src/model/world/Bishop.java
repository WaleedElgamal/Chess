package model.world;

import java.awt.Point;

import engine.Game;

public class Bishop extends Piece implements minorPiece{
	public Bishop(String color) {
		super(color);
	}

	public void validateMoves() {
		int i = this.getLocation().x-1;
		int j = this.getLocation().y-1;
		while (i>=0 && j>=0) {
			if (Game.getBoard()[i][j]==null) {
				getValidMoves().add(new Point(i,j));
				i--;
				j--;
			}
			else {
				if (!((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) 
					getValidMoves().add(new Point(i,j));
				break;
			}
		}
		i = this.getLocation().x+1;
		j = this.getLocation().y+1;
		while (i<=7 && j<=7) {
			if (Game.getBoard()[i][j]==null) {
				getValidMoves().add(new Point(i,j));
				i++;
				j++;
			}
			else {
				if (!((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) 
					getValidMoves().add(new Point(i,j));
				break;
			}
		}
		i = this.getLocation().x+1;
		j = this.getLocation().y-1;
		while (i<=7 && j>=0) {
			if (Game.getBoard()[i][j]==null) {
				getValidMoves().add(new Point(i,j));
				i++;
				j--;
			}
			else {
				if (!((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) 
					getValidMoves().add(new Point(i,j));
				break;
			}
		}
		i = this.getLocation().x-1;
		j = this.getLocation().y+1;
		while (i>=0 && j<=7) {
			if (Game.getBoard()[i][j]==null) {
				getValidMoves().add(new Point(i,j));
				i--;
				j++;
			}
			else {
				if (!((Piece) (Game.getBoard()[i][j])).getColor().equals(this.getColor())) 
					getValidMoves().add(new Point(i,j));
				break;
			}
		}
	}
}
