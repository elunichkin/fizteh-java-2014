package ru.fizteh.fivt.students.YaronskayaLiubov.Shell;

public class DirCommand extends Command {
	void execute(String[] args) {
		String[] content = Shell.curDir.list();
		for (int i = 0; i < content.length; ++i)
			System.out.println(content[i]);
	}

	DirCommand() {
		name = "dir";
	}
}
