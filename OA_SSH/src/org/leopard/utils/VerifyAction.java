package org.leopard.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.pept.transport.Selector;

public class VerifyAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	@Override
	public String execute() throws Exception {
//		 ��֤��ͼƬ�Ŀ�ȡ�
		int width = 70;
		// ��֤��ͼƬ�ĸ߶ȡ�
		int height = 36;
		BufferedImage bufferImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bufferImage.createGraphics();

		// ����һ��������������ࡣ
		Random random = new Random();

		// �趨ͼ�񱳾�ɫ(��Ϊ��������������ƫ��)
		g.setColor(getRandColor(180, 250));
		g.fillRect(0, 0, width, height);
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Times New Roman", Font.PLAIN, 28);
		// �������塣
		g.setFont(font);

		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// �������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		g.setColor(Color.GRAY);
		for (int i = 0; i < 50; i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();

		// ����Ĭ������4����֤��
		int length = 4;
		// ���ñ�ѡ��֤��:����"a-z"������"0-9"
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";

		int size = base.length();

		// �������4λ���ֵ���֤�롣
		for (int i = 0; i < length; i++)
		{
			// �õ������������֤�����֡�
			int start = random.nextInt(size);
			String strRand = base.substring(start, start + 1);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			// g.setColor(new Color(red,green,blue));
			// ���������ɫ(��Ϊ����ǰ��������ƫ��)
			g.setColor(getRandColor(1, 100));
			g.drawString(strRand, 13 * i + 6, 28);

			// ���������ĸ�����������һ��
			randomCode.append(strRand);
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = request.getSession();
		session.setAttribute("rand", randomCode.toString());

		// ��ֹͼ�񻺴档
	
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// ��ͼ�������Servlet������С�
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(bufferImage, "jpeg", sos);
		//sos.close();
	//	request.setAttribute("buffimg",buffImg);
		return null;
	
	}

	
	Color getRandColor(int fc, int bc)
	{// ������Χ��������ɫ
		Random random = new Random();
		if (fc > 255) fc = 255;
		if (bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public void setServletResponse(HttpServletResponse response) {
			this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
