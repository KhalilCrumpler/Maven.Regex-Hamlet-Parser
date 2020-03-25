import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    private static final Logger LOGGER = Logger.getLogger(HamletParser.class.getName());
    private String hamletData;
    private String leonRegex = "[Hh][Aa][Mm][Ll][Ee][Tt]'?s?";
    private String tariqRegex = "[Hh][Oo][Rr][Aa][Tt][Ii][Oo]'?s?";
    public HamletParser(){

        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }
    public void printData(){
        LOGGER.info("\n" + hamletData);
    }





    public void changeHamletToLeon(){
        Pattern pattern = Pattern.compile(leonRegex);
        Matcher matcher = pattern.matcher(hamletData);
        String results = matcher.replaceAll("Leon");
        hamletData = results;

    }

    public void changeHoratioToTariq(){
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletData);
        String results = matcher.replaceAll("Tariq");
        hamletData = results;
    }

    public void changeHamlet(){
        changeHamletToLeon();
        changeHoratioToTariq();
    }

    public int numberOfHamlet(){
        Pattern pattern = Pattern.compile(leonRegex);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }

    public int numberOfHoratio(){
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }

}
