package com.houyuli.common.utils;

public enum FileSizeEnum {
	BYTE(1, "BYTE"), KB(1024, "KB"), MB(1024 * 1024, "MB"), GB(1024 * 1024 * 1024, "GB"),
	TB(1024 * 1024 * 1024 * 1024, "TB"), PB(1024 * 1024 * 1024 * 1024 * 1024, "PB");

	private Integer code;
	private String name;

	FileSizeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
