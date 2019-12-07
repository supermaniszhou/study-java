package com.zhou.util;

import com.zhou.service.UserService;
import com.zhou.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 周刘成   2019-12-5
 */
public class BeanFactoryUtil {

    public static <T> T getBean(Boolean isProxy, Class clazz) {
        try {
            final T service = (T) clazz.newInstance();
            if (isProxy) {
                T proxy = (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            TransationManager.startTransation();
                            obj = method.invoke(service, args);
                            TransationManager.commitTransation();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } finally {
                            TransationManager.release();
                        }
                        return obj;
                    }
                });
                return proxy;
            } else {
                return service;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
