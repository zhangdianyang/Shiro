package test.cglib;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspectJ {

	@Around("@annotation(my)")
    public Object around(ProceedingJoinPoint pjp,MyComponent my) throws Throwable {
		before(pjp);
		my.address();
		my.name();
		my.value();
		Object [] object = pjp.getArgs();
		object[0] = "ls";
        Object result = pjp.proceed(object);
        after();
        pjp.getArgs();
        pjp.getTarget().getClass().toString();
        pjp.getSignature().toString();
        pjp.getKind();
        return result;
    }
	
	/*@Before("execution(* test.cglib.Hello.*(..))")
	public Object befor3(Joinpoint jp){
		
		  return jp;
	}*/
	
	
	private void before(ProceedingJoinPoint pjp) {
		Object [] args = pjp.getArgs();
		pjp.getTarget().getClass();
		args[1] = "123";
		System.out.println("Before");
		
	}
	
	private void after() {
		System.out.println("After");
	}

}
