import java.io.*;

public class TodoApp {

    public static void main(String[] args) {

        if (args.length == 0) {
            Print.printUsage();

        } else if (args[0].equals("-l")) {
            Print.printTasks();

        } else if (args[0].equals("-a")) {
            if (args.length == 1) {
                System.out.println("Unable to add: no task provided");
            } else {
                Manipulator.addTask(args[1]);
            }

        } else if (args[0].equals("-r")) {
            Manipulator.removeTask(args[1]);
        }

    }

}
