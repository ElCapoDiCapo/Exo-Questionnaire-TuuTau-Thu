import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListeItem {
    ArrayList<Item> questionnaire = new ArrayList<>();

    public ListeItem(File fichier){
        try {
            Scanner sc = new Scanner(fichier);
            while (sc.hasNext()){
                String question = sc.nextLine();
                String reponse = sc.nextLine();
                questionnaire.add(new Item(question, reponse));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(questionnaire);
    }
}
