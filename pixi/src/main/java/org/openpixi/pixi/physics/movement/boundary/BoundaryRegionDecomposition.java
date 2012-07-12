package org.openpixi.pixi.physics.movement.boundary;

import org.openpixi.pixi.physics.util.DoubleBox;

/**
 * Identifies different boundary regions of the simulation area.
 */
public class BoundaryRegionDecomposition {

	/*
	 * Specific boundary is specified by the combination of X and Y values.
	 * E.g. top-left is XMIN + YMIN.
	 */

	public static final int XMIN = 0;
	public static final int XCENTER = 1;
	public static final int XMAX = 2;
	public static final int YMIN = 0;
	public static final int YCENTER = 3;
	public static final int YMAX = 6;

	/** Regions which share an edge with the simulation area. */
	public static int[] EDGE_REGIONS = {
			XMIN + YCENTER,
			XMAX + YCENTER,
			YMIN + XCENTER,
			YMAX + XCENTER
	};
	/** Regions which share a corner with the simulation area. */
	public static int[] CORNER_REGIONS = {
			XMIN + YMIN,
			XMAX + YMIN,
			XMIN + YMAX,
			XMAX + YMAX
	};

	/** Box around the simulation area. */
	DoubleBox simulationArea;

	public BoundaryRegionDecomposition(DoubleBox simulationArea) {
		this.simulationArea = simulationArea;
	}

	public int getRegion(double x, double y) {
		int xidx;
		int yidx;

		if (x < simulationArea.xmin()) {
			xidx  = XMIN;
		} else if (x >= simulationArea.xmax()) {
			xidx = XMAX;
		} else {
			xidx = XCENTER;
		}

		if (y < simulationArea.ymin()) {
			yidx = YMIN;
		} else if (y >= simulationArea.ymax()) {
			yidx = YMAX;
		} else {
			yidx = YCENTER;
		}

		return xidx + yidx;
	}
}
