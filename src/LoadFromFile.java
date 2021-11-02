import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoadFromFile {

    private String filename;

    public Party loadParty(String name){
        Party party=null;
        Gson gson= new Gson();
        try{
           party=gson.fromJson(new FileReader(name),Party.class);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return party;
    }

    public void writeFile(Party party){
        Gson gson =new Gson();
        String filename="test.json";
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(party, writer);
            System.out.println("Updating "+filename+"...");
            System.out.println("Shutting down...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
