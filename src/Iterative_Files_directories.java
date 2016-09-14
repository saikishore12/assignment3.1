import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class Iterative_Files_directories {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		printFilesRecursively(args[0]);
	}

	public static void printFilesRecursively(String Url) throws IOException {
		try {
			// Instantiating Distributed file system
			FileSystem fs = new DistributedFileSystem();
			// loading configuration and URI
			fs.initialize(new URI(Url), new Configuration());
			FileStatus[] status = fs.listStatus(new Path(Url));
			for (int i = 0; i < status.length; i++) {
				if (status[i].isDir()) {
					printFilesRecursively(status[i].getPath().toString());
				} else {
					try {
						System.out.println(status[i].getPath().toString());
					} catch (Exception e) {
						System.out.println(e.toString());
					}

				}

			}
		} catch (URISyntaxException ex) {
			System.out.println(ex.toString());
		}

	}
}