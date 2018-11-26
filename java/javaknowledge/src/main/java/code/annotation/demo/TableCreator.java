package code.annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行时注解处理器，构造表创建语句
 */
public class TableCreator {
    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        //如果没有表注解，直接返回
        if (dbTable == null) {
            System.out.println(
                    "No DBTable annotations in class " + className);
            return null;
        }
        String tableName = dbTable.name();
        //if the name is empty, use the class name
        if (tableName.length() < 1) {
            tableName = cl.getName().toUpperCase();
        }
        List<String> columnDefs = new ArrayList<String>();
        //通过Class类API获取到所有成员字段
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            //获取字段上的注解
            Annotation[] anns = field.getDeclaredAnnotations();
            if (anns.length < 1) {
                continue;//not a db tolumn
            }
            //判断解析类型
            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                //获取字段对应列名称，如果没有就是使用字段名称替代
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                //构建语句
                columnDefs.add(columnName + " INT" +
                        getConstraints(sInt.constraint()));
            }
            //判断String类型
            if(anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
                if (sString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sString.name();
                }
                columnDefs.add(columnName + " VARCHAR(" +
                        sString.value() + ")" +
                        getConstraints(sString.constraint()));
            }
        }

        //数据库表构建语句
        StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs) {
            createCommand.append("\n " + columnDef + ",");
        }
        //Remove trailing comma
        String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
        return tableCreate;
    }

    /**
     * 判断该字段是否有其他约束
     * @param con
     * @return
     */
    private static String getConstraints(Constraints con) {
        String constraint = "";
        if (!con.allowNull()) {
            constraint += " not null";
        }
        if (con.primarKey()) {
            constraint += " primary key";
        }
        if (con.unique()) {
            constraint += " unique";
        }
        return constraint;
    }
}
