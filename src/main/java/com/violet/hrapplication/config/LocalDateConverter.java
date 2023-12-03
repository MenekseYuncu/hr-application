package com.violet.hrapplication.config;

import org.sql2o.converters.Converter;
import org.sql2o.converters.ConverterException;

import java.sql.Date;
import java.time.LocalDate;

public class LocalDateConverter implements Converter<LocalDate> {

    public LocalDateConverter() {
    }

    @Override
    public LocalDate convert(Object dateObject) throws ConverterException {
        if (dateObject == null) {
            return null;
        } else {
            try {
                return LocalDate.parse(dateObject.toString().split(" ")[0]);
            } catch (IllegalArgumentException exception) {
                var dateObjectClassName = dateObject.getClass().getName();
                var localDateClassName = LocalDate.class.getName();
                throw new ConverterException(
                        (String.format("Don't know how to convert from type '%s' to type '%s'", dateObjectClassName, localDateClassName)),
                        exception
                );
            }
        }
    }

    @Override
    public Object toDatabaseParam(LocalDate localDate) {
        return Date.valueOf(localDate);
    }
}