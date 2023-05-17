package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Stopwatch implements ActionListener{
	JLabel timeLabel = new JLabel();
	int elapsedTime =0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			elapsedTime +=1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		}
		
		
	});
	
	public Stopwatch() {
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setPreferredSize(new Dimension(240,90));
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}

	public void reset() {
		timer.start();
		elapsedTime=0;
		seconds =0;
		minutes=0;
		hours=0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}
}
