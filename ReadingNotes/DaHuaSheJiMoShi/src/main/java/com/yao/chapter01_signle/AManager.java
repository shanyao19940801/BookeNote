package com.yao.chapter01_signle;

/**
 * Created by user on 2018/7/24.
 */
public class AManager {
    private static final Singleton<AManager> sInstance = new Singleton<AManager>() {
        @Override
        protected AManager create() {
            return new AManager();
        }
    };

    public static AManager getInstance() {
        return sInstance.get();
    }
}
