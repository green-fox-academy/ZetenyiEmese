package com.greenfoxacademy.frontendjson.services;

import com.greenfoxacademy.frontendjson.models.SithText;
import com.greenfoxacademy.frontendjson.models.Text;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SithService {

  private ArrayList<String> weirdWords = new ArrayList<>();

  public SithService() {
    weirdWords.add("Arrgh.");
    weirdWords.add("Uhmmm.");
    weirdWords.add("Err..err.err.");
    weirdWords.add("Hmmm.");
    weirdWords.add("Khaaa.");
  }

  public SithText transformText(Text text) {
    ArrayList<String> words = createWordList(text);
    ArrayList<String> sithWords = new ArrayList<>();

    int size = words.size();
    int i = 0;

    while (i < size) {
      String firstWord = words.get(i);

      if (endsWithDot(firstWord)) {
        sithWords.add(firstWord);
        addSomeWeirdWords(sithWords);
        i += 1;

      } else {
        String nextWord = words.get(i + 1);

        if (endsWithDot(nextWord)) {
          nextWord = nextWord.substring(0, nextWord.length() - 1);
          firstWord = firstWord.concat(".");
        }
        if (startsWithCapital(firstWord)) {
          firstWord = firstWord.toLowerCase();
          nextWord = nextWord.substring(0, 1).toUpperCase() + nextWord.substring(1);
        }

        sithWords.add(nextWord);
        sithWords.add(firstWord);

        if (endsWithDot(firstWord)) {
          addSomeWeirdWords(sithWords);
        }
        i += 2;
      }
    }

    return createSithText(sithWords);
  }

  private ArrayList<String> createWordList(Text text) {
    String[] wordsInArray = text.getText().split(" ");
    ArrayList<String> wordsInList = new ArrayList<>();

    for (String word : wordsInArray) {
      wordsInList.add(word);
    }
    return wordsInList;
  }

  private boolean endsWithDot(String word) {
    return word.charAt(word.length() - 1) == '.';
  }

  private boolean startsWithCapital(String word) {
    return word.charAt(0) == word.toUpperCase().charAt(0);
  }

  private void addSomeWeirdWords(ArrayList<String> words) {
    int random = (int) (Math.random() * 2) + 1; //1 or 2

    for (int i = 0; i < random; i++) {
      int randomIndex = (int) (Math.random() * weirdWords.size());
      String weirdWord = weirdWords.get(randomIndex);
      words.add(weirdWord);
    }
  }

  private SithText createSithText(ArrayList<String> words) {
    return new SithText(String.join(" ", words));
  }

}
