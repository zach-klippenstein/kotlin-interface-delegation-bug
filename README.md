# kotlin-interface-delegation-bug

Demo of a Kotlin compiler bug that prevents a Kotlin interface from implementing a Java interface by delegation.

If you have a Java interface that looks like this:

```
public interface Interface<T> {
  void doThing(@NotNull T arg);
}
```

And a Kotlin class that tries implementing it using delegation, like this:

```
class Implementation(delegate: Interface<Int>) : Interface<Int> by delegate {

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
