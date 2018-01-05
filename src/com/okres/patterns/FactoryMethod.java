package com.okres.patterns;

import java.util.Date;

public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker watchMaker = getMakerByModel("Romes");
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByModel(String model) {
        if (model.equals("Digital"))
            return new DigitalWatchMaker();
        else if (model.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("No such model!");
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();//This is fabric method
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}