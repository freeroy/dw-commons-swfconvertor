package org.developerworld.commons.swfconverter.impl;

/**
 * jpeg文件转换swf转换器
 * 
 * @author Roy Huang
 *
 */
public class Jpeg2SwfConverter extends AbstractSwfConverter {

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
	 * 设置宽度
	 * 
	 * @param width
	 */
	public void setXOffset(int xOffset) {
		execCommandArgs.put("-x", xOffset + "");
	}

	/**
	 * 设置高度
	 * 
	 * @param width
	 */
	public void setYOffset(int yOffset) {
		execCommandArgs.put("-y", yOffset + "");
	}

	/**
	 * 设置是否使用flashMX编译
	 * 
	 * @param mx
	 */
	public void setMx(boolean mx) {
		if (mx)
			execCommandArgs.put("-M", null);
		else
			execCommandArgs.remove("-M");
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
	 * 是否使图片自适应影片大小
	 * @param fitToMovie
	 */
	public void setFitToMovie(boolean fitToMovie) {
		if (fitToMovie)
			execCommandArgs.put("-f", null);
		else
			execCommandArgs.remove("-f");
	}
}
