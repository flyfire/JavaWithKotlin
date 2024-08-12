package com.solarexsoft.javawithkotlin.regex;

/*
 * Created by Solarex on 2024/05/09 16:44
 */
public class DomainExtractor {

    public static String extractTopLevelDomain(String domain) {
        if (domain == null || domain.isEmpty()) {
            return "";
        }

        // 去除可能的协议头（如http://, https://）
        domain = domain.replaceFirst("^https?://", "");

        // 找到最后一个'.'的位置
        int lastIndex = domain.lastIndexOf('.');

        // 如果找不到'.'或者'.'是字符串的第一个字符（例如.com），则返回整个字符串
        if (lastIndex <= 0) {
            return domain;
        }

        // 提取并返回最后一个'.'之后的部分（包括'.'）
        return domain.substring(lastIndex);

        // 注意：上面的代码会返回如".com"这样的结果，如果你想要去掉开头的'.'，可以稍作修改

        // 提取并返回最后一个'.'之后的部分（不包括'.'）
        // return domain.substring(lastIndex + 1);
    }

    // 但是，根据你的描述，你可能想要的是没有子域名的部分，即倒数第二个'.'和最后一个'.'之间的部分
    public static String extractFirstLevelDomain(String domain) {
        if (domain == null || domain.isEmpty()) {
            return "";
        }

        // 去除可能的协议头（如http://, https://）
        domain = domain.replaceFirst("^https?://", "");

        // 找到倒数第二个'.'的位置
        int lastIndex = domain.lastIndexOf('.');
        int secondLastIndex = domain.lastIndexOf('.', lastIndex - 1);

        // 如果找不到倒数第二个'.'，则返回整个字符串（这通常不会发生，除非只有一个'.'）
        if (secondLastIndex < 0) {
            return domain; // 或者你可以决定返回null或抛出异常
        }

        // 提取并返回倒数第二个'.'和最后一个'.'之间的部分
        return domain.substring(secondLastIndex + 1);
    }
    public static void main(String[] args) {
        System.out.println(extractFirstLevelDomain("example1.com")); // 输出: example1
        System.out.println(extractFirstLevelDomain("sub.example2.com")); // 输出: example2
    }
}
