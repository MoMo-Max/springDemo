package com.oo.spring.Util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/** 
 * @author ZhangDe 
 * @version 創建時間：Dec 16, 2008 3:26:41 PM
 * 類說明：多文件上傳
 *
 */

public class MutiFileUpload extends HttpServlet{

    private static final long serialVersionUID = 670829239023754119L;

    

    public Map parameters;//保存表單參數

    public Map files;//保存上傳的檔
    
    public boolean uploadError = false; //上傳是否有錯，漠認是沒錯false
    

    /** *//**

     * The directory in which uploaded files will be stored, if stored on disk.

     */

    private int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;

    

    /** *//**

     * The maximum size permitted for the complete request, as opposed to

     * {@link #fileSizeMax}. A value of -1 indicates no maximum.

     */

    private long sizeMax = -1;

    

    private String encoding = "utf-8";//字元編碼，當讀取上傳表單的各部分時會用到該encoding

    

    public String getEncoding() {

        return encoding;

    }

    public void setEncoding(String encoding) {

        this.encoding = encoding;

    }

    public long getSizeMax() {

        return sizeMax;

    }

    public void setSizeMax(long sizeMax) {

        this.sizeMax = sizeMax;

    }

    public int getSizeThreshold() {

        return sizeThreshold;

    }

    public void setSizeThreshold(int sizeThreshold) {

        this.sizeThreshold = sizeThreshold;

    }

    public void parse(HttpServletRequest request){

        parameters = new HashMap();

        files = new HashMap();

        //Create a factory for disk-based file items

        DiskFileItemFactory factory = new DiskFileItemFactory();



        //Set factory constraints

        factory.setSizeThreshold(sizeThreshold);

        //factory.setRepository(repository);



        //Create a new file upload handler

        ServletFileUpload upload = new ServletFileUpload(factory);



        //Set overall request size constraint

        upload.setSizeMax(sizeMax);

        upload.setHeaderEncoding(encoding);



        try {

            List items = upload.parseRequest(request);

            Iterator iterator = items.iterator();

            while(iterator.hasNext()){

                FileItem item = (FileItem)iterator.next();

                if(item.isFormField()){                    

                    String fieldName = item.getFieldName();

                    String value = item.getString();

                    parameters.put(fieldName, value);

                }else{

                    String fieldName = item.getFieldName();

                    files.put(fieldName, item);

                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();               
            this.setUploadError(true);//設為出錯
        }

    }

    /** 得到上傳檔的檔案名

     * @param item

     * @return

     */
    public String getFileName(FileItem item){

        String fileName = item.getName();
        fileName = this.replace(fileName,"\\", "/");
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);

        return fileName;

    }
    
    /**
     * 獲得檔擴展
     * @param item
     * @return
     */
    
    public String getFileExtension(FileItem item){
    	String fileName = getFileName(item); System.out.println(fileName);
    	fileName = fileName.substring(fileName.lastIndexOf("."));
    	return fileName;
    }

    /** 字串替

     * @param source

     * @param oldString

     * @param newString

     * @return

     */

    public static String replace(String source, String oldString, String newString) {

        StringBuffer output = new StringBuffer();

        int lengthOfSource = source.length(); 

        int lengthOfOld = oldString.length(); 

        int posStart = 0; 

        int pos; 


        while ((pos = source.indexOf(oldString, posStart)) >= 0) {

            output.append(source.substring(posStart, pos));

            output.append(newString);

            posStart = pos + lengthOfOld;

        }
        if (posStart < lengthOfSource) {

            output.append(source.substring(posStart));

        }
        return output.toString();

    }
    
    public String getParameter(String key){
		return (parameters == null) ?  null:(String)parameters.get(key);
	}
	
	public String getParameter(String key, String encoding) {
		if (parameters == null) return null;
		String value = (String)parameters.get(key);
		try {
			if (value != null) {
				value = new String(value.getBytes("ISO-8859-1"), encoding);
			}
        } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
        }
		return value;
	}

	public boolean getUploadError() {
		return uploadError;
	}

	public void setUploadError(boolean uploadError) {
		this.uploadError = uploadError;
	}
    
   
}






