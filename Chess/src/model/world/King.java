package model.world;

import java.awt.Point;

import engine.Game;

public class King extends Piece{
	public King(String color) {
		super(color);
	}

	public void validateMoves() {
		int i = this.getLocation().x;
		int j = this.getLocation().y;
		int i1 = i-1;
		int i2 = i+1; 
		int j1 = j-1;
		int j2 = j+1;
		if (i1>=0) {
			if (j1>=0) {
				if ( (Game.getBoard()[i1][j1]==null) || !((Piece) (Game.getBoard()[i1][j1])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i1,j1));
			}
			if ( (Game.getBoard()[i1][j]==null) || !((Piece) (Game.getBoard()[i1][j])).getColor().equals(this.getColor()))
				getValidMoves().add(new Point(i1,j));
			if (j2<=7) {
				if ((Game.getBoard()[i1][j2]==null) || !((Piece) (Game.getBoard()[i1][j2])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i1,j2));
			}
		}
		
		if (j1>=0) {
			if ( (Game.getBoard()[i][j1]==null) || !((Piece) (Game.getBoard()[i][j1])).getColor().equals(this.getColor()))
				getValidMoves().add(new Point(i,j1));
		}
		if (j2<=7) {
			if ((Game.getBoard()[i][j2]==null) || !((Piece) (Game.getBoard()[i][j2])).getColor().equals(this.getColor()))
				getValidMoves().add(new Point(i,j2));
		}
		
		if (i2<=7) {
			if (j1>=0) {
				if ( (Game.getBoard()[i2][j1]==null) || !((Piece) (Game.getBoard()[i2][j1])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i2,j1));
			}
			if ( (Game.getBoard()[i2][j]==null) || !((Piece) (Game.getBoard()[i2][j])).getColor().equals(this.getColor()))
				getValidMoves().add(new Point(i2,j));
			if (j2<=7) {
				if ((Game.getBoard()[i2][j2]==null) || !((Piece) (Game.getBoard()[i2][j2])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i2,j2));
			}
		}
	}
}
