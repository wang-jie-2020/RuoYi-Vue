package com.ruoyi.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.config.serializer.SensitiveJsonSerializer;
import com.ruoyi.common.enums.DesensitizedType;

/**
 * 数据脱敏注解: {@link SensitiveJsonSerializer}
 *      在JSON序列化结果对象时,通过Jackon提供的功能对序列化结果进一步处理
 *      在此处:
 *          (1) 通过指定的 SensitiveJsonSerializer.class 对结果做处理
 *          (2) 通过 DesensitizedType 这个枚举类标记了对序列化的string字符串的处理正则,它是一个Function<String, String>
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside   ///  @JacksonAnnotationsInside: 内联标记 --> 标记了@Sensitive 就像直接在那个元素上使用了 @JsonSerialize
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface Sensitive
{
    DesensitizedType desensitizedType();
}