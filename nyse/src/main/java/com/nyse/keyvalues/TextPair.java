package com.nyse.keyvalues;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair> {

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
		this.first.write(out);
		this.second.write(out);

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.first.readFields(in);
		this.second.readFields(in);

	}

	@Override
	public int compareTo(TextPair other) {
		int cmp = this.first.compareTo(other.first);
		if (cmp != 0)
			return cmp;
		return this.second.compareTo(other.second);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextPair other = (TextPair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextPair [first=" + first + ", second=" + second + "]";
	}

}
