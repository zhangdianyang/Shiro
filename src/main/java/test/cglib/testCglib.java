package test.cglib;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
@Component
public class testCglib implements MethodInterceptor{
	
	private static testCglib instance = new testCglib();
    
    private testCglib() {
    }

    public static testCglib getInstance() {
        return instance;
    }
	
	 @SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
	        return (T) Enhancer.create(cls, this);
	    }

	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(object, args);
		after();
		return result;
	}
	
	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}
}
