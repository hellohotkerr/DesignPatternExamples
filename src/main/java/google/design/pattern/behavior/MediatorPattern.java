package google.design.pattern.behavior;

import javafx.scene.control.Button;

public class MediatorPattern {
    public abstract class Mediator{
        public abstract void componentChanged(Component component);
    }
    public class ConcreteMediator extends Mediator{
        //维持对各个同事对象的引用
        public Button addButton;
        public List list;
        public ComboBox cb;
        public TextBox userNameTextBox;

        //封装同事对象之间的交互
        @Override
        public void componentChanged(Component component) {
            //单击按钮
            if (component == addButton) {
                list.update();
                cb.update();
                userNameTextBox.update();
            }
            //从列表选择用户
            else if (component == list) {
                cb.select();
                userNameTextBox.setText();
            }
            //从组合框选择用户
            else if (component == cb) {
                cb.select();
                userNameTextBox.setText();
            }

        }
    }
    public abstract class Component{
        protected Mediator mediator;

        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }
        //转发调用
        public void changed(){
            mediator.componentChanged(this);
        }
        public abstract void update();
    }
    public class Button extends Component{

        @Override
        public void update() {

        }
    }
    public class List extends Component{
        @Override
        public void update() {
            System.out.println("列表增加一项");

        }

        public void select() {
            System.out.println("列表选中一项");
        }
    }
    public class ComboBox extends Component{

        @Override
        public void update() {
            System.out.println("组合框增加一项");
        }
        public void select() {
            System.out.println("组合框选中一项");
        }
    }
    public class TextBox extends Component{

        @Override
        public void update() {
            System.out.println("客户信息更新");

        }
        public void setText(){
            System.out.println("文本框显示");
        }
    }
    public class Client{
        public  void main(String[] args) {
            //定义中介者对象
            ConcreteMediator mediator = new ConcreteMediator();
            Button addBT = new Button();
            List list = new List();
            ComboBox cb = new ComboBox();
            TextBox userNameTextBox = new TextBox();
            addBT.setMediator(mediator);
            list.setMediator(mediator);
            cb.setMediator(mediator);
            userNameTextBox.setMediator(mediator);
            mediator.addButton = addBT;
            mediator.list = list;
            mediator.cb = cb;
            mediator.userNameTextBox = userNameTextBox;

            addBT.changed();

            list.changed();

        }
    }
}
