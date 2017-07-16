package io.robusta.trainings.lambdas;

import java.util.List;

/**
 * Created by Nicolas Zozol on 11/07/2017.
 */
public interface FunctionalCode {

    List<Integer> doubling(List<Integer> nums);

    List<Integer> sort(List<Integer> nums);

    List<Integer> reverseSort(List<Integer> nums);

    List<String> mutableFilter(List<String> strings, String chain );

}
