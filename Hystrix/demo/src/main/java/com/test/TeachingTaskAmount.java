package com.test;


/**
 * Created by shanyao on 2019/5/7
 */
public class TeachingTaskAmount {
    //创建教学计划
    private Double createTeachPlan;
    //更新阶段
    private Double updateTeachPlan;
    //确认阶段结束
    private Double confirmTeachPlan;
    //作业
    private Double homeWork;
    //预习
    private Double preview;

    public Double getCreateTeachPlan() {
        return createTeachPlan;
    }

    public void setCreateTeachPlan(Double createTeachPlan) {
        this.createTeachPlan = createTeachPlan;
    }

    public Double getUpdateTeachPlan() {
        return updateTeachPlan;
    }

    public void setUpdateTeachPlan(Double updateTeachPlan) {
        this.updateTeachPlan = updateTeachPlan;
    }

    public Double getConfirmTeachPlan() {
        return confirmTeachPlan;
    }

    public void setConfirmTeachPlan(Double confirmTeachPlan) {
        this.confirmTeachPlan = confirmTeachPlan;
    }

    public Double getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(Double homeWork) {
        this.homeWork = homeWork;
    }

    public Double getPreview() {
        return preview;
    }

    public void setPreview(Double preview) {
        this.preview = preview;
    }
}
