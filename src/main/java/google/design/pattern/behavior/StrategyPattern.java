package google.design.pattern.behavior;

public class StrategyPattern {
    public class MovieTicket{
        private double price;
        private Discount discount;//维持一个对抽象折扣类的引用

        public double getPrice() {
            return discount.calculate(price);
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setDiscount(Discount discount) {
            this.discount = discount;
        }
    }
    public interface Discount{
        double calculate(double price);
    }
    public class ChildrenDiscount implements Discount{
        private final double DISCOUNT  =10;
        @Override
        public double calculate(double price) {
            System.out.println("儿童票");
            if (price >= 20) {
                return price -DISCOUNT;
            }
            return price;
        }
    }
    public class StudenDiscount implements Discount{
        private final double DISCOUNT  =0.8;
        @Override
        public double calculate(double price) {
            System.out.println("学生票");

            return price * DISCOUNT;
        }
    }
    public class VIPDiscount implements Discount{
        private final double DISCOUNT  =0.5;
        @Override
        public double calculate(double price) {
            System.out.println("VIP票");
            System.out.println("增加积分");
            return price * DISCOUNT;
        }
    }
}
