package org.lxy.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author menglanyingfei
 * @date 2017-3-17
 */
public class TagDemo2 extends SimpleTagSupport {

	private PageContext pc;

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = getJspBody();
		jf.invoke(pc.getOut());
//		jf.invoke(null);
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext) pc;
	}
	
}



















