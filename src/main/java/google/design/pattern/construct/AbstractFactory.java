package google.design.pattern.construct;

public class AbstractFactory {

    //Abstract Factory Pattern

    public interface Button{
        public void display();
    }
    public interface TextFiled{
        public void display();
    }
    public interface ComboBox{
        public void display();
    }
    public class SpringButton implements Button{

        @Override
        public void display() {
            System.out.println("spring green  button");
        }
    }
    public class SpringTextFiled implements TextFiled{

        @Override
        public void display() {
            System.out.println("spring green  TextFiled");
        }
    }
    public class SpringComboBox implements ComboBox{

        @Override
        public void display() {
            System.out.println("spring green  ComboBox");
        }
    }

    public class SummerButton implements Button{

        @Override
        public void display() {
            System.out.println("summer blue  button");
        }
    }
    public class SummerTextFiled implements TextFiled{

        @Override
        public void display() {
            System.out.println("summer blue  TextFiled");
        }

    }
    public class SummerComboBox implements ComboBox{

        @Override
        public void display() {
            System.out.println("summer blue  ComboBox");
        }
    }

    public interface SkinFactory{
        public Button createButton();
        public TextFiled createTextFiled();
        public ComboBox createComboBox();
    }
    public class SpringSkinFactory implements SkinFactory{

        @Override
        public Button createButton() {
            return new SpringButton();
        }

        @Override
        public TextFiled createTextFiled() {
            return new SpringTextFiled();
        }

        @Override
        public ComboBox createComboBox() {
            return new SpringComboBox();
        }
    }
    public class SummerSkinFactory implements SkinFactory{

        @Override
        public Button createButton() {
            return new SummerButton();
        }

        @Override
        public TextFiled createTextFiled() {
            return new SummerTextFiled();
        }

        @Override
        public ComboBox createComboBox() {
            return new SummerComboBox();
        }
    }
}
