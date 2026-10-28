# 🌍 Language Detector

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Swing-blue)
![Neural Network](https://img.shields.io/badge/AI-Perceptron_Network-green)

**Language Detector** is a desktop application written in **Java** with the **Swing** library that recognizes the language of a given text. It uses a **single-layer neural network** implemented from scratch, without any external machine learning libraries.

## 📸 Screenshots

<table>
  <tr>
    <td align="center" width="33%">
      <img src="https://i.imgur.com/vLhVx7F.png" alt="Swedish Detected" width="100%"><br>
      <b>Swedish Detected</b>
    </td>
    <td align="center" width="33%">
      <img src="https://i.imgur.com/luELhjY.png" alt="Polish Detected" width="100%"><br>
      <b>Polish Detected</b>
    </td>
    <td align="center" width="33%">
      <img src="https://i.imgur.com/Pf7SqKX.png" alt="English Detected" width="100%"><br>
      <b>English Detected</b>
    </td>
  </tr>
</table>

## 💡 About the Project

The program can detect one of six languages:
* **Polish**
* **English**
* **German**
* **Italian**
* **Swedish**
* **Portuguese**

Language classification is done by a **single-layer neural network** made of six independent **perceptrons** – one for each language.

The network's input is a vector describing the **frequency of each letter of the Latin alphabet** (from `a` to `z`) in the analyzed text. Based on this letter profile, the network picks the language that matches the text best.

### ✨ Key Features:
* **Neural Network Built from Scratch** – perceptrons with a sigmoid activation function, trained with the delta rule.
* **Training on Startup** – the network learns from sample texts in the `Languages` folder every time the program starts, and the classification accuracy is printed to the console.
* **Letter Frequency Analysis** – the input is case-insensitive, and accented letters (e.g. `ą`, `ö`, `ß`) are mapped to their base Latin letters.
* **Graphical User Interface** – type or paste a text, click **Check** and instantly see the detected language together with the score for every language.
* **Easy to Extend** – adding a new language only requires a new folder with sample texts.

## 🛠️ Technologies & Tools

* **Programming Language:** Java
* **GUI Library:** Swing
* **AI:** Single-layer perceptron network (implemented manually)

## 👤 Author

* **[Jędrzej Nowakowski (End0m0nd0)](https://github.com/End0m0nd0)** - Developer

## 🚀 How to Run the Project

### Requirements
* [Git](https://git-scm.com/downloads)
* **Java Development Kit (JDK) 14** or newer – check with `javac -version`
* Windows / Linux / macOS

### Steps
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/End0m0nd0/LanguageDetector.git
   ```
2. Go to the folder with the source files:
   ```bash
   cd LanguageDetector/LanguageDetector/src
   ```
3. Compile all `.java` files:
   ```bash
   javac *.java
   ```
4. Run the program **from inside the `src` folder** – it loads the training texts from `../Languages`:
   ```bash
   java Main
   ```
5. After a short training phase, the classification accuracy is printed to the console and the application window opens.

## 🔤 Adding a New Language

1. Create a new folder in `Languages/` named after the language (e.g. `Languages/French`).
2. Put a few `.txt` files with sample texts in that language inside it.
3. Run the program again – a new perceptron is created and trained for the language automatically.
