package org.leopard.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUtil {
	
/**
 * �����ļ��ϴ�
 * @param is
 * @param fileName
 * @param filePath
 */
	public static void upFile(File uploadFile,String fileName,String filePath){
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		FileInputStream is = null;
		BufferedInputStream bis = null;
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		File f = new File(filePath+"/"+fileName);
		try {
			is = new FileInputStream(uploadFile);
			bis = new BufferedInputStream(is);
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			byte[] bt = new byte[4096];
			while((bis.read(bt))>0){
				bos.write(bt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(null != bos){
					bos.close();
					bos = null;}
					if(null != fos){
						fos.close();
						fos= null;
					}
					if(null != is){
						is.close();
						is=null;
					}
					
					if (null != bis) {
						bis.close();
						bis = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	
	
	/**
	 * �ļ�����
	 * @param response
	 * @param downloadFile
	 */
	public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFile, String fileName) {
		
		BufferedInputStream bis = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			File file=new File(downloadFile); //:�ļ�������
	        is = new FileInputStream(file);  //:�ļ���������
	        os = response.getOutputStream(); // �ص�ͻ��
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(os);
	        
	        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
	        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
	        } else {
	        	// ���ļ������б��봦����������
	  	        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// ���������ļ���������
	  	        fileName = new String(fileName.getBytes("UTF-8"), "GBK");// ���������ļ���������
	        }
	        
	        response.reset(); // �ص�ͻ��
	        response.setCharacterEncoding("UTF-8"); // �ص�ͻ��
	        response.setContentType("application/x-msdownload");// ��ͬ���͵��ļ���Ӧ��ͬ��MIME���� // �ص�ͻ��
	        // inline���������ֱ����ʾ������ʾ�û�����
	        // attachment�����Ի�����ʾ�û��������ر��汾��
	        // Ĭ��Ϊinline��ʽ
	        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	      //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // �ص�ͻ��
	        int bytesRead = 0;
	        byte[] buffer = new byte[1024];
	        while ((bytesRead = bis.read(buffer)) != -1){ //�ص�
	            bos.write(buffer, 0, bytesRead);// ���ļ����͵��ͻ���
	        }
	        
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			// �ر���Ҫ
	        // 1. ���йر���Ϊ���ͷ���Դ
	        // 2. ���йرջ��Զ�ִ��flush������ջ���������
			try {
				if (null != bis) {
					bis.close();
					bis = null;
				}
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != is) {
					is.close();
					is = null;
				}
				if (null != os) {
					os.close();
					os = null;
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
	
	/**
	 * �ļ�����
	 * @param response
	 * @param downloadFile
	 */
	public static void downloadFile(HttpServletResponse response, String downloadFile, String showFileName) {
		
		BufferedInputStream bis = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			File file=new File(downloadFile); //:�ļ�������
	        String fileName=file.getName();
	        is = new FileInputStream(file);  //:�ļ���������
	        os = response.getOutputStream(); // �ص�ͻ��
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(os);
	        // ���ļ������б��봦����������
	        fileName = java.net.URLEncoder.encode(showFileName, "UTF-8");// ���������ļ���������
	        fileName = new String(fileName.getBytes("UTF-8"), "GBK");// ���������ļ���������
	        response.reset(); // �ص�ͻ��
	        response.setCharacterEncoding("UTF-8"); // �ص�ͻ��
	        response.setContentType("application/x-msdownload");// ��ͬ���͵��ļ���Ӧ��ͬ��MIME���� // �ص�ͻ��
	        // inline���������ֱ����ʾ������ʾ�û�����
	        // attachment�����Ի�����ʾ�û��������ر��汾��
	        // Ĭ��Ϊinline��ʽ
	        response.setHeader("Content-Disposition", "attachment; filename="+fileName); // �ص�ͻ��
	        int bytesRead = 0;
	        byte[] buffer = new byte[1024];
	        while ((bytesRead = bis.read(buffer)) != -1){ //�ص�
	            bos.write(buffer, 0, bytesRead);// ���ļ����͵��ͻ���
	        }
	        
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			// �ر���Ҫ
	        // 1. ���йر���Ϊ���ͷ���Դ
	        // 2. ���йرջ��Զ�ִ��flush������ջ���������
			try {
				if (null != bis) {
					bis.close();
					bis = null;
				}
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != is) {
					is.close();
					is = null;
				}
				if (null != os) {
					os.close();
					os = null;
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}

}


