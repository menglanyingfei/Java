package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author menglanyingfei
 * @date 2017-8-23
 */
public class TestFreeMarker {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("F:\\repository\\JavaWeb\\freemarker\\src\\main\\resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		Template ftl = cfg.getTemplate("user.ftl");
		
		Map<String, Object> root = new HashMap<>();
		root.put("name", "lxy");
		root.put("password", "password");
		
		Writer out = new OutputStreamWriter(System.out);
		ftl.process(root, out);
	}

}
