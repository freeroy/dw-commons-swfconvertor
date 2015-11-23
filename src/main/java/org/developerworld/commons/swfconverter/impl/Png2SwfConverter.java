package org.developerworld.commons.swfconverter.impl;

/**
 * jpeg文件转换swf转换器
 * 
 * @author Roy Huang
 *
 */
public class Png2SwfConverter extends AbstractSwfConverter {

	protected String getExecCommand() {
		return "jpeg2swf";
	}

	/**
	 * 设置动画毎秒帧速
	 * 
	 * @param rate
	 */
	public void setRate(int rate) {
		execCommandArgs.put("-r", rate + "");
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
	 * 设置转换其中的jpeg图片的质量(从0到100，默认值是85)
	 * 
	 * @param quality
	 */
	public void setJpegQuality(int quality) {
		execCommandArgs.put("-j", quality + "");
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
	 * 设置宽度
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		execCommandArgs.put("-X", width + "");
	}

	/**
	 * 设置高度
	 * 
	 * @param width
	 */
	public void setHeight(int height) {
		execCommandArgs.put("-Y", height + "");
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
	 * 设置是否使用CGI前置http头
	 * 
	 * @param cgi
	 */
	public void setCgi(boolean cgi) {
		if (cgi)
			execCommandArgs.put("-C", null);
		else
			execCommandArgs.remove("-C");
	}

	/**
	 * 设置图片转换比例
	 * 
	 * @param scale
	 */
	public void setScale(int scale) {
		execCommandArgs.put("-s", scale + "");
	}
}
