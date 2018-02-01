package ubiquisense.iorx.qx;

import java.util.List;

public interface CompoundCmd extends Cmd {
	List<Cmd> getChildren();
	void add(Cmd cmd);
	void add(int index, Cmd cmd);
	void queue(Cmd cmd);
	void pop();
	void remove(int index);
	void remove(Cmd cmd);
	void drop();

}
