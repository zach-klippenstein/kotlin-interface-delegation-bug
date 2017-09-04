import org.jetbrains.annotations.NotNull;

public interface Interface<T> {
  void doThing(@NotNull T arg);
}
