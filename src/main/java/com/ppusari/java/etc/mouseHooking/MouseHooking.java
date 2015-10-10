
package com.ppusari.java.etc.mouseHooking;

import java.awt.AWTException;
 
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;

import de.ksquared.system.mouse.GlobalMouseListener;
import de.ksquared.system.mouse.MouseAdapter;
import de.ksquared.system.mouse.MouseEvent;

public class MouseHooking extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
		 
	@Override
	public void actionPerformed(ActionEvent e) {
 	
	}
	
	// 생성자함수
	public MouseHooking() {	
		mouseMove();
	}

	// 마우스 이동시키기
	public void mouseMove(){
		
		Robot robot;
		try {
			robot = new Robot();
			for (int i=0; i<500; i+=10){
				robot.setAutoDelay(10);
				robot.mouseMove(100+i, 100+i);		
				//rob.mouseRelease(InputEvent.ALT_GRAPH_MASK);
			}
		} catch (AWTException e) {			
			e.printStackTrace();
		}		
	}
	

	public static void main(String[] args) {
		
		MouseHooking mouseHooking = new MouseHooking();
		mouseHooking.setVisible(true);
		
		// 마우스 후킹 받아오기
		new GlobalMouseListener().addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent event)  { System.out.println(event); }
			@Override public void mouseReleased(MouseEvent event)  { System.out.println(event); }
			@Override public void mouseMoved(MouseEvent event) {
				System.out.println(event);
				if((event.getButtons()&MouseEvent.BUTTON_LEFT)!=MouseEvent.BUTTON_NO
				&& (event.getButtons()&MouseEvent.BUTTON_RIGHT)!=MouseEvent.BUTTON_NO)
					System.out.println("Both mouse buttons are currenlty pressed!");
			}
		});
		while(true)
			try { Thread.sleep(100); }
			catch(InterruptedException e) { e.printStackTrace(); }
 	
	}
}
