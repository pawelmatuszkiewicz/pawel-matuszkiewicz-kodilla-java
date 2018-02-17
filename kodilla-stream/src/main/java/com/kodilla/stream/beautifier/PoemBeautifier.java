package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String string, PoemDecorator poemDecorator) {
        String beautifiedText = poemDecorator.decorate(string);
        System.out.println(beautifiedText);
    }
}
