package com.wilsonramos.lac.converter;

import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 *
 * @author wilsonramos
 */
@Configuration
public class Converter {

    public <T, K> K convert(T mainClass, Class<K> targetClass) throws Exception {

        K instanceTargetClass = targetClass.getConstructor().newInstance();

        Field[] field = mainClass.getClass().getDeclaredFields();
        for (Field auxField : field) {
            String attributeName = auxField.getName();
            Field targetField = this.checkAttribute(attributeName, targetClass);
            if (!Objects.isNull(targetField)) {
                Object attributeValue = this.extractAttributeValue(attributeName, mainClass);
                Method method = this.findMethodToDoingAttribuition(attributeName, auxField, targetClass);
                method.invoke(instanceTargetClass, attributeValue);
            }
        }
        return instanceTargetClass;
    }

    private <T> Object extractAttributeValue(String attributeName, T mainClass) throws Exception {
        String methodName = "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
        return mainClass.getClass().getMethod(methodName, null).invoke(mainClass, null);
    }

    private <T> Method findMethodToDoingAttribuition(String attributeName, Field field, Class<T> targetClass) throws Exception {

        String setMethodName = "set" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
        return targetClass.getMethod(setMethodName, field.getType());
    }

    private <K> Field checkAttribute(String attributeName, Class<K> targetClass) {
        Field[] field = targetClass.getDeclaredFields();
        for (Field auxField : field) {
            if (auxField.getName().equals(attributeName)) {
                return auxField;
            }
        }
        return null;
    }

}
