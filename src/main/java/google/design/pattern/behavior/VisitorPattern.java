package google.design.pattern.behavior;

import java.util.ArrayList;
import java.util.Iterator;

public class VisitorPattern {
    public abstract class Visitor{
        public abstract void visit(ConcreteElementA elementA);
        public abstract void visit(ConcreteElementB elementB);
        public  void visit(ConcreteElementC elementC){

        }
    }
    public class ConcreteVisitor extends Visitor{

        @Override
        public void visit(ConcreteElementA elementA) {

        }

        @Override
        public void visit(ConcreteElementB elementB) {

        }
    }
    public interface Element{
        void accept(Visitor visitor);
    }
    public class ConcreteElementA implements Element{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public void operationA() {
            //...
        }
    }
    public class ConcreteElementB implements Element{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public void operationA() {
            //...
        }
    }
    public class ConcreteElementC implements Element{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public void operationA() {
            //...
        }
    }
    public class ObjectStructure{
        private ArrayList<Element> list = new ArrayList<>();

        public void accept(Visitor visitor) {
            Iterator<Element> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next().accept(visitor);
            }
        }

        public void addElement(Element element) {
            list.add(element);
        }

        public void removeElement(Element element) {
            list.remove(element);
        }
    }
}
