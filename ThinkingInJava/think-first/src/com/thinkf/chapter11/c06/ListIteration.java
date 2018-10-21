package com.thinkf.chapter11.c06;

import com.thinkf.typeinfo.pets.Pet;
import com.thinkf.typeinfo.pets.Pets;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> iteration = pets.listIterator();
        while (iteration.hasNext()) {
            System.out.println(iteration.next() + ", " + iteration.nextIndex() + ", " + iteration.previousIndex() + "; ");
        }
            System.out.println();
            System.out.println(pets);
            iteration = pets.listIterator(1);

            while (iteration.hasNext()) {
                iteration.next();
                iteration.set(Pets.randomPet());
            }
            System.out.println(pets);

    }
}
