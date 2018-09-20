package com.thinkf.chapter09.c04;

interface CanFight{
    void fight();
}

class ActionCharacter{
    public void fight(){
        System.out.println("ff");
    }
}

class Hero extends ActionCharacter implements CanFight {

}
public class Adventure {
    public static void main(String[] args) {

    }
}
