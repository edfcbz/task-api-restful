package br.com.edfcbz.api.serialization.converter;

import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.net.MediaType;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public YamlJackson2HttpMessageConverter() {
//		super(new YAMLMapper()
//				.setSerializationInclusion(JsonInclude.Include.NON_NULL), MediaType.MediaType("application/x-yaml"));
		super(null);
	}

}
