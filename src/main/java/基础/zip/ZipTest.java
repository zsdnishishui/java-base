package 基础.zip;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ZipTest {

    public static void main(String[] args) throws IOException {
        System.out.println(getZipFileList("D:/nginx 1.7.11.3 Gryphon.zip"));
    }

    public static List<String> getZipFileList(String zipFileName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(zipFileName)) {
            ZipInputStream zipInputStream = new ZipInputStream(
                    new BufferedInputStream(inputStream), StandardCharsets.UTF_8);
            java.util.zip.ZipEntry ze;
            List<String> list = new ArrayList<>();
            //循环遍历
            while ((ze = zipInputStream.getNextEntry()) != null) {
                if (ze.isDirectory()) { // 判断此zip项是否为目录
                    list.add("directory:" + ze.getName());
                } else {
                    list.add("file:" + ze.getName());
                }
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
