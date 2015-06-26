package com.zhaos.json;

import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MyJSON {
	
	public static String toJSONStringWithDateFormat(Object object){
		return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
	}
	
	public static <T> T parseObject(String text, Class<T> clazz){
		return JSON.parseObject(text, clazz, getInstance().parserConfig, JSON.DEFAULT_GENERATE_FEATURE, new Feature[0]);
	}
	
	public static <T> T parseObject(String text, TypeReference<T> type){
		return JSON.parseObject(text, type.getType(), getInstance().parserConfig, JSON.DEFAULT_GENERATE_FEATURE, new Feature[0]);
	}
	
	private static MyJSON getInstance(){
		return new MyJSON();
	}
	
	private MyJSON(){}
	/*
	 * FastJSON中ParserConfig中封装的都是不同类型对应的解析器，
	 * MyDate属于自定义的类型, JSON中没有对应的解析器，因此需要自定义；
	 */
	private ParserConfig parserConfig = new ParserConfig();
	{
		putRctDateDeserializer();
	}
	
	private void putRctDateDeserializer() {
		parserConfig.putDeserializer(MyDate.class, new DateFormatDeserializer(){

			@SuppressWarnings("unchecked")
			@Override
			protected MyDate cast(DefaultJSONParser parser, Type clazz,
					Object fieldName, Object val) {
		        if (val == null) {
		            return null;
		        }

		        if (val instanceof String) {
		            String strVal = (String) val;
		            if (strVal.length() == 0) {
		                return null;
		            }		            
		            return MyDate.yyyy_MM_dd(strVal);
		        }
		        if(val instanceof Long){
		        	return new MyDate((long) val);
		        }
				return null;
			}
	
			@Override
			public int getFastMatchToken() {
				return JSON.DEFAULT_PARSER_FEATURE;
			}
		} );
	}
}
