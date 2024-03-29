package com.mohamed.halim.javaeats.spec;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SpecUtils {
    public static String formatForLikeOperator(String val) {
        return "%" + val + "%";
    }
}
