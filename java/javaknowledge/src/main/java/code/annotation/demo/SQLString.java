package code.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 注解String类型的字段
 */
@Target(ElementType.FIELD)

public @interface SQLString {
}
