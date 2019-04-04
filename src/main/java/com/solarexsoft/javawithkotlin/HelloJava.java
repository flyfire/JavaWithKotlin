package com.solarexsoft.javawithkotlin;

import com.solarexsoft.kotlinexercise.TestInline;
import com.solarexsoft.kotlininaction.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by houruhou on 11/12/2017.
 */
public class HelloJava {
    public String platformType = null;
    public Collection<String> platformCollection = new ArrayList<>();

    public static void main(String[] args) {
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
        try {
            Class.forName("com.solarexsoft.kotlinexercise.TestInline");
        } catch (Exception e) {

        }
        System.out.println(SolarexUtils.lastChar("Solarex"));
        View view = new Button();
        view.click();
        ExtensionKt.showOff(view);
        System.out.println(SolarexUtils.getLastChar("Java"));
        StringBuilder sb = new StringBuilder("Kotlin?");
        SolarexUtils.setLastChar(sb, '!');
        System.out.println(sb);
        CaseInsensitiveFileComparator.INSTANCE.compare(new File("/z"), new File("/c"));
        KKUser.Companion.newFacebookUser(1);
        KKUser.Companion.newSubscirbeingUser("a@b.com");
    }
}
