package reflections;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class MainMethodsRunner {
    @SneakyThrows
    public void runAlMainMethods(Object o) {
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            Main[] annotations = method.getAnnotationsByType(Main.class);
            if (annotations != null && annotations.length != 0) {
                int repeat = 0;
                for (Main annotation : annotations) {
                    repeat += annotation.repeat();
                }
                for (int i = 0; i < repeat; i++) {
                    method.invoke(o);
                }
            }


        }
    }
}
