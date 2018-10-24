package com.solarexsoft.javawithkotlin;

import com.solarexsoft.kotlininaction.*;

import java.util.ArrayList;

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(K3_2Kt.joinToString(list, ", ", "(", ")"));
        SolarexUtils.setOpCount(1000);
        SolarexUtils.performOperation();
        SolarexUtils.reportOperationCount();
        System.out.println(SolarexUtils.lastChar("Solarex"));
        View view = new Button();
        view.click();
        ExtensionKt.showOff(view);
        System.out.println(SolarexUtils.getLastChar("Java"));
        StringBuilder sb = new StringBuilder("Kotlin?");
        SolarexUtils.setLastChar(sb, '!');
        System.out.println(sb);
    }
}
