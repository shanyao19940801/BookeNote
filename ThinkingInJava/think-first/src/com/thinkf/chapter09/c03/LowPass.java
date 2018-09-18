package com.thinkf.chapter09.c03;

public class LowPass extends Filter {
    double cutooff;

    public LowPass(double cutooff) {
        this.cutooff = cutooff;
    }

    public Waveform process (Waveform input) {
        return input;
    }
}
