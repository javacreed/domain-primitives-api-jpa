package com.javacreed.api.domain.objects.jpa.optional;

import java.sql.Timestamp;

import javax.persistence.Converter;

import com.javacreed.api.domain.objects.jpa.ObjectBasedAttributeConverter;
import com.javacreed.api.domain.objects.optional.LocalDateTimeBasedDomainObject;

@Converter(autoApply = true)
public abstract class LocalDateTimeBasedAttributeConverter<T extends LocalDateTimeBasedDomainObject>
    extends ObjectBasedAttributeConverter<T, Timestamp> {

  @Override
  protected Timestamp convertNotNullToDatabaseColumn(final T attribute) {
    return attribute.map(Timestamp::valueOf).get();
  }
}
