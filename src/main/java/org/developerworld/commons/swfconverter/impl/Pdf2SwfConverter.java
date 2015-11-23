package org.developerworld.commons.swfconverter.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

/**
 * pdf文件转换swf转换器
 * 
 * @author Roy Huang
 *
 */
public class Pdf2SwfConverter extends AbstractSwfConverter {

	protected String getExecCommand() {
		return "pdf2swf";
	}

	/**
	 * 是否使用flash6的zlib压缩机制
	 * 
	 * @param zlib
	 */
	public void setZlib(boolean zlib) {
		if (zlib)
			execCommandArgs.put("-z", null);
		else
			execCommandArgs.remove("-z");
	}

	/**
	 * 是否允许程序修改pdf的绘制顺序（可能会导致结果与原来的有差异）
	 * 
	 * @param ignore
	 */
	public void setIgnore(boolean ignore) {
		if (ignore)
			execCommandArgs.put("-i", null);
		else
			execCommandArgs.remove("-i");
	}

	/**
	 * 设置转换其中的jpeg图片的质量(从0到100，默认值是85)
	 * 
	 * @param quality
	 */
	public void setJpegQuality(int quality) {
		execCommandArgs.put("-j", quality + "");
	}

	/**
	 * 是否设置转换后的swf打开原pdf中的连接时使用相同的窗口
	 * 
	 * @param sameWindow
	 */
	public void setSamewindow(boolean sameWindow) {
		if (sameWindow)
			execCommandArgs.put("-w", null);
		else
			execCommandArgs.remove("-w");
	}

	/**
	 * 是否在每页结尾添加一个stop()命令
	 * 
	 * @param stop
	 */
	public void setStop(boolean stop) {
		if (stop)
			execCommandArgs.put("-t", null);
		else
			execCommandArgs.remove("-t");
	}

	/**
	 * 设置SWF所使用的flash版本号
	 * 
	 * @param flashVersion
	 */
	public void setFlashVersion(int flashVersion) {
		execCommandArgs.put("-T", flashVersion + "");
	}

	/**
	 * 指定字体文件所在路径
	 * 
	 * @param fontDir
	 */
	public void setFontDir(String fontDir) {
		execCommandArgs.put("-F", fontDir);
	}

	/**
	 * 指定默认的swf导航文件，用来翻页、放大缩小等等
	 * 
	 * @param defaultViewer
	 */
	public void setDefaultViewer(String defaultViewer) {
		execCommandArgs.put("-b", defaultViewer);
	}

	/**
	 * 指定默认的swf加载文件，用来显示加载进程效果
	 * 
	 * @param defaultLoader
	 */
	public void setDefaultLoader(String defaultLoader) {
		execCommandArgs.put("-l", defaultLoader);
	}

	/**
	 * 是否不打印普通信息
	 * 
	 * @param quiet
	 */
	public void setQuiet(boolean quiet) {
		if (quiet)
			execCommandArgs.put("-q", null);
		else
			execCommandArgs.remove("-q");
	}

	/**
	 * 是否不打印警告信息
	 * 
	 * @param qquiet
	 */
	public void setQQuiet(boolean qquiet) {
		if (qquiet)
			execCommandArgs.put("-qq", null);
		else
			execCommandArgs.remove("-qq");
	}

	/**
	 * 是否不使用字体，所有都转为形状
	 * 
	 * @param shapes
	 */
	public void setShapes(boolean shapes) {
		if (shapes)
			execCommandArgs.put("-S", null);
		else
			execCommandArgs.remove("-S");
	}

	/**
	 * 是否在swf中保存全部字体
	 * 
	 * @param fonts
	 */
	public void setFonts(boolean fonts) {
		if (fonts)
			execCommandArgs.put("-f", null);
		else
			execCommandArgs.remove("-f");
	}

	/**
	 * 是否在文件中尽量去除影片层，合并它们
	 * 
	 * @param flatten
	 */
	public void setFlatten(boolean flatten) {
		if (flatten)
			execCommandArgs.put("-G", null);
		else
			execCommandArgs.remove("-G");
	}

	/**
	 * 如果运行时间超时则退出(单位：秒)
	 * 
	 * @param maxtime
	 */
	public void setMaxtime(int maxtime) {
		execCommandArgs.put("-Q", maxtime + "");
	}

	/**
	 * 设置SWF转码时候的参数
	 * 
	 * @param specificParameter
	 */
	public void setSpecificParameter(Map<String, String> specificParameter) {
		String s = "";
		Iterator<Entry<String, String>> iterator = specificParameter.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			s += "-s " + entry.getKey();
			if (StringUtils.isNotBlank(entry.getValue()))
				s += "=" + entry.getValue();
		}
		if (s.startsWith("-s "))
			s = s.substring("-s ".length(), s.length());
		execCommandArgs.put("-s", s);
	}

	/**
	 * 指定打开pdf的密码
	 * 
	 * @param password
	 * @return
	 */
	public Pdf2SwfConverter setPassword(String password) {
		execCommandArgs.put("-P", password);
		return this;
	}

	/**
	 * 指定转换的页面范围，使用的页码描述方法与打印机打印文件时候的选页一样
	 * 
	 * @param pages
	 * @return
	 */
	public Pdf2SwfConverter setPages(String pages) {
		execCommandArgs.put("-p", pages);
		return this;
	}

}
