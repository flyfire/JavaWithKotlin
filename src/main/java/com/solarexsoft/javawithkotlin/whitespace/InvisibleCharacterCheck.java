package com.solarexsoft.javawithkotlin.whitespace;

/*
 * Created by Solarex on 2023/12/25 09:57
 */
public class InvisibleCharacterCheck {
    public static void main(String[] args) {
        char invisibleChar = '\u200E';
        System.out.println(isWhiteSpace(String.valueOf(invisibleChar)));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(invisibleChar))
                .append(" ")
                .append("\t");
        System.out.println(isWhiteSpace(stringBuilder.toString()));
    }
    public static boolean isWhiteSpace(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        // https://stackoverflow.com/questions/42960282/how-to-remove-u200b-zero-length-whitespace-unicode-character-from-string-in-j
        String newStr = str.replaceAll("[\\p{Cf}]", "").trim();
        if (newStr.isEmpty()) {
            return true;
        }
        for (int i = 0; i < newStr.length(); i++) {
            if (!Character.isWhitespace(newStr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
