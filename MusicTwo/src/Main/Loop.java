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
		songs[0] = read.track("takeOnMe");
		System.out.println(songs[0].getNotes());
		new Player().play(songs[0].getPattern());
		
	}
	
	public void defineNoteRhythms(){
		rhythms = new NoteRhythm[5];
		rhythms[0] = new NoteRhythm("-12 -8 -5 -5 -5 -5 -3 -1 0 2000 -8 -7 -5 -5 -7 -7 -8 -10 -10 2000 -10 -12 -8 -10 -12 -10");
		rhythms[1] = RaF.generate();
		rhythms[2] = new NoteRhythm("0 -1988 -1984 -1981 4 -1989 -1986 -1981 -3 -1988 -1984 -1981 9 -1988 -1984 -1981 5 -1990 -1986 -1983 -5 -1988 -1986 -1983 -3 -1988 -1984 -1983 -2 -1990 -1986 -1983 -2 -1990 -1986 -1983 -2 -1990 -1986 -1983 -2 -1990 -1986 -1983 -2 -1990 -1986 -1983 -3 -1988 -1984 -1979 2 -1988 -1983 -1979 0 -1988 -1984 -1981 ");
		rhythms[3] = new NoteRhythm("-3 -1 -5 -3 2000 0 -1 -5 -3 2000 -3 -1 -5 -3 2000 0 -1 -5 -3 2000 ");
		rhythms[4] = new NoteRhythm("9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 7 5 9 9 9 7 7 9 7 9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 7 5 9 9 9 7 7 9 7 9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 9 5 9 9 9 7 7 7 ");
		//9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 7 5 9 9 9 7 7 9 7 9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 7 5 9 9 9 7 7 9 7 9 9 5 2 2 7 7 7 11 11 12 14 12 12 12 9 5 9 9 9 7 7 7 
	}
	
	public void defineNoteLengths(){
		lengths = new NoteLengths[5];
		lengths[0] = new NoteLengths("s s s q s is i s qs q q i s i is i i s s i i s qi s i h ");
		lengths[1] = create.NoteLengths();
		lengths[2] = new NoteLengths("h h h h h h h h h h h h h h h h h h h h h h h h h h h h is is is qis i i i i i i i i s s s s i i i i i i i i q q q q h h h h");
		lengths[3] = new NoteLengths("q i q hqi h q i q hqi h q i q hqi h q i q hqi h ");
		lengths[4] = new NoteLengths("i i i q q q q i i i i i i i i q q q q i i i i i i i i q q q q i i i i i i i i q q q q i i i i i i i i q q q q i i i i i i i i q q q q i i i i ");
	}
	

}
