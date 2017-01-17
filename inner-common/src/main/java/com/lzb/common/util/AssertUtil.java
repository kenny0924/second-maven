package com.lzb.common.util;

import org.springframework.util.Assert;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by YJC on 2016-10-03.
 */
public class AssertUtil extends Assert {

    public static void listGtLength (List arr, Integer length, String message) {
        if (arr.size() > length) {
            throw new IllegalArgumentException(message);
        }
    }
}
