package com.thinkf.chapter11.c06;

import com.thinkf.typeinfo.pets.Pet;
import com.thinkf.typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

public class SimpleIteration {
    public static void main(String[] args) {

        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it =  pets.iterator();
        System.out.println(pets);
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        for (Pet p : pets) {
            System.out.println();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
