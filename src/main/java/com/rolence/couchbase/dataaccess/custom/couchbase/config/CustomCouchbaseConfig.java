package com.rolence.couchbase.dataaccess.custom.couchbase.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JavaType;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.type.TypeFactory;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.util.Converter;

public class CustomCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(
            BigDecimalToString.INSTANCE,     
            StringToBigDecimalConverter.INSTANCE));
    }

    @WritingConverter
    public static enum BigDecimalToString implements Converter<BigDecimal, String> {
        INSTANCE;

        @Override
        public String convert(BigDecimal source) {
            // or a more appropriate implementation
            return source.toString() ;
        }

		@Override
		public JavaType getInputType(TypeFactory typeFactory) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JavaType getOutputType(TypeFactory typeFactory) {
			// TODO Auto-generated method stub
			return null;
		}

    }


    @ReadingConverter
    public static enum StringToBigDecimalConverter implements Converter<String, BigDecimal> {
        INSTANCE;

        @Override
        public BigDecimal convert(String source) {
            return new BigDecimal(source);
        }

		@Override
		public JavaType getInputType(TypeFactory typeFactory) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JavaType getOutputType(TypeFactory typeFactory) {
			// TODO Auto-generated method stub
			return null;
		}

    }


	@Override
	protected List<String> getBootstrapHosts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String getBucketName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String getBucketPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
