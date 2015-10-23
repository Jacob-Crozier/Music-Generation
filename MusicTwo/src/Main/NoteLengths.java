package Main;
public class NoteLengths {
	private String[] value;
	
	public NoteLengths(String _value){
		System.out.println("New lengths with values " + _value);
		value = _value.split(" ");
	}
	
	public String[] getValues(){
		return value;
	}
	
	public String getValue(int i){
		return value[i];
	}
}
