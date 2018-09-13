package com.thinkf.chapter07;

public class SpaecShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaecShipDelegation(String name) {
        this.name = name;
    }
    public void up(int ve) {
        controls.up(ve);
    }
    public void down(int ve) {
        controls.down(ve);
    }

    public static void main(String[] args) {
        SpaecShipDelegation pro = new SpaecShipDelegation("nsa pr");
        pro.up(123);
    }
}
