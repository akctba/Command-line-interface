package ca.ciccc.kayser.boilerplate.model;

import ca.ciccc.kayser.boilerplate.controller.BaseController;
import ca.ciccc.kayser.boilerplate.view.BaseView;

public class BaseModel {
	
	BaseController controller;
	BaseView view;
	
	public void setController(BaseController aController) {
		this.controller = aController;
	}
	
	public void setView(BaseView aView) {
		this.view = aView;
	}
	
	//setController
	//setView

}
