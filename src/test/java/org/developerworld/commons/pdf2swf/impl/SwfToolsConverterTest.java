package org.developerworld.commons.pdf2swf.impl;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.developerworld.commons.swfconverter.SwfConverter;
import org.developerworld.commons.swfconverter.impl.Pdf2SwfConverter;
import org.junit.Assert;
import org.junit.Test;

public class SwfToolsConverterTest {

	//@Test
	public void testConver2swf() {
		URL origFileUrl = this.getClass().getClassLoader().getResource("pdf.pdf");
		final File origFile = new File(origFileUrl.getPath());
		File destFile = new File(origFile.getParent() + File.separator
				+ FilenameUtils.getBaseName(origFile.getName()) + ".swf");
		SwfConverter converter = buildConverter();
		converter.conver2swf(origFile, destFile);
		Assert.assertTrue(true);
	}

	private SwfConverter buildConverter() {
		Pdf2SwfConverter rst = new Pdf2SwfConverter();
		rst.setSwfToolsHome("D:\\Program Files (x86)\\SWFTools");
		return rst;
	}
}
