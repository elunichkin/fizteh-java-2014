package ru.fizteh.fivt.students.EgorLunichkin.MultiFileHashMap;

public class UseCommand implements Command {
    public UseCommand(MultiDataBase mdb, String name) {
        this.tableName = name;
        this.multiDataBase = mdb;
    }

    private String tableName;
    private MultiDataBase multiDataBase;

    public void run() throws MultiFileHashMapException {

    }
}