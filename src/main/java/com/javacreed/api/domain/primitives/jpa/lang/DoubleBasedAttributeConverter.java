package com.javacreed.api.domain.primitives.jpa.lang;

import javax.persistence.AttributeConverter;

import com.javacreed.api.domain.primitives.lang.DoubleBasedDomainPrimitive;

public abstract class DoubleBasedAttributeConverter<T extends DoubleBasedDomainPrimitive>
    implements AttributeConverter<T, Double> {

  protected abstract T convertNotNullToEntityAttribute(double dbData);

  @Override
  public Double convertToDatabaseColumn(final T attribute) {
    return attribute == null ? null : attribute.getValue();
  }

  @Override
  public T convertToEntityAttribute(final Double dbData) {
    return dbData == null ? null : convertNotNullToEntityAttribute(dbData);
  }
}
