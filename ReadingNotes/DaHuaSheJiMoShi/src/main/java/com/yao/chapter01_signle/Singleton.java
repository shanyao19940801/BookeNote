package com.yao.chapter01_signle;

/**
 * Created by user on 2018/7/24.
 * 登记式,可继承
 */
public abstract class Singleton<T> {
    private T mInstance;
    protected abstract T create();
    public final T get() {
        synchronized (this) {
            if (mInstance == null) {
                mInstance = create();
            }
            return mInstance;
        }
    }
}