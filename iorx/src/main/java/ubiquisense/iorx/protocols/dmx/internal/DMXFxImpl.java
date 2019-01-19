/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ubiquisense.iorx.protocols.dmx.internal;

public class DMXFxImpl  implements DMXFx {
	protected static final DMXfixtureMotion MOTION_EDEFAULT = DMXfixtureMotion.CIRCLE;
	protected DMXfixtureMotion motion = MOTION_EDEFAULT;
	protected static final DMXFixtureBehavior BEHAVIOR_EDEFAULT = DMXFixtureBehavior.LOOP;
	protected DMXFixtureBehavior behavior = BEHAVIOR_EDEFAULT;

	protected DMXFxImpl() {
		super();
	}

	public DMXfixtureMotion getMotion() {
		return motion;
	}

	public void setMotion(DMXfixtureMotion newMotion) {
		DMXfixtureMotion oldMotion = motion;
		motion = newMotion == null ? MOTION_EDEFAULT : newMotion;
	}

	public DMXFixtureBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(DMXFixtureBehavior newBehavior) {
		DMXFixtureBehavior oldBehavior = behavior;
		behavior = newBehavior == null ? BEHAVIOR_EDEFAULT : newBehavior;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (motion: ");
		result.append(motion);
		result.append(", behavior: ");
		result.append(behavior);
		result.append(')');
		return result.toString();
	}

} //DMXFxImpl
