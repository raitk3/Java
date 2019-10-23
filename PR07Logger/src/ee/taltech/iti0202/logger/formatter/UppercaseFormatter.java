package ee.taltech.iti0202.logger.formatter;

import ee.taltech.iti0202.logger.log.Log;

public class UppercaseFormatter implements LogFormatter {
    SimpleFormatter simpleFormatter = new SimpleFormatter();
    @Override
    public String format(Log log) {
        return simpleFormatter.format(log).toUpperCase();
    }
}
