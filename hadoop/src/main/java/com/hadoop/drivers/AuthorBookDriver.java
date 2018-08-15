package com.hadoop.drivers;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.hadoop.mappers.AuthorBookMapper;
import com.hadoop.reducers.AuthorBookReducer;

public class AuthorBookDriver {
	public static void main(String[] args) throws Exception {
		System.out.println("==============AuthorBook STARTS=================");
        Configuration conf = new Configuration();
        if (args.length != 2) {
            System.err.println("Usage: CombineBooks <in> <out>");
            System.exit(2);
        }

        //Job job = new Job(conf, "CombineBooks");
        Job job = Job.getInstance(conf,"AuthorBook using built in mappers and reducers");
        job.setJarByClass(AuthorBookDriver.class);
        job.setMapperClass(AuthorBookMapper.class);
        job.setReducerClass(AuthorBookReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        int i = job.waitForCompletion(true) ? 0 : 1;
        System.out.println("==============AuthorBook using built in mappers and reducers=================");
        System.out.println("==============ENDS=================");
        System.exit(i);
    }
}
