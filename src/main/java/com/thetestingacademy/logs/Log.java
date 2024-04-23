package com.thetestingacademy.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
    //Initialize Log4j instance
    private static final Logger logger = LogManager.getLogger(Log.class);

    //Info Level Logs
    public static void info(String message)
    {
        Log.info(message);
    }

    //warn level logs
    public static void warn(String message)
    {
        Log.warn(message);
    }

    //error level logs
    public static void error(String message)
    {
        Log.error(message);
    }

    //fatal level logs
    public static void fatal (String message)
    {
        Log.fatal(message);
    }

    //debug level logs
    public static void debug(String message)
    {
        Log.debug(message);
    }
}
