package ubiquisense.iorx.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import ubiquisense.iorx.cmd.Cmd;
import ubiquisense.iorx.cmd.CmdPipe;
import ubiquisense.iorx.cmd.CompoundCmd;
import ubiquisense.iorx.cmd.PRIORITY;
import ubiquisense.iorx.event.Event;
import ubiquisense.iorx.qx.Qx;
import ubiquisense.iorx.qx.QxProcessingStrategy;
import ubiquisense.iorx.qx.Rx;
import ubiquisense.iorx.qx.Tx;

public class EngineUtil {

//	/**
//	 * Create an event given a {@link EVENT_KIND} and its associated {@link Command}
//	 *
//	 * @param kind
//	 *            an event kind (RX_ADDED, RX_REMOVED, TX_ADDED, TX_REMOVED)
//	 * @param command
//	 *            {@link Cmd} command associated to the event it raises
//	 * 
//	 * @return the newly created {@link EVENT_KIND} event
//	 */
//	public Event createEvent(EVENT_KIND kind, Cmd command) {
//		return createEvent(kind, command, null, System.currentTimeMillis());
//	}
//
//	/**
//	 * Create an event given a {@link EVENT_KIND} and its associated {@link Command}
//	 * on a particular {@link Qx} queue
//	 *
//	 * @param kind
//	 *            an event kind (RX_ADDED, RX_REMOVED, TX_ADDED, TX_REMOVED)
//	 * @param command
//	 *            {@link Cmd} command associated to the event it raises
//	 * @param Qx
//	 *            queue the event comes from
//	 * 
//	 * @return the newly created {@link EVENT_KIND} event
//	 */
//	public Event createEvent(EVENT_KIND kind, Cmd command, Qx qx) {
//		return createEvent(kind, command, qx, System.currentTimeMillis());
//	}
//
//	/**
//	 * Create an event given a {@link EVENT_KIND} and its associated {@link Command}
//	 * on a particular {@link Qx} queue
//	 *
//	 * @param kind
//	 *            an event kind (RX_ADDED, RX_REMOVED, TX_ADDED, TX_REMOVED)
//	 * @param command
//	 *            {@link Cmd} command associated to the event it raises
//	 * @param Qx
//	 *            queue the event comes from
//	 * @param time
//	 *            the time stamp giving the moment the event happened
//	 * 
//	 * @return the newly created {@link EVENT_KIND} event
//	 */
//	public Event createEvent(EVENT_KIND kind, Cmd command, Qx qx, long time) {
//		Event evt = new EventImpl();
//		evt.setKind(kind);
//		evt.setCmd(command);
//		evt.setQx(qx);
//		evt.setTime(time);
//		return evt;
//	}

	//
	// Time range
	//

//	/**
//	 * Generically retrieves the events belonging to a given time range expressed as
//	 * a {@link TimeInfo}.
//	 * 
//	 * @param qx
//	 *            a Qx queue from which we want to retrieve the events
//	 * @param a
//	 *            {@link TimeInfo} time range from which bounds we want the events
//	 *            fitting
//	 * 
//	 * @return a list of {@link Event} events corresponding to to the given time
//	 *         range and queue
//	 */
//	public <T extends Qx> List<Event> getEventsFromTimeInfo(Qx qx, TimeInfo timeInfo) {
//		return getEventsWithinGivenTimeRange(qx, timeInfo.getStart(),
//				timeInfo.getStart() + (timeInfo.getDuration() * 1000), true, true,
//				qx instanceof Rx ? new EVENT_KIND[] { EVENT_KIND.RX_DONE, EVENT_KIND.RX_READY }
//						: new EVENT_KIND[] { EVENT_KIND.TX_DONE, EVENT_KIND.TX_READY });
//	}
//
//	/**
//	 * Specifically retrieves the *create* events belonging to a given time range
//	 * expressed as a {@link TimeInfo}.
//	 * 
//	 * @param qx
//	 *            a Qx queue from which we want to retrieve the events
//	 * @param a
//	 *            {@link TimeInfo} time range from which bounds we want the events
//	 *            fitting
//	 * 
//	 * @return a list of *create* {@link Event} events corresponding to to the given
//	 *         time range and queue
//	 */
//	public <T extends Qx> List<Event> getCreateEventsFromTimeInfo(Qx qx, TimeInfo timeInfo) {
//		return getEventsWithinGivenTimeRange(qx, timeInfo.getStart(), timeInfo.getStart() + timeInfo.getDuration(),
//				true, true, qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE);
//	}
//
//	/**
//	 * Specifically retrieves the *delete* events belonging to a given time range
//	 * expressed as a {@link TimeInfo}.
//	 * 
//	 * @param qx
//	 *            a Qx queue from which we want to retrieve the events
//	 * @param a
//	 *            {@link TimeInfo} time range from which bounds we want the events
//	 *            fitting
//	 * 
//	 * @return a list of *delete* {@link Event} events corresponding to to the given
//	 *         time range and queue
//	 */
//	public <T extends Qx> List<Event> getDeleteEventsFromTimeInfo(Qx qx, TimeInfo timeInfo) {
//		return getEventsWithinGivenTimeRange(qx, timeInfo.getStart(), timeInfo.getStart() + timeInfo.getDuration(),
//				true, true, qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE);
//	}
//
//	/**
//	 * Generically retrieves the events belonging to a given time range expressed as
//	 * lower and upper time bounds.
//	 * 
//	 * @param qx
//	 *            a Qx queue from which we want to retrieve the events
//	 * @param timeFrom
//	 *            lower time bound
//	 * @param timeTo
//	 *            upper time bound
//	 * @param lowerInclusive
//	 *            true if lower bound inclusive, false otherwise
//	 * @param upperInclusive
//	 *            true if upper bound inclusive, false otherwise
//	 * @param kindsToRetrieve
//	 *            a collection of kinds to retrieve among (RX_ADDED, RX_REMOVED,
//	 *            TX_ADDED, TX_REMOVED)
//	 * 
//	 * @return a list of {@link Event} events corresponding to to the given time
//	 *         range and queue
//	 */
//	public <T extends Qx> List<Event> getEventsWithinGivenTimeRange(final T qx, long timeFrom, long timeTo,
//			boolean lowerInclusive, boolean upperInclusive, EVENT_KIND... kindsToRetrieve) {
//		assert (timeFrom < timeTo);
//
//		Predicate<Event> predicate = e -> {
//			if (lowerInclusive && upperInclusive) {
//				if (e.getTime() > timeFrom && e.getTime() < timeTo) {
//					return true;
//				}
//			} else if (lowerInclusive && !upperInclusive) {
//				if (e.getTime() >= timeFrom) {
//					return true;
//				}
//			} else if (!lowerInclusive && upperInclusive) {
//				if (e.getTime() <= timeTo) {
//					return true;
//				}
//			} else {
//				if (e.getTime() < timeTo && e.getTime() > timeFrom) {
//					return true;
//				}
//			}
//			return false;
//		};
//
//		return getEvents(qx, kindsToRetrieve).stream().filter(predicate).collect(Collectors.toList());
//	}

	//
	// To a given time
	//

//	// Create
//	/**
//	 * Specifically retrieves the *create* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either Tx or Rx)
//	 * @param time
//	 *            a time until which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getCreateEventsToGivenTime(final T qx, long time) {
//		return getCreateEventsToGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves the *create* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getCreateEventsToGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsToGivenTime(qx, time, inclusive, EVENT_KIND.RX_READY, EVENT_KIND.TX_READY);
//	}
//
//	// Delete
//	/**
//	 * Specifically retrieves the *delete* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getDeleteEventsToGivenTime(final T qx, long time) {
//		return getCreateEventsToGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves the *delete* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getDeleteEventsToGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsToGivenTime(qx, time, inclusive, qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE);
//	}
//
//	// All
//	/**
//	 * Specifically retrieves *all* events that happened from the very beginning to
//	 * a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsToGivenTime(final T qx, long time) {
//		return getEventsToGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves *all* events that happened from the very beginning to
//	 * a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsToGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsToGivenTime(qx, time, inclusive,
//				qx instanceof Rx ? new EVENT_KIND[] { EVENT_KIND.RX_DONE, EVENT_KIND.RX_READY }
//						: new EVENT_KIND[] { EVENT_KIND.TX_DONE, EVENT_KIND.TX_READY });
//	}
//
//	/**
//	 * Specifically retrieves the *create* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time until which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * @param kindsToRetrieve
//	 *            a collection of kinds to retrieve among (RX_ADDED, RX_REMOVED,
//	 *            TX_ADDED, TX_REMOVED)
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsToGivenTime(final T qx, long time, boolean inclusive,
//			EVENT_KIND... kindsToRetrieve) {
//		return getEventsWithinGivenTimeRange(qx, Long.MIN_VALUE, time, true, inclusive, kindsToRetrieve);
//	}
//
//	//
//	// From a given time
//	//
//
//	// Create
//	/**
//	 * Specifically retrieves the *create* events that happened from the very
//	 * beginning to a given time (inclusive).
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getCreateEventsFromGivenTime(final T qx, long time) {
//		return getCreateEventsFromGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves the *create* events that happened from the very
//	 * beginning to a given time.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getCreateEventsFromGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsFromGivenTime(qx, time, inclusive,
//				qx instanceof Rx ? EVENT_KIND.RX_READY : EVENT_KIND.TX_READY);
//	}
//
//	// Delete
//	/**
//	 * Specifically retrieves the *delete* events that happened from a given time
//	 * until now.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getDeleteEventsFromGivenTime(final T qx, long time) {
//		return getCreateEventsFromGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves the *delete* events that happened from a given time
//	 * until now.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getDeleteEventsFromGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsFromGivenTime(qx, time, inclusive, qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE);
//	}
//
//	// All
//	/**
//	 * Specifically retrieves *all* events that happened from a given time until
//	 * now.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsFromGivenTime(final T qx, long time) {
//		return getEventsFromGivenTime(qx, time, true);
//	}
//
//	/**
//	 * Specifically retrieves *all* events that happened from a given time until
//	 * now.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsFromGivenTime(final T qx, long time, boolean inclusive) {
//		return getEventsFromGivenTime(qx, time, inclusive,
//				qx instanceof Rx ? new EVENT_KIND[] { EVENT_KIND.RX_DONE, EVENT_KIND.RX_READY }
//						: new EVENT_KIND[] { EVENT_KIND.TX_DONE, EVENT_KIND.TX_READY });
//	}
//
//	/**
//	 * Specifically retrieves *all* events that happened from a given time until
//	 * now.
//	 * 
//	 * @param qx
//	 *            a given Qx queue (Either {@link Tx} or {@link Rx})
//	 * @param time
//	 *            a time from which the create events happened
//	 * @param true
//	 *            if events should be temporally considered in a inclusive maner,
//	 *            false otherwise
//	 * @param kindsToRetrieve
//	 *            a collection of kinds to retrieve among (RX_ADDED, RX_REMOVED,
//	 *            TX_ADDED, TX_REMOVED)
//	 * 
//	 * @return a list of {@link Event} corresponding to given time and queue
//	 *         parameters
//	 */
//	public <T extends Qx> List<Event> getEventsFromGivenTime(final T qx, long time, boolean inclusive,
//			EVENT_KIND... kindsToRetrieve) {
//		return getEventsWithinGivenTimeRange(qx, time, Long.MAX_VALUE, inclusive, true, kindsToRetrieve);
//	}
//
	//
	// Not Temporal + General
	//

//	/**
//	 * Generically retrieves the events from a given Qx (Either {@link Tx} or
//	 * {@link Rx}).
//	 * 
//	 * @param qx
//	 *            a given Qx queue
//	 * @param kindsToRetrieve
//	 *            {@link EVENT_KIND} events kind(s) to retrieve
//	 * 
//	 * @return a list of compatible {@link Event} corresponding to given parameters,
//	 *         a void list otherwise
//	 */
//	public List<Event> getEvents(final Qx qx, EVENT_KIND... kindsToRetrieve) {
//		List<Event> lst = new ArrayList<Event>();
//		List<EVENT_KIND> kinds = Arrays.asList(kindsToRetrieve);
//
//		boolean txDone = kinds.contains(EVENT_KIND.TX_DONE);
//		boolean txReady = kinds.contains(EVENT_KIND.TX_READY);
//		boolean rxDone = kinds.contains(EVENT_KIND.RX_DONE);
//		boolean rxReady = kinds.contains(EVENT_KIND.RX_READY);
//
//		for (Event evt : ((CmdPipe) qx.getEngine()).getRxEvents()) {
//			if (evt.getQx().equals(qx)) {
//				if (rxDone && ((Event) evt).getKind().equals(EVENT_KIND.RX_DONE)) {
//					lst.add(((Event) evt));
//				} else if (rxReady && ((Event) evt).getKind().equals(EVENT_KIND.RX_READY)) {
//					lst.add(((Event) evt));
//				}
//			}
//		}
//
//		for (Event evt : ((CmdPipe) qx.getEngine()).getTxEvents()) {
//			if (evt.getQx().equals(qx)) {
//				if (txDone && ((Event) evt).getKind().equals(EVENT_KIND.TX_DONE)) {
//					lst.add(((Event) evt));
//				} else if (txReady && ((Event) evt).getKind().equals(EVENT_KIND.TX_READY)) {
//					lst.add(((Event) evt));
//				}
//			}
//		}
//
//		return lst;
//	}
//
//	//
//	// Not temporal + Specific
//	//
//
//	/**
//	 * Generically retrieves all events from a given Qx (Either {@link Tx} or
//	 * {@link Rx}).
//	 * 
//	 * @return a list of all compatible {@link Event} corresponding to given
//	 *         parameters, a void list otherwise
//	 */
//	public List<Event> getAllEvents(final Qx qx) {
//		return getEvents(qx, qx instanceof Rx ? new EVENT_KIND[] { EVENT_KIND.RX_DONE, EVENT_KIND.RX_READY }
//				: new EVENT_KIND[] { EVENT_KIND.TX_DONE, EVENT_KIND.TX_READY });
//	}
//
//	/**
//	 * Generically retrieves *create* events from a given Qx (Either {@link Tx} or
//	 * {@link Rx}).
//	 * 
//	 * @return a list of all compatible {@link Event} corresponding to given
//	 *         parameters, a void list otherwise
//	 */
//	public List<Event> getCreateEvents(final Qx qx) {
//		return getEvents(qx, qx instanceof Rx ? EVENT_KIND.RX_DONE : EVENT_KIND.TX_DONE);
//	}
//
//	/**
//	 * Generically retrieves *delete* events from a given Qx (Either {@link Tx} or
//	 * {@link Rx}).
//	 * 
//	 * @return a list of all compatible {@link Event} corresponding to given
//	 *         parameters, a void list otherwise
//	 */
//	public List<Event> getDeleteEvents(final Qx qx) {
//		return getEvents(qx, qx instanceof Rx ? EVENT_KIND.RX_READY : EVENT_KIND.TX_READY);
//	}

	//
	// ...
	//
	/**
	 * Generically retrieves *Qx* queues from a given {@link CmdPipe} reference.
	 * 
	 * @return a list of all compatible {@link Qx} queues to given parameters, a
	 *         void list otherwise
	 */
	public Set<Qx> getXxQueues(final CmdPipe engine, Class<?> qxSubType) {
		return engine.getQueues().stream().filter(q -> Sets.newHashSet(q.getClass().getInterfaces()).contains(qxSubType)).collect(Collectors.toSet());
	}

	//
	// Rx
	//
	/**
	 * Specifically retrieves *Rx* queues from a given {@link CmdPipe} reference.
	 * 
	 * @return a list of all compatible {@link Rx} queues to given parameters, a
	 *         void list otherwise
	 */
	public Set<Rx> getRxQueues(CmdPipe engine) {
		return Sets.newHashSet(getXxQueues(engine, Rx.class).toArray(new Rx[0]));
	}

	//
	// Tx
	//
	/**
	 * Specifically retrieves *Tx* queues from a given {@link CmdPipe} reference.
	 * 
	 * @return a list of all compatible {@link Tx} queues to given parameters, a
	 *         void list otherwise
	 */
	public Set<Tx> getTxQueues(CmdPipe engine) {
		return Sets.newHashSet(getXxQueues(engine, Tx.class).toArray(new Tx[0]));
	}

	private static QxRunnable<Cmd> qxRunner;

	public static EngineUtil INSTANCE = new EngineUtil();

	/** Constructor */
	public EngineUtil() {
		qxRunner = new QxRunnable<Cmd>();
	}


	class QxRunnable<T extends Cmd> implements Runnable {
		private Qx queue;
		private T cmd;

		public QxRunnable<T> setParameters(Qx q, T c) {
			queue = q;
			cmd = c;
			cmd.setQx(q);
			return this;
		}

		@Override
		public void run() {
			int size = getQueueSize(queue.getCommands());
			if (queue.getMax() < size) {
				if (Platform.inDebugMode()) {
					System.out.println("THRESHOLD " + queue.getMax() + " RAISED !!!");
				}
				int idx = queue.getMax() - queue.getMax() / 4;
				idx = idx > 0 ? idx : 1;
				idx = idx >= queue.getCommands().size() ? queue.getCommands().size() - 1 : idx;
				List<Cmd> lst = queue.getCommands().subList(0, idx);
				queue.eSetDeliver(false);
				queue.getCommands().removeAll(lst);
				queue.eSetDeliver(false);
			}

			cmd.setStamp(System.currentTimeMillis());

			if (queue.getCommands().size() > 1) {
				for (int i = queue.getCommands().size() - 1; i > 0; i--) {
					Cmd c = queue.getCommands().get(i);
					long delay = System.currentTimeMillis() - c.getStamp();
					if (queue.getTtl() < delay) {
						if (Platform.inDebugMode()) {
							System.out
									.println("Cmd FLUSH BECAUSE OF delay over TTL : " + delay + " > " + queue.getTtl());
						}
						queue.eSetDeliver(false);
						int idx = queue.getCommands().indexOf(c);
						queue.getCommands().removeAll(queue.getCommands().subList(0, idx < 1 ? 1 : idx - 1));
						queue.eSetDeliver(true);
						break;
					}
				}
			} else if (!queue.getCommands().isEmpty()) {
				Cmd c = queue.getCommands().get(0);
				long delay = System.currentTimeMillis() - c.getStamp();
				if (queue.getTtl() < delay) {
					if (Platform.inDebugMode()) {
						System.out.println(queue.getClass().getName() + " Cmd FLUSH BECAUSE OF delay over TTL : "
								+ delay + " > " + queue.getTtl());
					}
					queue.eSetDeliver(false);
					queue.getCommands().remove(0);
					queue.eSetDeliver(true);
				}
			}

			queue.getCommands().add(cmd);

			if (Platform.inDebugMode()) {
				System.out.println(queue.getClass().getName() + " Cmd queue size : " + size);
			}
		}
	}

	/**
	 * Send a Command to a given {@link Qx} queue.
	 * 
	 * @param <T>
	 *            a Cmd subclass
	 * @param queue
	 *            a given {@link Qx} queue
	 * @param cmd
	 *            a {@link Cmd} to send to a {@link Qx} queue
	 * 
	 * @return the {@link Cmd} sent
	 */
	public synchronized <T extends Cmd> T sendCmd(final Qx queue, final T cmd) {
		if (queue != null && cmd != null) {
			try {
				new Thread(qxRunner.setParameters(queue, cmd)).run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cmd;
	}

	 /**
	 * Send a randomly created {@link Cmd} to the given queue
	 *
	 * @param queue a given Qx queue to send the randomly created {@link Cmd}
	 *
	 * @return the randomly created {@link Cmd}
	 */
	 public Cmd sendRandomCmd(Qx queue) {
		 return sendCmd(queue, CmdUtil.INSTANCE.generateRamdomCmd());
	 }

	//
	//
	// Very likely to be Safe ... isn't it ?
	//
	/**
	 * Get the highest {@link PRIORITY} level from all existing {@link Cmd} list
	 * from a given {@link Qx} queue
	 * 
	 * @param tx
	 *            a given Qx queue to send the randomly created {@link Cmd}
	 * 
	 * @return the highest {@link PRIORITY} level from all existing {@link Cmd} list
	 */
	public PRIORITY getHighestPriorityCmdFromQueue(final Qx qx) {
		PRIORITY priority = PRIORITY.LOWEST;
		try {
			RunnableWithResult<PRIORITY> r = new RunnableWithResult.Impl<PRIORITY>() {
				public void run() {
					PRIORITY priority = PRIORITY.LOWEST;
					for (Cmd c : qx.getCommands()) {
						if (c != null && c.getPriority() != null &&  c.getPriority().compareTo(priority) > 0) {
							priority = c.getPriority();
						}
					}
					setResult(priority);
				}
			};
			new Thread(r).run();
			priority = r.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priority;
	}

	/**
	 * Get the oldest {@link Cmd} command with most urgent {@link PRIORITY} level
	 * from all existing {@link Cmd} list from a given {@link Qx} queue
	 * 
	 * @param tx
	 *            a given Qx queue to send the randomly created {@link Cmd}
	 * 
	 * @return the oldest {@link Cmd} command with most urgent {@link PRIORITY}
	 *         level
	 */
	public Cmd consumeOldestMostUrgentCmd(final Qx qx) {
		Cmd cmd = null;
		try {
			RunnableWithResult<Cmd> r = new RunnableWithResult.Impl<Cmd>() {
				public void run() {
					PRIORITY priority = getHighestPriorityCmdFromQueue(qx);
					for (Cmd c : qx.getCommands()) {
						if (c.getPriority().equals(priority)) {
							setResult(c);
							break;
						}
					}
					qx.getCommands().remove(getResult());
				}
			};
			new Thread(r).run();
			cmd = r.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}

	/**
	 * Get the oldest {@link Cmd} command with most urgent {@link PRIORITY} level
	 * from all existing {@link Cmd} list from a given {@link Qx} queue
	 *
	 * @param tx
	 *            a given Qx queue to send the randomly created {@link Cmd}
	 *
	 * @return the oldest {@link Cmd} command with most urgent {@link PRIORITY}
	 *         level
	 */
	public Cmd consumeNewestMostUrgentCmd(final Qx qx) {
		Cmd cmd = null;
		try {
			RunnableWithResult<Cmd> r = new RunnableWithResult.Impl<Cmd>() {
				public void run() {
					PRIORITY priority = getHighestPriorityCmdFromQueue(qx);
					for (Cmd c : qx.getCommands()) {
						if (c.getPriority().equals(priority)) {
							setResult(c);
							break;
						}
					}
					qx.getCommands().clear();
				}
			};
			new Thread(r).run();
			cmd = r.getResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}

	public int getEventQueueSize(Event e) {
		return !(e.getCmd() instanceof CompoundCmd) ? 1 : getEventQueueSize(Arrays.asList(new Event[] { e }));
	}

	public int getEventQueueSize(List<Event> lst) {
		int ret = lst.size();
		for (Event e : lst) {
			if (e.getCmd() instanceof CompoundCmd) {
				ret += getQueueSize(((CompoundCmd) e.getCmd()).getChildren());
			}
		}
		return ret;
	}

	public int getQueueSize(Cmd cmd) {
		if (cmd instanceof CompoundCmd) {
			return getQueueSize(((CompoundCmd) cmd).getChildren());
		}
		return 1;
	}

	public int getQueueSize(List<Cmd> lst) {
		int ret = lst.size();
		for (Cmd c : lst) {
			if (c instanceof CompoundCmd) {
				ret += getQueueSize(((CompoundCmd) c).getChildren());
			}
		}
		return ret;
	}

	/**
	 * Get the oldest {@link Cmd} command with most urgent {@link PRIORITY} level
	 * from all existing {@link Cmd} list from a given {@link Qx} queue
	 *
	 * @param tx
	 *            a given Qx queue to send the randomly created {@link Cmd}
	 *
	 * @return the oldest {@link Cmd} command with most urgent {@link PRIORITY}
	 *         level
	 */
	public Cmd consumeNewestAndFlushCmd(final Qx qx) {
		try {
			RunnableWithResult.Impl<Cmd> r = new RunnableWithResult.Impl<Cmd>() {
				public void run() {
					int size = getQueueSize(qx.getCommands());
					if (size > 0) {
						if (qx.getMax() < size) {
							if (Platform.inDebugMode()) {
								System.out.println(
										"THRESHOLD " + qx.getClass().getName() + " of " + qx.getMax() + " RAISED !!!");
							}
							int idx = qx.getMax() - qx.getMax() / 4;
							idx = idx > 0 ? idx : 1;
							idx = idx >= qx.getCommands().size() ? qx.getCommands().size() - 1 : idx;
							List<Cmd> lst = qx.getCommands().subList(0, idx);
							qx.eSetDeliver(false);
							qx.getCommands().removeAll(lst);
							qx.eSetDeliver(true);
						}

						if (size > 1) {
							for (int i = qx.getCommands().size() - 1; i > 0; i--) {
								Cmd c = qx.getCommands().get(i);
								long delay = System.currentTimeMillis() - c.getStamp();
								if (qx.getTtl() < delay) {
									if (Platform.inDebugMode()) {
										System.out.println(
												qx.getClass().getName() + " Cmd FLUSH BECAUSE OF delay over TTL : "
														+ delay + " > " + qx.getTtl());
									}
									qx.eSetDeliver(false);
									int idx = qx.getCommands().indexOf(c);
									qx.getCommands().removeAll(qx.getCommands().subList(0, idx < 1 ? 1 : idx - 1));
									qx.eSetDeliver(true);
									break;
								}
							}
						} else if (!qx.getCommands().isEmpty()) {
							Cmd c = qx.getCommands().get(0);

							long delay = System.currentTimeMillis() - c.getStamp();
							if (qx.getTtl() < delay) {
								if (Platform.inDebugMode()) {
									System.out.println(qx.getClass().getName()
											+ " Cmd FLUSH BECAUSE OF delay over TTL : " + delay + " > " + qx.getTtl());
								}
								qx.eSetDeliver(false);
								qx.getCommands().remove(0);
								qx.eSetDeliver(true);
							}
						}

						if (Platform.inDebugMode()) {
							System.out.println(qx.getClass().getName() + " Cmd queue size : " + size);
						}

						if (!qx.getCommands().isEmpty()) {
							qx.eSetDeliver(false);
							setResult(qx.getCommands().remove(0));
							qx.eSetDeliver(true);
						}
					}
				}
			};
			new Thread(r).run();
			return r.getResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Consumes the oldest {@link Cmd} command with most urgent {@link PRIORITY}
	 * level from all existing {@link Cmd} list from a given {@link Qx} queue
	 *
	 * @param qx
	 *            a given Qx queue to send the randomly created {@link Cmd}
	 * @param strategy
	 *            a given {@link QxProcessingStrategy} queue to choose a behavior
	 *            for {@link Cmd} consumption
	 *
	 * @return the oldest {@link Cmd} command with most urgent {@link PRIORITY}
	 *         level consumed
	 */
	public Cmd consumeCmd(Qx qx) {
		switch (qx.getStrategy()) {
		case OLDEST_MOST_URGENT:
			return consumeOldestMostUrgentCmd(qx);
		case PICK_NFLUSH:
		case NEWEST_MOST_URGENT:
			return consumeNewestMostUrgentCmd(qx);
		case PREDICATE:
		case ROUND_ROBIN:
		case TIME_RANGE_EXCLUSIVE:
		case TIME_RANGE_INCLUSIVE:
		default:
			return consumeNewestAndFlushCmd(qx);
		// return consumeOldestMostUrgentCmd(qx);
		}
	}

}