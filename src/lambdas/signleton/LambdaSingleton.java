package lambdas.signleton;


import java.util.function.Supplier;

public class LambdaSingleton
{
    private static Supplier<LambdaSingleton> instance = () -> createAndCacheSingleton();

    public LambdaSingleton() {
        System.out.println("Singleton Initialized");
    }

    public static LambdaSingleton getInstance() {
        return instance.get();
    }

    // Body of synchronized supplier
    private static synchronized LambdaSingleton createAndCacheSingleton()
    {
        System.out.println("In Synchronized Supplier");

        // Second non-synchronized(dummy) supplier
        class DummySupplier implements Supplier<LambdaSingleton>
        {
            private final LambdaSingleton instance = new LambdaSingleton();

            public LambdaSingleton get()
            {
                System.out.println("In non-synchronized Supplier");
                return instance;
            }
        }

        if(!(instance instanceof DummySupplier))
        {
            instance = new DummySupplier();
        }

        return instance.get();
    }

    public static void main(String[] args) throws Exception
    {
        Class.forName(LambdaSingleton.class.getName());
//        LambdaSingleton.getInstance();
//        LambdaSingleton.getInstance();
    }

}
