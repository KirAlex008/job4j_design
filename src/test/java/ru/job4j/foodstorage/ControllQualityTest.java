package ru.job4j.foodstorage;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.foodstorage.ControllQuality.quality;

public class ControllQualityTest {

        @Test
        public void whenPrecentIs76() throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
            Date expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 30)));
            Date createDate = sdf.parse(sdf.format(new Date(2020, 11, 17)));
            Food food = new Food1("food1",expaireDate, createDate, 100, 30);
            ControllQuality control = new ControllQuality();
            int result = quality(food, today);
            System.out.println(result);
            int expect = 76;
            assertThat(result, is(expect));
        }

    @Test
    public void whenPrecentIs62() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
        Date expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 25)));
        Date createDate = sdf.parse(sdf.format(new Date(2020, 11, 17)));
        Food food = new Food1("food1",expaireDate, createDate, 100, 30);
        ControllQuality control = new ControllQuality();
        int result = quality(food, today);
        System.out.println(result);
        int expect = 62;
        assertThat(result, is(expect));
    }

    @Test
    public void whenPrecentIs16() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
        Date expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 22)));
        Date createDate = sdf.parse(sdf.format(new Date(2020, 11, 10)));
        Food food = new Food1("food1",expaireDate, createDate, 100, 30);
        ControllQuality control = new ControllQuality();
        int result = quality(food, today);
        System.out.println(result);
        int expect = 16;
        assertThat(result, is(expect));
    }

    @Test
    public void whenPrecentIs0() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
        Date expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 19)));
        Date createDate = sdf.parse(sdf.format(new Date(2020, 11, 10)));
        Food food = new Food1("food1",expaireDate, createDate, 100, 30);
        ControllQuality control = new ControllQuality();
        int result = quality(food, today);
        System.out.println(result);
        int expect = -11;
        assertThat(result, is(expect));
    }



}