import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private Gson gson=new Gson();

    public Party loadParty(String name){
        Party party=null;
        try{
           party=gson.fromJson(new FileReader(name),Party.class);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return party;
    }
    public void writeFile(Party party){
        String filename="test.json";
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(party, writer);
            System.out.println("\nUpdating "+filename+"...");
            System.out.println("Shutting down...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
