import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileMapper {
    public static double[] FileToEntry(File file) throws IOException {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i='a'; i<='z';i++)
            map.put(i,0);
        FileReader reader = new FileReader(file);
        int c;
        while ((c = reader.read()) != -1) {
            c = converChar((char)c);
            if(c>='A'&& c<='Z')
                c-=('A'-'a');
            if(c>='a'&&c<='z')
            map.put((char) c, map.get((char)c)+1);
        }
        double[] entry = new double[26];
        int sum = 0;
        for(int i=0;i<entry.length;i++){
        entry[i] = map.get((char)(i+'a'));
        sum+=entry[i];
        }
        for(int i=0;i<entry.length;i++)
            entry[i]=entry[i]/sum;
        return entry;
    }

    public static double [] TextToEntry(String text){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i='a'; i<='z';i++)
            map.put(i,0);
        for(int i=0;i<text.length();i++){
            int c = text.charAt(i);
            c = converChar((char)c);
            if(c>='A'&& c<='Z')
                c-=('A'-'a');
            if(c>='a'&&c<='z')
                map.put((char) c, map.get((char)c)+1);
        }
        double[] entry = new double[26];
        int sum = 0;
        for(int i=0;i<entry.length;i++){
            entry[i] = map.get((char)(i+'a'));
            sum+=entry[i];
        }
        for(int i=0;i<entry.length;i++)
            entry[i]=entry[i]/sum;
        return entry;
    }

    public static char converChar(char c){
        return switch (c){
            case 'Ö','ö','Ò','ò','Ó','ó','Ô','ô' -> 'o';
            case 'Å','å','Ä','ä','À','à','Ą','ą','Á','á','Â','â','Ã','ã' -> 'a';
            case 'Ü','ü','Ù','ù','Ú','ú','Û','û' -> 'u';
            case 'ẞ','ß', 'Ś', 'ś' -> 's';
            case 'È','è','É','é','Ę','ę','Ê','ê' -> 'e';
            case 'Ì','ì','Í','í' -> 'i';
            case 'Ć','ć','Ç','ç' -> 'c';
            case 'Ł','ł' -> 'l';
            case 'Ń','ń' -> 'n';
            case 'Ź','ź','Ż','ż' -> 'z';
            default -> c;
        };
    }
}
