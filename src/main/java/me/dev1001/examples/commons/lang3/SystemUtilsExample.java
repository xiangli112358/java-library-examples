package me.dev1001.examples.commons.lang3;

import java.io.File;
import org.apache.commons.lang3.SystemUtils;

/**
 * @author think on 6/7/2018
 */
public class SystemUtilsExample {

  public static void main(String[] args) {
    System.out.println("JavaHome: " + SystemUtils.getJavaHome());
    System.out.println("HostName: " + SystemUtils.getHostName());
    System.out.println("UserDir: " + SystemUtils.getUserDir());
    System.out.println("TmpDir: " + SystemUtils.getJavaIoTmpDir());
    System.out.println(SystemUtils.FILE_ENCODING);
    System.out.println(File.separator);
    System.out.println(SystemUtils.JAVA_CLASS_PATH);
    System.out.println(SystemUtils.JAVA_VERSION);
  }
}
