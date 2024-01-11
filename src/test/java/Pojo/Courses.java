package Pojo;

import java.util.List;

public class Courses {
	
	private List<WebAutomation> WebAutomation;
	private List<api> api;
	private List<Mobile> mobile;
	
	public List<Pojo.WebAutomation> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<Pojo.WebAutomation> webAutomation) {
		WebAutomation = webAutomation;
	}
	public List<Pojo.api> getApi() {
		return api;
	}
	public void setApi(List<Pojo.api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	
	

}
