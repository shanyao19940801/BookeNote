package com.thinkf.chapter11.c03;

import java.util.Arrays;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(
                new Crusty(),new Slush(), new Powder()
        );
        List<Snow> snows2 = Arrays.asList(
                new Light(), new Heavy()
        );
        snows1.add(new Light());
    }
}
