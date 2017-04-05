package com.reader;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import com.processor.ParamsProcessor;
import com.writer.ParamsWriter;

@Component
public class ParamsReader implements Serializable {
private static final long serialVersionUID = -8791959039649920129L;
	
	private static final Logger log = LoggerFactory.getLogger(ParamsReader.class);
	
	@Autowired
	SparkSession sparkSession;
	
	@Bean
	public Dataset<Row> reader() {
		log.warn(":::::::::::::::::::::::::::::::::::processamento iniciado..." + LocalDateTime.now());
		JavaRDD<Params> paramsRDD = sparkSession
				.read()
				.textFile("file:/D:/java/workspace/eclipse/ws-batch-boot/spark-boot/bin/DATA.csv")
				.javaRDD()
				.map(new Function<String, Params>(){
					@Override
					public Params call(String line) throws Exception {
						Params params = new ParamsProcessor().process(line);
						new ParamsWriter().write(params);
						return params;
					}
					
				});
		Dataset<Row> dataSet = sparkSession.createDataFrame(paramsRDD, Params.class);
		log.warn(":::::::::::::::::::::::::::::::::::processamento finalizado..." + LocalDateTime.now());
		log.warn(":::::::::::::::::::::::::::::::::::total de linhas ..." + paramsRDD.count());
		return dataSet;
	}
}
