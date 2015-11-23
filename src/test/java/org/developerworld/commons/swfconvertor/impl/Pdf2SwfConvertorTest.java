package org.developerworld.commons.swfconvertor.impl;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.developerworld.commons.swfconvertor.SwfConvertor;
import org.junit.Assert;
import org.junit.Test;

public class Pdf2SwfConvertorTest {

	//@Test
	public void testConver2swf() {
		URL origFileUrl = this.getClass().getClassLoader().getResource("pdf.pdf");
		final File origFile = new File(origFileUrl.getPath());
		File destFile = new File(origFile.getParent() + File.separator
				+ FilenameUtils.getBaseName(origFile.getName()) + ".swf");
		SwfConvertor convertor = buildConvertor();
		convertor.conver2swf(origFile, destFile);
		Assert.assertTrue(true);
	}

	private SwfConvertor buildConvertor() {
		Pdf2SwfConvertor rst = new Pdf2SwfConvertor();
		rst.setSwfToolsHome("D:\\Program Files (x86)\\SWFTools");
		return rst;
	}
}
