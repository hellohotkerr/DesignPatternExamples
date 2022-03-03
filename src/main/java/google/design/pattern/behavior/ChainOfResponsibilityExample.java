package google.design.pattern.behavior;

public class ChainOfResponsibilityExample {
    public class PurchaseRequest {
        private double amount;//采购金额
        private int number;//采购单编号
        private String purpose;//采购目的

        public PurchaseRequest(double amount, int number, String purpose) {
            this.amount = amount;
            this.number = number;
            this.purpose = purpose;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }
    }

    public abstract class Approver{
        protected Approver successor;//定义后继对象
        protected String name;//审批者姓名

        public Approver(String name) {
            this.name = name;
        }

        public void setSuccessor(Approver successor) {
            this.successor = successor;
        }

        //抽象请求处理方法
        public abstract void processRequest(PurchaseRequest request);

    }
    //主任
    public class Director extends Approver{

        public Director(String name) {
            super(name);
        }
        //具体请求处理方法
        @Override
        public void processRequest(PurchaseRequest request) {
            if (request.getAmount() < 50000) {
                //处理请求
            }else{
                this.successor.processRequest(request);
            }
        }
    }
    //副董事
    public class VicePresident extends Approver{

        public VicePresident(String name) {
            super(name);
        }
        //具体请求处理方法
        @Override
        public void processRequest(PurchaseRequest request) {
            if (request.getAmount() < 100000) {
                //处理请求
            }else{
                this.successor.processRequest(request);
            }
        }
    }
    //董事长
    public class President extends Approver{

        public President(String name) {
            super(name);
        }
        //具体请求处理方法
        @Override
        public void processRequest(PurchaseRequest request) {
            if (request.getAmount() < 500000) {
                //处理请求
            }else{
                this.successor.processRequest(request);
            }
        }
    }
    //董事会
    public class Congress extends Approver{

        public Congress(String name) {
            super(name);
        }
        //具体请求处理方法
        @Override
        public void processRequest(PurchaseRequest request) {
            //处理请求

        }
    }

}
