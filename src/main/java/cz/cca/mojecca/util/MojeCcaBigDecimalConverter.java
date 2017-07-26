package cz.cca.mojecca.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

public class MojeCcaBigDecimalConverter implements Converter {

	Converter delegate;

	public MojeCcaBigDecimalConverter(Converter delegate) {
		this.delegate = delegate;
	}

	@Override
	public <T> T convert(Class<T> targetType, Object value) {
		if (value instanceof Date) {
			return targetType.cast(dateToBigDecimal((Date) value));
		}
		
		return delegate.convert(targetType, value);
	}

	private BigDecimal dateToBigDecimal(Date date) {
		if (date == null) {
			return null;
		}
		return new BigDecimal(date.getTime());
	}
	
	public static void register() {
		ConvertUtils.register(new MojeCcaBigDecimalConverter(new BigDecimalConverter()), BigDecimal.class);
	}

}
