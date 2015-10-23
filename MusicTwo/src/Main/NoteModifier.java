package Main;

import java.util.regex.Pattern;

public class NoteModifier {
	Notes notesTable = new Notes();
	
	public String getNote(int _value, String length, String startingNote){
		int[] startingValues = notesTable.getValues(startingNote);
		int startingOctave = startingValues[1]; 
		int value = startingValues[0] + _value;
		String note = notesTable.getNote(value, startingOctave) + length;

		return note;
	}
	
	public String[] breakDownSong(String song){
		song = song.replaceAll("\\+", " +");
		System.out.println(song);
		String[] notes = song.split(" ");
		String[] returnThis = new String[2];
		returnThis[0] = "";
		returnThis[1] = "";
		for(int i = 0; i < notes.length; i++){
			returnThis[0] += notesTable.getValue(notes[i]) + " ";
			returnThis[1] += notesTable.getLengths(notes[i]) + " ";
		}
		return returnThis;
	}
}
