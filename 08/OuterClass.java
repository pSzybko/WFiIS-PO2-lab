public class OuterClass{
    interface Inner{
        String getName();
        void saySomething();
    }
    public Inner instantiateFirst(){
        Inner inner=new InnerClassFirst();
        return inner;
    }
    public Inner instantiateSecond(){
        Inner inner=new InnerClassSecond();
        return inner;
    }
    class InnerClassFirst implements Inner{
        InnerClassFirst(){  
            System.out.println("Tworze klase wewnetrzna pierwsza");
        }
        final private String name="first";
        public String getName(){
            return name;
        }
        @Override
        public void saySomething(){
            System.out.println("Say something "+getName());
        }
    }
    static class InnerClassSecond implements Inner{
        InnerClassSecond(){  
            System.out.println("Tworze klase wewnetrzna druga");
        }
        final private String name="second";
        public String getName(){
            return name;
        }
        @Override
        public void saySomething(){
            System.out.println("Say something "+getName());
        }
    }
}