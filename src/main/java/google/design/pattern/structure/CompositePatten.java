package google.design.pattern.structure;

import java.util.ArrayList;

public class CompositePatten {
    public abstract class Component {
        public abstract void add(Component component);

        public abstract void remove(Component component);

        public abstract Component getChild(int i);

        public abstract void operation();
    }
    public class Leaf extends Component {

        @Override
        public void add(Component component) {
            //异常处理或错误提示
        }

        @Override
        public void remove(Component component) {
            //异常处理或错误提示
        }

        @Override
        public Component getChild(int i) {
            //异常处理或错误提示
            return null;
        }

        @Override
        public void operation() {
        //detail ....
        }
    }
    public class Composite extends Component {
        private ArrayList<Component> list = new ArrayList<>();

        @Override
        public void add(Component component) {
            list.add(component);
        }

        @Override
        public void remove(Component component) {
            list.remove(component);
        }

        @Override
        public Component getChild(int i) {
            return list.get(i);
        }

        @Override
        public void operation() {
            for (Component component : list) {
                component.operation();
            }
        }
    }
}
