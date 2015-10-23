package RhythmPatterns;

import java.util.Random;

import Main.NoteRhythm;

public class RiseAndFall extends RhythmPattern{
	public double switchChance = .2;
	private boolean direction = false;
	private int lastNote = 0;
	
	
	public RiseAndFall(double _switchChance, int _startingNote, boolean _direction, int _octave){
		super(_octave);
		switchChance = _switchChance;
		lastNote = _startingNote;
		direction = _direction;
	}
	
	public NoteRhythm generatePattern(){
		String song = "";
		
		for(int i = 0; i < 100; i++){
			switchD();
			if(direction){
				lastNote++;
			}else{
				lastNote--;
			}
			song += lastNote + " ";
		}
		
		return new NoteRhythm(song);
	}
	
	private void switchD(){
		Random ra = new Random();
		int t = ra.nextInt(10);
		if(t < switchChance*10){
			direction = !direction;
		}
		if(direction){
			if(lastNote > 10){
				direction = !direction;
			}
		}else{
			if(lastNote < 1){
				direction = !direction;
			}
		}
	}
}

/*
  	Random ra = new Random();
		String values = "";
		for(int i = 0; i < 100; i++){
			values += ra.nextInt(12) + " ";
		}
		return new NoteRhythm(values);
 */
