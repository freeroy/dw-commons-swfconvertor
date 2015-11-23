package org.developerworld.commons.swfconverter.impl;

/**
 * gif文件转换swf转换器
 * 
 * @author Roy Huang
 *
 */
public class Gif2SwfConverter extends AbstractSwfConverter {

	protected String getExecCommand() {
		return "gif2swf";
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
	 * 设置循环播放次数
	 * 
	 * @param loop
	 */
	public void setLoop(int loop) {
		execCommandArgs.put("-l", loop + "");
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

}
