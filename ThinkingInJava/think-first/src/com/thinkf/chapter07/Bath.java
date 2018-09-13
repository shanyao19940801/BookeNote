package com.thinkf.chapter07;

public class Bath {
    private String s1 = "h",s2 = "h", s3, s4;
    private Soap castitle;
    private int i;
    private float toy;
    public Bath() {
        System.out.println("insid bath()");
        s3 = "j";
        toy = 3.14f;
        castitle = new Soap();
    }

    @Override
    public String toString() {
        if (s4 == null) {
            s4 = "j";
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castitle=" + castitle +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }
    {
        System.out.println("iiii");
        i = 47;
    }


    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}

class Soap {
    private String s;

    public Soap() {
        System.out.println("SOAP()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
