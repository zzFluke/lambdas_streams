package lambdas.signleton;


public class InnerClassSingleton
{
    //1 Eager initialization
    private static final FunctionPointerSingleton INSTANCE = new FunctionPointerSingleton();

    public InnerClassSingleton()
{
    System.out.println("Gettin' instance");
}

    public static class SingletonHolder
    {
        public static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) throws Exception
    {
//        Class.forName(InnerClassSingleton.class.getName());
//        InnerClassSingleton.getInstance();
    }
}
