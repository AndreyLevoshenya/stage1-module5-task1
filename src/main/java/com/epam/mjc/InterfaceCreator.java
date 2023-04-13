package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String word : list) {
                if(!Character.isUpperCase(word.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
    return list -> {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if(list.get(i) % 2 == 0) {
                list.add(list.get(i));
            }
        }
    };
    }


    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(sentence -> !Character.isUpperCase(sentence.charAt(0)) || sentence.charAt(sentence.length() - 1) != '.' || sentence.split(" ").length <= 3);
        return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String string : list) {
                map.put(string, string.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return new ArrayList<>(list1);
        };
    }
}
