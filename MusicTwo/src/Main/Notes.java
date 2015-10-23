package Main;

public class Notes {
	String[] notes;
	int[] values;
	
	/* ID   NOTES
	 * 0	C1 		B0#						
	 * 1 	C1# 	D1b						
	 * 2	D1 							
	 * 3	D1#		Eb			
	 * 4 	E		Fb
	 * 5	F		E#
	 * 6	G#		Fb
	 * 7	G
	 * 8	G#		Ab
	 * 9	A
	 * 10	A#		Bb
	 * 11	B 		C2b
	 */
	public Notes(){
		notes = new String[21];
		values = new int[21];
		notes[0] = "C"; 	values[0] = 0;
		notes[1] = "B # #";	values[1] = 0;
		notes[2] = "D b"; 	values[2] = 1;
		notes[3] = "C #"; 	values[3] = 1;
		notes[4] = "D"; 	values[4] = 2;
		notes[5] = "E b"; 	values[5] = 3;
		notes[6] = "D #"; 	values[6] = 3;
		notes[7] = "E"; 	values[7] = 4;
		notes[8] = "F b"; 	values[8] = 4;
		notes[9] = "F"; 	values[9] = 5;
		notes[10] = "E #"; 	values[10] = 5;
		notes[11] = "F b"; 	values[11] = 6;
		notes[12] = "G #"; 	values[12] = 6;
		notes[13] = "G"; 	values[13] = 7;
		notes[14] = "A b"; 	values[14] = 8;
		notes[15] = "G #"; 	values[15] = 8;
		notes[16] = "A"; 	values[16] = 9;
		notes[17] = "A #"; 	values[17] = 10;
		notes[18] = "B b"; 	values[18] = 10;
		notes[19] = "B"; 	values[19] = 11;
		notes[20] = "C b b b"; 	values[20] = 11;
	}
	
	public String getNote(int value, int octave){
		String  added = " ";
		if(value < -1000){
			value = 2000+value;
			added = "+";
		}
		if(value > 1000){
			return "R";
		}
		while(value < 0){
			value += 12;
			octave--;
		}
		while(value > 11){
			value -= 12;
			octave++;
		}
		
		String note = "";
		for(int i = 0; i < values.length; i++){
			if(value == values[i]){
				note = notes[i];
				i = values.length;
			}
		}
		String[] divided = note.split(" ");
		if(divided.length == 1){
			return added + note + octave;
		}else if(divided.length == 2){
			return added + divided[0] + octave + divided[1];
		}else if(divided.length == 3){
			return added + divided[0] + (octave-1) + divided[1];
		}else if(divided.length == 4){
			return added + divided[0] + (octave+1) + divided[1];
		}
		
		return "";
	}
	
	public int[] getValues(String note){
		int value = 0;
		int octave = 5;
		boolean addedNote = false;
		for(int i = 1; i < 9; i++){			//Remove octave numbering 
			String oldNote = note;
			note = note.replaceAll(Integer.toString(i), "");
			if(!oldNote.equals(note)){
				octave = i;
				i = 9;
			}
		}
		
		note = note.replaceAll("w", "");
		note = note.replaceAll("q", "");
		note = note.replaceAll("n", "");
		note = note.replaceAll("i", "");
		note = note.replaceAll("s", "");
		note = note.replaceAll("//.", "");
		note = note.replaceAll("#", " #");	//Expand sharps
		note = note.replaceAll("b", " b");	//Expand flats
		if(note.contains("//+")){
			addedNote = true;
			note = note.replaceAll("//+", "");
		}
		
		if(note.equals("R")){
			value = 2000;
		}
		for(int i = 0; i < notes.length; i++){
			if(note.equals(notes[i])){
				value = values[i];
				i = notes.length;
			}
		}
		
		int[] toReturn = new int[2];
		toReturn[0] = value;
		toReturn[1] = octave;
		if(addedNote){
			toReturn[0] = value-2000;
		}
		return toReturn;
	}
	
	public int getValue(String note){
		int value = 0;
		int octave = 5;
		boolean addedNote = false;
		for(int i = 1; i < 9; i++){			//Remove octave numbering 
			String oldNote = note;
			note = note.replaceAll(Integer.toString(i), "");
			if(!oldNote.equals(note)){
				octave = i;
				i = 9;
			}
		}
		
		note = note.replaceAll("w", "");
		note = note.replaceAll("q", "");
		note = note.replaceAll("n", "");
		note = note.replaceAll("i", "");
		note = note.replaceAll("s", "");
		note = note.replaceAll("h", "");
		note = note.replaceAll("\\.", "");
		note = note.replaceAll("#", " #");	//Expand sharps
		note = note.replaceAll("b", " b");	//Expand flats
		String oldNote = note;
		note = note.replaceAll("\\+", "");
		if(!oldNote.equals(note)){
			addedNote = true;
		}
		if(note.equals("R")){
			value = 2000;
		}
		for(int i = 0; i < notes.length; i++){
			if(note.equals(notes[i])){
				value = values[i];
				i = notes.length;
			}
		}
		
		int toReturn = 0;
		toReturn = value + (octave-5)*12;
		if(addedNote){
			toReturn = toReturn - 2000;
		}
		return toReturn;
	}
	
	public String getLengths(String note){

		for(int i = 1; i < 9; i++){			//Remove octave numbering 
			note = note.replaceAll(Integer.toString(i), "");
		}
		note = note.replaceAll("A", "");
		note = note.replaceAll("B", "");
		note = note.replaceAll("C", "");
		note = note.replaceAll("D", "");
		note = note.replaceAll("E", "");
		note = note.replaceAll("F", "");
		note = note.replaceAll("G", "");
		note = note.replaceAll("b", "");
		note = note.replaceAll("#", "");
		note = note.replaceAll("R", "");
		note = note.replaceAll("\\+", "");
		return note;
	}
}
