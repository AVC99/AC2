import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private Gson gson;

    public ReadWriteFile() {
        this.gson = new Gson();
    }

    /**
     * Carga la party
     * @param name
     * @return
     */
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

    /**
     * Escribe la party modificada a un json
     * @param party
     */
    public void writeFile(Party party){
        try (FileWriter writer = new FileWriter("party.json")) {
            gson.toJson(party, writer);
            System.out.println("\nUpdating party.json...");
            System.out.println("Shutting down...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
