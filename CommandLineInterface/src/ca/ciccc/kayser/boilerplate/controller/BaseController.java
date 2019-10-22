package ca.ciccc.kayser.boilerplate.controller;

import ca.ciccc.kayser.boilerplate.model.BaseModel;
import ca.ciccc.kayser.boilerplate.view.BaseView;

public abstract class BaseController {
	
	BaseModel model;
	BaseView view;
	
	public void setModel(BaseModel aModel) {
		this.model = aModel;
	}
	
	public void setView(BaseView aView) {
		this.view = aView;
	}

}
