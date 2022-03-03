package google.design.pattern.behavior;

public class StatePattern {
    public class Account{
        private AccountState state;
        private String owner;//开户名
        private double balance = 0;//余额

        public Account(String owner,double balance) {
            this.owner = owner;
            this.balance = balance;

        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void setState(AccountState state) {
            this.state = state;
        }

        public void deposit(double amount) {
            state.deposit(amount);
        }

        public void withdraw(double amount) {
            state.withdraw(amount);
        }
        public void computeInterest() {
            state.computeInterest();
        }
    }
    public abstract class AccountState{
        protected Account account;
        public abstract void deposit(double amount);//存款
        public abstract void withdraw(double amount);//取款
        public abstract void computeInterest();//计算利息
        public abstract void stateCheck();
    }
    public class NormalState extends AccountState{
        public NormalState(Account account) {
            this.account = account;
        }
        public NormalState(AccountState state) {
            this.account = state.account;
        }

        @Override
        public void deposit(double amount) {
            this.account.setBalance(this.account.getBalance()+amount);
            stateCheck();
        }

        @Override
        public void withdraw(double amount) {
            this.account.setBalance(this.account.getBalance()-amount);
            stateCheck();
        }

        @Override
        public void computeInterest() {
            System.out.println("正常状态,无须支付利息");
        }

        @Override
        public void stateCheck() {
            if (account.getBalance() > -2000 && account.getBalance() < 0) {
                account.setState(new OverdraftlState(this));
            } else if (account.getBalance() == -2000) {
                account.setState(new RestrictedState(this));
            }else if (account.getBalance() < -2000) {
                System.out.println("操作受限");
            }
        }
    }
    public class OverdraftlState extends AccountState{
        public OverdraftlState(Account account) {
            this.account = account;
        }
        public OverdraftlState(AccountState state) {
            this.account = state.account;
        }

        @Override
        public void deposit(double amount) {
            this.account.setBalance(this.account.getBalance()+amount);
            stateCheck();
            stateCheck();
        }

        @Override
        public void withdraw(double amount) {
            this.account.setBalance(this.account.getBalance()-amount);
            stateCheck();
        }

        @Override
        public void computeInterest() {
            System.out.println("计算利息");
        }

        @Override
        public void stateCheck() {
            if (account.getBalance() >= 0) {
                account.setState(new NormalState(this));
            } else if (account.getBalance() == -2000) {
                account.setState(new RestrictedState(this));
            }else if (account.getBalance() < -2000) {
                System.out.println("操作受限");
            }
        }
    }
    public class RestrictedState extends AccountState{
        public RestrictedState(Account account) {
            this.account = account;
        }
        public RestrictedState(AccountState state) {
            this.account = state.account;
        }

        @Override
        public void deposit(double amount) {
            this.account.setBalance(this.account.getBalance()+amount);
            stateCheck();
        }

        @Override
        public void withdraw(double amount) {
            System.out.println("账号受限，取款失败");
        }

        @Override
        public void computeInterest() {
            System.out.println("计算利息");
        }

        @Override
        public void stateCheck() {
            if (account.getBalance() >= 0) {
                account.setState(new NormalState(this));
            }else if (account.getBalance() > -2000) {
                account.setState(new OverdraftlState(this));
            }
        }
    }
    public class Client{
        public void main(String[] args) {
            Account account = new Account("段誉", 0.0);
            account.deposit(1000);
            account.withdraw(2000);
            account.deposit(3000);
            account.withdraw(4000);
            account.withdraw(1000);
            account.computeInterest();

        }
    }
}
