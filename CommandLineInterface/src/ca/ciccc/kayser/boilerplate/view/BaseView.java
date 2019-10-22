package ca.ciccc.kayser.boilerplate.view;

import ca.ciccc.kayser.boilerplate.controller.BaseController;
import ca.ciccc.kayser.boilerplate.model.BaseModel;

public class BaseView {
	
	BaseModel model;
	
	BaseController controller;
	
	public void setModel(BaseModel aModel) {
		this.model = aModel;
	}
	
	public void setController(BaseController aController) {
		this.controller = aController;
	}

}
