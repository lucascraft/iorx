package ubiquisense.iorx.cmd.impl;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CompoundCmd;

public class CompoundCmdImpl extends CmdImpl implements CompoundCmd {
	LinkedList<Cmd> children;
	
	@Inject
	public CompoundCmdImpl() {
		children = new LinkedList<>();
	}
	
	@Override
	public List<Cmd> getChildren() {
		return children;
	}

	@Override
	public void add(Cmd cmd) {
		children.add(cmd);
	}

	@Override
	public void add(int index, Cmd cmd) {
		children.add(index, cmd);
	}

	@Override
	public void queue(Cmd cmd) {
		children.addLast(cmd);
	}

	@Override
	public void pop() {
		children.pop();
	}

	@Override
	public void remove(int index) {
		children.remove(index);
	}

	@Override
	public void remove(Cmd cmd) {
		children.remove(cmd);
	}

	@Override
	public void drop() {
		children.peek();
	}

}
