package com.hotel.hotelmanagement.common;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class Util {

    public static String getFile(ClassLoader classLoader, String fileName) throws IOException {
        return IOUtils.toString(classLoader.getResourceAsStream(fileName), Charset.defaultCharset());
    }
}
