package org.developerworld.commons.swfconverter;

import java.io.File;

/**
 * swf转换器
 * 
 * @author Roy Huang
 *
 */
public interface SwfConverter {

	/**
	 * 转为swf文件
	 * 
	 * @param origFile
	 *            转换来源
	 * @param destFile
	 *            目标输出
	 */
	public void conver2swf(File origFile, File destFile);

	/**
	 * 转为swf文件
	 * 
	 * @param origFilePath
	 *            转换来源路径
	 * @param destFilePath
	 *            目标输出路径
	 */
	public void conver2swf(String origFilePath, String destFilePath);
}
