public class TodoApp {

    public static void main(String[] args) {

        if (args.length == 0) {
            Print.printUsage();

        } else if (!isSupportedArgument(args[0])) {
            System.out.println("Unsupported argument");
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
            if (args.length == 1) {
                System.out.println("Unable to remove: no index provided");
            } else {
                Manipulator.removeTask(args[1]);
            }
        }

        else if (args[0].equals("-c")) {
            if (args.length == 1) {
                System.out.println("Unable to check: no index provided");
            } else {
                Manipulator.checkTask(args[1]);
            }
        }

    }

    private static boolean isSupportedArgument(String arg) {
        return arg.equals("-l") || arg.equals("-a") || arg.equals("-r") || arg.equals("-c");
    }

}
