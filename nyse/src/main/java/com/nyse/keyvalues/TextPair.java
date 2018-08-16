package com.nyse.keyvalues;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair>{

	Text first;
	Text second;
	
	
	public TextPair(Text first, Text second) {
		super();
		this.first = first;
		this.second = second;
	}
	public TextPair(String first, String second) {
		super();
		this.first = new Text(first);
		this.second = new Text(second);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		this.first.write(out);
		this.second.write(out);
		
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.first.readFields(in);
		this.second.readFields(in);
		
	}

	@Override
	public int compareTo(TextPair arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
