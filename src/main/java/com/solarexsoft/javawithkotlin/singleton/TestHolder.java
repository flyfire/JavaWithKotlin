package com.solarexsoft.javawithkotlin.singleton;

/*
 * Created by Solarex on 2024/01/20 17:28
 */
public class TestHolder {
    private boolean addToken = true;

    private TestHolder(boolean b) {
        this.addToken = b;
        System.out.println(b + ", " + hashCode());
    }

    public void printAddToken() {
        System.out.println("addToken = " + addToken);
    }

    public static TestHolder getInstanceA() {
        return Holder.INSTANCE_A;
    }

    public static TestHolder getInstanceB() {
        return Holder.INSTANCE_B;
    }

    private static class Holder {
        private static final TestHolder INSTANCE_A = new TestHolder(true);
        private static final TestHolder INSTANCE_B = new TestHolder(false);
    }

    public static void main(String[] args) {
        TestHolder instanceA = TestHolder.getInstanceA();
        TestHolder instanceB = TestHolder.getInstanceB();
        instanceA.printAddToken();
        instanceB.printAddToken();
    }
}
