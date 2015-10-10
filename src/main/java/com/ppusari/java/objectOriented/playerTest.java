package com.ppusari.java.objectOriented;
 
// 추상클래스 이기 떄문에 인스턴스화 할 수 없음.
abstract class Player {

	abstract void play(int pos);
	abstract void stop();
	
	int volume = 0;
	void volumeUp() { ++volume; }
	void volumeDown() { --volume; }
}

// 추상클래스와 달리 인터페이는 내부에 변수나 상수를 가질수 없다.
// 추상클래스처럼 인스던트화 할 수 없음.
interface Playable {
	// 상수는 기본적으로 인터페이스에서는 public static final 이 추가된다.
	public static final boolean playing = false; // 상수
	public static final int PLAY = 0;	// 상수
	public static final int STOP = 1;	// 상수

	// 함수는 기본적으로 인터페이스에서 public abstract 이  무조건 추가된다.
	public abstract boolean isPlaying();  // 추상 메소드
	public abstract boolean isStop();		// 추상 메소드
}

interface Recodable {
	abstract boolean isRecording();  // 추상메소드	
}

// 클래스는 하나만 상속할 수 있지만 인터페이스는 여러게를 상속할 수 있다.
class TapePlayer extends Player implements Playable, Recodable {
	int currentPosition = 0;
	void play(int pos) {}	
	void stop() { }	
	void rewind() {
		currentPosition = 0;
	}
	
	public String toString(){
		return String.format("currentPos:%d", currentPosition);
	}
	
	// public 이 붙은 이유는 
	public boolean isPlaying() { return true; }
	public boolean isStop() { return true; }
	public boolean isRecording() { return true; }	
}

class CDPlayer extends Player implements Playable {
	int currentTrack = 0;
	int lastTrack = 10;
	void play(int pos) { }	
	void stop() { }
	void previous() {
		if (currentTrack > 0)
			currentTrack--;
	}
	void next() {
		if (currentTrack < lastTrack)
			currentTrack++;
	}
	
	public String toString(){
		return String.format("currentTrack:%d lastTrack:%d", currentTrack, lastTrack);
	}
	
	public boolean isPlaying() { return true; }
	public boolean isStop() { return true; }	
}

class MultimediaPlayer extends Player implements Playable{

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void play(int pos) {
		// TODO Auto-generated method stub		
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub		
	}
}

public class playerTest {
	public static Playable getPlayable() {
		return new TapePlayer();
	}
	public static void main(String[] args)
	{		
		TapePlayer tapePlayer = new TapePlayer();
		CDPlayer cdPlayer = new CDPlayer();
		Player player = (Player)new TapePlayer();
		Player player2 = (Player)new CDPlayer();
		
		player.play(0);
		Object obj = (Player)new TapePlayer();
		
		// 상위 클래스
		//obj.play(0);
		((Player)obj).play(0);
		
		// 누가 던젔든지 상관없이 함수만 사용할 수 있음.
		Playable playabe = new TapePlayer();
		playabe.isPlaying();
		Playable returnPlayable = getPlayable();
		
		
		
		
		

	}
	

}
