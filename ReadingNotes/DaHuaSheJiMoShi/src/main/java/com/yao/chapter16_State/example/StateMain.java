package com.yao.chapter16_State.example;

/**
 * Created by shanyao on 2018/5/30.
 */
public class StateMain {
    public static void main(String[] args) {
        Work emergencyProjects =new Work();
        emergencyProjects.setHour(9);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(12);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(13);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(14);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(17);
        emergencyProjects.writeProgram();


        emergencyProjects.setFinish(true);
//        emergencyProjects.setFinish(false);

        emergencyProjects.setHour(19);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(22);
        emergencyProjects.writeProgram();


    }
}
