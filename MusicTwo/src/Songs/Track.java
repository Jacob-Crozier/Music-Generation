package Songs;

import org.jfugue.pattern.Pattern;

import Main.Create;
import Main.NoteLengths;
import Main.NoteRhythm;

public class Track {
	private NoteLengths nL;
	private NoteRhythm nR;
	private int tempo;
	private String name; 
	private String instrument;
	private String notes;
	private String base;
	
	public Track(NoteLengths _nL, NoteRhythm _nR, int _tempo, String _name, String _instrument, String _base){
		Create create = new Create();
		nL = _nL;
		nR = _nR;
		tempo = _tempo;
		name = _name;
		instrument = _instrument;
		base = _base;
		notes = create.generatePattern(nR.getValues(), nL.getValues(), base);
	}
	
	public Track(String _nL, String _nR, int _tempo, String _name, String _instrument, String _base){
		Create create = new Create();
		nL = new NoteLengths(_nL);
		nR = new NoteRhythm(_nR);
		tempo = _tempo;
		name = _name;
		instrument = _instrument;
		base = _base;
		notes = create.generatePattern(nR.getValues(), nL.getValues(), base);
	}
	
	public NoteLengths getLengths(){
		return nL;
	}
	
	public NoteRhythm getRhythm(){
		return nR;
	}
	
	public int getTempo(){
		return tempo;
	}
	
	public String getName(){
		return name;
	}
	
	public String getInstrument(){
		return instrument;
	}
	
	public String getNotes(){
		return notes;
	}
	
	public Pattern getPattern(){
		return new Pattern(notes).setInstrument(instrument).setTempo(tempo);
	}
}
