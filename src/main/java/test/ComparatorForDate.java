package test;

import java.util.Comparator;

/**
 * Created by vladimir on 24.07.2018.
 */
public class ComparatorForDate implements Comparator<Data> {
    @Override
    public int compare(Data o1, Data o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
