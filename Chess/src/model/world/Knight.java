package model.world;

import java.awt.Point;

import engine.Game;

public class Knight extends Piece implements minorPiece{
	public Knight(String color) {
		super(color);
	}

	public void validateMoves() {
		int i = this.getLocation().x;
		int j = this.getLocation().y;
		int i1 = i-2;
		int i2 = i-1;
		int i3 = i+1;
		int i4 = i+2;
		int j1 = j-2; 
		int j2 = j-1;
		int j3 = j+1;
		int j4 = j+2;
		if (i1>=0) {
			if (j2>=0) {
				if ( (Game.getBoard()[i1][j2]==null) || !((Piece) (Game.getBoard()[i1][j2])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i1,j2));
			}
			if (j3<=7) {
				if ((Game.getBoard()[i1][j3]==null) || !((Piece) (Game.getBoard()[i1][j3])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i1,j3));
			}
		}
		if (i2>=0) {
			if (j1>=0) {
				if (Game.getBoard()[i2][j1]==null || !((Piece) (Game.getBoard()[i2][j1])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i2,j1));
			}
			if (j4<=7) {
				if (Game.getBoard()[i2][j4]==null || !((Piece) (Game.getBoard()[i2][j4])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i2,j4));
			}
		}
		if (i3<=7) {
			if (j1>=0) {
				if ((Game.getBoard()[i3][j1]==null) || !((Piece) (Game.getBoard()[i3][j1])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i3,j1));
			}
			if (j4<=7) {
				if ( (Game.getBoard()[i3][j4]==null) || !((Piece) (Game.getBoard()[i3][j4])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i3,j4));
			}
		}
		if (i4<=7) {
			if (j2>=0) {
				if ( (Game.getBoard()[i4][j2]==null) || !((Piece) (Game.getBoard()[i4][j2])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i4,j2));
			}
			if (j3<=7) {
				if ((Game.getBoard()[i4][j3]==null) || !((Piece) (Game.getBoard()[i4][j3])).getColor().equals(this.getColor()))
					getValidMoves().add(new Point(i4,j3));
			}
		}
	}
	
}
