package com.springinaction.chapter02;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc{

    private String title = "Sgt. Pepper's Lonely";
    private String artist = "The Beatles";
    @Override
    public void play() {
        System.out.println("Playing " + title + " by" + artist);
    }
}
