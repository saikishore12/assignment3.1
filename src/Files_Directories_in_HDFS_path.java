import java.io.*;
import java.util.*;
import java.net.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class Files_Directories_in_HDFS_path{
    public static void main (String [] args) throws Exception{
    	//loading the configuration
        	Configuration conf =new Configuration();
        	//creating URI by passing HDFS path as argument
        	URI uri=URI.create(args[0]);
        	//loading the filesystem
            FileSystem fs = FileSystem.get(uri,conf);
            //get the status of all the files systems
            FileStatus[] status = fs.listStatus(new Path(uri+"/"));  // you need to pass in your hdfs path
            Path[] paths=FileUtil.stat2Paths(status);
            //printing all the paths 
            for(Path path:paths){
            	System.out.println(path);
            }
    }
}
          
