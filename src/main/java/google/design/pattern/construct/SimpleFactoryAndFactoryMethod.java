package google.design.pattern.construct;

public class SimpleFactoryAndFactoryMethod {
    //Simple Factory Pattern
    public abstract class Product{
        public void methodName(){}
        public abstract void methodDiff();
    }
    public class ConcreteProductA extends Product{
        @Override
        public  void methodDiff(){
            //....
        }
    }
    public class ConcreteProductB extends Product{
        @Override
        public  void methodDiff(){
            //....
        }
    }
    public class Factory{
        public  Product getFactory(String args){
            Product product = null;
            if (args.equalsIgnoreCase("A")) {
                product = new ConcreteProductA();
                //init A
            } else if (args.equalsIgnoreCase("B")) {
                product = new ConcreteProductB();
                //init B
            }
            return product;

        }
    }

    // Factory Method Pattern
    public interface FactoryInterface{
        public Product factoryMethod();
    }
    public class ConcreteFactory implements FactoryInterface{

        @Override
        public Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

}
