package ru.fizteh.fivt.students.gudkov394.shell;

import java.util.Scanner;

public class Shell {
    public Boolean checkName(String name) {
        String[] s = {"ls", "pwd", "cd", "mkdir", "rm", "cp", "mv", "cat", "exit"};
        for (int i = 0; i < s.length; ++i) {
            if (name.equals(s[i])) {
                return true;
            }
        }
        return false;
    }

    public void run(String[] currentArgs, CurrentDirectory cd) {
        if (currentArgs[0].equals("pwd")) {
            Pwd pwd = new Pwd(currentArgs, cd);
        } else if (currentArgs[0].equals("mkdir")) {
            Mkdir mkdir = new Mkdir(currentArgs, cd);
        } else if (currentArgs[0].equals("cd")) {
            ChangeDirectory changeDirectory = new ChangeDirectory(currentArgs, cd);
        } else if (currentArgs[0].equals("rm")) {
            RemoveDirectory removeDerictory = new RemoveDirectory(currentArgs, cd);
        } else if (currentArgs[0].equals("cp")) {
            Copy copy = new Copy(currentArgs, cd);
        } else if (currentArgs[0].equals("mv")) {
            MoveFile moveFile = new MoveFile(currentArgs, cd);
        } else if (currentArgs[0].equals("ls")) {
            Ls ls = new Ls(currentArgs, cd);
        } else if (currentArgs[0].equals("exit")) {
            Exit exit = new Exit(currentArgs);
        } else if (currentArgs[0].equals("cat")) {
            Cat cat = new Cat(currentArgs, cd);

        } else {
            System.err.println("wrong command");
            //System.exit(228);
        }
    }

    public void interactive() {
        CurrentDirectory currentDirectory = new CurrentDirectory();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(currentDirectory.getCurrentDirectory() + "$");
            String currentString = sc.nextLine();
            String[] functions = currentString.split(";");
            for (int i = 0; i < functions.length; ++i) {
                functions[i] = functions[i].trim();
                run(functions[i].split("\\s+"), currentDirectory);
            }
        }

    }

    public void packageMode(String[] args) {
        CurrentDirectory currentDirectory = new CurrentDirectory();
        int i = 0;
        while (i < args.length) {
            int first = i;
            ++i;
            while (i < args.length && !checkName(args[i])) {
                ++i;
            }
            String[] s = new String[i - first];
            for (int j = 0; j < s.length; ++j) {
                s[j] = args[j + first];
            }
            run(s, currentDirectory);
        }
    }


    public Shell(String[] args) {
        if (args.length == 0) {
            interactive();
        } else {
            packageMode(args);
        }
    }
}
