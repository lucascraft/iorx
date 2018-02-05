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

public enum PIN_MAPPING {

	PIN_AREF(27, "PIN_AREF", "AREF"),

	PIN_TX_I(33, "PIN_TX_I", "TX I"),

	PIN_TX(0, "PIN_TX", "TX"),

	PIN_RX(1, "PIN_RX", "RX"),

	PIN_D2(2, "PIN_D2", "D2"),

	PIN_D3(3, "PIN_D3", "D3"),

	PIN_D4(4, "PIN_D4", "D4"),

	PIN_D5(5, "PIN_D5", "D5"),

	PIN_D6(6, "PIN_D6", "D6"),

	PIN_D7(7, "PIN_D7", "D7"),

	PIN_D8(8, "PIN_D8", "D8"),

	PIN_D9(9, "PIN_D9", "D9"),

	PIN_D10(10, "PIN_D10", "D10"),

	PIN_D11(11, "PIN_D11", "D11"),

	PIN_D12(12, "PIN_D12", "D12"),

	PIN_D13(13, "PIN_D13", "D13"),

	PIN_D14(14, "PIN_D14", "D14"),

	PIN_D15(15, "PIN_D15", "D15"),

	PIN_D16(16, "PIN_D16", "D16"),

	PIN_D17(17, "PIN_D17", "D17"),

	PIN_D18(18, "PIN_D18", "D18"),

	PIN_D19(19, "PIN_D19", "D19"),

	PIN_D20(20, "PIN_D20", "D20"),

	PIN_D21(21, "PIN_D21", "D21"),

	PIN_GND_D(30, "PIN_GND_D", "PIN_GND_D"),

	PIN_3V3_1(14, "PIN_3V3_1", "PIN_3V3_1"),

	PIN_3V3_2(15, "PIN_3V3_2", "PIN_3V3_2"),

	PIN_5V(28, "PIN_5V", "PIN_5V"),

	PIN_9V(29, "PIN_9V", "PIN_9V"),

	PIN_GND_9V(16, "PIN_GND_9V", "GND 9V"),

	PIN_GND_3V(17, "PIN_GND_3V", "GND 3V"),

	PIN_RST(18, "PIN_RST", "Reset"),

	PIN_A0(0, "PIN_A0", "A0"),

	PIN_A1(1, "PIN_A1", "A1"),

	PIN_A2(2, "PIN_A2", "A2"),

	PIN_A3(3, "PIN_A3", "A3"),

	PIN_A4(4, "PIN_A4", "A4"),

	PIN_A5(5, "PIN_A5", "A5"),

	PIN_A6(6, "PIN_A6", "A6"),

	PIN_A7(7, "PIN_A7", "A7"),

	PIN_A8(8, "PIN_A8", "A8"),

	PIN_A9(9, "PIN_A9", "A9"),

	PIN_A10(10, "PIN_A10", "A10"),

	PIN_A11(11, "PIN_A11", "A11"),

	PIN_A12(12, "PIN_A12", "A12"),

	PIN_A13(13, "PIN_A13", "A13"),

	PIN_A14(14, "PIN_A14", "A14"),

	PIN_A15(15, "PIN_A15", "A15"),

	PIN_VIN(31, "PIN_VIN", "VIN"),

	PIN_TX_O(32, "PIN_TX_O", "TX O"),

	PIN_D22(22, "PIN_D22", "D22"),

	PIN_D23(23, "PIN_D23", "D23"),

	PIN_D24(24, "PIN_D24", "D24"),

	PIN_D25(25, "PIN_D25", "D25"),

	PIN_D26(26, "PIN_D26", "D26"),

	PIN_D27(27, "PIN_D27", "D27"),

	PIN_D28(28, "PIN_D28", "D28"),

	PIN_D29(29, "PIN_D29", "D29"),

	PIN_D30(30, "PIN_D30", "D30"),

	PIN_D31(31, "PIN_D31", "D31"),

	PIN_D32(32, "PIN_D32", "D32"),

	PIN_D33(33, "PIN_D33", "D33"),

	PIN_D34(34, "PIN_D34", "D34"),

	PIN_D35(35, "PIN_D35", "D35"),

	PIN_D36(36, "PIN_D36", "D36"),

	PIN_D37(37, "PIN_D37", "D37"),

	PIN_D38(38, "PIN_D38", "D38"),

	PIN_D39(39, "PIN_D39", "D39"),

	PIN_D40(40, "PIN_D40", "D40"),

	PIN_D41(41, "PIN_D41", "D41"),

	PIN_D42(42, "PIN_D42", "D42"),

	PIN_D43(43, "PIN_D43", "D43"),

	PIN_D44(44, "PIN_D44", "D44"),

	PIN_D45(45, "PIN_D45", "D45"),

	PIN_D46(46, "PIN_D46", "D46"),

	PIN_D47(47, "PIN_D47", "D47"),

	PIN_D48(48, "PIN_D48", "D48"),

	PIN_D49(49, "PIN_D49", "D49"),

	PIN_D50(50, "PIN_D50", "D50"),

	PIN_D51(51, "PIN_D51", "D51"),

	PIN_D52(52, "PIN_D52", "D52"),

	PIN_IO7(82, "PIN_IO7", "PIN_IO7"),

	UNKNOWN(0, "UNKNOWN", "UNKNOWN"),

	PIN_A16(16, "PIN_A16", "A16"),

	PIN_A17(17, "PIN_A17", "A17"),

	PIN_A18(18, "PIN_A18", "A18"),

	PIN_A19(19, "PIN_A19", "A19"),

	PIN_A20(20, "PIN_A20", "A20"),

	PIN_A21(21, "PIN_A21", "A21"),

	PIN_A22(22, "PIN_A22", "A22"),

	PIN_A23(23, "PIN_A23", "A23"),

	PIN_A24(24, "PIN_A24", "A24");

	public static final int PIN_AREF_VALUE = 27;

	public static final int PIN_TX_I_VALUE = 33;

	public static final int PIN_TX_VALUE = 0;

	public static final int PIN_RX_VALUE = 1;

	public static final int PIN_D2_VALUE = 2;

	public static final int PIN_D3_VALUE = 3;

	public static final int PIN_D4_VALUE = 4;

	public static final int PIN_D5_VALUE = 5;

	public static final int PIN_D6_VALUE = 6;

	public static final int PIN_D7_VALUE = 7;

	public static final int PIN_D8_VALUE = 8;

	public static final int PIN_D9_VALUE = 9;

	public static final int PIN_D10_VALUE = 10;

	public static final int PIN_D11_VALUE = 11;

	public static final int PIN_D12_VALUE = 12;

	public static final int PIN_D13_VALUE = 13;

	public static final int PIN_D14_VALUE = 14;

	public static final int PIN_D15_VALUE = 15;

	public static final int PIN_D16_VALUE = 16;

	public static final int PIN_D17_VALUE = 17;

	public static final int PIN_D18_VALUE = 18;

	public static final int PIN_D19_VALUE = 19;

	public static final int PIN_D20_VALUE = 20;

	public static final int PIN_D21_VALUE = 21;

	public static final int PIN_GND_D_VALUE = 30;

	public static final int PIN_3V3_1_VALUE = 14;

	public static final int PIN_3V3_2_VALUE = 15;

	public static final int PIN_5V_VALUE = 28;

	public static final int PIN_9V_VALUE = 29;

	public static final int PIN_GND_9V_VALUE = 16;

	public static final int PIN_GND_3V_VALUE = 17;

	public static final int PIN_RST_VALUE = 18;

	public static final int PIN_A0_VALUE = 0;

	public static final int PIN_A1_VALUE = 1;

	public static final int PIN_A2_VALUE = 2;

	public static final int PIN_A3_VALUE = 3;

	public static final int PIN_A4_VALUE = 4;

	public static final int PIN_A5_VALUE = 5;

	public static final int PIN_A6_VALUE = 6;

	public static final int PIN_A7_VALUE = 7;

	public static final int PIN_A8_VALUE = 8;

	public static final int PIN_A9_VALUE = 9;

	public static final int PIN_A10_VALUE = 10;

	public static final int PIN_A11_VALUE = 11;

	public static final int PIN_A12_VALUE = 12;

	public static final int PIN_A13_VALUE = 13;

	public static final int PIN_A14_VALUE = 14;

	public static final int PIN_A15_VALUE = 15;

	public static final int PIN_VIN_VALUE = 31;

	public static final int PIN_TX_O_VALUE = 32;

	public static final int PIN_D22_VALUE = 22;

	public static final int PIN_D23_VALUE = 23;

	public static final int PIN_D24_VALUE = 24;

	public static final int PIN_D25_VALUE = 25;

	public static final int PIN_D26_VALUE = 26;

	public static final int PIN_D27_VALUE = 27;

	public static final int PIN_D28_VALUE = 28;

	public static final int PIN_D29_VALUE = 29;

	public static final int PIN_D30_VALUE = 30;

	public static final int PIN_D31_VALUE = 31;

	public static final int PIN_D32_VALUE = 32;

	public static final int PIN_D33_VALUE = 33;

	public static final int PIN_D34_VALUE = 34;

	public static final int PIN_D35_VALUE = 35;

	public static final int PIN_D36_VALUE = 36;

	public static final int PIN_D37_VALUE = 37;

	public static final int PIN_D38_VALUE = 38;

	public static final int PIN_D39_VALUE = 39;

	public static final int PIN_D40_VALUE = 40;

	public static final int PIN_D41_VALUE = 41;

	public static final int PIN_D42_VALUE = 42;

	public static final int PIN_D43_VALUE = 43;

	public static final int PIN_D44_VALUE = 44;

	public static final int PIN_D45_VALUE = 45;

	public static final int PIN_D46_VALUE = 46;

	public static final int PIN_D47_VALUE = 47;

	public static final int PIN_D48_VALUE = 48;

	public static final int PIN_D49_VALUE = 49;

	public static final int PIN_D50_VALUE = 50;

	public static final int PIN_D51_VALUE = 51;

	public static final int PIN_D52_VALUE = 52;

	public static final int PIN_IO7_VALUE = 82;

	public static final int UNKNOWN_VALUE = 0;

	public static final int PIN_A16_VALUE = 16;

	public static final int PIN_A17_VALUE = 17;

	public static final int PIN_A18_VALUE = 18;

	public static final int PIN_A19_VALUE = 19;

	public static final int PIN_A20_VALUE = 20;

	public static final int PIN_A21_VALUE = 21;

	public static final int PIN_A22_VALUE = 22;

	public static final int PIN_A23_VALUE = 23;

	public static final int PIN_A24_VALUE = 24;

	private static final PIN_MAPPING[] VALUES_ARRAY = new PIN_MAPPING[] { PIN_AREF, PIN_TX_I, PIN_TX, PIN_RX, PIN_D2,
			PIN_D3, PIN_D4, PIN_D5, PIN_D6, PIN_D7, PIN_D8, PIN_D9, PIN_D10, PIN_D11, PIN_D12, PIN_D13, PIN_D14,
			PIN_D15, PIN_D16, PIN_D17, PIN_D18, PIN_D19, PIN_D20, PIN_D21, PIN_GND_D, PIN_3V3_1, PIN_3V3_2, PIN_5V,
			PIN_9V, PIN_GND_9V, PIN_GND_3V, PIN_RST, PIN_A0, PIN_A1, PIN_A2, PIN_A3, PIN_A4, PIN_A5, PIN_A6, PIN_A7,
			PIN_A8, PIN_A9, PIN_A10, PIN_A11, PIN_A12, PIN_A13, PIN_A14, PIN_A15, PIN_VIN, PIN_TX_O, PIN_D22, PIN_D23,
			PIN_D24, PIN_D25, PIN_D26, PIN_D27, PIN_D28, PIN_D29, PIN_D30, PIN_D31, PIN_D32, PIN_D33, PIN_D34, PIN_D35,
			PIN_D36, PIN_D37, PIN_D38, PIN_D39, PIN_D40, PIN_D41, PIN_D42, PIN_D43, PIN_D44, PIN_D45, PIN_D46, PIN_D47,
			PIN_D48, PIN_D49, PIN_D50, PIN_D51, PIN_D52, PIN_IO7, UNKNOWN, PIN_A16, PIN_A17, PIN_A18, PIN_A19, PIN_A20,
			PIN_A21, PIN_A22, PIN_A23, PIN_A24, };

	public static final List<PIN_MAPPING> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	public static PIN_MAPPING get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PIN_MAPPING result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static PIN_MAPPING getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PIN_MAPPING result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public static PIN_MAPPING get(int value) {
		switch (value) {
		case PIN_AREF_VALUE:
			return PIN_AREF;
		case PIN_TX_I_VALUE:
			return PIN_TX_I;
		case PIN_TX_VALUE:
			return PIN_TX;
		case PIN_RX_VALUE:
			return PIN_RX;
		case PIN_D2_VALUE:
			return PIN_D2;
		case PIN_D3_VALUE:
			return PIN_D3;
		case PIN_D4_VALUE:
			return PIN_D4;
		case PIN_D5_VALUE:
			return PIN_D5;
		case PIN_D6_VALUE:
			return PIN_D6;
		case PIN_D7_VALUE:
			return PIN_D7;
		case PIN_D8_VALUE:
			return PIN_D8;
		case PIN_D9_VALUE:
			return PIN_D9;
		case PIN_D10_VALUE:
			return PIN_D10;
		case PIN_D11_VALUE:
			return PIN_D11;
		case PIN_D12_VALUE:
			return PIN_D12;
		case PIN_D13_VALUE:
			return PIN_D13;
		case PIN_D14_VALUE:
			return PIN_D14;
		case PIN_D15_VALUE:
			return PIN_D15;
		case PIN_D16_VALUE:
			return PIN_D16;
		case PIN_D17_VALUE:
			return PIN_D17;
		case PIN_D18_VALUE:
			return PIN_D18;
		case PIN_D19_VALUE:
			return PIN_D19;
		case PIN_D20_VALUE:
			return PIN_D20;
		case PIN_D21_VALUE:
			return PIN_D21;
		case PIN_GND_D_VALUE:
			return PIN_GND_D;
		case PIN_5V_VALUE:
			return PIN_5V;
		case PIN_9V_VALUE:
			return PIN_9V;
		case PIN_VIN_VALUE:
			return PIN_VIN;
		case PIN_TX_O_VALUE:
			return PIN_TX_O;
		case PIN_D22_VALUE:
			return PIN_D22;
		case PIN_D23_VALUE:
			return PIN_D23;
		case PIN_D24_VALUE:
			return PIN_D24;
		case PIN_D25_VALUE:
			return PIN_D25;
		case PIN_D26_VALUE:
			return PIN_D26;
		case PIN_D34_VALUE:
			return PIN_D34;
		case PIN_D35_VALUE:
			return PIN_D35;
		case PIN_D36_VALUE:
			return PIN_D36;
		case PIN_D37_VALUE:
			return PIN_D37;
		case PIN_D38_VALUE:
			return PIN_D38;
		case PIN_D39_VALUE:
			return PIN_D39;
		case PIN_D40_VALUE:
			return PIN_D40;
		case PIN_D41_VALUE:
			return PIN_D41;
		case PIN_D42_VALUE:
			return PIN_D42;
		case PIN_D43_VALUE:
			return PIN_D43;
		case PIN_D44_VALUE:
			return PIN_D44;
		case PIN_D45_VALUE:
			return PIN_D45;
		case PIN_D46_VALUE:
			return PIN_D46;
		case PIN_D47_VALUE:
			return PIN_D47;
		case PIN_D48_VALUE:
			return PIN_D48;
		case PIN_D49_VALUE:
			return PIN_D49;
		case PIN_D50_VALUE:
			return PIN_D50;
		case PIN_D51_VALUE:
			return PIN_D51;
		case PIN_D52_VALUE:
			return PIN_D52;
		case PIN_IO7_VALUE:
			return PIN_IO7;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	private PIN_MAPPING(int value, String name, String literal) {
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

} // PIN_MAPPING
