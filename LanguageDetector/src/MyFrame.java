import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyFrame extends JFrame {
    public MyFrame(Language[] languages) {
        setTitle("Language Detector 2.0");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 📝 Tekst wejściowy
        JTextArea jTextArea = new JTextArea(10, 30);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        jPanel.add(scrollPane);

        jPanel.add(Box.createVerticalStrut(20));

        // 🔘 Przycisk
        JButton jButton = new JButton("Check");
        jButton.setFont(new Font("Arial", Font.PLAIN, 24));
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(jButton);

        jPanel.add(Box.createVerticalStrut(20));

        // 🏆 Główna etykieta z najlepszym wynikiem
        JLabel jLabel = new JLabel("This is: ");
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel.setFont(new Font("Arial", Font.BOLD, 22));
        jPanel.add(jLabel);

        jPanel.add(Box.createVerticalStrut(10));

        // 📊 Etykiety wyników perceptronów
        JLabel[] resultLabels = new JLabel[languages.length];
        for (int i = 0; i < languages.length; i++) {
            JLabel label = new JLabel();
            label.setFont(new Font("Monospaced", Font.PLAIN, 16));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultLabels[i] = label;
            jPanel.add(label);
        }

        add(jPanel);
        setVisible(true);

        // 🎯 Obsługa przycisku
        jButton.addActionListener(l -> {
            String str = jTextArea.getText();
            double[] entry = FileMapper.TextToEntry(str);

            Language winner = languages[0];
            double bestScore = 0;

            for (int i = 0; i < languages.length; i++) {
                try {
                    double score = languages[i].getPerceptron().compute(entry);
                    String langName = languages[i].getDirectory().getName();
                    resultLabels[i].setText(String.format("%-15s %6.2f", langName + ":", score));

                    if (score > bestScore) {
                        bestScore = score;
                        winner = languages[i];
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            jLabel.setText("This is: " + winner.getDirectory().getName());
        });
    }
}
