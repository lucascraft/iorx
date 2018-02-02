package ubiquisense.iorx.utils;

import com.google.inject.Inject;

import ubiquisense.iorx.qx.EngineApplication;

public class Orchestror 
{
	@Inject 
	EngineApplication applicationEngine;
	
	public void setApplication(EngineApplication value)
	{
		applicationEngine = value;
	}
	
	public EngineApplication getApplication()
	{
		return applicationEngine;
	}
}
