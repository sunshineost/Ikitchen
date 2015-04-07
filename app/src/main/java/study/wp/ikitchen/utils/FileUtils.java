package study.wp.ikitchen.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wp on 2015-03-05.
 */
public class FileUtils {
    /***
     * SD目录
     */
    private String SDCardRoot;
    //使用构造函数获得SD卡的目录
    public FileUtils(){
        //得到当前外部存储设备的目录名
        SDCardRoot= Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    /***
     * 在SD卡上创建文件
     * @param fileName 文件名
     * @param dir 文件存储目录
     * @return 文件
     * @throws IOException
     */
    public File createFileInSDCard(String fileName,String dir) throws IOException{
        //File.separator是系统有关的默认名称分隔符“/”
        Log.e("wp", SDCardRoot + dir + File.separator + fileName);
        File file = new File(SDCardRoot+ File.separator + dir + File.separator + fileName);
        //System.out.println(file);
        if(!file.exists()){
            file.createNewFile();
        }
        return file;
    }
    /**
     * 在SD卡上创建目录
     * @param dir 目录名称
     * @return 返回目录
     */
    public File createSDDir(String dir)
    {
        File dirFile = new File(SDCardRoot +File.separator + dir + File.separator);
        dirFile.mkdirs();
        return dirFile;
    }
    /***
     * 判断文件是否存在
     * @param fileNameString 文件名
     * @param
     * @return 存在返回true 不存在返回false
     */
    public boolean isFileExist(String fileNameString , String path)
    {
        File file = new File(SDCardRoot + "/"+ path + File.separator + fileNameString);
        //System.out.println("isExist ->" + file);
        return file.exists();
    }

    /***
     * 将InputStream里面的数据写入到SD卡的文件中
     * @param path 文件的路径
     * @param fileNameString 文件名
     * @param inputStream 数据流
     * @return
     */
    public File write2SDFromInput(String path , String fileNameString , InputStream inputStream)
    {
        File file = null;
        OutputStream outputStream = null;
        try {
            createSDDir(path);
            file = createFileInSDCard(fileNameString, path);

            outputStream = new FileOutputStream(file);
            //创建一个4*1024大小的缓冲区
            byte buffer [] = new byte[4*1024];
            int temp;
            //循环读取InputStream里的数据
            while ((temp = inputStream.read(buffer)) != -1) {
                //把流按照buffer的大小写入到文件中
                outputStream.write(buffer, 0, temp);

            }
            //提交缓冲区的内容
            outputStream.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                outputStream.close();

            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }

        return file;

    }

    public File write2SDFromBitmap(String path, String filename, Bitmap bitmap) {
        File file = null;
        try {
            createSDDir(path);
            file = createFileInSDCard(filename, path);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
