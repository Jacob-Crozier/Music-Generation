package Songs;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read{
	public Track track(String fileName){
        String[] file = new String[6];
        fileName = "Songs/" + fileName + ".txt";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            for(int i = 0; i < file.length; i++){
            	file[i] = bufferedReader.readLine(); 
            }

            // Always close files.
            bufferedReader.close();         
        }catch(Exception e){
        	System.out.println("You Broke It");
        }
        String name = file[0];
        String rhythm = file[1];
        String lengths = file[2];
        int tempo = Integer.parseInt(file[3]);
        String instrument = file[4];
        String base = file[5];
        
        return new Track(lengths, rhythm, tempo, name, instrument, base);
	}
}
