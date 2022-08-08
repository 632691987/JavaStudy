package jdk16;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.ClassLoader.getSystemClassLoader;

public class InvokeDefaultMethod {

    interface HelloWorld {
        default String hello() {
            return "world";
        }
    }

    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object proxy = Proxy.newProxyInstance(getSystemClassLoader(), new Class<?>[] { HelloWorld.class },
                (prox, method, args) -> InvocationHandler.invokeDefault(prox, method, args)
        );
        Method method = proxy.getClass().getMethod("hello");
        Assert.assertEquals(method.invoke(proxy), "world");
    }

}
