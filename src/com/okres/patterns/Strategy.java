package com.okres.patterns;

import java.util.Arrays;

public class Strategy {
    /*Реализация паттерна Стратегия*/
}

interface Processor {
    public String name();

    public Object process(Object input);
}

abstract class StringProcessor implements Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    public Object process(Object input) {
        return input;
    }
}

class Upcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();// Ковариантный возвращаемый тип
    }
}

class Downcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}

class Apply {
    public static void process(Processor p, Object o) {
        System.out.println("Use Processor " + p.name());
        System.out.println(p.process(o));
    }

    public static String s = "It will be a great year!";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}