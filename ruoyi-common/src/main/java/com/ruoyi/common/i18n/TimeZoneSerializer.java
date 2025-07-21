//package com.ruoyi.common.i18n;
//
////import cn.hutool.core.date.DatePattern;
////import cn.hutool.core.date.DateUtil;
////import cn.hutool.core.util.ReflectUtil;
////import com.aesc.common.global.annotation.TimeZoneMatch;
////import com.aesc.common.global.enums.GlobalLanguageEnums;
////import com.aesc.common.global.utils.GlobalUtils;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//
//
//@Slf4j
//public class TimeZoneSerializer extends JsonSerializer<Object> {
//
//    @Override
//    public void serialize(Object obj, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
////        TimeZoneMatch annotation = ReflectUtil.getField(gen.getOutputContext().getCurrentValue().getClass(), gen.getOutputContext().getCurrentName()).getAnnotation(TimeZoneMatch.class);
////        if (annotation != null) {
////                ZoneId zoneId = GlobalUtils.getSystemZoneId();
////            // 若时区没有变化则不转换
////            if (zoneId.equals(GlobalLanguageEnums.CN.getZoneId())) {
////                gen.writeObject(obj);
////            }
////
////            ZonedDateTime zonedDateTime = null;
////            if (obj instanceof Date) {
////                LocalDateTime localDateTime = LocalDateTime.parse(DateUtil.formatDateTime((Date) obj), DatePattern.NORM_DATETIME_FORMATTER);
////                ZonedDateTime dateTime = localDateTime.atZone(GlobalLanguageEnums.CN.getZoneId());
////                zonedDateTime = ZonedDateTime.ofInstant(dateTime.toInstant(), zoneId);
////            } else if (obj instanceof LocalDateTime){
////                ZonedDateTime dateTime = ((LocalDateTime) obj).atZone(GlobalLanguageEnums.CN.getZoneId());
////                zonedDateTime = ZonedDateTime.ofInstant(dateTime.toInstant(), zoneId);
////            } else if (obj instanceof ZonedDateTime) {
////                zonedDateTime = ((ZonedDateTime) obj).withZoneSameInstant(zoneId);
////            } else if (obj instanceof String) {
////                LocalDateTime localDateTime = LocalDateTime.parse((CharSequence) obj, DatePattern.NORM_DATETIME_FORMATTER);
////                ZonedDateTime dateTime = localDateTime.atZone(GlobalLanguageEnums.CN.getZoneId());
////                zonedDateTime = ZonedDateTime.ofInstant(dateTime.toInstant(), zoneId);
////            } else {
////                gen.writeObject(obj);
////                return;
////            }
////            String formattedDate = DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN).format(zonedDateTime);
////            gen.writeString(formattedDate);
////        } else {
////            gen.writeObject(obj);
////        }
//    }
//}
