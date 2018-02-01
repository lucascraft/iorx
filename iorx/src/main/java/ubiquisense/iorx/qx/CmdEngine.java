package ubiquisense.iorx.qx;

import java.util.List;

public interface CmdEngine {
	List<CmdPipe> getEngines();

	String getId();

	void setId(String newId);

	String getName();

	void setName(String newName);

	Object getRunner();

	void setRunner(Object newRunner);

	void start();

	void stop();

	void quicken();

	void slow();

	void activate();

	void deactivate();

	EngineApplication getApplication();

	void setApplication(EngineApplication value);

}
