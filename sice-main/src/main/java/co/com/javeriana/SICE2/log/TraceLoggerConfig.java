package co.com.javeriana.SICE2.log;

import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_ARGUMENT_TYPES;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_METHOD_NAME;
import static org.springframework.aop.interceptor.CustomizableTraceInterceptor.PLACEHOLDER_TARGET_CLASS_SHORT_NAME;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Clase que permite definir un interceptor para loguear la entrada y salida de
 * todos los metodos del sistema.
 * 
 * @author Javeriana
 */
@Configuration
@EnableAspectJAutoProxy
public class TraceLoggerConfig {

	/**
	 * Expresión que define los metodos que serán logueados. 
	 */
	private static final String TRACE_ANNOTATION = "execution(public * co.com.javeriana.SICE2..*.*(..)) && !execution(public * co.com.javeriana.SICE2.log..*.*(..)) && !execution(public * co.com.javeriana.SICE2.repositories..*.*(..))";

	/**
	 * Configura el Interceptor
	 * 
	 * @return el interceptor configurado
	 */
	@Bean
    public CustomizableTraceInterceptor customizableTraceInterceptor() {
        CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
        cti.setEnterMessage(PLACEHOLDER_TARGET_CLASS_SHORT_NAME +"."+PLACEHOLDER_METHOD_NAME + "("+ PLACEHOLDER_ARGUMENT_TYPES+")::START");
        cti.setExitMessage(PLACEHOLDER_TARGET_CLASS_SHORT_NAME +"."+PLACEHOLDER_METHOD_NAME + "("+ PLACEHOLDER_ARGUMENT_TYPES+")::END");
        return cti;
    }
	
	/**
	 * Configura el advisor
	 * 
	 * @return el advisor configurado
	 */
	@Bean
    public Advisor traceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(TRACE_ANNOTATION);
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }
}
