package io.robusta.trainings.lambdas;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nicolas Zozol on 11/07/2017.
 */
public class FunctionalCodeSolution implements FunctionalCode {
    @Override
    public List<Integer> doubling(List<Integer> inputs) {
        return inputs;
    }

    @Override
    public List<Integer> sort(List<Integer> nums) {
        return nums;
    }

    @Override
    public List<Integer> reverseSort(List<Integer> nums) {
        return nums;
    }

    @Override
    public List<String> mutableFilter(List<String> strings,String chain ) {

        strings.removeIf(s -> s.contains(chain));
        return strings;
    }
}
