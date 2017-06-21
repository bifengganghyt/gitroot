package gz.itcast.framework.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ���ù�����
 * ��ȡmystruts.xml�ļ�����Ϣ��Ȼ���װ��javabena��
 * @heyutong
 * 2017��6��21��
 */
public class ConfigurationManager {
	//��װActionMapping�ļ���
	private Map<String,ActionMapping> actionMappings;

	public Map<String, ActionMapping> getActionMappings() {
		return actionMappings;
	}

	public ConfigurationManager() {
		//��װ���е�ActionMapping
		actionMappings = new HashMap<String, ActionMapping>();
		this.init();
	}
	
	/**
	 * ʹ��dom4j��ȡmystruts.xml�ļ���Ȼ�����������з�װ 
	 * @heyutong
	 * 2017��6��21��
	 */
	public void init(){
		try {
			//1)ʹ����·����ʽ��ȡmysturs.xml�ļ�
			InputStream in = ConfigurationManager.class.getResourceAsStream("/mystruts.xml");
			
			//2)����SAXREader
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			
			//3����ȡ����action��ǩ
			List<Element> actionList = doc.selectNodes("//action");
			Map<String, ActionMapping> amMap = new HashMap<String,ActionMapping>();
			
			for(Element element : actionList) {
				ActionMapping actionMapping = new ActionMapping();
				//��װActionMapping
				//(������)
				actionMapping.setName(element.attributeValue("name"));
				actionMapping.setClassName(element.attributeValue("class"));
				//mehtod��ѡ
				if(element.attributeValue("method") == null) {
					//Ĭ��ֵ  execute
					actionMapping.setMethod("execute");
				} else {
					actionMapping.setMethod(element.attributeValue("method"));
				}
				
				//��װResult
				List<Element> resultList= element.elements("result");
				HashMap<String, Result> rsMap = new HashMap<String, Result>();
				for(Element rsElem : resultList) {
					Result result = new Result();
					result.setName(rsElem.attributeValue("name"));
					//type��ѡ
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
