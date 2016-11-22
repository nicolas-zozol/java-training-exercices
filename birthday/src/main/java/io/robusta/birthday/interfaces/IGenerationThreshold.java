package io.robusta.birthday.interfaces;

/**
 * Created by Nicolas Zozol on 04/10/2016.
 */
public interface IGenerationThreshold {


    /**
     * Returns a small number for quick test
     * @return
     */
    int getSmallNumber();

    /**
     * Returns a big number to validate test
     * @return
     */
    int getBigNumber();
    
    float calculateProbabilityOfSame(int size);

    int findSmallestNumberOfPeopleRequiredToHave50();


}
