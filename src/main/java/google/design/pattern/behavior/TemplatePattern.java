package google.design.pattern.behavior;

public class TemplatePattern {
    public abstract class Account{
        public boolean validate(String account,String password){
            if (account.equalsIgnoreCase("张无忌") && password.equals("6521")) {
                return true;
            }
            return false;
        }

        //基本方法--抽象
        public abstract void calculateInterest();

        //基本方法--具体
        public void display() {
            System.out.println("显示利息！");
        }
    }
    //活期账户
    public class CurrentAccount extends Account{
        @Override
        public void calculateInterest() {
            System.out.println("按活期利率计算利息");
        }
    }
    //定期账户
    public class SavingAccount extends Account{
        @Override
        public void calculateInterest() {
            System.out.println("按定期利率计算利息");
        }
    }
}
