package lambdas.signleton;


import java.util.function.Supplier;

public class LambdaSingleton
{
    private static Supplier<LambdaSingleton> accessor = () -> createAndCacheSingleton();

    public LambdaSingleton() {
        System.out.println("Gettin' instance");
    }

    public static LambdaSingleton getInstance() {
        return accessor.get();
    }

    // Synchronized supplier
    private static synchronized LambdaSingleton createAndCacheSingleton()
    {
        System.out.println("In Synchronized Supplier");

        // Non-synchronized(dummy) supplier
        class DummySupplier implements Supplier<LambdaSingleton>
        {
            private LambdaSingleton instance;

            DummySupplier(LambdaSingleton instance)
            {
                this.instance = instance;
            }

            public LambdaSingleton get()
            {
                System.out.println("In non-synchronized Supplier");
                return instance;
            }
        }

        if(accessor instanceof DummySupplier)
        {
            return accessor.get();
        }

        LambdaSingleton instance = new LambdaSingleton();
        accessor = new DummySupplier(instance);
        return instance;
    }

    public static void main(String[] args) throws Exception
    {
        Class.forName(LambdaSingleton.class.getName());
        LambdaSingleton.getInstance();
    }
}
