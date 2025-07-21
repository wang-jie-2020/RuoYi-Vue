//package com.ruoyi.common.i18n;
//
//
////import com.aesc.common.global.config.TimeZoneSerializer;
//import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//import java.lang.annotation.*;
//
///**
// * 时区匹配注解<br>
// *
// * 支持属性转换
// * eg:若当前时区为日本(ja_JP),数据库时区为中国(zh_CN),数据表映射实体domain的某个属性time对应某条记录的值为"2023-12-07 15:00:00"
// * 当我查询的时候获取到的时间为"2023-12-07 16:00:00",即中国时区的"2023-12-07 15:00:00"会切换成日本时区的"2023-12-07 16:00:00"
// * <p>
// * 通过{@link com.aesc.common.global.utils.GlobalUtils}工具类设置当前时区对应的语言环境
// * eg:GlobalUtils.setSystemLanguage(GlobalLanguageEnums.JP.getName()); 设置当前时区为日本
// * 枚举类型参照{@link com.aesc.common.global.enums.GlobalLanguageEnums}
// *
// * 若存在时间条件的检索，比如当前时区为日本(ja_JP)，查询"2023-12-07 16:00:00"这个时间点后的登录日志，实际检索为"2023-12-07 15:00:00"这个时间点后的登录日志
// * 此时各应用系统需要调用GlobalUtils.formatTime("2023-12-07 16:00:00")将当前时区的时间转换为中国时区"2023-12-07 15:00:00"
// * 数据库默认时区为Asia/Shanghai中国上海
// * <p>
// * 用法:
// * @TimeZoneMatch                  @TimeZoneMatch
// * private Date date;              private String time;
// * <p>
// * 支持时间格式，预定义的格式见：
// * {@link java.time.LocalDateTime}
// * {@link java.util.Date}
// * {@link java.time.ZonedDateTime}
// * {@link String}
// *
// * @author hao.lu
// */
//@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@JacksonAnnotationsInside
//@JsonSerialize(using = TimeZoneSerializer.class)
//public @interface TimeZoneMatch {
//
//}
