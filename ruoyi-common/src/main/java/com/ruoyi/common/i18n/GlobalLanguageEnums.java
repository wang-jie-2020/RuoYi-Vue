//package com.ruoyi.common.i18n;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.springframework.context.i18n.LocaleContext;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.context.i18n.SimpleLocaleContext;
//
//import java.time.ZoneId;
//import java.util.Locale;
//
///**
// * @author hao.lu
// *
// * @Description 国际化语言枚举
// */
//
//@Getter
//@AllArgsConstructor
//public enum GlobalLanguageEnums {
//
//    CN("zh_CN", "中文简体", ZoneId.of("Asia/Shanghai"), Locale.SIMPLIFIED_CHINESE),
//    TW("zh_TW", "中文繁体", ZoneId.of("Asia/Taipei"), Locale.TRADITIONAL_CHINESE),
//    US("en_US", "英文", ZoneId.of("America/New_York"), Locale.US),
//    JP("ja_JP", "日文", ZoneId.of("Asia/Tokyo"), Locale.JAPAN),
//    FR("fr_FR", "法文", ZoneId.of("Europe/Paris"), Locale.FRANCE),
//    DE("de_DE", "德文", ZoneId.of("Europe/Berlin"), Locale.GERMANY),
//    KR("ko_KR", "韩文", ZoneId.of("Asia/Seoul"), Locale.KOREA),
//    ;
//
//    private final String language;
//    private final String displayName;
//    private final ZoneId zoneId;
//    private final Locale locale;
//
//    public static LocaleContext getLocaleContext(GlobalLanguageEnums enums) {
//        for (GlobalLanguageEnums value : GlobalLanguageEnums.values()) {
//            if (value == enums) {
//                return new SimpleLocaleContext(value.locale);
//            }
//        }
//        return new SimpleLocaleContext(CN.locale);
//    }
//
//    public static ZoneId getCurrentZoneId() {
//        for (GlobalLanguageEnums value : GlobalLanguageEnums.values()) {
//            Locale currentLocale = LocaleContextHolder.getLocale();
//            if (value.locale.equals(currentLocale)) {
//               return value.zoneId;
//            }
//        }
//        return ZoneId.systemDefault();
//    }
//
//    public static GlobalLanguageEnums getByLanguage(String language) {
//        for (GlobalLanguageEnums value : GlobalLanguageEnums.values()) {
//            if (value.getLanguage().equals(language)) {
//                return value;
//            }
//        }
//        return null;
//    }
//}
