package google.design.pattern.behavior;

public class CommandPatternExample {
    public class FunctionButton{
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void click() {
            command.execute();
        }
    }
    public abstract class Command{
        public abstract void execute();
    }
    public class ExitCommand extends Command{
        private SystemExitClass seObj;

        public ExitCommand() {
            seObj = new SystemExitClass();
        }

        @Override
        public void execute() {
            seObj.exit();
        }
    }
    public class SystemExitClass{
        public void exit() {
            System.out.println("exit system");
        }
    }
    public class DisplayClass{
        public void display() {
            System.out.println(" display helper docment");
        }
    }
    public class HelperCommand extends Command{
        private DisplayClass displayClass;

        public HelperCommand() {
            displayClass = new DisplayClass();
        }

        @Override
        public void execute() {
            displayClass.display();
        }
    }
}
