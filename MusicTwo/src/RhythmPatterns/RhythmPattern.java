package RhythmPatterns;

import java.util.Random;

import Main.NoteRhythm;

public class RhythmPattern {
	int octave = 5;
	
	
	public RhythmPattern(int _octave){
		octave = _octave;
	}
	
	public NoteRhythm generate(){
		String song = "";
		Random ra = new Random();
		for(int i = 0; i < 100; i++){
			song += ra.nextInt(12)-((octave-5) * 12) + " ";
		}
		return new NoteRhythm(song);
	}
}
