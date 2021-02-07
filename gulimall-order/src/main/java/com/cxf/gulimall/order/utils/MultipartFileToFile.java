package com.cxf.gulimall.order.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author xfchai
 * @ClassName MultipartFileToFile.java
 * @Description MultipartFile转fie
 * @createTime 2021/02/04 10:50:00
 */
public class MultipartFileToFile {
    public static File multipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = null;
        if (multipartFile.isEmpty()) {
            file = null;
        } else {
            InputStream inputStream = multipartFile.getInputStream();
            file = new File(multipartFile.getOriginalFilename());
            inputStreamToFile(inputStream, file);
            inputStream.close();
        }
        return file;
    }

    private static void inputStreamToFile(InputStream inputStream, File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除本地的临时文件(单个文件)
     *
     * @param file
     * @return
     */
    public static boolean deleteFile(File file) {
        boolean flag = false;
        // File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            flag = file.delete();
        }
        return flag;
    }

    /**
     * 删除目录以及目录下的文件
     *
     * @param sPath ：目录路径
     * @return ：是否删除成功
     */
    public static boolean deleteDirectory(String sPath) {
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }

        File dirFile = new File(sPath);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        if (files != null) {
            for (File ff : files) {
                if (ff.isFile()) {
                    flag = deleteFile(ff);
                    if (!flag) {
                        break;
                    }
                } else {
                    flag = deleteDirectory(ff.getAbsolutePath());
                    if (!flag) {
                        break;
                    }
                }
            }
        }

        if (!flag) {
            return false;
        }
        //删除当前目录
        return dirFile.delete();
    }

    /**
     * 根据路径删除指定目录和文件
     *
     * @param ：路径
     * @return ：删除成功返回true,否则返回false
     */
    public static boolean deleteFolder(File file) {
        //File file = new File(sPath);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(file);
            } else {
                return deleteDirectory(file.getPath());
            }
        }
    }
}
