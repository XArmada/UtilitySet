package com.github.xarmada.utilityset;

import java.lang.reflect.Field;

public class ReflectionUtil {
	public static <T> T getPrivateFieldValue(Class<T> fieldType, Object containingObj, String fieldName)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> containingClass = containingObj.getClass();
		Field field = containingClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		return fieldType.cast(field.get(containingObj));
	}

	public static <T> void setPrivateFieldValue(Class<T> fieldType, Object containingObj, String fieldName, T newValue)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> containingClass = containingObj.getClass();
		Field field = containingClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(containingObj, newValue);
	}

	public static void setPrivateFieldValue(Object containingObj, String fieldName, float newValue)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> containingClass = containingObj.getClass();
		Field field = containingClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.setFloat(containingObj, newValue);
	}
}
