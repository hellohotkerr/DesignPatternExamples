package google.design.pattern.behavior;

public class CommandPatten {
    public abstract class Command{
        public abstract void execute();
    }
    public class Invoker{
        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void setCommand(Command command) {
            this.command = command;
        }
        public void call(){
            if (command != null) {
                command.execute();
            }
        }
    }
    public class ConcreteCommand extends Command{
        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }
    public class Receiver{
        public void action(){

        }
    }
}
