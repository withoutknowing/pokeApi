package com.mx.bky.converter;

public  interface Converter<IN, OUT> {

	OUT convert(IN in);

}

