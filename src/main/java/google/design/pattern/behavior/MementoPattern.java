package google.design.pattern.behavior;

import java.util.Arrays;

public class MementoPattern {
    public class Originator{
        private String state;

        public Originator(String state) {
            this.state = state;
        }
        //创建一个备忘录对象
        public Memento createMemento(){
            return new Memento(this);
        }

        //根据备忘录对象恢复原发器状态
        public void restoreMemento(Memento m){
            state = m.getState();
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
    //备忘录类
     class Memento{
        private String state;
        public Memento(Originator o){
            state = o.getState();
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
    public class Caretaker{
        private Memento memento;

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }
    public class Client{
        public void main(String[] args) {
            //创建原发器对象
            Originator ori = new Originator("状态1");
            System.out.println(ori.getState());

            //创建负责人对象，保存创建的备忘录对象
            Caretaker ct = new Caretaker();
            ct.setMemento(ori.createMemento());

            ori.setState("状态2");
            System.out.println(ori.getState());
            //从负责人对象中取出备忘录对象，实现撤销
            ori.restoreMemento(ct.getMemento());
            System.out.println(ori.getState());

        }
    }
}
