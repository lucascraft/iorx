package ubiquisense.iorx.ui.fx.fiducial;

/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.sg.prism.NGCircle;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.javafx.tk.Toolkit;
import com.sun.javafx.util.Utils;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

/**
 * The {@code Circle} class creates a new circle
 * with the specified radius and center location measured in pixels
 *
 * Example usage. The following code creates a circle with radius 50px centered
 * at (100,100)px.
 *
<PRE>
import javafx.scene.shape.*;

Circle circle = new Circle();
circle.setCenterX(100.0f);
circle.setCenterY(100.0f);
circle.setRadius(50.0f);
}
</PRE>
 * @since JavaFX 2.0
 */
public class MTCircle extends Shape {

    private final FiducialEllipse2D shape = new FiducialEllipse2D();

	

    
    /**
     * Creates a new instance of Circle with a specified radius.
     * @param radius the radius of the circle in pixels
     */
    public MTCircle(double radius) {
    	this();
    	setRadius(radius);
    }

    /**
     * Creates a new instance of Circle with a specified radius and fill.
     * @param radius the radius of the circle
     * @param fill determines how to fill the interior of the Circle
     */
    public MTCircle(double radius, Paint fill) {
    	this();
        setRadius(radius);
        setFill(fill);
    }

    /**
     * Creates an empty instance of Circle.
     */
    public MTCircle() {
     }

    /**
     * Creates a new instance of Circle with a specified position and radius.
     * @param centerX the horizontal position of the center of the circle in pixels
     * @param centerY the vertical position of the center of the circle in pixels
     * @param radius the radius of the circle in pixels
     */
    public MTCircle(double centerX, double centerY, double radius) {
    	this();
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    /**
     * Creates a new instance of Circle with a specified position, radius and fill.
     * @param centerX the horizontal position of the center of the circle in pixels
     * @param centerY the vertical position of the center of the circle in pixels
     * @param radius the radius of the circle in pixels
     * @param fill determines how to fill the interior of the Circle
     */
    public MTCircle(double centerX, double centerY, double radius, Paint fill) {
    	this();
    	setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
        setFill(fill);
    }

    /**
     * Defines the horizontal position of the center of the circle in pixels.
     *
     * @defaultValue 0.0
     */
    private DoubleProperty centerX;



    public final void setCenterX(double value) {
        if (centerX != null || value != 0.0) {
            centerXProperty().set(value);
        }
    }

    public final double getCenterX() {
        return centerX == null ? 0.0 : centerX.get();
    }

    public final DoubleProperty centerXProperty() {
        if (centerX == null) {
            centerX = new DoublePropertyBase(0.0) {

                @Override
                public void invalidated() {
                    impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    impl_geomChanged();
                }

                @Override
                public Object getBean() {
                    return MTCircle.this;
                }

                @Override
                public String getName() {
                    return "centerX";
                }
            };
        }
        return centerX;
    }

    /**
     * Defines the vertical position of the center of the circle in pixels.
     *
     * @defaultValue 0.0
     */
    private DoubleProperty centerY;



    public final void setCenterY(double value) {
        if (centerY != null || value != 0.0) {
            centerYProperty().set(value);
        }
    }

    public final double getCenterY() {
        return centerY == null ? 0.0 : centerY.get();
    }

    public final DoubleProperty centerYProperty() {
        if (centerY == null) {
            centerY = new DoublePropertyBase(0.0) {

                @Override
                public void invalidated() {
                    impl_markDirty(DirtyBits.NODE_GEOMETRY);
                    impl_geomChanged();
                }

                @Override
                public Object getBean() {
                    return MTCircle.this;
                }

                @Override
                public String getName() {
                    return "centerY";
                }
            };
        }
        return centerY;
    }

    /**
     * Defines the radius of the circle in pixels.
     *
     * @defaultValue 0.0
     */
    private final DoubleProperty radius = new DoublePropertyBase() {

        @Override
        public void invalidated() {
            impl_markDirty(DirtyBits.NODE_GEOMETRY);
            impl_geomChanged();
        }

        @Override
        public Object getBean() {
            return MTCircle.this;
        }

        @Override
        public String getName() {
            return "radius";
        }
    };

    public final void setRadius(double value) {
        radius.set(value);
    }

    public final double getRadius() {
        return radius.get();
    }

    public final DoubleProperty radiusProperty() {
        return radius;
    }

    /**
     */
   StrokeLineJoin convertLineJoin(StrokeLineJoin t) {
        // The MITER join style can produce anomalous results for very thin or
        // very wide ellipses when the bezier curves that approximate the arcs
        // become so distorted that they shoot out MITER-like extensions.  This
        // effect complicates matters because it makes the circles very non-round,
        // and also because it means we might have to pad the bounds to account
        // for this rare and unpredictable circumstance.
        // To avoid the problem, we set the Join style to BEVEL for any
        // circle.  The BEVEL join style is more predictable for
        // anomalous angles and is the simplest join style to compute in
        // the stroking code.
        // These problems do not necessarily happen for circles which have a
        // fixed and balanced aspect ratio, but why waste time computing a
        // conversion of a MITER join style when it has no advantage for
        // circles and technically requires more computation?
        return StrokeLineJoin.BEVEL;
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override protected NGNode impl_createPeer() {
        return new NGFiducial();
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        // if there is no fill or stroke, then there are no bounds. The bounds
        // must be marked empty in this case to distinguish it from 0,0,0,0
        // which would actually contribute to the bounds of a group.
        if (impl_mode == NGShape.Mode.EMPTY) {
            return bounds.makeEmpty();
        }

        final double cX = getCenterX();
        final double cY = getCenterY();

        if ((tx.getType() & ~(BaseTransform.TYPE_MASK_ROTATION | BaseTransform.TYPE_TRANSLATION)) == 0) {

            double tCX = cX * tx.getMxx() + cY * tx.getMxy() + tx.getMxt();
            double tCY = cX * tx.getMyx() + cY * tx.getMyy() + tx.getMyt();
            double r = getRadius();

            if (impl_mode != NGShape.Mode.FILL && getStrokeType() != StrokeType.INSIDE) {
                double upad = getStrokeWidth();
                if (getStrokeType() == StrokeType.CENTERED) {
                    upad /= 2.0f;
                }
                r += upad;
            }

            return bounds.deriveWithNewBounds((float) (tCX - r), (float) (tCY - r), 0,
                    (float) (tCX + r), (float) (tCY + r), 0);
        } else if ((tx.getType() & ~(BaseTransform.TYPE_MASK_SCALE | BaseTransform.TYPE_TRANSLATION | BaseTransform.TYPE_FLIP)) == 0) {
            final double r = getRadius();
            final double x = getCenterX() - r;
            final double y = getCenterY() - r;
            final double width = 2.0 * r;
            final double height = width;
            double upad;
            if (impl_mode == NGShape.Mode.FILL || getStrokeType() == StrokeType.INSIDE) {
                upad = 0.0f;
            } else {
                upad = getStrokeWidth();
            }
            return computeBounds(bounds, tx, upad, 0, x, y, width, height);
        }

        return computeShapeBounds(bounds, tx, impl_configShape());
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override public Ellipse2D impl_configShape() {
        double r = getRadius();
        shape.setFrame(
            (float)(getCenterX() - r), // x
            (float)(getCenterY() - r), // y
            (float)(r * 2.0), // w
            (float)(r * 2.0)); // h
        return shape;
    }
    /**
     * Helper function for rectangular shapes such as Rectangle and Ellipse
     * for computing their bounds.
     */
    BaseBounds computeBounds(BaseBounds bounds, BaseTransform tx,
                                   double upad, double dpad,
                                   double x, double y,
                                   double w, double h)
    {
        // if the w or h is < 0 then bounds is empty
        if (w < 0.0f || h < 0.0f) return bounds.makeEmpty();

        double x0 = x;
        double y0 = y;
        double x1 = w;
        double y1 = h;
        double _dpad = dpad;
        if (tx.isTranslateOrIdentity()) {
            x1 += x0;
            y1 += y0;
            if (tx.getType() == BaseTransform.TYPE_TRANSLATION) {
                final double dx = tx.getMxt();
                final double dy = tx.getMyt();
                x0 += dx;
                y0 += dy;
                x1 += dx;
                y1 += dy;
            }
            _dpad += upad;
        } else {
            x0 -= upad;
            y0 -= upad;
            x1 += upad*2;
            y1 += upad*2;
            // Each corner is transformed by an equation similar to:
            //     x' = x * mxx + y * mxy + mxt
            //     y' = x * myx + y * myy + myt
            // Since all of the corners are translated by mxt,myt we
            // can ignore them when doing the min/max calculations
            // and add them in once when we are done.  We then have
            // to do min/max operations on 4 points defined as:
            //     x' = x * mxx + y * mxy
            //     y' = x * myx + y * myy
            // Furthermore, the four corners that we will be transforming
            // are not four independent coordinates, they are in a
            // rectangular formation.  To that end, if we translated
            // the transform to x,y and scaled it by width,height then
            // we could compute the min/max of the unit rectangle 0,0,1x1.
            // The transform would then be adjusted as follows:
            // First, the translation to x,y only affects the mxt,myt
            // components of the transform which we can hold off on adding
            // until we are done with the min/max.  The adjusted translation
            // components would be:
            //     mxt' = x * mxx + y * mxy + mxt
            //     myt' = x * myx + y * myy + myt
            // Second, the scale affects the components as follows:
            //     mxx' = mxx * width
            //     mxy' = mxy * height
            //     myx' = myx * width
            //     myy' = myy * height
            // The min/max of that rectangle then degenerates to:
            //     x00' = 0 * mxx' + 0 * mxy' = 0
            //     y00' = 0 * myx' + 0 * myy' = 0
            //     x01' = 0 * mxx' + 1 * mxy' = mxy'
            //     y01' = 0 * myx' + 1 * myy' = myy'
            //     x10' = 1 * mxx' + 0 * mxy' = mxx'
            //     y10' = 1 * myx' + 0 * myy' = myx'
            //     x11' = 1 * mxx' + 1 * mxy' = mxx' + mxy'
            //     y11' = 1 * myx' + 1 * myy' = myx' + myy'
            double mxx = tx.getMxx();
            double mxy = tx.getMxy();
            double myx = tx.getMyx();
            double myy = tx.getMyy();
            // Computed translated translation components
            final double mxt = (x0 * mxx + y0 * mxy + tx.getMxt());
            final double myt = (x0 * myx + y0 * myy + tx.getMyt());
            // Scale non-translation components by w/h
            mxx *= x1;
            mxy *= y1;
            myx *= x1;
            myy *= y1;
            x0 = (Math.min(Math.min(0,mxx),Math.min(mxy,mxx+mxy)))+mxt;
            y0 = (Math.min(Math.min(0,myx),Math.min(myy,myx+myy)))+myt;
            x1 = (Math.max(Math.max(0,mxx),Math.max(mxy,mxx+mxy)))+mxt;
            y1 = (Math.max(Math.max(0,myx),Math.max(myy,myx+myy)))+myt;
        }
        x0 -= _dpad;
        y0 -= _dpad;
        x1 += _dpad;
        y1 += _dpad;

        bounds = bounds.deriveWithNewBounds((float)x0, (float)y0, 0.0f,
                (float)x1, (float)y1, 0.0f);
        return bounds;
    }
    BaseBounds computeShapeBounds(BaseBounds bounds, BaseTransform tx,
            com.sun.javafx.geom.Shape s)
{
// empty mode means no bounds!
if (impl_mode == NGShape.Mode.EMPTY) {
return bounds.makeEmpty();
}

float[] bbox = {
Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY,
};
boolean includeShape = (impl_mode != NGShape.Mode.STROKE);
boolean includeStroke = (impl_mode != NGShape.Mode.FILL);
if (includeStroke && (getStrokeType() == StrokeType.INSIDE)) {
includeShape = true;
includeStroke = false;
}

if (includeStroke) {
final StrokeType type = getStrokeType();
double sw = Utils.clampMin(getStrokeWidth(), 0.0);
StrokeLineCap cap = getStrokeLineCap();
StrokeLineJoin join = convertLineJoin(getStrokeLineJoin());
float miterlimit =
(float) Utils.clampMin(getStrokeMiterLimit(), 1.0);
// Note that we ignore dashing for computing bounds and testing
// point containment, both to save time in bounds calculations
// and so that animated dashing does not keep perturbing the bounds...
Toolkit.getToolkit().accumulateStrokeBounds(
s,
bbox, type, sw,
cap, join, miterlimit, tx);
// Account for "minimum pen size" by expanding by 0.5 device
// pixels all around...
bbox[0] -= 0.5;
bbox[1] -= 0.5;
bbox[2] += 0.5;
bbox[3] += 0.5;
} else if (includeShape) {
com.sun.javafx.geom.Shape.accumulate(bbox, s, tx);
}

if (bbox[2] < bbox[0] || bbox[3] < bbox[1]) {
// They are probably +/-INFINITY which would yield NaN if subtracted
// Let's just return a "safe" empty bbox..
return bounds.makeEmpty();
}
bounds = bounds.deriveWithNewBounds(bbox[0], bbox[1], 0.0f,
bbox[2], bbox[3], 0.0f);
return bounds;
}

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    @Override public void impl_updatePeer() {
        super.impl_updatePeer();

        if (impl_isDirty(DirtyBits.NODE_GEOMETRY)) {
            final NGFiducial peer = (NGFiducial) impl_getPeer();
            peer.updateCircle((float)getCenterX(),
                (float)getCenterY(),
                (float)getRadius());
        }
    }



    /**
     * Returns a string representation of this {@code Circle} object.
     * @return a string representation of this {@code Circle} object.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle[");

        String id = getId();
        if (id != null) {
            sb.append("id=").append(id).append(", ");
        }

        sb.append("centerX=").append(getCenterX());
        sb.append(", centerY=").append(getCenterY());
        sb.append(", radius=").append(getRadius());

        sb.append(", fill=").append(getFill());

        Paint stroke = getStroke();
        if (stroke != null) {
            sb.append(", stroke=").append(stroke);
            sb.append(", strokeWidth=").append(getStrokeWidth());
        }

        return sb.append("]").toString();
    }
}

