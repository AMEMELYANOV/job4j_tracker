package ru.job4j.pojo;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 0);
        assertThat(rsl[0].getName(), is("Bread"));
        assertThat(rsl[0].getCount(), is(4));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 1);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[0].getCount(), is(10));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropMiddle() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = null;
        products[3] = new Product("Butter", 8);
        products[4] = new Product("Cheese", 5);
        Product[] rsl = ShopDrop.leftShift(products, 2);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1].getName(), is("Bread"));
        assertThat(rsl[2].getName(), is("Butter"));
        assertThat(rsl[3].getName(), is("Cheese"));
        assertThat(rsl[4], is(nullValue()));
    }
}