package google.design.pattern.structure;

import java.util.Arrays;
import java.util.Hashtable;

public class FlyweightPatten {
    public class Coordinates{
        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
   public abstract class IgoChessman{
       public abstract String getColor();

       public void display(Coordinates coordinate) {
           System.out.println(" 棋子颜色：" + this.getColor() + ",棋子位置 = " + coordinate.getX()
                   + ", " + coordinate.getY());
       }
   }
   public class BlackIgoChessman extends IgoChessman{

       @Override
       public String getColor() {
           return "黑色";
       }
   }
    public class WhiteIgoChessman extends IgoChessman{

        @Override
        public String getColor() {
            return "白色";
        }
    }
    public class IgoChessmanFactory{
       private  IgoChessmanFactory instance = new IgoChessmanFactory();
       private Hashtable ht;

        public IgoChessmanFactory() {
            ht = new Hashtable();
            IgoChessman black,white;
            black = new BlackIgoChessman();
            ht.put("b", black);
            white = new WhiteIgoChessman();
            ht.put("w", white);

        }

        public IgoChessmanFactory getInstance() {
            return instance;
        }
        public IgoChessman getIgoChessman(String color){
            return (IgoChessman) ht.get(color);
        }
    }

}
