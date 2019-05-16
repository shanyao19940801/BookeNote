package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shanyao on 2019/5/7
 */
public class TeachingTaskAmountConfig {
    private static final Logger logger = LoggerFactory.getLogger(TeachingTaskAmountConfig.class);

    List<TeachingTaskAmount> teachingTaskAmountList;

    public static void main(String[] args) {
        TeachingTaskAmountConfig config = new TeachingTaskAmountConfig();
        config.setTeachingTaskAmountList(Arrays.asList(getDefault(),getDefault()));
        boolean printLog = false;
        for (TeachingTaskAmount teachingTaskAmount : config.getTeachingTaskAmountList()) {
            if (teachingTaskAmount.getConfirmTeachPlan() == null || teachingTaskAmount.getConfirmTeachPlan() < 0) {
                teachingTaskAmount.setConfirmTeachPlan(0.0);
                printLog = true;
            }
            if (teachingTaskAmount.getCreateTeachPlan() == null || teachingTaskAmount.getConfirmTeachPlan() < 0) {
                teachingTaskAmount.setCreateTeachPlan(0.0);
                printLog = true;
            }
            if (teachingTaskAmount.getHomeWork() == null || teachingTaskAmount.getHomeWork() < 0) {
                teachingTaskAmount.setHomeWork(0.0);
                printLog = true;
            }
            if (teachingTaskAmount.getPreview() == null || teachingTaskAmount.getPreview() < 0) {
                teachingTaskAmount.setPreview(0.0);
                printLog = true;
            }
            if (teachingTaskAmount.getUpdateTeachPlan() == null || teachingTaskAmount.getUpdateTeachPlan() < 0) {
                teachingTaskAmount.setUpdateTeachPlan(0.0);
                printLog = true;
            }
            teachingTaskAmount.setConfirmTeachPlan(3.2);
        }
        System.out.println(config);

    }

    public static TeachingTaskAmount getDefault() {
        TeachingTaskAmount teachingTaskAmount = new TeachingTaskAmount();
        teachingTaskAmount.setConfirmTeachPlan(0.0);
        teachingTaskAmount.setCreateTeachPlan(0.0);
        teachingTaskAmount.setHomeWork(0.0);
        teachingTaskAmount.setPreview(0.0);
        teachingTaskAmount.setUpdateTeachPlan(0.0);
        return teachingTaskAmount;
    }

    public List<TeachingTaskAmount> getTeachingTaskAmountList() {
        return teachingTaskAmountList;
    }

    public void setTeachingTaskAmountList(List<TeachingTaskAmount> teachingTaskAmountList) {
        this.teachingTaskAmountList = teachingTaskAmountList;
    }
}
