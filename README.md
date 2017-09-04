# kotlin-interface-delegation-bug

Demo of a Kotlin compiler bug that prevents a Kotlin interface from implementing a Java interface by delegation,
when a method on the interface accepts a boxed primitive type.

If you have a Java interface that looks like this:

```
public interface Interface {
  void doThing(@NotNull Integer arg);
}
```

And a Kotlin class that tries implementing it using delegation, like this:

```
class Implementation(delegate: Interface) : Interface by delegate {

  override fun doThing(arg: Int) {
    TODO()
  }
}
```

The Kotlin compiler will complain about conflicting overloads of the `doThing` method:

```
…/src/main/java/Implementation.kt: (3, 3): Conflicting overloads: public open fun doThing(arg: Int): Unit defined in Implementation, public open fun doThing(@NotNull arg: Int): Unit defined in Implementation
…/src/main/java/Interface.java: (4, 3): Conflicting overloads: public open fun doThing(arg: Int): Unit defined in Implementation, public open fun doThing(@NotNull arg: Int): Unit defined in Implementation
```
