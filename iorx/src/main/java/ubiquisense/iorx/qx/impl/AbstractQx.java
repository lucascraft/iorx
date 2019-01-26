package ubiquisense.iorx.qx.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

import rx.Observable;
import rx.functions.Action1;
import ubiquisense.iorx.changes.Add;
import ubiquisense.iorx.changes.AddMany;
import ubiquisense.iorx.changes.Remove;
import ubiquisense.iorx.changes.RemoveMany;
import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.io.Port;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.QxProcessingStrategy;

public class AbstractQx implements Qx {

	List<Cmd> commands;
	boolean deliver;
	QxProcessingStrategy strategy;
	AbstractQx Instance;
	@Inject
	CmdPipe pipe;

	Port port;

	long ttl;
	int max;

	@Inject
	public AbstractQx() {
		deliver = true;
		Instance = this;
		strategy = QxProcessingStrategy.NEWEST_MOST_URGENT;
		max = 32;
		ttl = 10;
		commands = new ArrayList<Cmd>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(Cmd arg0) {
				Observable.just(arg0).subscribe(new Action1<Cmd>() {
					@Override
					public void call(Cmd s) {
						s.setQx(Instance);
						pipe.eAdapters().forEach(a -> a.notifyChanged(new Add<Cmd>((Cmd) arg0)));
					}
				});
				return super.add(arg0);
			}

			@Override
			public boolean remove(Object arg0) {
				Observable.just(arg0).subscribe(new Action1<Object>() {
					@Override
					public void call(Object s) {
						((Cmd) arg0).setQx(Instance);
						pipe.eAdapters().forEach(a -> a.notifyChanged(new Remove<Cmd>((Cmd) arg0)));
					}
				});
				return super.remove(arg0);
			}

			@Override
			public boolean addAll(Collection<? extends Cmd> arg0) {
				Observable.just(arg0).subscribe(new Action1<Collection<? extends Cmd>>() {
					@Override
					public void call(Collection<? extends Cmd> s) {
						List<Cmd> cmds = Lists.newArrayList(arg0);
						cmds.stream().forEach(q -> q.setQx(Instance));
						pipe.eAdapters().forEach(a -> a.notifyManyChanged(new AddMany<Cmd>(cmds)));
					}
				});
				return super.addAll(arg0);
			}

			@Override
			public boolean removeAll(Collection<?> arg0) {
				Observable.just(arg0).subscribe(new Action1<Collection<?>>() {
					@Override
					public void call(Collection<?> s) {
						List<Cmd> cmds = (List<Cmd>) Lists.newArrayList(arg0);
						cmds.stream().forEach(q -> q.setQx(Instance));
						pipe.eAdapters().forEach(a -> a
								.notifyManyChanged(new RemoveMany<Cmd>(Lists.newArrayList((Collection<Cmd>) arg0))));
					}
				});
				return super.removeAll(arg0);
			}
		};
	}

	@Override
	public List<Cmd> getCommands() {
		return commands;
	}

	@Override
	public CmdPipe getEngine() {
		return pipe;
	}

	@Override
	public void eSetDeliver(boolean value) {
		deliver = value;
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public long getTtl() {
		return ttl;
	}

	@Override
	public QxProcessingStrategy getStrategy() {
		return QxProcessingStrategy.NEWEST_MOST_URGENT;
	}

	@Override
	public void setStrategy(QxProcessingStrategy value) {
		strategy = value;
	}

	@Override
	public void setMax(int value) {
		max = value;
	}

	@Override
	public void setTtl(int value) {
		ttl = value;
	}

	@Override
	public void postCommand(Cmd cmd) {
		synchronized(commands)
		{
			commands.add(cmd);
		}
	}

	@Override
	public Cmd consumeCommand() {
		synchronized(commands)
		{
			return commands.remove(commands.size()-1);
		}
	}
}
