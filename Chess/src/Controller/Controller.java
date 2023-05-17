package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import engine.Game;
import engine.GameStatus;
import engine.Player;
import model.world.*;
import view.GameView; 

public class Controller implements ActionListener, MouseListener{
	private Game game;
	private GameView view;
	private int currTurn;
	private JButton[][] boardButtons;
	private Point lastPressedPiece;
	private Point lastMove;
	//private Point moveForward;
	private boolean start=false;
	//private Player player1;
	//private Player player2;
	public Controller() {
		view = new GameView();
		view.getStart().addActionListener(this);
		view.getMoveBack().addActionListener(this);
	//	view.getMoveForward().addActionListener(this);
		Player player1 = new Player("");
		Player player2 = new Player("");
		game = new Game(player1, player2);
		currTurn = 0;
		boardButtons = new JButton[8][8];
		lastPressedPiece = new Point();
		lastMove = null;
	//	moveForward = null;
		game.noLegitMoves(player1.getKing(), player2, player1);
		fillBoard();
	}
	
	public void fillBoard() {
		for (int i =0; i<8; i++) {
			for (int j = 0; j<8;j++) {
				JButton button = new JButton();
				button.addActionListener(this);
				button.setBorder(BorderFactory.createEmptyBorder());
				if ( (i+j) %2!=0) {
					//button.setForeground(Color.GREEN);
					button.setBackground(Color.decode("#50C878"));
					button.setOpaque(true);
				}
				else {
					button.setBackground(Color.decode("#EDEADE"));
					button.setOpaque(true);
				}
				if((Game.getBoard())[i][j]!=null) {
					String color = ((Piece) Game.getBoard()[i][j]).getColor();
					ImageIcon icon = setIcon((Piece)Game.getBoard()[i][j], color);
					button.setIcon(icon);
				}
				else {
					button.setIcon(null);
				}
				boardButtons[i][j] = button;
				view.getBoardPanel().add(button);
			}
		}
		view.revalidate();
	}
	
	public void refreshBoard() {
		for (int i =0; i<8; i++) {
			for (int j = 0; j<8;j++) {
				if((Game.getBoard())[i][j]!=null) {
					String color = ((Piece) Game.getBoard()[i][j]).getColor();
					ImageIcon icon = setIcon((Piece)Game.getBoard()[i][j], color);
					boardButtons[i][j].setIcon(icon);
				}
				else
					boardButtons[i][j].setIcon(null);
				boardButtons[i][j].setBorder(BorderFactory.createEmptyBorder());
			}
		}
		view.revalidate();
	}
	
	public void refreshBoard2() {
		for (int i =7; i>=0; i--) {
			for (int j = 7; j>=0;j--) {
				if((Game.getBoard())[i][j]!=null) {
					String color = ((Piece) Game.getBoard()[i][j]).getColor();
					ImageIcon icon = setIcon((Piece)Game.getBoard()[i][j], color);
					boardButtons[7-i][7-j].setIcon(icon);
				}
				else
					boardButtons[7-i][7-j].setIcon(null);
				boardButtons[7-i][7-j].setBorder(BorderFactory.createEmptyBorder());
			}
		}
		view.revalidate();
	}
	
	public ImageIcon setIcon(Piece p,String color) {
		ImageIcon icon = new ImageIcon();
		if (p instanceof Pawn) {
			if (color.equals("White"))
				icon = new ImageIcon("whitePawn.png");
			else
				icon = new ImageIcon("blackPawn.png");
			
		}
		else if (p instanceof Knight) {
			if (color.equals("White"))
				icon = new ImageIcon("whiteKnight.png");
			else
				icon = new ImageIcon("blackKnight.png");
		}
		else if (p instanceof Bishop) {
			if (color.equals("White"))
				icon = new ImageIcon("whiteBishop.png");
			else
				icon = new ImageIcon("blackBishop.png");
		}
		else if (p instanceof Queen) {
			if (color.equals("White"))
				icon = new ImageIcon("whiteQueen.png");
			else
				icon = new ImageIcon("blackQueen.png");	
		}
		else if (p instanceof Rook) {
			if (color.equals("White"))
				icon = new ImageIcon("whiteRook.png");
			else
				icon = new ImageIcon("blackRook.png");	
		}
		else {
			if (color.equals("White"))
				icon = new ImageIcon("whiteKing.png");
			else
				icon = new ImageIcon("blackKing.png");	
		}
		return icon;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==view.getStart()) {
			if (!start) {
				start=true;
				view.getStart().setText("Stop");
				if (currTurn==0)
					view.getWhite().start();
				else
					view.getBlack().start();
				view.add(view.getBoardPanel(),BorderLayout.WEST);
				view.remove(view.getBlur());
				view.repaint();
				view.revalidate();
			}
			else {
				start = false;
				view.getStart().setText("Start");
				if(currTurn==0)
					view.getWhite().stop();
				else
					view.getBlack().stop();
				view.remove(view.getBoardPanel());
				view.add(view.getBlur(),BorderLayout.WEST);
				view.repaint();
				view.revalidate();
			}
			return;
		}
		
		if(e.getSource()==view.getMoveBack()) {
			if(currTurn==0) {
				if (lastMove!=null) {
					Piece temp=(Piece)Game.getBoard()[7-lastMove.x][7-lastMove.y]; 
					game.undoMove(temp, lastPressedPiece.x, lastPressedPiece.y);
					lastMove=null;
					refreshBoard2();
					view.getWhite().stop();
					view.getBlack().start();
					String t = view.getBlackMoves().getText();
					view.getBlackMoves().setText(t.substring(0,t.length()-9));
					currTurn=1;
				}
			}
			else {
				if (lastMove!=null) {
					Piece temp=(Piece)Game.getBoard()[lastMove.x][lastMove.y]; 
					game.undoMove(temp, lastPressedPiece.x, lastPressedPiece.y);
					lastMove=null;
					refreshBoard();
					view.getBlack().stop();
					view.getWhite().start();
					String t = view.getWhiteMoves().getText();
					view.getWhiteMoves().setText(t.substring(0,t.length()-9));
					currTurn=0;
				}
			}
			return;
		}

		
		
		Border bd=BorderFactory.createEmptyBorder();
		if(((JButton) (e.getSource())).getBorder()!=bd ) {
			if (currTurn==0) {
				Piece p = (Piece) Game.getBoard()[lastPressedPiece.x][lastPressedPiece.y];
				for(int i=0; i<8;i++)
					for (int j =0;j<8;j++) {
						if (boardButtons[i][j]==e.getSource()) {
							if (Game.getBoard()[i][j]!=null) {
								game.getSecondPlayer().getPieces().remove(Game.getBoard()[i][j]);
							}
							String updateWhite = getChar(p.getLocation().y) + "" + (8-p.getLocation().x);
							updateWhite += " -> " + getChar(j) +(8-i) + "\n" ;
							view.getWhiteMoves().append(updateWhite);
							//JScrollBar sb1 = view.getWhiteScroll().getVerticalScrollBar();
							//sb1.setValue(sb1.getMaximum());
							view.getWhiteMoves().setCaretPosition(view.getWhiteMoves().getDocument().getLength());
							view.getWhiteScroll().revalidate();
							if (p instanceof Pawn && i==0) {
								game.getFirstPlayer().getPieces().remove(p);
								String[] upgrades  = {"Queen", "Rook", "Bishop", "Knight"};
								int res = JOptionPane.showOptionDialog(view, "Choose an Upgrade!", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, upgrades, 0);
								Piece upg = null;
								switch(res) {
								case 3: upg = new Knight("White");break;
								case 2: upg = new Bishop("White");break;
								case 1: upg = new Rook("White");break;
								default: upg = new Queen("White");
								}
								upg.setLocation(new Point(0,p.getLocation().y));
								game.getFirstPlayer().getPieces().add(upg);
								Game.getBoard()[p.getLocation().x][p.getLocation().y]=null;
								Game.getBoard()[0][p.getLocation().y] = upg;
								game.updateGameStatus(upg);
							}
							else {
								game.move(p, i, j);
								game.updateGameStatus(p);
							}
							refreshBoard2();
							lastMove = new Point(i,j);
							if (game.getGameStatus()!=GameStatus.ONGOING) {
								if (game.getGameStatus().equals(GameStatus.BLACK_CHECKMATE)) {
									JOptionPane.showConfirmDialog(view,"" + "BLACK IS THE WINNER!", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else if (game.getGameStatus().equals(GameStatus.WHITE_CHECKMATE)) {
									JOptionPane.showConfirmDialog(view,"" + "WHITE IS THE WINNER!", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else if (game.getGameStatus().equals(GameStatus.STALEMATE)) {
									JOptionPane.showConfirmDialog(view,"DRAW BY STALEMATE", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else {
									JOptionPane.showConfirmDialog(view,"DRAW BY INSUFFICIENT MATERIAL", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								System.exit(0);
							}
							else {
								currTurn=1;
							}
							view.getWhite().stop();
							view.getBlack().start();
						}	
					}
			}
			else {
				Piece p = (Piece) Game.getBoard()[lastPressedPiece.x][lastPressedPiece.y];
				for(int i=0; i<8;i++)
					for (int j =0;j<8;j++) {
						if (boardButtons[i][j]==e.getSource()) {
							if (Game.getBoard()[7-i][7-j]!=null) {
								game.getFirstPlayer().getPieces().remove(Game.getBoard()[7-i][7-j]);
							}
							String updateBlack = getChar(p.getLocation().y) + "" + (8-p.getLocation().x);
							updateBlack += " -> " + getChar(7-j) +(i+1) + "\n";
							view.getBlackMoves().append(updateBlack);
							view.getBlackMoves().setCaretPosition(view.getBlackMoves().getDocument().getLength());
							view.getBlackMoves().revalidate();
							//JScrollBar sb2 = view.getBlackScroll().getVerticalScrollBar();
							//sb2.setValue(sb2.getMaximum());
							if (p instanceof Pawn && i==0) {
								game.getSecondPlayer().getPieces().remove(p);
								String[] upgrades  = {"Queen", "Rook", "Bishop", "Knight"};
								int res = JOptionPane.showOptionDialog(view, "Choose an Upgrade!", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, upgrades, 0);
								Piece upg = null;
								switch(res) {
								case 3: upg = new Knight("Black");break;
								case 2: upg = new Bishop("Black");break;
								case 1: upg = new Rook("Black");break;
								default: upg = new Queen("Black");
								}
								upg.setLocation(new Point(7,p.getLocation().y));
								game.getSecondPlayer().getPieces().add(upg);
								Game.getBoard()[p.getLocation().x][p.getLocation().y]=null;
								Game.getBoard()[7][p.getLocation().y] = upg;
								game.updateGameStatus(upg);
							}
							else {
								game.move(p, 7-i, 7-j);
								game.updateGameStatus(p);
							}
							refreshBoard();
							lastMove = new Point(i,j);
							if (game.getGameStatus()!=GameStatus.ONGOING) {
								if (game.getGameStatus().equals(GameStatus.BLACK_CHECKMATE)) {
									JOptionPane.showConfirmDialog(view,"" + "BLACK IS THE WINNER!", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else if (game.getGameStatus().equals(GameStatus.WHITE_CHECKMATE)) {
									JOptionPane.showConfirmDialog(view,"" + "WHITE IS THE WINNER!", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else if (game.getGameStatus().equals(GameStatus.STALEMATE)) {
									JOptionPane.showConfirmDialog(view,"DRAW BY STALEMATE", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								else {
									JOptionPane.showConfirmDialog(view,"DRAW BY INSUFFICIENT MATERIAL", "GAME OVER", JOptionPane.DEFAULT_OPTION);
								}
								System.exit(0);
							}
							else {
								currTurn =0;
							}
							view.getBlack().stop();
							view.getWhite().start();
						}	
					}
			}
			return;
		}
		
		for (int i =0; i<8;i++)
			for (int j =0; j<8; j++) {
				if (boardButtons[i][j].getBorder()!=bd) {
					boardButtons[i][j].setBorder(bd);
				}
			}
		
		
		JButton temp = (JButton) e.getSource();
		if (currTurn==0) {
			for (int i = 0; i<8;i++) {
				for (int j=0; j<8;j++) {
					if(temp==boardButtons[i][j]) {
						if (Game.getBoard()[i][j]==null)
							break;
						String color =  ((Piece) (Game.getBoard())[i][j]).getColor();
						if ( (currTurn==0 && !color.equals("White")) || (currTurn==1 && !color.equals("Black")) )
							break;
						
						Piece p = (Piece) Game.getBoard()[i][j];
						for (Point pt: p.getLegitMoves()) {
							if (Game.getBoard()[pt.x][pt.y]==null)
								boardButtons[pt.x][pt.y].setBorder(BorderFactory.createLineBorder(Color.yellow,2));
							else
								boardButtons[pt.x][pt.y].setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						view.getBoardPanel().revalidate();
						lastPressedPiece.setLocation(i,j);
						break;
					}
				}
			}
		}
		else {
			for (int i = 0; i<8;i++) {
				for (int j=0; j<8;j++) {
					if(temp==boardButtons[i][j]) {
						if (Game.getBoard()[7-i][7-j]==null)
							break;
						String color =  ((Piece) (Game.getBoard())[7-i][7-j]).getColor();
						if ( (currTurn==0 && !color.equals("White")) || (currTurn==1 && !color.equals("Black")) )
							break;
						
						Piece p = (Piece) Game.getBoard()[7-i][7-j];
						for (Point pt: p.getLegitMoves()) {
							if (Game.getBoard()[pt.x][pt.y]==null)
								boardButtons[7-pt.x][7-pt.y].setBorder(BorderFactory.createLineBorder(Color.yellow,2));
							else
								boardButtons[7-pt.x][7-pt.y].setBorder(BorderFactory.createLineBorder(Color.red,2));
						}
						view.getBoardPanel().revalidate();
						lastPressedPiece.setLocation(7-i,7-j);
						break;
					}
				}
			}
		}
		
	}
	
	public char getChar(int i) {
		switch(i) {
		case 0: return 'a';
		case 1: return 'b';
		case 2: return 'c';
		case 3: return 'd';
		case 4: return 'e';
		case 5: return 'f';
		case 6: return 'g';
		default: return 'h';
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
