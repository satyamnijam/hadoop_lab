package com.nyse.avgstockvolpermonth;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.nyse.keyvalues.LongPair;
import com.nyse.keyvalues.TextPair;

public class AvgStockVolPerMonthDriver  extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		System.out.println(args);
		Job job = Job.getInstance(getConf());
		job.setJarByClass(getClass());
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setInputFormatClass(CombineTextInputFormat.class);
		job.setMapOutputKeyClass(TextPair.class);
		job.setMapOutputValueClass(LongPair.class);
		
		job.setMapperClass(AvgStockVolPerMonthMapper.class);
		job.setNumReduceTasks(0);
		System.out.println("###################### END OF PROGRAM ##########################");
		// TODO Auto-generated method stub
		return job.waitForCompletion(true) ? 0 : 1; // 0= Success, 1=Fail
	}
	
	 public static void main(String[] args) throws Exception {
		 System.exit(ToolRunner.run(new AvgStockVolPerMonthDriver(), args));
		
	}
}
