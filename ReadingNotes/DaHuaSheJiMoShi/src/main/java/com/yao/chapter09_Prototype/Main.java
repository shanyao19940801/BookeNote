package com.yao.chapter09_Prototype;

/**
 * Created by shanyao on 2018/5/4.
 */
public class Main {
    public static void main(String[] args) {
        Resume resume = new Resume("单耀");
        resume.setInfp("w","12");
        Works works = new Works();
        works.setName("谢宁科技");
        DeepClone deepClone = new DeepClone("深度克隆");

        resume.setWorks(works);
        resume.setDeepClone(deepClone);
        resume.show();

        try {
            Resume resume1 = (Resume) resume.clone();
            resume1.show();
            System.out.println("==============");
            works.setName("博彦科技");
            deepClone.setName("没有变");
            resume.show();
            resume1.show();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
