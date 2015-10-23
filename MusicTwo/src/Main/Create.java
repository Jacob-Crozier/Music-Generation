package Main;

import java.util.Random;
import Songs.Track;

public class Create {
	public Track Track(){
		return new Track(NoteLengths(), NoteRhythm(), 120, "Random Music", "Guitar", "C5");
	}
	
	public NoteRhythm NoteRhythm(){
		Random ra = new Random();
		String values = "";
		for(int i = 0; i < 100; i++){
			values += ra.nextInt(12) + " ";
		}
		return new NoteRhythm(values);
	}
	

	public NoteLengths NoteLengths(){
		Random ra = new Random();
		String values = "";
		for(int i = 0; i < 100; i++){
			int ran = ra.nextInt(5);
			switch(ran){
			case 0:
				values += "q ";
				break;
			case 1:
				values += "i ";
				break;
			case 2:
				values += "is ";
				break;
			case 3:
				values += "h ";
				break;
			case 4:
				values += "qi ";
				break;

			}
		}
		return new NoteLengths(values);
	}
	

	
	public String generatePattern(int[] values, String[] lengths, String base){
		NoteModifier testNM = new NoteModifier();
		String song = "";
		for(int i = 0; i < values.length; i++){
			int value = values[i];
			String length = lengths[i];
			song += testNM.getNote(value, length, base);
		}		
		return song;
	}
	
	public void breakDown(String song){
		NoteModifier testNM = new NoteModifier();
		String[] results = testNM.breakDownSong(song);
		System.out.println(results[0]);
		System.out.println(results[1]);
	}
	
}
