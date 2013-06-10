package com.oo.spring.Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * @author ZhangDe
 * @version 創建時間：Jan 17, 2009 9:36:42 AM 
 * 類說明:文件操作
 */
public class FileUtil {
	private static final Log log = LogFactory.getLog(FileUtil.class);
	//分割符，在 UNIX 系統上，此欄位的值為 '/'；在 Microsoft Windows 系統上，它為 '\\'。
	public static String FILE_SEPARATOR = System.getProperty("file.separator");
	//默認圖片，大中小
	public static String DEFAULT_IMG_BIG = "images/default/default_img_big.jpg";
	public static String DEFAULT_IMG_MIDDLE = "images/default/default_img_middle.jpg";
	public static String DEFAULT_IMG_SMALL = "images/default/default_img_small.jpg";
	public static String DEFAULT_IMG_FRONT_SMALL = "images/default/nophoto.jpg";//前臺沒有照片時的默認圖片
	
	//默認文件路徑
	public static String DEFAULT_FILE = "uploadFile/";
	/**
	 * 文件寫入硬盤
	 * 
	 * @param saveDir
	 *            地址
	 * @param fileName
	 *            文件名
	 * @param data
	 */
	public static void saveFile(String saveDir, String fileName, byte[] data)
			throws Exception {
		BufferedOutputStream fout = null;
		ByteArrayInputStream in = new ByteArrayInputStream(data);  
		//DataInputStream file   = new  DataInputStream(new FileInputStream(new File(data))); 
		FileOutputStream out = null;
		try {
			File f = new File(saveDir);
			if (!f.exists()) {
				if (!f.mkdirs()) {
					log.error("檔夾創建失敗....");
					throw new Exception("檔夾創建失敗");
				}
			}

			String fileType = fileName.substring(fileName.length()-3, fileName.length());

			out = new FileOutputStream(new File(f, fileName));
			byte[] b = new byte[1024 * 10];
			fout = new BufferedOutputStream(out);
			
			//if (!fileType.equals("pdf")&&(!fileType.equals("xml")))
			//{
				/*
				while (in.read(b) > 0) {
					out.write(b);
				}
				*/
				int fileIdx = -1;
				while ((fileIdx = in.read(b)) != -1) {
					out.write(b,0,fileIdx);
				}
			//}
			/*
			if (fileType.equals("pdf") || fileType.equals("xml"))
			{
				byte fileBuffer[] = new byte[8192];
				int fileIdx = -1;
				while ((fileIdx = in.read(fileBuffer)) != -1) {
					out.write(fileBuffer,0,fileIdx);
				}
			} 
			*/

			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
			if (fout != null) {
				fout.close();
			}
		}
	}


	


	
	/**
	 * 多種不同文件上傳(多一級文件夾）
	 * @param fileFolder 
	 * @param linkId
	 * @param upload
	 * @return
	 */
	public static Map uploadFiles( MutiFileUpload upload)
	    throws Exception {
		Map map = new HashMap();
		String uploadFilePath = "/home/max/workspaceSTS/springDEMO/src/main/webapp/uploadFile"; // 上傳檔位置

		String dummyPath = "uploadFile"; // 虛擬路徑，用於存在表中
		Iterator iterator = upload.files.values().iterator();
		while (iterator.hasNext()) {
			FileItem item = (FileItem) iterator.next();
			if (upload.getFileName(item) == null
					|| upload.getFileName(item).equals(""))
				continue;
			String fileName = upload.getFileName(item); //原來的檔案名
			String fieldName = item.getFieldName();
			saveFile(uploadFilePath, fileName, item.get());
			fileName = dummyPath + fileName;// 虛擬路徑
			map.put(fieldName, fileName);
		}
		return map;		
	}
	

}
