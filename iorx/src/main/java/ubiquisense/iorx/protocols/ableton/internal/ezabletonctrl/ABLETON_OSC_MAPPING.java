/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.ableton.internal.ezabletonctrl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ABLETON OSC MAPPING</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.smbt.ezabletonctrl.EzabletonctrlPackage#getABLETON_OSC_MAPPING()
 * @model
 * @generated
 */
public enum ABLETON_OSC_MAPPING {
	/**
	 * The '<em><b>MASTER PAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTER_PAN_VALUE
	 * @generated
	 * @ordered
	 */
	MASTER_PAN(0, "MASTER_PAN", "/live/master/pan"),

	/**
	 * The '<em><b>MASTER VOLUME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTER_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	MASTER_VOLUME(1, "MASTER_VOLUME", "/live/master/volume"), /**
	 * The '<em><b>TEMPO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPO_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPO(2, "TEMPO", "/live/tempo"), /**
	 * The '<em><b>TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(3, "TIME", "/live/time"), /**
	 * The '<em><b>OVERDUB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERDUB_VALUE
	 * @generated
	 * @ordered
	 */
	OVERDUB(4, "OVERDUB", "/live/overdub"), /**
	 * The '<em><b>STATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE(5, "STATE", "/live/state"), /**
	 * The '<em><b>UNDO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDO_VALUE
	 * @generated
	 * @ordered
	 */
	UNDO(6, "UNDO", "/live/undo"), /**
	 * The '<em><b>REDO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REDO_VALUE
	 * @generated
	 * @ordered
	 */
	REDO(7, "REDO", "/live/redo"), /**
	 * The '<em><b>NEXT CUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEXT_CUE_VALUE
	 * @generated
	 * @ordered
	 */
	NEXT_CUE(8, "NEXT_CUE", "/live/next/cue"), /**
	 * The '<em><b>PREV CUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREV_CUE_VALUE
	 * @generated
	 * @ordered
	 */
	PREV_CUE(9, "PREV_CUE", "/live/prev/cue"), /**
	 * The '<em><b>PLAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY(10, "PLAY", "/live/play"), /**
	 * The '<em><b>PLAY CONTINUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_CONTINUE_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_CONTINUE(11, "PLAY_CONTINUE", "/live/play/continue"), /**
	 * The '<em><b>PLAY SELECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_SELECTION(12, "PLAY_SELECTION", "/live/play/selection"), /**
	 * The '<em><b>PLAY CLIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_CLIP_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_CLIP(13, "PLAY_CLIP", "/live/play/clip"), /**
	 * The '<em><b>PLAY CLIPSLOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_CLIPSLOT_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_CLIPSLOT(14, "PLAY_CLIPSLOT", "/live/clipslot"), /**
	 * The '<em><b>PLAY SCENE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_SCENE_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_SCENE(15, "PLAY_SCENE", "/live/play/scene"), /**
	 * The '<em><b>STOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOP_VALUE
	 * @generated
	 * @ordered
	 */
	STOP(16, "STOP", "/live/stop"), /**
	 * The '<em><b>STOP CLIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOP_CLIP_VALUE
	 * @generated
	 * @ordered
	 */
	STOP_CLIP(17, "STOP_CLIP", "/live/stop/clip"), /**
	 * The '<em><b>STOP TRACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOP_TRACK_VALUE
	 * @generated
	 * @ordered
	 */
	STOP_TRACK(18, "STOP_TRACK", "/live/stop/track"), /**
	 * The '<em><b>SCENES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCENES_VALUE
	 * @generated
	 * @ordered
	 */
	SCENES(19, "SCENES", "/live/scenes"), /**
	 * The '<em><b>TRACKS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKS_VALUE
	 * @generated
	 * @ordered
	 */
	TRACKS(20, "TRACKS", "/live/tracks"), /**
	 * The '<em><b>SCENE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCENE_VALUE
	 * @generated
	 * @ordered
	 */
	SCENE(21, "SCENE", "/live/scene"), /**
	 * The '<em><b>NAME SCENE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_SCENE_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_SCENE(22, "NAME_SCENE", "/live/name/scene"), /**
	 * The '<em><b>NAME SCENEBLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_SCENEBLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_SCENEBLOCK(23, "NAME_SCENEBLOCK", "/live/name/sceneblock"), /**
	 * The '<em><b>NAME TRACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_TRACK_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_TRACK(24, "NAME_TRACK", "/live/name/track"), /**
	 * The '<em><b>NAME TRACKBLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_TRACKBLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_TRACKBLOCK(25, "NAME_TRACKBLOCK", "/live/name/trackblock"), /**
	 * The '<em><b>NAME CLIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_CLIP_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_CLIP(26, "NAME_CLIP", "/live/name/clip"), /**
	 * The '<em><b>NAME CLIPBLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_CLIPBLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	NAME_CLIPBLOCK(27, "NAME_CLIPBLOCK", "/live/name/clipblock"), /**
	 * The '<em><b>ARM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARM_VALUE
	 * @generated
	 * @ordered
	 */
	ARM(28, "ARM", "/live/arm"), /**
	 * The '<em><b>MUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUTE_VALUE
	 * @generated
	 * @ordered
	 */
	MUTE(29, "MUTE", "/live/mute"), /**
	 * The '<em><b>SOLO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLO_VALUE
	 * @generated
	 * @ordered
	 */
	SOLO(30, "SOLO", "/live/solo"), /**
	 * The '<em><b>VOLUME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	VOLUME(31, "VOLUME", "/live/volume"), /**
	 * The '<em><b>PAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAN_VALUE
	 * @generated
	 * @ordered
	 */
	PAN(32, "PAN", "/live/pan"), /**
	 * The '<em><b>SEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEND_VALUE
	 * @generated
	 * @ordered
	 */
	SEND(33, "SEND", "/live/send"), /**
	 * The '<em><b>PITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PITCH_VALUE
	 * @generated
	 * @ordered
	 */
	PITCH(34, "PITCH", "/live/pitch"), /**
	 * The '<em><b>RETURN MUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_MUTE_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_MUTE(35, "RETURN_MUTE", "/live/return/mute"), /**
	 * The '<em><b>RETURN SOLO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_SOLO_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_SOLO(36, "RETURN_SOLO", "/live/return/solo"), /**
	 * The '<em><b>RETURN VOLUME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_VOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_VOLUME(37, "RETURN_VOLUME", "/live/return/volume"), /**
	 * The '<em><b>RETURN PAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_PAN_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_PAN(38, "RETURN_PAN", "/live/return/pan"), /**
	 * The '<em><b>RETURN SEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_SEND_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_SEND(39, "RETURN_SEND", "/live/return/send"), /**
	 * The '<em><b>TRACK JUMP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACK_JUMP_VALUE
	 * @generated
	 * @ordered
	 */
	TRACK_JUMP(40, "TRACK_JUMP", "/live/track/jump"), /**
	 * The '<em><b>TRACK INFO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACK_INFO_VALUE
	 * @generated
	 * @ordered
	 */
	TRACK_INFO(41, "TRACK_INFO", "/live/track/info"), /**
	 * The '<em><b>TRACK VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACK_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	TRACK_VIEW(42, "TRACK_VIEW", "/live/track/view"), /**
	 * The '<em><b>RETURN VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_VIEW(43, "RETURN_VIEW", "/live/return/view"), /**
	 * The '<em><b>MASTER VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTER_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	MASTER_VIEW(44, "MASTER_VIEW", "/live/master/view"), /**
	 * The '<em><b>TRACK DEVICE VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACK_DEVICE_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	TRACK_DEVICE_VIEW(45, "TRACK_DEVICE_VIEW", "/live/track/device/view"), /**
	 * The '<em><b>RETURN DEVICE VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_DEVICE_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_DEVICE_VIEW(46, "RETURN_DEVICE_VIEW", "/live/return/device/view"), /**
	 * The '<em><b>MASTER DEVICE VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTER_DEVICE_VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	MASTER_DEVICE_VIEW(47, "MASTER_DEVICE_VIEW", "/live/master/device/view");

	/**
	 * The '<em><b>MASTER PAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASTER PAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASTER_PAN
	 * @model literal="/live/master/pan"
	 * @generated
	 * @ordered
	 */
	public static final int MASTER_PAN_VALUE = 0;

	/**
	 * The '<em><b>MASTER VOLUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASTER VOLUME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASTER_VOLUME
	 * @model literal="/live/master/volume"
	 * @generated
	 * @ordered
	 */
	public static final int MASTER_VOLUME_VALUE = 1;

	/**
	 * The '<em><b>TEMPO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPO
	 * @model literal="/live/tempo"
	 * @generated
	 * @ordered
	 */
	public static final int TEMPO_VALUE = 2;

	/**
	 * The '<em><b>TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @model literal="/live/time"
	 * @generated
	 * @ordered
	 */
	public static final int TIME_VALUE = 3;

	/**
	 * The '<em><b>OVERDUB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERDUB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERDUB
	 * @model literal="/live/overdub"
	 * @generated
	 * @ordered
	 */
	public static final int OVERDUB_VALUE = 4;

	/**
	 * The '<em><b>STATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE
	 * @model literal="/live/state"
	 * @generated
	 * @ordered
	 */
	public static final int STATE_VALUE = 5;

	/**
	 * The '<em><b>UNDO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNDO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDO
	 * @model literal="/live/undo"
	 * @generated
	 * @ordered
	 */
	public static final int UNDO_VALUE = 6;

	/**
	 * The '<em><b>REDO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REDO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REDO
	 * @model literal="/live/redo"
	 * @generated
	 * @ordered
	 */
	public static final int REDO_VALUE = 7;

	/**
	 * The '<em><b>NEXT CUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEXT CUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEXT_CUE
	 * @model literal="/live/next/cue"
	 * @generated
	 * @ordered
	 */
	public static final int NEXT_CUE_VALUE = 8;

	/**
	 * The '<em><b>PREV CUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PREV CUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREV_CUE
	 * @model literal="/live/prev/cue"
	 * @generated
	 * @ordered
	 */
	public static final int PREV_CUE_VALUE = 9;

	/**
	 * The '<em><b>PLAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY
	 * @model literal="/live/play"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_VALUE = 10;

	/**
	 * The '<em><b>PLAY CONTINUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY CONTINUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_CONTINUE
	 * @model literal="/live/play/continue"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_CONTINUE_VALUE = 11;

	/**
	 * The '<em><b>PLAY SELECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY SELECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_SELECTION
	 * @model literal="/live/play/selection"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_SELECTION_VALUE = 12;

	/**
	 * The '<em><b>PLAY CLIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY CLIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_CLIP
	 * @model literal="/live/play/clip"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_CLIP_VALUE = 13;

	/**
	 * The '<em><b>PLAY CLIPSLOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY CLIPSLOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_CLIPSLOT
	 * @model literal="/live/clipslot"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_CLIPSLOT_VALUE = 14;

	/**
	 * The '<em><b>PLAY SCENE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAY SCENE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_SCENE
	 * @model literal="/live/play/scene"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_SCENE_VALUE = 15;

	/**
	 * The '<em><b>STOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOP
	 * @model literal="/live/stop"
	 * @generated
	 * @ordered
	 */
	public static final int STOP_VALUE = 16;

	/**
	 * The '<em><b>STOP CLIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOP CLIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOP_CLIP
	 * @model literal="/live/stop/clip"
	 * @generated
	 * @ordered
	 */
	public static final int STOP_CLIP_VALUE = 17;

	/**
	 * The '<em><b>STOP TRACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOP TRACK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOP_TRACK
	 * @model literal="/live/stop/track"
	 * @generated
	 * @ordered
	 */
	public static final int STOP_TRACK_VALUE = 18;

	/**
	 * The '<em><b>SCENES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCENES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCENES
	 * @model literal="/live/scenes"
	 * @generated
	 * @ordered
	 */
	public static final int SCENES_VALUE = 19;

	/**
	 * The '<em><b>TRACKS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRACKS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRACKS
	 * @model literal="/live/tracks"
	 * @generated
	 * @ordered
	 */
	public static final int TRACKS_VALUE = 20;

	/**
	 * The '<em><b>SCENE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCENE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCENE
	 * @model literal="/live/scene"
	 * @generated
	 * @ordered
	 */
	public static final int SCENE_VALUE = 21;

	/**
	 * The '<em><b>NAME SCENE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME SCENE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_SCENE
	 * @model literal="/live/name/scene"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_SCENE_VALUE = 22;

	/**
	 * The '<em><b>NAME SCENEBLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME SCENEBLOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_SCENEBLOCK
	 * @model literal="/live/name/sceneblock"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_SCENEBLOCK_VALUE = 23;

	/**
	 * The '<em><b>NAME TRACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME TRACK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_TRACK
	 * @model literal="/live/name/track"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_TRACK_VALUE = 24;

	/**
	 * The '<em><b>NAME TRACKBLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME TRACKBLOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_TRACKBLOCK
	 * @model literal="/live/name/trackblock"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_TRACKBLOCK_VALUE = 25;

	/**
	 * The '<em><b>NAME CLIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME CLIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_CLIP
	 * @model literal="/live/name/clip"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_CLIP_VALUE = 26;

	/**
	 * The '<em><b>NAME CLIPBLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME CLIPBLOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME_CLIPBLOCK
	 * @model literal="/live/name/clipblock"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_CLIPBLOCK_VALUE = 27;

	/**
	 * The '<em><b>ARM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ARM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARM
	 * @model literal="/live/arm"
	 * @generated
	 * @ordered
	 */
	public static final int ARM_VALUE = 28;

	/**
	 * The '<em><b>MUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUTE
	 * @model literal="/live/mute"
	 * @generated
	 * @ordered
	 */
	public static final int MUTE_VALUE = 29;

	/**
	 * The '<em><b>SOLO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLO
	 * @model literal="/live/solo"
	 * @generated
	 * @ordered
	 */
	public static final int SOLO_VALUE = 30;

	/**
	 * The '<em><b>VOLUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLUME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLUME
	 * @model literal="/live/volume"
	 * @generated
	 * @ordered
	 */
	public static final int VOLUME_VALUE = 31;

	/**
	 * The '<em><b>PAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAN
	 * @model literal="/live/pan"
	 * @generated
	 * @ordered
	 */
	public static final int PAN_VALUE = 32;

	/**
	 * The '<em><b>SEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEND
	 * @model literal="/live/send"
	 * @generated
	 * @ordered
	 */
	public static final int SEND_VALUE = 33;

	/**
	 * The '<em><b>PITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PITCH
	 * @model literal="/live/pitch"
	 * @generated
	 * @ordered
	 */
	public static final int PITCH_VALUE = 34;

	/**
	 * The '<em><b>RETURN MUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN MUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_MUTE
	 * @model literal="/live/return/mute"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_MUTE_VALUE = 35;

	/**
	 * The '<em><b>RETURN SOLO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN SOLO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_SOLO
	 * @model literal="/live/return/solo"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_SOLO_VALUE = 36;

	/**
	 * The '<em><b>RETURN VOLUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN VOLUME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_VOLUME
	 * @model literal="/live/return/volume"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VOLUME_VALUE = 37;

	/**
	 * The '<em><b>RETURN PAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN PAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_PAN
	 * @model literal="/live/return/pan"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_PAN_VALUE = 38;

	/**
	 * The '<em><b>RETURN SEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN SEND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_SEND
	 * @model literal="/live/return/send"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_SEND_VALUE = 39;

	/**
	 * The '<em><b>TRACK JUMP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRACK JUMP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRACK_JUMP
	 * @model literal="/live/track/jump"
	 * @generated
	 * @ordered
	 */
	public static final int TRACK_JUMP_VALUE = 40;

	/**
	 * The '<em><b>TRACK INFO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRACK INFO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRACK_INFO
	 * @model literal="/live/track/info"
	 * @generated
	 * @ordered
	 */
	public static final int TRACK_INFO_VALUE = 41;

	/**
	 * The '<em><b>TRACK VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRACK VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRACK_VIEW
	 * @model literal="/live/track/view"
	 * @generated
	 * @ordered
	 */
	public static final int TRACK_VIEW_VALUE = 42;

	/**
	 * The '<em><b>RETURN VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_VIEW
	 * @model literal="/live/return/view"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VIEW_VALUE = 43;

	/**
	 * The '<em><b>MASTER VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASTER VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASTER_VIEW
	 * @model literal="/live/master/view"
	 * @generated
	 * @ordered
	 */
	public static final int MASTER_VIEW_VALUE = 44;

	/**
	 * The '<em><b>TRACK DEVICE VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRACK DEVICE VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRACK_DEVICE_VIEW
	 * @model literal="/live/track/device/view"
	 * @generated
	 * @ordered
	 */
	public static final int TRACK_DEVICE_VIEW_VALUE = 45;

	/**
	 * The '<em><b>RETURN DEVICE VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RETURN DEVICE VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_DEVICE_VIEW
	 * @model literal="/live/return/device/view"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_DEVICE_VIEW_VALUE = 46;

	/**
	 * The '<em><b>MASTER DEVICE VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASTER DEVICE VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASTER_DEVICE_VIEW
	 * @model literal="/live/master/device/view"
	 * @generated
	 * @ordered
	 */
	public static final int MASTER_DEVICE_VIEW_VALUE = 47;

	/**
	 * An array of all the '<em><b>ABLETON OSC MAPPING</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ABLETON_OSC_MAPPING[] VALUES_ARRAY =
		new ABLETON_OSC_MAPPING[] {
			MASTER_PAN,
			MASTER_VOLUME,
			TEMPO,
			TIME,
			OVERDUB,
			STATE,
			UNDO,
			REDO,
			NEXT_CUE,
			PREV_CUE,
			PLAY,
			PLAY_CONTINUE,
			PLAY_SELECTION,
			PLAY_CLIP,
			PLAY_CLIPSLOT,
			PLAY_SCENE,
			STOP,
			STOP_CLIP,
			STOP_TRACK,
			SCENES,
			TRACKS,
			SCENE,
			NAME_SCENE,
			NAME_SCENEBLOCK,
			NAME_TRACK,
			NAME_TRACKBLOCK,
			NAME_CLIP,
			NAME_CLIPBLOCK,
			ARM,
			MUTE,
			SOLO,
			VOLUME,
			PAN,
			SEND,
			PITCH,
			RETURN_MUTE,
			RETURN_SOLO,
			RETURN_VOLUME,
			RETURN_PAN,
			RETURN_SEND,
			TRACK_JUMP,
			TRACK_INFO,
			TRACK_VIEW,
			RETURN_VIEW,
			MASTER_VIEW,
			TRACK_DEVICE_VIEW,
			RETURN_DEVICE_VIEW,
			MASTER_DEVICE_VIEW,
		};

	/**
	 * A public read-only list of all the '<em><b>ABLETON OSC MAPPING</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ABLETON_OSC_MAPPING> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ABLETON OSC MAPPING</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ABLETON_OSC_MAPPING get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ABLETON_OSC_MAPPING result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ABLETON OSC MAPPING</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ABLETON_OSC_MAPPING getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ABLETON_OSC_MAPPING result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ABLETON OSC MAPPING</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ABLETON_OSC_MAPPING get(int value) {
		switch (value) {
			case MASTER_PAN_VALUE: return MASTER_PAN;
			case MASTER_VOLUME_VALUE: return MASTER_VOLUME;
			case TEMPO_VALUE: return TEMPO;
			case TIME_VALUE: return TIME;
			case OVERDUB_VALUE: return OVERDUB;
			case STATE_VALUE: return STATE;
			case UNDO_VALUE: return UNDO;
			case REDO_VALUE: return REDO;
			case NEXT_CUE_VALUE: return NEXT_CUE;
			case PREV_CUE_VALUE: return PREV_CUE;
			case PLAY_VALUE: return PLAY;
			case PLAY_CONTINUE_VALUE: return PLAY_CONTINUE;
			case PLAY_SELECTION_VALUE: return PLAY_SELECTION;
			case PLAY_CLIP_VALUE: return PLAY_CLIP;
			case PLAY_CLIPSLOT_VALUE: return PLAY_CLIPSLOT;
			case PLAY_SCENE_VALUE: return PLAY_SCENE;
			case STOP_VALUE: return STOP;
			case STOP_CLIP_VALUE: return STOP_CLIP;
			case STOP_TRACK_VALUE: return STOP_TRACK;
			case SCENES_VALUE: return SCENES;
			case TRACKS_VALUE: return TRACKS;
			case SCENE_VALUE: return SCENE;
			case NAME_SCENE_VALUE: return NAME_SCENE;
			case NAME_SCENEBLOCK_VALUE: return NAME_SCENEBLOCK;
			case NAME_TRACK_VALUE: return NAME_TRACK;
			case NAME_TRACKBLOCK_VALUE: return NAME_TRACKBLOCK;
			case NAME_CLIP_VALUE: return NAME_CLIP;
			case NAME_CLIPBLOCK_VALUE: return NAME_CLIPBLOCK;
			case ARM_VALUE: return ARM;
			case MUTE_VALUE: return MUTE;
			case SOLO_VALUE: return SOLO;
			case VOLUME_VALUE: return VOLUME;
			case PAN_VALUE: return PAN;
			case SEND_VALUE: return SEND;
			case PITCH_VALUE: return PITCH;
			case RETURN_MUTE_VALUE: return RETURN_MUTE;
			case RETURN_SOLO_VALUE: return RETURN_SOLO;
			case RETURN_VOLUME_VALUE: return RETURN_VOLUME;
			case RETURN_PAN_VALUE: return RETURN_PAN;
			case RETURN_SEND_VALUE: return RETURN_SEND;
			case TRACK_JUMP_VALUE: return TRACK_JUMP;
			case TRACK_INFO_VALUE: return TRACK_INFO;
			case TRACK_VIEW_VALUE: return TRACK_VIEW;
			case RETURN_VIEW_VALUE: return RETURN_VIEW;
			case MASTER_VIEW_VALUE: return MASTER_VIEW;
			case TRACK_DEVICE_VIEW_VALUE: return TRACK_DEVICE_VIEW;
			case RETURN_DEVICE_VIEW_VALUE: return RETURN_DEVICE_VIEW;
			case MASTER_DEVICE_VIEW_VALUE: return MASTER_DEVICE_VIEW;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ABLETON_OSC_MAPPING(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ABLETON_OSC_MAPPING
