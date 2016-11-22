package io.robusta.birthday.interfaces;

import io.robusta.birthday.implementations.PeopleCollection;

import java.util.List;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public interface IGeneration {


    IPeopleCollection createRandom(int size);

    List<IPeopleCollection> createAllRandom(int n, int size);

    List<PeopleCollection> getPeopleCollection();

    int getNumberOfCollectionsThatHasTwoPeopleWithSameBirthday();

    boolean isLessThan50();

}
