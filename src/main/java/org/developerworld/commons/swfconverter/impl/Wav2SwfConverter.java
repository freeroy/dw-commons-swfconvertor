package org.developerworld.commons.swfconverter.impl;

/**
 * jpeg文件转换swf转换器
 * 
 * @author Roy Huang
 *
 */
public class Wav2SwfConverter extends AbstractSwfConverter {

	protected String getExecCommand() {
		return "wav2swf";
	}

	/**
	 * 设置帧速
	 * 
	 * @param framerate
	 */
	public void setFramerate(int framerate) {
		execCommandArgs.put("-r", framerate + "");
	}

	/**
	 * 设置采样精度
	 * 
	 * @param samplerate
	 */
	public void setSamplerate(int samplerate) {
		execCommandArgs.put("-s", samplerate + "");
	}

	/**
	 * 设置是否在声音流中生成defineSound
	 * 
	 * @param defineSound
	 */
	public void setDefineSound(boolean defineSound) {
		if (defineSound)
			execCommandArgs.put("-d", null);
		else
			execCommandArgs.remove("-d");
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
	 * 在第0帧停止
	 * 
	 * @param stop
	 */
	public void setStop(boolean stop) {
		if (stop)
			execCommandArgs.put("-S", null);
		else
			execCommandArgs.remove("-S");
	}

	/**
	 * 是否在最后帧停止
	 * 
	 * @param end
	 */
	public void setEnd(boolean end) {
		if (end)
			execCommandArgs.put("-E", null);
		else
			execCommandArgs.remove("-E");
	}

	/**
	 * 设置MP3的bps（默认32）
	 * 
	 * @param bitRate
	 */
	public void setBitRate(int bitRate) {
		execCommandArgs.put("-b", bitRate + "");
	}
}
