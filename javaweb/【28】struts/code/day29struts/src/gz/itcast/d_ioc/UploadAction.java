package gz.itcast.d_ioc;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 模拟文件上传
 * @author APPle
 *
 */
public class UploadAction extends ActionSupport{
	//1）在action中提供一个属性
	private String savePath;
	//2)提供属性的setter方法，用于外部的action的参数进行注入
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	//文件上传的方法
	public String upload()throws Exception{
		//1)已经获取了用户的文件
		File file  = new File("e:/2.jpg");
		System.out.println(savePath);
		//2)把文件保存服务器硬盘
		//这样做把服务器保存的地址硬编码
		FileUtils.copyFile(file, new File(savePath+file.getName()));
		
		return SUCCESS;
	}
	
}
