package com.hadoop.reducers;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorBookReducer extends Reducer<Text,Text,NullWritable,Text>{

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{

        try{
            JSONObject obj = new JSONObject();
            JSONArray ja = new JSONArray();
            for(Text val : values){
                JSONObject jo = new JSONObject().put("book", val.toString());
                ja.put(jo);
            }
            obj.put("books", ja);
            obj.put("author", key.toString());
            context.write(NullWritable.get(), new Text(obj.toString()));
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}

