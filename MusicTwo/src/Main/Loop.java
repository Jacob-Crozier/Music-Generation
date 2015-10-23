package Main;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import RhythmPatterns.RiseAndFall;
import Songs.Read;
import Songs.Track;

public class Loop implements Runnable{
	NoteModifier testNM = new NoteModifier();
	Notes testN = new Notes();
	
	NoteRhythm[] rhythms;
	NoteLengths[] lengths;
	RiseAndFall RaF = new RiseAndFall(.2, 4, true, 5);
	Read read = new Read();
	Track[] songs = new Track[1];
	
	Create create = new Create();
	
	public void run() {

		//breakDown("A5i A5i F5i D5q D5q G5q G5q G5i B5i B5i C6i D6i C6i C6i C6i G5q F5q A5q A5q A5i G5i G5i A5i G5i A5i A5i F5i D5q D5q G5q G5q G5i B5i B5i C6i D6i C6i C6i C6i G5q F5q A5q A5q A5i G5i G5i A5i G5i A5i A5i F5i D5q D5q G5q G5q G5i B5i B5i C6i D6i C6i C6i C6i A5q F5q A5q A5q A5i G5i G5i G5i");
		songs[0] = create.Track();
		System.out.println(songs[0].getNotes());
		new Player().play(songs[0].getPattern());
	}	

}
