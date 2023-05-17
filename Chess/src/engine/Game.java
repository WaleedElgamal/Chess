package engine;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.InvalidTargetCell;
import exceptions.UnallowedMovementException;
import model.world.*;

public class Game {
	private static int legitemateMoves = 0;
	private Player firstPlayer;
	private Player secondPlayer;
	private static Object[][] board;
	private GameStatus gameStatus;
	private final static int BOARDWIDTH = 8;
	private final static int BOARDHEIGHT = 8;
	private Piece rem1;
	private Piece rem2;
	
	
	public Game(Player first, Player second) {
		firstPlayer = first;
		secondPlayer = second;
		board = new Object[BOARDWIDTH][BOARDHEIGHT];
		gameStatus = GameStatus.ONGOING;
		loadPieces();
		placePieces();
	}
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void loadPieces() {
		Piece p1;
		for (int j = 0; j<8; j++) {
			switch(j) {
			case 0:
			case 7: p1 = new Rook("White");break;
			case 1:
			case 6: p1 = new Knight("White");break;
			case 2:
			case 5: p1 = new Bishop("White");break;
			case 3: p1 = new Queen("White");break;
			default: p1 = new King("White"); firstPlayer.setKing(p1);
			}
			firstPlayer.getPieces().add(p1);
		}
		for (int j = 0; j<8; j++) {		
			p1 = new Pawn("White");
			firstPlayer.getPieces().add(p1);
		}
		
		Piece p2;
		for (int j = 0; j<8; j++) {
			switch(j) {
			case 0:
			case 7: p2 = new Rook("Black");break;
			case 1:
			case 6: p2 = new Knight("Black");break;
			case 2:
			case 5: p2 = new Bishop("Black");break;
			case 3: p2 = new Queen("Black");break;
			default: p2 = new King("Black"); secondPlayer.setKing(p2);
			}
			secondPlayer.getPieces().add(p2);
		}
		for (int j = 0; j<8; j++) {		
			p2 = new Pawn("Black");
			secondPlayer.getPieces().add(p2);
		}	
	
	}
	
	public void placePieces() {
		int k = 0;
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<8; j++) {
				board[i][j] = secondPlayer.getPieces().get(k);
				((Piece)board[i][j]).setLocation(new Point(i,j));
				k++;
			}
		}
		k = 0;
		for (int i = 7; i>5; i--) {
			for (int j = 0; j<8; j++) {
				board[i][j] = firstPlayer.getPieces().get(k);
				((Piece)board[i][j]).setLocation(new Point(i,j));
				k++;
			}
		}
	}
	
	public static Object[][] getBoard() {
		return board;
	}
	
	public void move(Piece p, int x, int y) {
		rem1 = null;
		int currx = p.getLocation().x;
		int curry = p.getLocation().y;
		board[currx][curry]=null;
		if (board[x][y]!=null) {
			rem1 = (Piece) board[x][y];
		}
		board[x][y]=p;
		p.setLocation(new Point(x,y));


	}
	
	
	public void undoMove(Piece p, int x, int y) {
		board[p.getLocation().x][p.getLocation().y]=rem1;
		board[x][y]=p;
		p.setLocation(new Point(x,y));
	}
	
	public boolean insufficientMaterial() {
		if ((firstPlayer.getPieces().size()==1 && firstPlayer.getPieces().get(0) instanceof King) && (secondPlayer.getPieces().size()==1 && secondPlayer.getPieces().get(0) instanceof King)) {
			return true;
		}
		if ((firstPlayer.getPieces().size()==1 && firstPlayer.getPieces().get(0) instanceof King) && (secondPlayer.getPieces().size()==2) ) {
			 Piece p1 = secondPlayer.getPieces().get(0);
			 Piece p2= secondPlayer.getPieces().get(1);
			 if ( (p1 instanceof King && p2 instanceof minorPiece) || (p2 instanceof King && p1 instanceof minorPiece) ) {
				 return true;
			 }
		}
		if ((secondPlayer.getPieces().size()==1 && secondPlayer.getPieces().get(0) instanceof King) && (firstPlayer.getPieces().size()==2) ) {
			 Piece p1 = firstPlayer.getPieces().get(0);
			 Piece p2= firstPlayer.getPieces().get(1);
			 if ( (p1 instanceof King && p2 instanceof minorPiece) || (p2 instanceof King && p1 instanceof minorPiece) ) {
				 return true;
			 }
		}
		if ((firstPlayer.getPieces().size()==1 && firstPlayer.getPieces().get(0) instanceof King) && (secondPlayer.getPieces().size()==3) ) {
			 Piece p1 = secondPlayer.getPieces().get(0);
			 Piece p2= secondPlayer.getPieces().get(1);
			 Piece p3 = secondPlayer.getPieces().get(2);
			 if (p1 instanceof King) {
				 if (p2 instanceof Knight && p3 instanceof Knight) {
					 return true;
				 }
			 }
			 else if (p2 instanceof King) {
				 if (p1 instanceof Knight && p3 instanceof Knight) {
					 return true;
				 }
			 }
			 else if (p3 instanceof King) {
				 if (p1 instanceof Knight && p2 instanceof Knight) {
					 return true;
				 }
			 }
		}
		if ((secondPlayer.getPieces().size()==1 && secondPlayer.getPieces().get(0) instanceof King) && (firstPlayer.getPieces().size()==3) ) {
			 Piece p1 = firstPlayer.getPieces().get(0);
			 Piece p2= firstPlayer.getPieces().get(1);
			 Piece p3 = firstPlayer.getPieces().get(2);
			 if (p1 instanceof King) {
				 if (p2 instanceof Knight && p3 instanceof Knight) {
					 return true;
				 }
			 }
			 else if (p2 instanceof King) {
				 if (p1 instanceof Knight && p3 instanceof Knight) {
					 return true;
				 }
			 }
			 else if (p3 instanceof King) {
				 if (p1 instanceof Knight && p2 instanceof Knight) {
					 return true;
				 }
			 }
		}
		if (firstPlayer.getPieces().size()==2 && secondPlayer.getPieces().size()==2) {
			Piece p1 = firstPlayer.getPieces().get(0);
			Piece p2 = firstPlayer.getPieces().get(1);
			Piece p3 = secondPlayer.getPieces().get(0);
			Piece p4 = secondPlayer.getPieces().get(1);
			if ( (p1 instanceof King && p2 instanceof minorPiece) || ( p2 instanceof King && p1 instanceof minorPiece) ) {
				if ( (p3 instanceof King && p4 instanceof minorPiece) || ( p4 instanceof King && p3 instanceof minorPiece)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean inCheck(Piece k, Player player1) {
		boolean flag = false;
		int x = k.getLocation().x;
		int y = k.getLocation().y;
		for (Piece p: player1.getPieces()) {
			p.getValidMoves().clear();
			p.validateMoves();
			for (Point pt: p.getValidMoves()) {
				if (pt.x==x && pt.y==y) {
					flag = true;
				}
			}
		}
		return flag;
	}
	
	public boolean noLegitMoves(Piece k, Player player1, Player player2) {
		for (Piece p: player2.getPieces()) {
			p.getValidMoves().clear();
			p.getLegitMoves().clear();
			p.validateMoves();
			for (Point pt : p.getValidMoves()) {
				int currx = p.getLocation().x;
				int curry = p.getLocation().y;
				move(p, pt.x,pt.y);
				if(!inCheck(k,player1)) {
					p.getLegitMoves().add(pt);
					legitemateMoves++;
				}
				undoMove(p,currx,curry);
			}
		}
		if (legitemateMoves==0) {
			return true;
		}
		else {
			legitemateMoves = 0;
			return false;
		}
	}
	
	//player1 attack
	//player2 defend
	
	public void updateGameStatus(Piece p) {
		Player player1 = null;
		Player player2 = null;
		if (p.getColor().equals("White")) {
				player1 = firstPlayer;
				player2 = secondPlayer;
		}
		else {
			player1 = secondPlayer;
			player2 = firstPlayer;
		}
		King k = (King) player2.getKing();
		boolean noMoves = noLegitMoves(k,player1,player2);
		boolean check = inCheck(k,player1); 
		if(!check && noMoves)
			gameStatus = GameStatus.STALEMATE;
		else if (insufficientMaterial())
			gameStatus = GameStatus.INSUFFICIENT_MATERIAL;
		else {
			if (check && noMoves) {
				if (p.getColor().equals("White"))
					gameStatus = GameStatus.WHITE_CHECKMATE;
				else
					gameStatus = GameStatus.BLACK_CHECKMATE;
			}
			else {
				gameStatus = GameStatus.ONGOING;
			}
		}
	}

	public Piece getRem2() {
		return rem2;
	}
	
	public void setRem2(Piece p) {
		rem2 = p;
	}
	
	
	
}
