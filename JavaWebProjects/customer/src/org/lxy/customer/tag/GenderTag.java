package org.lxy.customer.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author menglanyingfei
 * @date 2017-5-12
 */
public class GenderTag extends SimpleTagSupport {
	
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		StringBuffer buff = new StringBuffer();
		
		if ("男".equals(gender)) {
			buff.append("<input type='radio' name='gender' value='男' checked='checked'>男<input type='radio' name='gender' value='女'>女");
		} else {
			buff.append("<input type='radio' name='gender' value='男'>男<input type='radio' name='gender' value='女' checked='checked'>女");
		}
		
		this.getJspContext().getOut().write(buff.toString());
	}
}











