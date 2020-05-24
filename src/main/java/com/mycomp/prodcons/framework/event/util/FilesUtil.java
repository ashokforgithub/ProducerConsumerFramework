/**
 * 
 */
package com.mycomp.prodcons.framework.event.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;

/**
 * @author ashok
 *
 */
public class FilesUtil {

	public static <A extends FileAttributeView> A getBasicFileAttributes(Path path, Class<A> classType)
			throws Exception {
		return Files.getFileAttributeView(path, classType, LinkOption.NOFOLLOW_LINKS);
	}

	// Unit Testing

	public static void main(String[] args) {

		try {
			String fileName = "";
			String dupFileName = "";

			BasicFileAttributes basicFileAttributes = getBasicFileAttributes(Paths.get(fileName),
					BasicFileAttributeView.class).readAttributes();
			System.out.println(" File BasicViewAttributes : Size=" + basicFileAttributes.size() + ", Creation Time="
					+ basicFileAttributes.creationTime() + ", isRegularFile=" + basicFileAttributes.isRegularFile());

			BasicFileAttributes basicFileAttributes1 = getBasicFileAttributes(Paths.get(dupFileName),
					BasicFileAttributeView.class).readAttributes();
			System.out.println(" File BasicViewAttributes : Size=" + basicFileAttributes.size() + ", Creation Time="
					+ basicFileAttributes.creationTime() + ", isRegularFile=" + basicFileAttributes.isRegularFile());

			System.out.println("Content Type Equals" + Files.probeContentType(Paths.get(fileName))
					.contentEquals(Files.probeContentType(Paths.get(dupFileName))));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
