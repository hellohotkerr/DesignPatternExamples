package google.design.pattern.structure;

import java.awt.*;

public class DecoratorPatten2 {
    public abstract class Component{
        public abstract void display();
    }
    public class Window extends Component{

        @Override
        public void display() {
            //display
        }
    }
    public class TextBox extends Component{

        @Override
        public void display() {
            //display
        }
    }
    public class ListBox extends Component{

        @Override
        public void display() {
            //display
        }
    }
    public class ComponentDecorator extends Component{
        private  Component component;

        public ComponentDecorator(Component component) {
            this.component = component;
        }

        @Override
        public void display() {
            component.display();
        }
    }
    public class ScrollBarDecorator extends ComponentDecorator{

        public ScrollBarDecorator(Component component) {
            super(component);
        }

        @Override
        public void display() {
            this.setScrollBar();
            super.display();
        }

        private void setScrollBar() {
            System.out.println("add scroll bar");
        }
    }
    public class BlackBorderDecorator extends ComponentDecorator{

        public BlackBorderDecorator(Component component) {
            super(component);
        }

        @Override
        public void display() {
            this.setBlackBorder();
            super.display();
        }

        private void setBlackBorder() {
            System.out.println("add black border");
        }
    }

    public class Client{
        public void main(String[] args) {
            Component component,componentSB,componentBB;
            component = new Window();
            componentSB = new ScrollBarDecorator(component);
            componentBB = new BlackBorderDecorator(componentSB);
            componentBB.display();
        }
    }
}
