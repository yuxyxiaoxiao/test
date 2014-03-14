package org.leopard.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
/**
* ����:ʹ��Apache Ant���ṩ��org.apache.tools.zipʵ��zipѹ���ͽ�ѹ (֧�������ļ���)
* ���������java.util.zip����֧�ֺ��ֵ����⡣ ʹ��java.util.zip��ʱ,��zip�ļ���������Ϊ���ĵ��ļ�ʱ,
* �ͻ�����쳣:"Exception in thread "main " java.lang.IllegalArgumentException at
* java.util.zip.ZipInputStream.getUTF8String(ZipInputStream.java:285)
* 
* @author 
* @version ����ʱ�䣺2013-3-22 ����10:40:21 ��˵����
*/
public class AntZipUtil {
	private static List list = new ArrayList();
		private static List listFile(String path) {
		File file = new File(path);
		String[] array = null;
		String sTemp = "";
			if (!file.isDirectory()) {
			return null;
			}
		array = file.list();
		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
			sTemp = path + array[i];
			file = new File(sTemp);
			if (file.isDirectory()) {
				listFile(sTemp + "/");
			} else
				list.add(sTemp);
			}
		} else {
			return null;
		}
		return list;
	}
	public static void zip(String needtozipfilepath, String zipfilepath){
		try {
			byte[] b = new byte[512];
			File needtozipfile = new File(needtozipfilepath);
			if (!needtozipfile.exists()) {
			System.err.println("ָ����Ҫѹ�����ļ���Ŀ¼������.");
			return;
		}
		String zipFile = zipfilepath;
		File targetFile = new File(zipFile.substring(0, zipFile.indexOf("\\") + 1));
		if (!targetFile.exists()) {
			System.out.println("ָ����Ŀ���ļ���Ŀ¼������.");
			return;
		}
		String filepath = needtozipfilepath;
		List fileList = listFile(filepath);
		FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
		CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream,new CRC32());
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(cs));
		for (int i = 0; i < fileList.size(); i++) {
			InputStream in = new FileInputStream((String) fileList.get(i));
			String fileName = ((String) fileList.get(i)).replace(File.separatorChar, '/');
			fileName = fileName.substring(fileName.indexOf("/") + 1);
			ZipEntry e = new ZipEntry(fileName);
			out.putNextEntry(e);
			int len = 0;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.closeEntry();
		}
		out.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	// ///////////////////////////////////////
	/**
	* ѹ���ļ� ���� �ļ���
	* 
	* @param baseDirName
	* ѹ���ĸ�Ŀ¼
	* @param fileName
	* ��Ŀ¼�´�ѹ�����ļ����ļ�����
	* @param targetFileName
	* Ŀ��ZIP �ļ� �Ǻ� "*" ��ʾѹ����Ŀ¼�µ�ȫ���ļ�
	* 
	*/
	public static boolean zip(String baseDirName, String[] fileNames,
	String targetFileName, String encoding) {
		boolean flag = false;
		try {
		// �ж� "ѹ���ĸ�Ŀ¼"�Ƿ����! �Ƿ���һ���ļ���!
		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || (!baseDir.isDirectory())) {
		System.err.println("ѹ��ʧ��! ��Ŀ¼������: " + baseDirName);
		return false;
		}
		// �õ���� "ѹ���ĸ�Ŀ¼" �ľ���·��
		String baseDirPath = baseDir.getAbsolutePath();
		// ����� "Ŀ�� ZIP �ļ�" �ļ����õ�һ�� ѹ������ ZipOutputStream
		File targetFile = new File(targetFileName);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
		targetFile));
		// ���������룬��������ĸ�����
		// CnZipOutputStream out = new CnZipOutputStream(new
		// FileOutputStream(targetFile),encoding);
		// ����ѹ������Apache Ant�и���ר�Ŵ���ZIP�ļ�������ָ���ļ����ı��뷽ʽ���ɴ˿��Խ�����⡣���磺��
		// org.apache.tools.zip.ZipOutputStream����java.util.zip.ZipOutputStream��ZipOutputStream
		// out = .....; out.setEncoding("GBK");
		// out.setEncoding("GBK");//����ΪGBK����windows�¾Ͳ��������ˣ����Ҫ�ŵ�Linux����Unix�¾Ͳ�Ҫ������
		out.setEncoding(encoding);
		// "*" ��ʾѹ��������Ŀ¼ baseDirName ���ڵ�ȫ���ļ� �� targetFileName�ļ���
		if (fileNames.equals("*")) {
		AntZipUtil.dirToZip(baseDirPath, baseDir, out);
		} else {
		File[] files = new File[fileNames.length];
		for (int i = 0; i < files.length; i++) {
		// ���� parent ����·������ child ·�����ַ�������һ���� File ʵ����
		files[i] = new File(baseDir, fileNames[i]);
		}
		if (files[0].isFile()) {
		// ���ñ����һ����̬���� ѹ��һ���ļ�
		// CompressUtil.fileToZip(baseDirPath, file, out);
		AntZipUtil.filesToZip(baseDirPath, files, out);
		}
		}
		out.close();
		// System.out.println("ѹ���ɹ�! Ŀ���ļ���Ϊ: " + targetFileName);
		flag = true;
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return flag;
	}
	/**
	* ���ļ�ѹ����Zip �����
	* 
	* @param baseDirPath
	* ��Ŀ¼·��
	* @param file
	* Ҫѹ�����ļ�
	* @param out
	* �����
	* @throws IOException
	*/
	private static void fileToZip(String baseDirPath, File file,
	ZipOutputStream out) throws IOException {
	//
	FileInputStream in = null;
	org.apache.tools.zip.ZipEntry entry = null;
	// �������ƻ����� 1024*4 = 4K
	byte[] buffer = new byte[1024 * 4];
	int bytes_read = 0;
	if (file.isFile()) {
	in = new FileInputStream(file);
	// ���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ��
	String zipFileName = getEntryName(baseDirPath, file);
	entry = new org.apache.tools.zip.ZipEntry(zipFileName);
	// "ѹ���ļ�" ������� "Ҫѹ�����ļ�" ����
	out.putNextEntry(entry);
	// �����ǰ� "Ҫѹ�����ļ�" �����е�����д�뵽 "ѹ���ļ�" ����
	while ((bytes_read = in.read(buffer)) != -1) {
	out.write(buffer, 0, bytes_read);
	}
	out.closeEntry();
	in.close();
	// System.out.println("����ļ�" + file.getAbsolutePath()+ "����ӵ� ZIP
	// �ļ���!");
	}
	}
	/**
	* ����ļ�Ŀ¼ѹ����Zip �����
	* 
	* @param baseDirPath
	* @param files
	* @param out
	* @throws IOException
	*/
	@SuppressWarnings("unused")
	private static void filesToZip(String baseDirPath, File[] files,
	ZipOutputStream out) throws IOException {
	// �������е��ļ� һ��һ����ѹ��
	for (int i = 0; i < files.length; i++) {
	File file = files[i];
	if (file.isFile()) {
	// ���ñ����һ����̬���� ѹ��һ���ļ�
	AntZipUtil.fileToZip(baseDirPath, file, out);
	} else {
	/*
	* ����һ���ļ��� ����Ҫ�ٴεõ�����������е��ļ� �������Լ������Լ�..............�ݹ�..........
	*/
	AntZipUtil.dirToZip(baseDirPath, file, out);
	}
	}
	}
	/**
	* ���ļ�Ŀ¼ѹ����Zip �����
	* 
	* @param baseDirPath
	* @param dir
	* @param out
	* @throws IOException
	*/
	private static void dirToZip(String baseDirPath, File dir,
	ZipOutputStream out) throws IOException {
	// �õ�һ���ļ��б� (��Ŀ¼�µ������ļ����󼯺�)
	File[] files = dir.listFiles();
	// Ҫ������ļ���������ĳ���Ϊ 0 , Ҳ��֤��������һ���յ��ļ���,��Ȼû����ѭ���������ı�Ҫ,����ҲҪ��������ļ���Ҳѹ����Ŀ���ļ���ȥ
	if (files.length == 0) {
	// ���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ��
	String zipFileName = getEntryName(baseDirPath, dir);
	org.apache.tools.zip.ZipEntry entry = new org.apache.tools.zip.ZipEntry(
	zipFileName);
	out.putNextEntry(entry);
	out.closeEntry();
	} else {
	// �������е��ļ� һ��һ����ѹ��
	for (int i = 0; i < files.length; i++) {
	File file = files[i];
	if (file.isFile()) {
	// ���ñ����һ����̬���� ѹ��һ���ļ�
	AntZipUtil.fileToZip(baseDirPath, file, out);
	} else {
	/*
	* ����һ���ļ��� ����Ҫ�ٴεõ�����������е��ļ�
	* �������Լ������Լ�..............�ݹ�..........
	*/
	AntZipUtil.dirToZip(baseDirPath, file, out);
	}
	}
	}
	}
	/**
	* ��ȡ ��ѹ���ļ��� ZIP �ļ��е� entry�����֣�������ڸ�Ŀ¼�����·����
	* 
	* @param baseDirPath
	* ��Ŀ¼
	* @param file
	* @return
	*/
	private static String getEntryName(String baseDirPath, File file) {
	/**
	* �ı� baseDirPath ����ʽ �� "C:/temp" ��� "C:/temp/"
	*/
	if (!baseDirPath.endsWith(File.separator)) {
	baseDirPath += File.separator;
	}
	String filePath = file.getAbsolutePath();
	/**
	* ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼�� Ҫ������ļ�������һ��Ŀ¼ ��ҲҪ��� ����� "/" ����ļ�����������
	* "C:/temp/����д��/1.jpg" Ҫ������ļ���һ���ļ��� ��ҲҪ��� ����� "/"
	* ��Ϊ��Ҫ�ǲ�������,��Ҳ�ᱻѹ����Ŀ���ļ��� ����ȴ����������ʾ Ҳ����˵����ϵͳ������ȷʶ�������ļ�����(���ļ������ļ���)
	*/
	if (file.isDirectory()) {
	filePath += "/";
	}
	int index = filePath.indexOf(baseDirPath);
	return filePath.substring(index + baseDirPath.length());
	}
	// //////////////////////////��ѹ��////////////////////////////////////////
	/**
	* ����org.apache.tools.zipʵ�ֽ�ѹ����֧��Ŀ¼Ƕ�׺�������
	* Ҳ����ʹ��java.util.zip������������ĵĻ�����ѹ����ʱ���ļ����ֻ������롣ԭ���ǽ�ѹ������ı����ʽ��java.util.zip.ZipInputStream�ı����ַ���(�̶���UTF-8)��ͬ
	* 
	* @param zipFileName
	* Ҫ��ѹ�����ļ�
	* @param outputDirectory
	* Ҫ��ѹ����Ŀ¼
	* @throws Exception
	*/
	public static boolean unZip(String zipFileName, String outputDirectory) {
	boolean flag = false;
	try {
	org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(
	zipFileName);
	java.util.Enumeration e = zipFile.getEntries();
	org.apache.tools.zip.ZipEntry zipEntry = null;
	createDirectory(outputDirectory, "");
	while (e.hasMoreElements()) {
	zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
	// System.out.println("unziping " + zipEntry.getName());
	if (zipEntry.isDirectory()) {
	String name = zipEntry.getName();
	name = name.substring(0, name.length() - 1);
	File f = new File(outputDirectory + File.separator + name);
	f.mkdir();
	System.out.println("����Ŀ¼��" + outputDirectory
	+ File.separator + name);
	} else {
	String fileName = zipEntry.getName();
	fileName = fileName.replace('\\', '/');
	// System.out.println("�����ļ�1��" +fileName);
	if (fileName.indexOf("/") != -1) {
	createDirectory(outputDirectory, fileName.substring(0,
	fileName.lastIndexOf("/")));
	fileName = fileName.substring(
	fileName.lastIndexOf("/") + 1, fileName
	.length());
	}
	File f = new File(outputDirectory + File.separator
	+ zipEntry.getName());
	f.createNewFile();
	InputStream in = zipFile.getInputStream(zipEntry);
	FileOutputStream out = new FileOutputStream(f);
	byte[] by = new byte[1024];
	int c;
	while ((c = in.read(by)) != -1) {
	out.write(by, 0, c);
	}
	out.close();
	in.close();
	}
	flag = true;
	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return flag;
	}
	/**
	* ����Ŀ¼
	* 
	* @param directory
	* ��Ŀ¼
	* @param subDirectory
	* ��Ŀ¼
	*/
	private static void createDirectory(String directory, String subDirectory) {
	String dir[];
	File fl = new File(directory);
	try {
	if (subDirectory == "" && fl.exists() != true)
	fl.mkdir();
	else if (subDirectory != "") {
	dir = subDirectory.replace('\\', '/').split("/");
	for (int i = 0; i < dir.length; i++) {
	File subFile = new File(directory + File.separator + dir[i]);
	if (subFile.exists() == false)
	subFile.mkdir();
	directory += File.separator + dir[i];
	}
	}
	} catch (Exception ex) {
	System.out.println(ex.getMessage());
	}
	}
	// /////////////////////////////////////
	public static void main(String[] temp) {
		String name = "file";
	// ѹ�� fileNames ���ƶ����ļ���ѹ·��ΪbaseDirName���ƶ���·��     ����Ϊ    ����.zip
	String baseDirName = "d:\\file\\";
	String[] fileNames = { "��.sql", "qq.sql" };
	String zipFileName = "d:\\file\\����.zip";//ѹ�����·�������ļ���
	// ѹ�����ָ�����ļ� ��ZIP
	System.out.println(AntZipUtil.zip(baseDirName, fileNames,zipFileName,"GBK"));
	//ѹ��һ���ļ��� ��ZIP    ����ǰ��sourcePath �ƶ���·�����ļ���ѹ��������ļ�����         ����Ϊ   ����2.zip
	String sourcePath = "d:\\"+name+"\\";
	String zipFilePath = "d:\\"+name+"\\"+name+".zip";
	AntZipUtil.zip(sourcePath, zipFilePath);
	//��ѹ��
	System.out.println(AntZipUtil.unZip("d:\\file\\����.zip", "d:\\aaa"));
	}
	}
