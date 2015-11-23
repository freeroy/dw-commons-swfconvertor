package org.developerworld.commons.swfconvertor.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.developerworld.commons.swfconvertor.SwfConvertor;
import org.developerworld.commons.swfconvertor.utils.Utils;

/**
 * 抽象swf转换器
 * 
 * @author Roy Huang
 *
 */
public abstract class AbstractSwfConvertor implements SwfConvertor {

	private final static Log LOG = LogFactory.getLog(AbstractSwfConvertor.class);

	private String swfToolsHome;

	private boolean log = false;

	protected Map<String, String> execCommandArgs = new LinkedHashMap<String, String>();

	public void setSwfToolsHome(String swfToolsHome) {
		this.swfToolsHome = swfToolsHome;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	/**
	 * 是否输出详细详细的转换内容
	 * 
	 * @param verbose
	 */
	public void setVerbose(boolean verbose) {
		if (verbose)
			execCommandArgs.put("-v", null);
		else
			execCommandArgs.remove("-v");
	}

	public void conver2swf(File origFile, File destFile) {
		conver2swf(origFile, destFile, null);
	}

	public void conver2swf(File origFile, File destFile, String execCommandArgs) {
		conver2swf(origFile.getPath(), destFile.getPath(), execCommandArgs);
	}

	public void conver2swf(String origFilePath, String destFilePath) {
		conver2swf(origFilePath, destFilePath);
	}

	public void conver2swf(String origFilePath, String destFilePath, String execCommonsArgs) {
		try {
			Utils.checkFileArgs(origFilePath, destFilePath);
			int rst = -1;
			// 判断操作系统类型
			// window
			if (SystemUtils.IS_OS_WINDOWS)
				rst = converInWindow(origFilePath, destFilePath, execCommonsArgs);
			// unix类系统
			else if (SystemUtils.IS_OS_UNIX)
				rst = converInUnix(origFilePath, destFilePath, execCommonsArgs);
			else
				throw new RuntimeException("the os system is not support!");
			if (log)
				LOG.info("finish conver,the exitvalue is:" + rst);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * window环境转换
	 * 
	 * @param origFilePath
	 * @param destFilePath
	 * @param execCommandArgs
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private int converInWindow(String origFilePath, String destFilePath, String execCommandArgs)
			throws IOException, InterruptedException {
		String command = getExecCommand() + ".exe " + origFilePath + " -o " + destFilePath + " " + getExecCommandStr();
		if (StringUtils.isNotBlank(swfToolsHome))
			command = swfToolsHome + File.separator + command;
		if (log)
			LOG.info("run command:" + command);
		Process pro = Runtime.getRuntime().exec(command);
		BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String console = null;
		while ((console = br.readLine()) != null) {
			if (log)
				LOG.info(console);
		}
		// 用于等待程序执行完毕
		pro.waitFor();
		// 结束进程
		return pro.exitValue();
	}

	/**
	 * linux环境
	 * 
	 * @param origFilePath
	 * @param destFilePath
	 * @param execCommonsArgs
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private int converInUnix(String origFilePath, String destFilePath, String execCommonsArgs)
			throws IOException, InterruptedException {
		String command = getExecCommand() + origFilePath + " -o " + destFilePath + " " + getExecCommandStr();
		if (StringUtils.isNotBlank(swfToolsHome))
			command = swfToolsHome + File.separator + command;
		if (log)
			LOG.info("run command:" + command);
		Process pro = Runtime.getRuntime().exec(command);
		BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String console = null;
		while ((console = br.readLine()) != null) {
			if (log)
				LOG.info(console);
		}
		// 用于等待程序执行完毕
		pro.waitFor();
		// 结束进程
		return pro.exitValue();
	}

	/**
	 * 获取命令行参数字符串
	 * 
	 * @return
	 */
	private String getExecCommandStr() {
		String rst = "";
		Iterator<Entry<String, String>> iterator = execCommandArgs.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			rst += entry.getKey() + " ";
			if (StringUtils.isNotBlank(entry.getValue()))
				rst += entry.getValue() + " ";
		}
		return rst;
	}

	/**
	 * 获取执行命令名
	 * 
	 * @return
	 */
	protected abstract String getExecCommand();
}
