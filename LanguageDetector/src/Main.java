import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File [] files = new File("Languages").listFiles();
        Language [] languages = new Language[files.length];
        for(int i=0;i<files.length;i++)
            languages[i] = new Language(files[i]);
        boolean learning;
        int count = 0;
        int limit = 1000;
        do {
            count++;
            learning = false;
            for (Language languageToLearn : languages) {
                for (Language otherLanguage : languages) {
                    int correctAnswer = languageToLearn == otherLanguage ? 1 : 0;
                    for (double[] entry : otherLanguage.getFilesMap().values()) {
                        int i=0;
                        int lm = 150;
                        while (Math.pow(languageToLearn.getPerceptron().compute(entry) - correctAnswer, 2) > 0.001 && i < lm) {
                            i++;
                            languageToLearn.getPerceptron().learn(entry, correctAnswer);
                            learning = true;
                        }
                    }
                }
            }
        }while (learning && count < limit);
            File[] testingFolders = new File("Languages").listFiles();
            int correct = 0;
            int all = 0;
            for (File lang : testingFolders)
                for(File fileToTest : lang.listFiles())
                {
                    String answer = lang.getName();
                    double[] entry = FileMapper.FileToEntry(fileToTest);
                    Language winner = languages[0];
                    for (Language language : languages)
                        if (language.getPerceptron().compute(entry) > winner.getPerceptron().compute(entry))
                            winner = language;
                    if (winner.getDirectory().getName().equals(answer))
                        correct++;
                    all++;
                }
            System.out.println("Poprawnie zakwalifikowanych: " + correct + "/" + all + " --- Dokładność: " + (float) (correct) / all * 100 + "%");
        SwingUtilities.invokeLater(() -> new MyFrame(languages));


    }
}