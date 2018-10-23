package com.solarexsoft.javawithkotlin;

import com.solarexsoft.kotlininaction.People;
import com.solarexsoft.kotlininaction.Rectangle;

/**
 * Created by houruhou on 11/12/2017.
 */
public class HelloJava {
    public static void main(String[] args){
        User user = new User(1, "solarex");
        System.out.println(user);
        People people = new People("Solarex", false);
        System.out.println(people.getName() + "," + people.isMarried());
        people.setMarried(true);
        Rectangle rectangle = new Rectangle(400, 300);
        System.out.println(rectangle.isLongSquare());
        System.out.println(rectangle.isSquare());
    }
}
