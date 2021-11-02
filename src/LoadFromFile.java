import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoadFromFile {

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
}
