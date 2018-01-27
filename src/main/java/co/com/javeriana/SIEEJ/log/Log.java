package co.com.javeriana.SIEEJ.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Log annotation must be used on logger fields to automatically inject logger
 * instance.
 * 
 * @author Javeriana
 */
@Documented
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

	/**
	 * Setup logger name, if it's empty, then class name will be used.
	 * 
	 * @return logger name
	 */
	String value() default "";

	/**
	 * Check if logger object must be instantiated or not.
	 * 
	 * @return mandatory
	 */
	boolean required() default true;

}