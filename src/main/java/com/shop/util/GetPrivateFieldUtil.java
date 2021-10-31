package com.shop.util;

import java.lang.reflect.Field;

public class GetPrivateFieldUtil {
    public static Object getPrivateField(Object obj, String fieldName, Class classs) {
        try {
            Field field = classs.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            try {
                classs = classs.getSuperclass();
                Field field = classs.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(obj);
            } catch (Exception ex) {
                return null;
            }
        }
    }
}
