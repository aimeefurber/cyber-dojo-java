package com.test.app;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DiamondMakerTest {
    Diamond diamond;

    @Before
    public void before() {
        diamond = new Diamond();
    }

    @Test
    public void canPrintADiamond() {

    }

    @Test
    public void itCanPrintASingleLetterDiamond() {
        assertEquals("a\n", diamond.make("a"));
    }

    @Test
    public void itCanGetAllTheLettersFromAToTheGivenLetter() {
        List<String> expecteLetters = new ArrayList();
        expecteLetters.add("a");
        expecteLetters.add("b");

        List<String> letters = diamond.getLetters("b");

        assertEquals(expecteLetters, letters);
    }

    @Test
    public void itCanGetTheWholeAlphabet() {
        List<String> letters = diamond.getLetters("z");
        assertEquals(26, letters.size());
        assertEquals("g", letters.get(6));

    }

    @Test
    public void itCanGetTheSpacesBettwenLettersInTheDiamondForAGivenLetter() {
        String letter = "d";

        int spaces = diamond.getSpacesBetweenLetters(letter);

        assertEquals(5, spaces);
    }

    @Test
    public void itCanGetTheIndentForALetterInTheContextOfTheDiamond() {
        String indentedLetter = "a";
        String finalLetter = "d";

        int indentOfIndented = diamond.getIndentOfLetter(indentedLetter, finalLetter);
        assertEquals(3, indentOfIndented);
    }

    @Test
    public void itCanGetTheIndentForAnotherLetterInTheContextOfTheDiamond() {
        String indentedLetter = "c";
        String finalLetter = "d";

        int indentOfIndented = diamond.getIndentOfLetter(indentedLetter, finalLetter);
        assertEquals(1, indentOfIndented);
    }

    @Test
    public void itCanMakeALineForALetter() {
        String expected = " b b\n";
        String letter = "b";
        String finalLetter = "c";

        String line = diamond.getLine(letter, finalLetter);

        assertEquals(expected, line);
    }

    @Test
    public void itCanMakeAListOfLettersToPlot() {
        List<String> expectedLetters = new ArrayList<>();
        String[] l = new String[]{"a", "b", "c", "b", "a"};
        expectedLetters.addAll(Arrays.asList(l));

        assertEquals(expectedLetters, diamond.getDiamondRowLetters("c"));
    }

    @Test
    public void itMakeMakeADiamond() {
        String expectedDiamond =
                        "  a\n" +
                        " b b\n" +
                        "c   c\n" +
                        " b b\n" +
                        "  a\n";

        String finalLetter = "c";

        String diamond = this.diamond.make(finalLetter);

        assertEquals(expectedDiamond, diamond);
    }

    @Test
    public void itCanStillGetTheRightLettersRegardlessOfCase() {
        fail();
    }

    @Test
    public void itCanHandleNoSpaces(){
        String letter = "a";

        int spaces = diamond.getSpacesBetweenLetters(letter);

        assertEquals(0, spaces);
    }

    @Test
    public void itCanHandleNoIndent(){
        String finalLetter = "c";

        int indent = diamond.getIndentOfLetter(finalLetter, finalLetter);

        assertEquals(0, indent);

    }
}
