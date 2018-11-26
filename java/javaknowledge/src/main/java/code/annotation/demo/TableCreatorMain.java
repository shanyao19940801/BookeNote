package code.annotation.demo;

import static code.annotation.demo.TableCreator.createTableSql;

public class TableCreatorMain {
    public static void main(String[] args) {
        String[] arg = {"code.annotation.demo.Member"};
        for (String className : arg) {
            try {
                System.out.println("Table Creation SQL for " +
                        className + " is :\n" + createTableSql(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
