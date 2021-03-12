package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenMatrixNot0() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> result = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expected));
    }

    @Test
    public void whenMatrix0() {
        Integer[][] matrix = {};
        List<Integer> result = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of();
        assertThat(result, is(expected));
    }
}
