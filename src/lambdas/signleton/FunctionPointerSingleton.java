package lambdas.signleton;

public class FunctionPointerSingleton
{
    // 1 Eager initialization
//    private static final FunctionPointerSingleton INSTANCE = new FunctionPointerSingleton();
    private static FunctionPointer<FunctionPointerSingleton> accessor = new SyncFunctionPointer();

    public FunctionPointerSingleton()
    {
        System.out.println("Singleton Initialized");
    }

    // 2. Initialization-on-demand holder
    public static class SingletonHolder
    {
        public static final FunctionPointerSingleton INSTANCE = new FunctionPointerSingleton();
    }

    public static FunctionPointerSingleton getInstance()
    {
//        return SingletonHolder.INSTANCE;
          return accessor.get();
    }

    public static void main(String[] args) throws Exception
    {
//        Class.forName(FunctionPointerSingleton.class.getName());
        FunctionPointerSingleton.getInstance();
//        FunctionPointerSingleton.getInstance();
//        FunctionPointerSingleton.getInstance();

    }


    // 3. Function pointer singleton
    public static class SyncFunctionPointer implements FunctionPointer<FunctionPointerSingleton>
    {
        @Override
        public synchronized FunctionPointerSingleton get() {
            System.out.println("Synchronized Function Pointer");
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
            System.out.println("Dummy Function Pointer");
            return instance;
        }
    }
}

interface FunctionPointer<T>
{
    public T get();
}
