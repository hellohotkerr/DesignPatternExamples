package google.design.pattern.behavior;

import java.util.ArrayList;

public class ObserverPattern {
    public abstract class AllyControlCenter{
        protected String allyName;//战队名称
        protected ArrayList<Observer> players = new ArrayList<>();

        public String getAllyName() {
            return allyName;
        }

        public void setAllyName(String allyName) {
            this.allyName = allyName;
        }

        //注册方法
        public void join(Observer observer) {
            players.add(observer);
        }

        //注销方法
        public void quit(Observer observer) {
            players.remove(observer);
        }
        //声明抽象通知方法
        public abstract void notifyObserver(String name);
    }
    public class ConcreteAllyControlCenter extends AllyControlCenter{

        public ConcreteAllyControlCenter(String allyName) {
            this.allyName = allyName;
        }

        @Override
        public void notifyObserver(String name) {
            for (Observer player : players) {
                if (!player.getName().equalsIgnoreCase(name)) {
                    player.help();
                }
            }
        }
    }
    public interface Observer{
        public String getName();

        public void setName(String name);

        public void help();//声明支援盟友
        public void beAttacked(AllyControlCenter acc);//声明遭受攻击方法
    }
    public class Player implements Observer{

       private String name;

        public Player(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void help() {

        }

        @Override
        public void beAttacked(AllyControlCenter acc) {
            acc.notifyObserver(name);
        }
    }

}
