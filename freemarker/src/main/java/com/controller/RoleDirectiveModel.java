package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import freemarker.core.Environment;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;
@Service
public class RoleDirectiveModel implements TemplateDirectiveModel {
/**
 * env:环境变量
 * params:指令参数(储存你所需要的值，随便是什么Key-Value你懂的)
 * loopVars:循环变量
 * body:指令内容
 * 除了params外，其他的都能使null。
 */
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		System.out.println("==========");
		
		TemplateScalarModel user=(TemplateScalarModel)params.get("user");
		TemplateScalarModel role=(TemplateScalarModel)params.get("role");
		
		if("123456".equals(user.getAsString())
				&&"admin".equals(role.getAsString())){//用户id
			loopVars[0]=TemplateBooleanModel.TRUE;
		}
		
		List<String> otherRights=new ArrayList<String>();
		otherRights.add("add");
		otherRights.add("delete");
		otherRights.add("update");
		loopVars[1]=new SimpleSequence(otherRights);
		body.render(env.getOut());
				

	}

}
