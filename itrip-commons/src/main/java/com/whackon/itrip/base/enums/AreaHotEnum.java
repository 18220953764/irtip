package com.whackon.itrip.base.enums;

/**
 * 是否是热门城市枚举信息
 */
public enum AreaHotEnum {
	AREA_HOT_YES(1),
	AREA_HOT_NO(2)
	;

	private int code;

	private AreaHotEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
