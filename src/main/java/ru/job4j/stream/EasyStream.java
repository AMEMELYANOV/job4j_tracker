package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> easyStream;

    private EasyStream(List<Integer> source) {
        easyStream = source;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer element : easyStream) {
            rsl.add(fun.apply(element));
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer element : easyStream) {
            if (fun.test(element)) {
                rsl.add(element);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return easyStream;
    }
}
