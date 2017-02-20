package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.PeopleCollection;

import java.util.List;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public interface IGeneration {


    IPeopleCollection createRandom(int size);

    List<? extends PeopleCollection> createAllRandom(int n, int size);

    List<? extends PeopleCollection> getPeopleCollections();

    int getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday();

    boolean isLessThan50();

}
