package com.yao.chapter23_Command.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shanyao on 2018/6/9.
 */
public class WaiterBetter {
    private List<CommandE> orders = new ArrayList<CommandE>();

    public void setOrder(CommandE command) {
        if ("如果没有了回绝客户".equals("")) {

        } else {
            //记录点餐日志
            orders.add(command);
            System.out.println("增加订单"+command.toString());
        }
    }
    //取消
    public void CancelOrder(CommandE command) {
        orders.remove(command);
        //记录日志
        System.out.println("取消订单");
    }
    //全部执行
    public void Notify() {
        for (CommandE commandE : orders) {
            commandE.executeCommand();
        }
    }
}
