package google.design.pattern.structure;

public class DecoratorPatten {
    public abstract class Component{
        public abstract void operation();
    }
    public class ConcreteComponent extends Component{

        @Override
        public void operation() {
            //detail ....
        }
    }

    public class Decorator extends Component{
        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }
    public class ConcreteDecorator extends Decorator {
        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addBehavior();
        }

        private void addBehavior() {
            //....
        }
    }
}
