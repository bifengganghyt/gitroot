package cn.itcast.c_di;
import java.util.List;
import java.util.Map;
import java.util.Properties;
public class User {
	private int id;
	private String name;
	// list集合
	private List<String> list;
	// Map集合
	private Map<String,Object> map;
	// Properties 对象
	private Properties prop;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", list=" + list + ", map=" + map + ", name="
				+ name + ", prop=" + prop + "]";
	}
}






