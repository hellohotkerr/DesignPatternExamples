package google.design.pattern.behavior;

import java.util.ArrayList;

public class MementoPatternExample {
    public class Chessman{
        private String label;
        private int x;
        private int y;

        public Chessman(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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

        //保存状态
        public ChessmanMemento save() {
            return new ChessmanMemento(this.label, this.x, this.y);
        }

        //恢复状态
        public void restore(ChessmanMemento memento) {
            this.label = memento.getLabel();
            this.x = memento.getX();
            this.y = memento.getY();
        }
    }
    class ChessmanMemento{
        private String label;
        private int x;
        private int y;

        public ChessmanMemento(String label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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
    public class MementoCaretaker {
        //定义一个集合来存储多个备忘录
        private ArrayList<ChessmanMemento> mementoList = new ArrayList<>();
        public ChessmanMemento getMemnto(int i) {
            return mementoList.get(i);
        }

        public void setMemnto(ChessmanMemento memnto) {
            mementoList.add(memnto);
        }
    }
    public class Client{
        private int index = -1;//记录当前状态所在的位置
        private MementoCaretaker mc = new MementoCaretaker();
        public void main(String[] args) {


            Chessman chess = new Chessman("车", 1, 1);
            play(chess);
            chess.setY(4);
            play(chess);
            chess.setY(5);
            play(chess);
            undo(chess, index);
            undo(chess, index);
            redo(chess, index);
            redo(chess, index);
        }

        //下棋
        public void play(Chessman chessman) {
            mc.setMemnto(chessman.save());
            System.out.println("棋子 = " + chessman.getLabel()+", 位置 = "+"第"+chessman.getX()+"行，第 "
            +chessman.getY()+"列");
            index++;
        }

        //悔棋
        public void undo(Chessman chessman, int i) {
            System.out.println("***************悔棋***************");
            index --;
            chessman.restore(mc.getMemnto(i-1));//撤销到上一个备忘录
            System.out.println("棋子 = " + chessman.getLabel()+", 位置 = "+"第"+chessman.getX()+"行，第 "
                    +chessman.getY()+"列");
        }
        //撤销悔棋
        public void redo(Chessman chessman, int i) {
            System.out.println("***************撤销悔棋***************");
            index ++;
            chessman.restore(mc.getMemnto(i+1));//恢复到下一个备忘录
            System.out.println("棋子 = " + chessman.getLabel()+", 位置 = "+"第"+chessman.getX()+"行，第 "
                    +chessman.getY()+"列");
        }
    }
}
