package lambdas.signleton;

public class FunctionPointerSingleton
{

    private static FunctionPointer<FunctionPointerSingleton> accessor = new SyncFunctionPointer();

    public FunctionPointerSingleton()
    {
        System.out.println("Gettin' instance");
    }


    public static FunctionPointerSingleton getInstance()
    {
          return accessor.get();
    }

    public static class SyncFunctionPointer implements FunctionPointer<FunctionPointerSingleton>
    {
        @Override
        public synchronized FunctionPointerSingleton get() {
            System.out.println("In synchronized function pointer");
            if (accessor != this)
            {
                return accessor.get();
            }

            FunctionPointerSingleton instance = new FunctionPointerSingleton();
            accessor = new DummyFunctionPointer(instance);
            return instance;
        }
    }

    public static class DummyFunctionPointer implements FunctionPointer<FunctionPointerSingleton>
    {
        FunctionPointerSingleton instance;

        public DummyFunctionPointer(FunctionPointerSingleton instance)
        {
            this.instance = instance;
        }

        @Override
        public FunctionPointerSingleton get() {
            System.out.println("In non-synchronized function pointer");
            return instance;
        }
    }

    public static void main(String[] args) throws Exception
    {
        Class.forName(FunctionPointerSingleton.class.getName());
        FunctionPointerSingleton.getInstance();

    }
}

interface FunctionPointer<T>
{
    public T get();
}
