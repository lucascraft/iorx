/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.media.fmodex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DSP_KIND  {
	
	CHORUS(0, "CHORUS", "CHORUS"),

	
	COMPRESSOR(1, "COMPRESSOR", "COMPRESSOR"),


	DELAY(2, "DELAY", "DELAY"),

	
	DISTORTION(3, "DISTORTION", "DISTORTION"),

	
	ECHO(4, "ECHO", "ECHO"),

	
	FFT_WINDOW(5, "FFT_WINDOW", "FFT_WINDOW"),

	
	FLANGE(6, "FLANGE", "FLANGE"),

	HIGH_PASS(7, "HIGH_PASS", "HIGH_PASS"),

	
	IT_ECHO(8, "IT_ECHO", "IT_ECHO"),

	
	IT_LOW_PASS(9, "IT_LOW_PASS", "IT_LOW_PASS"),

	
	LOW_PASS_SIMPLE(10, "LOW_PASS_SIMPLE", "LOW_PASS_SIMPLE"),

	
	LOW_PASS(11, "LOW_PASS", "LOW_PASS"),

	
	NORMALIZE(12, "NORMALIZE", "NORMALIZE"),

	
	OSCILLATOR(13, "OSCILLATOR", "OSCILLATOR"),

	
	PARAM_EQ(14, "PARAM_EQ", "PARAM_EQ"),

	
	PITCH_SHIFFT(15, "PITCH_SHIFFT", "PITCH_SHIFFT"),

	RESAMPLER(16, "RESAMPLER", "RESAMPLER"),

	REVERB(17, "REVERB", "REVERB"),

	SFX_REVERB(18, "SFX_REVERB", "SFX_REVERB"),

	TREMOLO(19, "TREMOLO", "TREMOLO"),

	TYPE(20, "TYPE", "TYPE");


	public static final int CHORUS_VALUE = 0;


	public static final int COMPRESSOR_VALUE = 1;

	
	public static final int DELAY_VALUE = 2;

	
	public static final int DISTORTION_VALUE = 3;

	
	public static final int ECHO_VALUE = 4;


	public static final int FFT_WINDOW_VALUE = 5;


	public static final int FLANGE_VALUE = 6;


	public static final int HIGH_PASS_VALUE = 7;

	public static final int IT_ECHO_VALUE = 8;

	
	public static final int IT_LOW_PASS_VALUE = 9;

	
	public static final int LOW_PASS_SIMPLE_VALUE = 10;

	public static final int LOW_PASS_VALUE = 11;

	public static final int NORMALIZE_VALUE = 12;

	
	public static final int OSCILLATOR_VALUE = 13;

	
	public static final int PARAM_EQ_VALUE = 14;

	
	public static final int PITCH_SHIFFT_VALUE = 15;

	
	public static final int RESAMPLER_VALUE = 16;

	
	public static final int REVERB_VALUE = 17;

	
	public static final int SFX_REVERB_VALUE = 18;

	public static final int TREMOLO_VALUE = 19;

	
	public static final int TYPE_VALUE = 20;

	
	private static final DSP_KIND[] VALUES_ARRAY =
		new DSP_KIND[] {
			CHORUS,
			COMPRESSOR,
			DELAY,
			DISTORTION,
			ECHO,
			FFT_WINDOW,
			FLANGE,
			HIGH_PASS,
			IT_ECHO,
			IT_LOW_PASS,
			LOW_PASS_SIMPLE,
			LOW_PASS,
			NORMALIZE,
			OSCILLATOR,
			PARAM_EQ,
			PITCH_SHIFFT,
			RESAMPLER,
			REVERB,
			SFX_REVERB,
			TREMOLO,
			TYPE,
		};

	
	public static final List<DSP_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	
	public static DSP_KIND get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DSP_KIND result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	
	public static DSP_KIND getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DSP_KIND result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	
	public static DSP_KIND get(int value) {
		switch (value) {
			case CHORUS_VALUE: return CHORUS;
			case COMPRESSOR_VALUE: return COMPRESSOR;
			case DELAY_VALUE: return DELAY;
			case DISTORTION_VALUE: return DISTORTION;
			case ECHO_VALUE: return ECHO;
			case FFT_WINDOW_VALUE: return FFT_WINDOW;
			case FLANGE_VALUE: return FLANGE;
			case HIGH_PASS_VALUE: return HIGH_PASS;
			case IT_ECHO_VALUE: return IT_ECHO;
			case IT_LOW_PASS_VALUE: return IT_LOW_PASS;
			case LOW_PASS_SIMPLE_VALUE: return LOW_PASS_SIMPLE;
			case LOW_PASS_VALUE: return LOW_PASS;
			case NORMALIZE_VALUE: return NORMALIZE;
			case OSCILLATOR_VALUE: return OSCILLATOR;
			case PARAM_EQ_VALUE: return PARAM_EQ;
			case PITCH_SHIFFT_VALUE: return PITCH_SHIFFT;
			case RESAMPLER_VALUE: return RESAMPLER;
			case REVERB_VALUE: return REVERB;
			case SFX_REVERB_VALUE: return SFX_REVERB;
			case TREMOLO_VALUE: return TREMOLO;
			case TYPE_VALUE: return TYPE;
		}
		return null;
	}

	private final int value;

	private final String name;

	private final String literal;

	
	private DSP_KIND(int value, String name, String literal) {
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
	
} //DSP_KIND
