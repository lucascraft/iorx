/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.hardware.arduino;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ARDUINO_BOARD_UID  {

	DIECMILA_ATMEGA_168(0, "DIECMILA_ATMEGA_168", "Diecimila ATMega 168"),

	DIECIMILA_ATMEGA328(1, "DIECIMILA_ATMEGA328", "DIECIMILA_ATMEGA328"),

	DIECIMILA_ATMEGA_328P(2, "DIECIMILA_ATMEGA_328P", "Diecimila ATMega 328P"),

	MINI_ATMEGA_168(3, "MINI_ATMEGA_168", "Mini ATMega 168"),

	MEGA_ATMEGA_1280(4, "MEGA_ATMEGA_1280", "Mega ATMega 1280"),

	LILIPAD_ATMEGA_328V(5, "LILIPAD_ATMEGA_328V", "Lilipad ATMega 328V"),

	DUEMILANOVE_ATMEGA_328(6, "DUEMILANOVE_ATMEGA_328", "Duemilanove ATMega 328"),

	DUEMILANOVE_ATMEGA_168(7, "DUEMILANOVE_ATMEGA_168", "Duemilanove ATMega 168"),

	MINI_PRO_ATMEGA_168(8, "MINI_PRO_ATMEGA_168", "Mini Pro ATMega 168"),

	NANO_30_ATMEGA328(9, "NANO_30_ATMEGA328", "Nano 30 ATMega 328"),

	NANO_23_ATMEGA168(10, "NANO_23_ATMEGA168", "Nano 23 ATMega 168"),

	FUNNEL_IO_ATMEGA328P(11, "FUNNEL_IO_ATMEGA328P", "Funnel IO ATMega 328P"),

	PRO_ATMEGA_168(12, "PRO_ATMEGA_168", "Pro ATMega 168"),

	PRO_ATMEGA_328(13, "PRO_ATMEGA_328", "Pro ATMega 328"),

	BT_ATMEGA_168(14, "BT_ATMEGA_168", "Bluetooth ATMega 168"),

	PRO_MINI_ATMEGA_168(15, "PRO_MINI_ATMEGA_168", "Pro Mini ATMega 168"), 

	UNO_ATMEGA328(16, "UNO_ATMEGA328", "UNO ATMega 328"), 

	LEONARDO_ATMEGA32U4(17, "LEONARDO_ATMEGA32U4", "Leonardo ATMega 32U4"),

	PLACEHOLDER_VOID_BOARD(0, "PLACEHOLDER_VOID_BOARD", "Placeholder Void Board");

	public static final int DIECMILA_ATMEGA_168_VALUE = 0;

	public static final int DIECIMILA_ATMEGA328_VALUE = 1;

	public static final int DIECIMILA_ATMEGA_328P_VALUE = 2;

	public static final int MINI_ATMEGA_168_VALUE = 3;

	public static final int MEGA_ATMEGA_1280_VALUE = 4;

	public static final int LILIPAD_ATMEGA_328V_VALUE = 5;

public static final int DUEMILANOVE_ATMEGA_328_VALUE = 6;

	public static final int DUEMILANOVE_ATMEGA_168_VALUE = 7;

	public static final int MINI_PRO_ATMEGA_168_VALUE = 8;

	public static final int NANO_30_ATMEGA328_VALUE = 9;

	public static final int NANO_23_ATMEGA168_VALUE = 10;

	public static final int FUNNEL_IO_ATMEGA328P_VALUE = 11;

	public static final int PRO_ATMEGA_168_VALUE = 12;
	public static final int PRO_ATMEGA_328_VALUE = 13;
	public static final int BT_ATMEGA_168_VALUE = 14;

	public static final int PRO_MINI_ATMEGA_168_VALUE = 15;

	public static final int UNO_ATMEGA328_VALUE = 16;

	public static final int LEONARDO_ATMEGA32U4_VALUE = 17;

	public static final int PLACEHOLDER_VOID_BOARD_VALUE = 0;

	private static final ARDUINO_BOARD_UID[] VALUES_ARRAY =
		new ARDUINO_BOARD_UID[] {
			DIECMILA_ATMEGA_168,
			DIECIMILA_ATMEGA328,
			DIECIMILA_ATMEGA_328P,
			MINI_ATMEGA_168,
			MEGA_ATMEGA_1280,
			LILIPAD_ATMEGA_328V,
			DUEMILANOVE_ATMEGA_328,
			DUEMILANOVE_ATMEGA_168,
			MINI_PRO_ATMEGA_168,
			NANO_30_ATMEGA328,
			NANO_23_ATMEGA168,
			FUNNEL_IO_ATMEGA328P,
			PRO_ATMEGA_168,
			PRO_ATMEGA_328,
			BT_ATMEGA_168,
			PRO_MINI_ATMEGA_168,
			UNO_ATMEGA328,
			LEONARDO_ATMEGA32U4,
			PLACEHOLDER_VOID_BOARD,
		};

	public static final List<ARDUINO_BOARD_UID> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static ARDUINO_BOARD_UID get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_UID result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_BOARD_UID getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ARDUINO_BOARD_UID result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static ARDUINO_BOARD_UID get(int value) {
		switch (value) {
			case DIECMILA_ATMEGA_168_VALUE: return DIECMILA_ATMEGA_168;
			case DIECIMILA_ATMEGA328_VALUE: return DIECIMILA_ATMEGA328;
			case DIECIMILA_ATMEGA_328P_VALUE: return DIECIMILA_ATMEGA_328P;
			case MINI_ATMEGA_168_VALUE: return MINI_ATMEGA_168;
			case MEGA_ATMEGA_1280_VALUE: return MEGA_ATMEGA_1280;
			case LILIPAD_ATMEGA_328V_VALUE: return LILIPAD_ATMEGA_328V;
			case DUEMILANOVE_ATMEGA_328_VALUE: return DUEMILANOVE_ATMEGA_328;
			case DUEMILANOVE_ATMEGA_168_VALUE: return DUEMILANOVE_ATMEGA_168;
			case MINI_PRO_ATMEGA_168_VALUE: return MINI_PRO_ATMEGA_168;
			case NANO_30_ATMEGA328_VALUE: return NANO_30_ATMEGA328;
			case NANO_23_ATMEGA168_VALUE: return NANO_23_ATMEGA168;
			case FUNNEL_IO_ATMEGA328P_VALUE: return FUNNEL_IO_ATMEGA328P;
			case PRO_ATMEGA_168_VALUE: return PRO_ATMEGA_168;
			case PRO_ATMEGA_328_VALUE: return PRO_ATMEGA_328;
			case BT_ATMEGA_168_VALUE: return BT_ATMEGA_168;
			case PRO_MINI_ATMEGA_168_VALUE: return PRO_MINI_ATMEGA_168;
			case UNO_ATMEGA328_VALUE: return UNO_ATMEGA328;
			case LEONARDO_ATMEGA32U4_VALUE: return LEONARDO_ATMEGA32U4;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private ARDUINO_BOARD_UID(int value, String name, String literal) {
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
	
} //ARDUINO_BOARD_UID
