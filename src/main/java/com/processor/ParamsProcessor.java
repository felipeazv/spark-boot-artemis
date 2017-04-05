package com.processor;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.pojo.Params;

public class ParamsProcessor implements Serializable {

	private static final long serialVersionUID = -8791959039649920129L;
	
	private static final Logger log = LoggerFactory.getLogger(ParamsProcessor.class);
	
	public Params process(String line) {
		String[] values = line.split(",");
		Params params =  new Params();
		params.setParam1(values[0]);
		params.setParam2(values[1]);
		params.setParam3(values[2]);
		params.setParam4(values[3]);
		params.setParam5(values[4]);
		params.setParam6(values[5]);
		params.setParam7(values[6]);
		params.setParam8(values[7]);
		params.setParam9(values[8]);
		params.setParam10(values[9]);
		params.setParam11(values[10]);
		params.setParam12(values[11]);
		params.setParam13(values[12]);
		params.setParam14(values[13]);
		params.setParam15(values[14]);
		params.setParam16(values[15]);
		params.setParam17(values[16]);
		params.setParam18(values[17]);
		params.setParam19(values[18]);
		params.setParam20(values[19]);
		params.setParam21(values[20]);
		params.setParam22(values[21]);
		params.setParam23(values[22]);
		params.setParam24(values[23]);
		params.setParam25(values[24]);
		params.setParam26(values[25]);
		params.setParam27(values[26]);
		params.setParam28(values[27]);
		params.setParam29(values[28]);
		params.setParam30(values[29]);
		return params;
	} 
}
