package com.beans;

import javax.xml.bind.annotation.XmlElement;

public class QueryParam {
	@Override
	public String toString() {
		return "QueryParam [param1=" + param1 + ", param2=" + param2
				+ ", param3=" + param3 + ", param4=" + param4 + ", param5="
				+ param5 + ", param6=" + param6 + ", param7=" + param7
				+ ", param8=" + param8 + ", param9=" + param9 + ", param10="
				+ param10 + "]";
	}

	String param1;
	String param2;
	String param3;
	String param4;
	String param5;
	String param6;
	String param7;
	String param8;
	String param9;
	String param10;

	public String getParam1() {
		return param1;
	}

	@XmlElement
	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	@XmlElement
	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	@XmlElement
	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	@XmlElement
	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	@XmlElement
	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam6() {
		return param6;
	}

	@XmlElement
	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getParam7() {
		return param7;
	}

	@XmlElement
	public void setParam7(String param7) {
		this.param7 = param7;
	}

	public String getParam8() {
		return param8;
	}

	@XmlElement
	public void setParam8(String param8) {
		this.param8 = param8;
	}

	public String getParam9() {
		return param9;
	}

	@XmlElement
	public void setParam9(String param9) {
		this.param9 = param9;
	}

	public String getParam10() {
		return param10;
	}

	@XmlElement
	public void setParam10(String param10) {
		this.param10 = param10;
	}
}
