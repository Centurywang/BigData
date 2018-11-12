package hdfspro;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Test3 {
	//定义HDFS的地址
	public static final String HDFS_PATH="hdfs://wangsj:9000";
	public static void main(String[] args) throws URISyntaxException, IOException {
	//1.读取hadoop配置文件，构造conf对象
	Configuration conf=new Configuration();
	//2.构造uri
	URI uri=new URI(HDFS_PATH);
	
	//3.构造文件系统FileSystem对象
	FileSystem fileSystem=FileSystem.get(uri, conf);
	
	//将HDFS /home/test.txt文件download到local的/root目录下
	Path dst=new Path("/root/testcopy.txt");
	Path src=new Path(HDFS_PATH+"/newdir/testcopy.txt");
	
	fileSystem.copyToLocalFile(src, dst);
	
}
}

	
