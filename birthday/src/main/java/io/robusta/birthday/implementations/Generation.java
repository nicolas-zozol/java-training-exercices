package io.robusta.birthday.implementations;

import io.robusta.birthday.interfaces.IGeneration;
import io.robusta.birthday.interfaces.IPeopleCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public class Generation implements IGeneration{

    List<IPeopleCollection> collections;

    public Generation(){

    }

    public Generation(int n, int collectionSize) {
        this.collections = createAllRandom(n, collectionSize);
    }

    @Override
    public IPeopleCollection createRandom(int size) {
        return null;
    }

    @Override
    public List<IPeopleCollection> createAllRandom(int n, int size) {
        // call n times createRandom(size)
        return null;
    }

    @Override
    public List<PeopleCollection> getPeopleCollection() {
        return null;
    }

    @Override
    public int getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday() {
        return 0;
    }

    @Override
    public boolean isLessThan50() {
        return false;
    }


}
