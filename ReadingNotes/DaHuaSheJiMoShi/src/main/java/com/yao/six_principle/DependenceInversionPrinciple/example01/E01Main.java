package com.yao.six_principle.DependenceInversionPrinciple.example01;

/**
 * Created by shanyao on 2018/5/8.
 */
public class E01Main {
    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        IRead daHuaSheJiMoShi = new DaHuaSheJiMoShi();
        IRead dao = new DaoShanShuDIan();
        xiaoMing.reader(daHuaSheJiMoShi);
        xiaoMing.reader(dao);
    }
}
