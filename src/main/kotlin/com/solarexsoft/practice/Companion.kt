package com.solarexsoft.practice

interface A {
    companion object {
        fun hello() {
            println("hello")
        }
    }
}

/***
@Metadata(
mv = {1, 4, 3},
bv = {1, 0, 3},
k = 1,
d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"},
d2 = {"Lcom/solarexsoft/practice/A;", "", "Companion", "javawithkotlin.main"}
)
public interface A {
@NotNull
A.Companion Companion = A.Companion.$$INSTANCE;

@Metadata(
mv = {1, 4, 3},
bv = {1, 0, 3},
k = 1,
d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
d2 = {"Lcom/solarexsoft/practice/A$Companion;", "", "()V", "hello", "", "javawithkotlin.main"}
)
public static final class Companion {
// $FF: synthetic field
static final A.Companion $$INSTANCE;

public final void hello() {
String var1 = "hello";
boolean var2 = false;
System.out.println(var1);
}

private Companion() {
}

static {
A.Companion var0 = new A.Companion();
$$INSTANCE = var0;
}
}
}
***/