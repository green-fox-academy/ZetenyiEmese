public class TodoApp {

  public static void main(String[] args) {

    if (args.length == 0) {
      Print.printUsage();

    } else if (!isSupportedArgument(args[0])) {
      System.out.println("Unsupported argument!");
      Print.printUsage();

    } else if (args[0].equals("-l") || args[0].equals("-list")) {
      Print.printUndoneTasks();

    } else if (args[0].equals("-la") || args[0].equals("-listall")) {
      Print.printAllTasks();

    } else if (args[0].equals("-a") || args[0].equals("-add")) {
      if (args.length == 1) {
        System.out.println("Unable to add: no task provided!");
      } else if (args.length > 2) {
        System.out.println("Too many arguments!");
      } else {
        Manipulator.addTask(args[1]);
      }

    } else if (args[0].equals("-r") || args[0].equals("-remove")) {
      if (args.length == 1) {
        System.out.println("Unable to remove: no index provided!");
      } else if (args.length > 2) {
        System.out.println("Too many arguments!");
      } else {
        Manipulator.removeTask(args[1]);
      }

    } else if (args[0].equals("-c") || args[0].equals("-check")) {
      if (args.length == 1) {
        System.out.println("Unable to check: no index provided!");
      } else if (args.length > 2) {
        System.out.println("Too many arguments!");
      } else {
        Manipulator.checkTask(args[1]);
      }

    } else if (args[0].equals("-u") || args[0].equals("-update")) {
      if (args.length == 1) {
        System.out.println("Unable to update: no id and no description provided!");
      } else if (args.length == 2) {
        System.out.println("Unable to update: enter the id and the new description!");
      } else if (args.length > 3) {
        System.out.println("Too many arguments!");
      } else {
        Manipulator.updateTask(args[1], args[2]);
      }
    }

  }

  private static boolean isSupportedArgument(String arg) {
    return arg.equals("-l") || arg.equals("-list") ||
            arg.equals("-la") || arg.equals("-listall") ||
            arg.equals("-a") || arg.equals("-add") ||
            arg.equals("-r") || arg.equals("-remove") ||
            arg.equals("-c") || arg.equals("-check") ||
            arg.equals("-u") || arg.equals("-update");
  }

}
