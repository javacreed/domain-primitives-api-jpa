package com.javacreed.api.domain.primitives.jpa.optional;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.Converter;

import com.javacreed.api.domain.primitives.optional.ZonedDateTimeBasedDomainPrimitive;

@Converter(autoApply = true)
public abstract class ZonedDateTimeBasedAttributeConverter<T extends ZonedDateTimeBasedDomainPrimitive>
    extends MismatchedObjectBasedAttributeConverter<ZonedDateTime, T, Timestamp> {

  @Override
  protected Timestamp convertNotNullToDatabaseColumn(final T value) {
    return value.toSqlTimestampOrNull();
  }

  @Override
  protected ZonedDateTime convertNotNullToValue(final Timestamp dbData) {
    return ZonedDateTime.ofInstant(dbData.toInstant(), ZoneOffset.UTC);
  }
}
