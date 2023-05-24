package com.pdai.javafx.app.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * {@code SpringUtils} is a utility class that can be used to get a Spring Bean from the application context.
 */
@Component
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * Implement the callback methods of the ApplicationContextAware interface to set the context environment
	 * @param applicationContext ApplicationContext object to be set up in the SpringUtils class.
	 * @throws BeansException Exception thrown when the Spring container fails to set the ApplicationContext object to the SpringUtils class.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtils.applicationContext == null) {
			SpringUtils.applicationContext = applicationContext;
		}
	}

	/**
	 * Get the applicationContext
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * Get the Bean by name.
	 * @param name Bean name
	 * @return Object
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 * Get the Bean by name.
	 * @param clazz Bean class
	 * @return Object
	 * @param <T> Bean class
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	/**
	 * Returns the specified Bean by name and Clazz
	 * @param name Bean name
	 * @param clazz Bean class
	 * @return Object
	 * @param <T> Bean class
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
}
