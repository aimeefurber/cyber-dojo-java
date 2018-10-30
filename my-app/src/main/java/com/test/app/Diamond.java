package com.test.app;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class Diamond {
    final static String alphabetSoup = "a b c d e f g h i j k l m n o p q r s t u v w x y z";

    public String make(String finalLetter) {
        List<String> rowLetters = getDiamondRowLetters(finalLetter);

        return rowLetters.stream().map(l -> getLine(l, finalLetter)).collect(Collectors.joining(""));
    }

    public List<String> getLetters(String startingLetter) {
        int index = getAlphabet().indexOf(startingLetter) + 1;
        List<String> letters = getAlphabet().subList(0, index);
        return letters;
    }

    private ArrayList<String> getAlphabet() {
        ArrayList<String> alphabet = new ArrayList<>();
        alphabet.addAll(Arrays.asList(alphabetSoup.split(" ")));
        return alphabet;
    }

    public int getSpacesBetweenLetters(String letter) {
        int i = getAlphabet().indexOf(letter);

        if (i == 0) {
            return 0;
        }

        int index = i * 2 - 1;

        return index;
    }

    public int getIndentOfLetter(String indentedLetter, String finalLetter) {
        List<String> letters = getLetters(finalLetter);
        Collections.reverse(letters);
        return letters.indexOf(indentedLetter);
    }

    public String getLine(String letter, String finalLetter) {
        int indent = getIndentOfLetter(letter, finalLetter);
        int spaces = getSpacesBetweenLetters(letter);
        if (spaces == 0 ){
            return join("", Collections.nCopies(indent, " ")) + letter + "\n";
        }
        return join("", Collections.nCopies(indent, " ")) + letter + join("", Collections.nCopies(spaces, " ")) + letter + "\n";
    }

    public List<String> getDiamondRowLetters(String finalLetter) {
        List<String> letters = getLetters(finalLetter);
        List<String> reverseLetters = getLetters(finalLetter);
        Collections.reverse(reverseLetters);

        reverseLetters.remove(0);
        letters.addAll(reverseLetters);

        return letters;
    }
}
