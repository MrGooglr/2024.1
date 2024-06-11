package com.aniket.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Utility {

    private static final Logger logger = LogManager.getLogger(Utility.class);

    public static void printArrayElementAsAString(Object array){
        if (array instanceof Object[]) {
            logger.info(stream((Object[]) array)
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof int[]) {
            logger.info(stream((int[]) array)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof long[]) {
            logger.info(stream((long[]) array)
                    .mapToObj(Long::toString)
                    .collect(Collectors.joining(", ")));
        } else if (array instanceof double[]) {
            logger.info(stream((double[]) array)
                    .mapToObj(Double::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}
