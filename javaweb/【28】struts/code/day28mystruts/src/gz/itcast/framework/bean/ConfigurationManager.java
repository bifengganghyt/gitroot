package gz.itcast.framework.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 配置管理类
 * 读取mystruts.xml文件的信息，然后封装到javabena中
 * @heyutong
 * 2017年6月21日
 */
public class ConfigurationManager {
	//封装ActionMapping的集合
	private Map<String,ActionMapping> actionMappings;

	public Map<String, ActionMapping> getActionMappings() {
		return actionMappings;
	}

	public ConfigurationManager() {
		//封装所有的ActionMapping
		actionMappings = new HashMap<String, ActionMapping>();
		this.init();
	}
	
	/**
	 * 使用dom4j读取mystruts.xml文件，然后逐个对象进行封装 
	 * @heyutong
	 * 2017年6月21日
	 */
	public void init(){
		try {
			//1)使用类路径方式读取mysturs.xml文件
			InputStream in = ConfigurationManager.class.getResourceAsStream("/mystruts.xml");
			
			//2)创建SAXREader
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			
			//3）读取所有action标签
			List<Element> actionList = doc.selectNodes("//action");
			Map<String, ActionMapping> amMap = new HashMap<String,ActionMapping>();
			
			for(Element element : actionList) {
				ActionMapping actionMapping = new ActionMapping();
				//封装ActionMapping
				//(必须有)
				actionMapping.setName(element.attributeValue("name"));
				actionMapping.setClassName(element.attributeValue("class"));
				//mehtod可选
				if(element.attributeValue("method") == null) {
					//默认值  execute
					actionMapping.setMethod("execute");
				} else {
					actionMapping.setMethod(element.attributeValue("method"));
				}
				
				//封装Result
				List<Element> resultList= element.elements("result");
				HashMap<String, Result> rsMap = new HashMap<String, Result>();
				for(Element rsElem : resultList) {
					Result result = new Result();
					result.setName(rsElem.attributeValue("name"));
					//type可选
					if(rsElem.attributeValue("type") == null) {
						result.setType("dispatcher");
					} else {
						result.setType(rsElem.attributeValue("type"));
					}
					result.setPage(rsElem.getText().trim());
					rsMap.put(result.getName(), result);
				}
				
				actionMapping.setResults(rsMap);
				amMap.put(actionMapping.getName(), actionMapping);
			}
			
			actionMappings = amMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
