//package com.ruoyi.common.i18n;
//
////import cn.hutool.core.date.DatePattern;
////import cn.hutool.core.date.DateUtil;
////import cn.hutool.core.util.StrUtil;
////import com.aesc.common.global.enums.GlobalLanguageEnums;
//import org.springframework.context.i18n.LocaleContext;
//import org.springframework.context.i18n.LocaleContextHolder;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
////import static cn.hutool.core.date.DatePattern.*;
//
///**
// * 国际化工具类
// *
// * @author hao.lu
// */
//public class GlobalUtils {
//
//    /**
//     * 设置当前系统语言环境
//     * eg: GlobalUtils.setSystemLanguage(GlobalLanguageEnums.JP.getLanguage());
//     * 枚举类型参照{@link com.aesc.common.global.enums.GlobalLanguageEnums}
//     * @param value eg:GlobalLanguageEnums.CN
//     */
//    public static void setLocaleContext(GlobalLanguageEnums value) {
//        // 根据各个系统的规则设置当前系统的语言环境
//        LocaleContextHolder.setLocaleContext(GlobalLanguageEnums.getLocaleContext(value));
//    }
//
//    public static void resetLocaleContext() {
//        // 清除当前系统的语言环境
//        LocaleContextHolder.resetLocaleContext();
//    }
//
//    public static LocaleContext getLocaleContext() {
//        // 获取当前系统的语言环境
//        return LocaleContextHolder.getLocaleContext();
//    }
//
//    /**
//     * 获取当前 ZoneId
//     *
//     * @return ZoneId
//     */
//    public static ZoneId getSystemZoneId() {
//        return GlobalLanguageEnums.getCurrentZoneId();
//    }
//
//    /**
//     * 格式化日期时间<br>
//     * 格式 yyyy-MM-dd HH:mm:ss
//     *
//     * @param date 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatDateTime(Date date) {
//        if (null == date) {
//            return null;
//        }
//        ZoneId zoneId = GlobalLanguageEnums.CN.getZoneId();
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
//        return DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化日期时间<br>
//     * 格式 yyyy-MM-dd HH:mm:ss
//     *
//     * @param dateStr 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatDateTime(String dateStr) {
//        if (StrUtil.isBlank(dateStr)) {
//            return null;
//        }
//        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DatePattern.NORM_DATETIME_FORMATTER);
//        ZonedDateTime dateTime = localDateTime.atZone(getSystemZoneId());
//        ZonedDateTime zonedDateTime = dateTime.withZoneSameInstant(GlobalLanguageEnums.CN.getZoneId());
//        return DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化日期部分（不包括时间）<br>
//     * 格式 yyyy-MM-dd
//     *
//     * @param date 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatDate(Date date) {
//        if (null == date) {
//            return null;
//        }
//        ZoneId zoneId = GlobalLanguageEnums.CN.getZoneId();
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
//        return DateTimeFormatter.ofPattern(NORM_DATE_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化日期部分（不包括时间）<br>
//     * 格式 yyyy-MM-dd
//     *
//     * @param dateStr 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatDate(String dateStr) {
//        if (StrUtil.isBlank(dateStr)) {
//            return null;
//        }
//        ZoneId zoneId = GlobalLanguageEnums.CN.getZoneId();
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(DateUtil.parseDate(dateStr).toInstant(), zoneId);
//        return DateTimeFormatter.ofPattern(NORM_DATE_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化事件部分（不包括日期）<br>
//     * 格式 HH:mm:ss
//     *
//     * @param date 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatTime(Date date) {
//        if (null == date) {
//            return null;
//        }
//        ZoneId zoneId = GlobalLanguageEnums.CN.getZoneId();
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
//        return DateTimeFormatter.ofPattern(NORM_TIME_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化事件部分（不包括日期）<br>
//     * 格式 HH:mm:ss
//     *
//     * @param dateStr 被格式化的日期
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatTime(String dateStr) {
//        if (StrUtil.isBlank(dateStr)) {
//            return null;
//        }
//        ZoneId zoneId = GlobalLanguageEnums.CN.getZoneId();
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(DateUtil.parseTime(dateStr).toInstant(), zoneId);
//        return DateTimeFormatter.ofPattern(NORM_TIME_PATTERN).format(zonedDateTime);
//    }
//
//    /**
//     * 格式化日期时间为指定格式
//     *
//     * @param time      {@link LocalDateTime}
//     * @param formatter 日期格式化器，预定义的格式见：{@link DateTimeFormatter}
//     * @return 格式化后的字符串
//     * @author hao.lu
//     */
//    public static String formatDateTime(LocalDateTime time, DateTimeFormatter formatter) {
//        if (time == null || formatter == null) {
//            return null;
//        }
//        ZonedDateTime dateTime = time.atZone(getSystemZoneId());
//        ZonedDateTime zonedDateTime = dateTime.withZoneSameInstant(GlobalLanguageEnums.CN.getZoneId());
//        return formatter.format(zonedDateTime);
//    }
//
//
//}
