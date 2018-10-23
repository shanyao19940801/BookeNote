package com.thinkf.chapter11.c12;

import com.thinkf.typeinfo.pets.Pet;
import com.thinkf.typeinfo.pets.Pets;

import java.util.Iterator;

class PetSequeue {
    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequeue extends PetSequeue{
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Pet next() {
                return null;
            }
        };
    }

}
