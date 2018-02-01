package ubiquisense.iorx.qx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum QxProcessingStrategy  {
	OLDEST_MOST_URGENT(0, "OLDEST_MOST_URGENT", "OLDEST_MOST_URGENT"),
	NEWEST_MOST_URGENT(1, "NEWEST_MOST_URGENT", "NEWEST_MOST_URGENT"),
	ROUND_ROBIN(2, "ROUND_ROBIN", "ROUND_ROBIN"),
	PREDICATE(3, "PREDICATE", "PREDICATE"),
	TIME_RANGE_EXCLUSIVE(4, "TIME_RANGE_EXCLUSIVE", "TIME_RANGE_EXCLUSIVE"),
	TIME_RANGE_INCLUSIVE(5, "TIME_RANGE_INCLUSIVE", "TIME_RANGE_INCLUSIVE"), 
	PICK_NFLUSH(6, "PICK_N_FLUSH", "PICK_N_FLUSH");

	public static final int OLDEST_MOST_URGENT_VALUE = 0;

	public static final int NEWEST_MOST_URGENT_VALUE = 1;

	public static final int ROUND_ROBIN_VALUE = 2;

	public static final int PREDICATE_VALUE = 3;

	public static final int TIME_RANGE_EXCLUSIVE_VALUE = 4;

	public static final int TIME_RANGE_INCLUSIVE_VALUE = 5;

	public static final int PICK_NFLUSH_VALUE = 6;

	private static final QxProcessingStrategy[] VALUES_ARRAY =
		new QxProcessingStrategy[] {
			OLDEST_MOST_URGENT,
			NEWEST_MOST_URGENT,
			ROUND_ROBIN,
			PREDICATE,
			TIME_RANGE_EXCLUSIVE,
			TIME_RANGE_INCLUSIVE,
			PICK_NFLUSH,
		};

	public static final List<QxProcessingStrategy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static QxProcessingStrategy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QxProcessingStrategy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static QxProcessingStrategy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QxProcessingStrategy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static QxProcessingStrategy get(int value) {
		switch (value) {
			case OLDEST_MOST_URGENT_VALUE: return OLDEST_MOST_URGENT;
			case NEWEST_MOST_URGENT_VALUE: return NEWEST_MOST_URGENT;
			case ROUND_ROBIN_VALUE: return ROUND_ROBIN;
			case PREDICATE_VALUE: return PREDICATE;
			case TIME_RANGE_EXCLUSIVE_VALUE: return TIME_RANGE_EXCLUSIVE;
			case TIME_RANGE_INCLUSIVE_VALUE: return TIME_RANGE_INCLUSIVE;
			case PICK_NFLUSH_VALUE: return PICK_NFLUSH;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private QxProcessingStrategy(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public int getValue() {
	  return value;
	}

	public String getName() {
	  return name;
	}

	public String getLiteral() {
	  return literal;
	}

	@Override
	public String toString() {
		return literal;
	}
	
} //QxProcessingStrategy
