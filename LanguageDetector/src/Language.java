import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Language {
    private File directory;
    private File[] files;

    public File getDirectory() {
        return directory;
    }

    public Map<File, double[]> getFilesMap() {
        return filesMap;
    }

    private Map<File, double []> filesMap;
    private Perceptron perceptron;

    public Language(File directory) throws IOException {
    filesMap = new HashMap<>();
    this.directory=directory;
    files = directory.listFiles();
    for(File file : files)
        filesMap.put(file,FileMapper.FileToEntry(file));
    perceptron = new Perceptron();
    }

    public Perceptron getPerceptron(){
        return perceptron;
    }

    public File[] getFiles() {
        return files;
    }
}
