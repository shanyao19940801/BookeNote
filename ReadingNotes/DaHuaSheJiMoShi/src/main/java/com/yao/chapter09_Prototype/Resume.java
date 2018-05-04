package com.yao.chapter09_Prototype;

/**
 * Created by shanyao on 2018/5/4.
 */
public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private Works works;
    private DeepClone deepClone;

    public Resume(String name) {
        this.name = name;
    }

    public void setInfp(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorks(Works works) {
        this.works = works;
    }

    public void setDeepClone(DeepClone deepClone) {
        this.deepClone = deepClone;
    }

    public void show() {
        System.out.println("name:"+name+",sex:"+sex+",age:"+age);
        if (works != null) {
            System.out.println("工作经历：" + works.getName());
        }
        if (deepClone != null) {
            System.out.println("克隆："+deepClone.getName());
        }
    }

    private Resume(DeepClone deepClone) throws CloneNotSupportedException {
        this.deepClone = (DeepClone) deepClone.clone();
    }

    public Object clone() throws CloneNotSupportedException {
        //完成深度克隆
        Resume resume = new Resume(this.deepClone);
        resume.setWorks(works);;
        resume.setInfp(sex,age);
        return resume;
    }

}
