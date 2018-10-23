package com.thinkf.chapter11.c12;

import com.thinkf.typeinfo.pets.Pet;
import com.thinkf.typeinfo.pets.Pets;

import java.util.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        System.out.print("Iterator:");
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets) {
        System.out.print("Collections:");
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap =
                new LinkedHashMap<>();
        String[] names = ("ralph, Eric, Robin, Shan, Yao, Li, Jia, Sh").split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());


    }
}
