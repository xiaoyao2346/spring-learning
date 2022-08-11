package org.example.myannotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class XiaoHandler {
    public static void xiaohandler(Object object) {
        Class cl = object.getClass();
        Field[] fields = cl.getFields();
        for (Field field : fields){
            Xiao xiao = field.getAnnotation(Xiao.class);
            if(xiao != null) {
                String methodname = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                try{
                    Method m = cl.getMethod("setName",String.class);
                    m.invoke(object,xiao.value());
                }catch (Exception e){e.printStackTrace();}


            }
        }
    }
}
