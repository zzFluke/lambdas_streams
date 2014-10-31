package lambdas;

import java.util.function.Function;


@FunctionalInterface
public interface FunctionalInterfaces<T, U>
{
    U apply(T t);

//    void secondMethod();
}
