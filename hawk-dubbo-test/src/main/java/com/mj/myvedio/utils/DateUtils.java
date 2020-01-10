package com.mj.myvedio.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * java8之前：
 * Date：表示时间和日期，不支持时间日期运算，不支持国际化
 * Calendar：表示时间和日期，支持时间和日期操作，但是不支持格式化
 * SimpleDateFormatte：仅能格式化Date
 *
 * java8:兼容旧版Date
 * LocalDateTime：日期和时间
 * LocalDate：仅表示日期
 * LocalTime：仅表示时间
 * Peroid：仅表示日期间隔
 * Duration：时间间隔，以秒和纳秒为单位
 * DateTimeFormatter：可以格式化LocalDate，LocalTime以及LocalDateTime
 */
public class DateUtils {

    public static void main(String[] args) {
       // 获取当前时间
        System.out.println(LocalDateTime.now());
        // 结果：2019-12-19T20:28:50.358

        System.out.println(LocalDate.now());
        // 结果：2019-12-19

        System.out.println(LocalTime.now());
        // 结果：20:28:50.358

        System.out.println(LocalTime.now().toString());
        // 结果：20:28:50.358

        // 获取指定时间
        System.out.println(LocalDateTime.of(2019,12,18,10,2,1));
        // 结果：2019-12-18T10:02:01

        // 获取1天1小时之后的时间
        System.out.println(LocalDateTime.now().plusDays(1).plusHours(1));
        // 结果：2019-12-20T21:28:50.358

        // 获取1天1小时之之前的时间
        System.out.println(LocalDateTime.now().plusDays(-1).plusHours(-1));
        // 2019-12-18T19:28:50.358

        // 获取指定的年月日
        System.out.println(LocalDateTime.now().getYear());
        System.out.println(LocalDateTime.now().getMonthValue());
        System.out.println(LocalDateTime.now().getDayOfMonth());

        // 计算时间距离
        LocalDate localDate1 = LocalDate.of(2018,10,2);
        LocalDate localDate2 = LocalDate.of(2019,11,3);
        long num = localDate1.until(localDate2, ChronoUnit.DAYS);
        System.out.println("until:days:"+num);
        num = localDate1.until(localDate2, ChronoUnit.WEEKS);
        System.out.println("until:days:"+num);
        // TemporalAdjusters 实现：上一个，下一个时间点
        System.out.println(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        System.out.println(LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        // 月最后一天
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
        // 月最后一个周一
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)));
        // 月第一天
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(2,DayOfWeek.MONDAY)));

        // 时间格式化 DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // date -> string
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        // string -> date
        System.out.println(dateTimeFormatter.parse("20190212111111"));
        System.out.println(LocalDateTime.parse("20190212111111", dateTimeFormatter));

        // 时区 Instant
        // UTC时区（格林尼治时间）
        // 获取UTC时间   比北京时间晚8小时
        Instant instant = Instant.now();
        System.out.println(instant);
        // 获取北京时间（东8区）
        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime:"+offsetDateTime);
        // 获取时间戳
        System.out.println("时间戳:"+Instant.now().toEpochMilli());
        // 时间戳操作
        System.out.println("时间戳:"+Instant.ofEpochSecond(18).plusMillis(1).toEpochMilli());

        // LocalDateTime 与时间戳转换
        // 时间戳 -》 LocalDateTime （默认改时间戳为格林尼治时间）
        long timestamp_1 = System.currentTimeMillis();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp_1).atOffset(ZoneOffset.ofHours(0)).toLocalDateTime();
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(0)).toEpochMilli();
        System.out.println("时间戳:timestamp_1="+timestamp_1);
        System.out.println("时间戳:localDateTime="+localDateTime);
        System.out.println("时间戳:timestamp="+timestamp);

        // 兼容旧版本Date
        LocalDateTime ldt = LocalDateTime.of(2019,12,18,10,2,1);
        Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        // date -> LocalDateTime
        Date date1 = new Date();
        LocalDate dt = date1.toInstant().atOffset(ZoneOffset.ofHours(8)).toLocalDate();
        System.out.println("时间戳:localDateTime="+dt);
        Date date2 = new Date();
        LocalDate dt1 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("时间戳:localDateTime="+dt1);

        System.out.println("finish");
    }
}
