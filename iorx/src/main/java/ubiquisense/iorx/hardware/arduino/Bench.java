package ubiquisense.iorx.hardware.arduino;

import java.util.List;

public interface Bench {


	List<Arduino> getBoards();

	String getName();

	void setName(String value);

} // Bench
