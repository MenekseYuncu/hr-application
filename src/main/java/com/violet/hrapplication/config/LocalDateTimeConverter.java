package com.violet.hrapplication.config;

import org.sql2o.converters.Converter;
import org.sql2o.converters.ConverterException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

class LocalDateTimeConverter implements Converter<LocalDateTime> {

    public LocalDateTimeConverter() {
    }

    @Override
    public LocalDateTime convert(Object dateObject) throws ConverterException {
        if (dateObject == null) {
            return null;
        } else {
            try {
                return LocalDateTime.parse(dateObject.toString());
            } catch (IllegalArgumentException exception) {
                var dateObjectClassName = dateObject.getClass().getName();
                var localDateTimeClassName = LocalDateTime.class.getName();
                throw new ConverterException(
                        (String.format("Don't know how to convert from type '%s' to type '%s'", dateObjectClassName, localDateTimeClassName)),
                        exception
                );
            }
        }
    }

    @Override
    public Object toDatabaseParam(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }
}
