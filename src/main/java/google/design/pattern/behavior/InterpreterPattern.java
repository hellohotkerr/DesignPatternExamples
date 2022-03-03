package google.design.pattern.behavior;

import java.util.Arrays;
import java.util.Stack;

public class InterpreterPattern {
    public abstract class AbstractNode{
        public abstract String interpret();
    }
    public class AndNode extends AbstractNode{
        private AbstractNode left;//And 的左表达式
        private AbstractNode right;//And 的右表达式

        public AndNode(AbstractNode left, AbstractNode right) {
            this.left = left;
            this.right = right;
        }

        //And表达式解释工作
        @Override
        public String interpret() {
            return left.interpret() + "再" + right.interpret();
        }
    }
    public class SentenceNode extends AbstractNode{
        private AbstractNode direction;
        private AbstractNode action;
        private AbstractNode distance;

        public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
            this.direction = direction;
            this.action = action;
            this.distance = distance;
        }

        //简单句子的解释操作
        @Override
        public String interpret() {
            return direction.interpret() + action.interpret() + distance.interpret();
        }
    }
    public class DirectionNode extends AbstractNode{
        private String direction;

        public DirectionNode(String direction) {
            this.direction = direction;
        }

        //方向表达式的解释工作
        @Override
        public String interpret() {
            if (direction.equalsIgnoreCase("up")) {
                return "向上";
            } else if (direction.equalsIgnoreCase("down")) {
                return "向下";
            } else if (direction.equalsIgnoreCase("left")) {
                return "向左";
            }else if (direction.equalsIgnoreCase("right")) {
                return "向右";
            }
            return "无效命令";
        }
    }
    public class ActionNode extends AbstractNode{
        private String action;

        public ActionNode(String action) {
            this.action = action;
        }
        //动作（移动方式）表达式的解释工作
        @Override
        public String interpret() {
            if (action.equalsIgnoreCase("move")) {
                return "移动";
            } else if (action.equalsIgnoreCase("run")) {
                return "快速移动";
            }
            return "无效命令";
        }
    }
    public class DistanceNode extends AbstractNode{
        private String distance;

        public DistanceNode(String distance) {
            this.distance = distance;
        }
        //距离表达式的解释工作
        @Override
        public String interpret() {
            return this.distance;
        }
    }
    public class InstructionHandler{
        private AbstractNode node;
        private void handle(String instruction){
            AbstractNode left,right;
            AbstractNode direction,action,distance;
            Stack<AbstractNode> stack = new Stack<AbstractNode>();
            String[] words = instruction.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equalsIgnoreCase("and")) {
                    left = stack.pop();
                    String word1 = words[++i];
                    direction = new DirectionNode(word1);
                    String word2 = words[++i];
                    action = new ActionNode(word2);
                    String word3 = words[++i];
                    distance = new DistanceNode(word3);
                    right = new SentenceNode(direction, action, distance);
                    stack.push(new AndNode(left, right));
                }else{
                    String word1 = words[i];
                    direction = new DirectionNode(word1);
                    String word2 = words[++i];
                    action = new ActionNode(word2);
                    String word3 = words[++i];
                    distance = new DistanceNode(word3);
                    left = new SentenceNode(direction, action, distance);
                    stack.push(left);
                }
            }
            this.node = stack.pop();
        }

        public String output() {
            String result = node.interpret();//解释表达式
            return result;
        }
    }
    public class Client{
        public  void main(String[] args) {
            String instruction = "down run 10 and left move 20";
            InstructionHandler instructionHandler = new InstructionHandler();
            instructionHandler.handle(instruction);
            String outputStr = "";
            outputStr = instructionHandler.output();
            System.out.println("outputStr = " + outputStr);
        }
    }
}
