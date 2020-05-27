package com.houyuli.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class StreamUtilTest {

	@Test
	void testClosings() {
		fail("Not yet implemented");
	}

	@Test
	void testAsString() {
		try {
			String asString = StreamUtil.asString(new FileInputStream(new File("C:/Users/King/Desktop/1.txt")), false);
			System.out.println(asString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testReadingLineFormTextFileFile() {
		String list = StreamUtil.readTextFile(new File("C:/Users/King/Desktop/1.txt"));
		System.out.println(list);
	}

	@Test
	void testReadingLineFormTextFileInputStream() {
		fail("Not yet implemented");
	}

}
