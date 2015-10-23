package Main;
public class NoteRhythm {
	private int[] value;
	
	public NoteRhythm(String _value){
		System.out.println("New rhythm with values " + _value);
		String[] values = _value.split(" ");
		value = new int[values.length];
		for(int i = 0; i < values.length; i++){
			value[i] = Integer.parseInt(values[i]);
		}
	}
	
	public int[] getValues(){
		return value;
	}
	
	public int getValue(int i){
		return value[i];
	}
}
