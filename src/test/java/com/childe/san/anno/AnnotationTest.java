package com.childe.san.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.childe.san.BaseTest;

/**
 * @author zhangh
 * @createTime 2013-6-21 下午3:48:28
 */
public class AnnotationTest extends BaseTest {

	@Test
	public void test() {
		Class<User> user = User.class;
		Annotation[] annotations = user.getAnnotations();
		for (Annotation annotation : annotations) {
			logger.debug("Annotation {} at Type {}", annotation, user.getSimpleName());
		}

		// Method
		Method[] methods = user.getDeclaredMethods();
		for (Method method : methods) {
			annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				logger.debug("Annotation {} at method {}", annotation, method.getName());
			}
		}
		//Constructor
		Constructor<?>[] constructors = user.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			constructor.setAccessible(true);
			if (constructor.isAnnotationPresent(ConstructorAnnotation.class)) {
				constructor.getAnnotation(ConstructorAnnotation.class);
			}

			annotations = constructor.getAnnotations();
			for (Annotation annotation : annotations) {
				logger.debug("Annotation {} at constructor {}", annotation, constructor.getName());
			}
		}
		//Field
		Field[] fields = user.getDeclaredFields();
		for (Field field : fields) {
			annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				logger.debug("Annotation {} at field {}", annotation, field.getName());
			}
		}

	}
}
