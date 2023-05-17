package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class GameView extends JFrame{
	private JPanel boardPanel;
	private JPanel playPanel;
	private JPanel timerPanel;
	private JPanel buttonsPanel;
	private JPanel blur;
	private JLabel whiteTimer;
	private JLabel whitePieces; //pic of pieces below timer
	private JLabel blackTimer;
	private JLabel blackPieces; //pic of pieces below timer
	private JTextArea whiteMoves;
	private JScrollPane whiteScroll;
	private JTextArea blackMoves;
	private JScrollPane blackScroll;
	private JButton start;
	private JButton moveBack;
	private JButton moveForward;
	private String whiteName;
	private String blackName;
	private Stopwatch white;
	private Stopwatch black;
	
	
	public GameView() {
		
		//initializing JFrame (main window)
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Chess");
		
		//setting icon for application
		ImageIcon image = new ImageIcon("chess_icon1.jpeg");
		this.setIconImage(image.getImage());
		
		//taking user names
	/*	do {
			whiteName = JOptionPane.showInputDialog("First Player Name");
		}while (whiteName.equals(""));
		whiteName = whiteName.toUpperCase();
		
		do {
			blackName= JOptionPane.showInputDialog("Second Player Name");
		}while (blackName.equals(""));
		blackName = blackName.toUpperCase();
		*/
		//initializing board panel
		boardPanel = new JPanel();
		boardPanel.setPreferredSize(new Dimension(800, 720));
		boardPanel.setLayout(new GridLayout(8,8));
		
		//initializing game play panel
		playPanel = new JPanel();
		playPanel.setLayout(new BorderLayout());
		playPanel.setPreferredSize(new Dimension(480,720));
		
		//initializing timer panel for both players
		timerPanel = new JPanel();
		timerPanel.setLayout(new GridLayout(2,2));
		
		//initializing time and picture labels for both players
		white = new Stopwatch();
		whiteTimer = white.getTimeLabel();
		whiteTimer.setPreferredSize(new Dimension(240, 90));
		black = new Stopwatch();
		blackTimer = black.getTimeLabel();
		blackTimer.setPreferredSize(new Dimension(240, 90));
		whitePieces = new JLabel();
		whitePieces.setPreferredSize(new Dimension(240, 90));
		blackPieces = new JLabel();
		blackPieces.setPreferredSize(new Dimension(240, 90));
		
		//setting icon for pieces labels
		ImageIcon image1 = new ImageIcon("whitePieces.png");
		ImageIcon image2 = new ImageIcon("blackPieces2.png");
		whitePieces.setIcon(image1);
		blackPieces.setIcon(image2);
		
		//adding timers to timerPanel
		timerPanel.add(whiteTimer);
		timerPanel.add(blackTimer);
		timerPanel.add(whitePieces);
		timerPanel.add(blackPieces);
		
		//initializing two text fields to updates moves with scroll bars
		whiteMoves = new JTextArea();
		whiteMoves.setPreferredSize(new Dimension(240,450));
		whiteMoves.setEditable(false);
		whiteMoves.setBorder(BorderFactory.createLineBorder(getBackground()));
		whiteMoves.setFont(new Font("Monaco", Font.PLAIN, 15));
	//	DefaultCaret caret = (DefaultCaret)whiteMoves.getCaret();
	//	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		whiteScroll = new JScrollPane(whiteMoves);
	//	whiteScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		blackMoves = new JTextArea();
		blackMoves.setPreferredSize(new Dimension(240,450));
		blackMoves.setEditable(false);
		blackMoves.setBorder(BorderFactory.createLineBorder(getBackground()));
		blackMoves.setFont(new Font("Monaco", Font.PLAIN, 15));
	//	DefaultCaret caret1 = (DefaultCaret)whiteMoves.getCaret();
	//	caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		blackScroll = new JScrollPane(blackMoves);
	//	blackScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//initializing panel to hold buttons
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(480,45));
		buttonsPanel.setLayout(new GridLayout(0,2));
		
		//initializing buttons to start and move back and forth
		start = new JButton("Start");
		start.setPreferredSize(new Dimension(160,45));
		start.setFocusable(false);
		moveBack = new JButton("Back");
		moveBack.setPreferredSize(new Dimension(160,45));
		moveBack.setFocusable(false);
/*		moveForward = new JButton("Forward");
		moveForward.setPreferredSize(new Dimension(160,45));
		moveForward.setFocusable(false);*/
		
		//adding buttons to buttonsPanel
		buttonsPanel.add(start);
		buttonsPanel.add(moveBack);
	//	buttonsPanel.add(moveForward);
		
	
		//adding text fields, labels and buttons to playPanel
		playPanel.add(timerPanel,BorderLayout.NORTH);
		playPanel.add(whiteScroll,BorderLayout.WEST);
		playPanel.add(blackScroll,BorderLayout.EAST);
		playPanel.add(buttonsPanel,BorderLayout.SOUTH);
		
		
		//adding blur panel
		blur = new JPanel();
		blur.setPreferredSize(new Dimension(800, 720));

		//adding panels to frame
	//	this.add(boardPanel,BorderLayout.WEST);
		this.add(blur,BorderLayout.WEST);
		this.add(playPanel,BorderLayout.CENTER);
		
		this.revalidate();
	}
	
	

	public JPanel getBoardPanel() {
		return boardPanel;
	}



	public String getWhiteName() {
		return whiteName;
	}



	public String getBlackName() {
		return blackName;
	}
	

	public JPanel getPlayPanel() {
		return playPanel;
	}



	public JPanel getTimerPanel() {
		return timerPanel;
	}



	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}



	public JLabel getWhiteTimer() {
		return whiteTimer;
	}



	public JLabel getWhitePieces() {
		return whitePieces;
	}



	public JLabel getBlackTimer() {
		return blackTimer;
	}



	public JLabel getBlackPieces() {
		return blackPieces;
	}



	public JTextArea getWhiteMoves() {
		return whiteMoves;
	}



	public JTextArea getBlackMoves() {
		return blackMoves;
	}



	public JButton getStart() {
		return start;
	}



	public JButton getMoveBack() {
		return moveBack;
	}



	public JButton getMoveForward() {
		return moveForward;
	}



	public Stopwatch getWhite() {
		return white;
	}



	public Stopwatch getBlack() {
		return black;
	}

	
	public JPanel getBlur() {
		return blur;
	}

	

	public JScrollPane getWhiteScroll() {
		return whiteScroll;
	}



	public JScrollPane getBlackScroll() {
		return blackScroll;
	}



	public static void main(String[] args) {
		new GameView();
	}
}
