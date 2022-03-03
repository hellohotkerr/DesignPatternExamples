package google.design.pattern.behavior;

public class StatePattern2 {
    public class Screen{
        private ScreenState currentState,normalState,largerState,largestState;

        public Screen() {
            this.normalState = new NormalState();
            this.largerState = new LargerState();
            this.largestState = new LargestState();
            this.currentState = normalState;
            this.currentState.display();
        }

        public void setCurrentState(ScreenState state) {
            this.currentState = state;
        }

        public void onClick() {
            if (currentState == normalState) {
                setCurrentState(largerState);

            } else if (currentState == largerState) {
                setCurrentState(largestState);
            }else if (currentState == largestState) {
                setCurrentState(normalState);
            }
            currentState.display();
        }
    }
    public abstract class ScreenState{
        public abstract void display();
    }
    public class NormalState extends ScreenState{

        @Override
        public void display() {
            System.out.println("正常屏幕大小");
        }
    }
    public class LargerState extends ScreenState{

        @Override
        public void display() {
            System.out.println("两倍屏幕大小");
        }
    }
    public class LargestState extends ScreenState{

        @Override
        public void display() {
            System.out.println("四倍屏幕大小");
        }
    }
}
