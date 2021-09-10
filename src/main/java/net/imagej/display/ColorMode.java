/*
 * #%L
 * ImageJ2 software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2021 ImageJ2 developers.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.display;

import java.util.Hashtable;

/**
 * The mode to use to display data in a view.
 * 
 * @author Barry DeZonia
 * @author Curtis Rueden
 */
public enum ColorMode {
	COLOR("Color"), COMPOSITE("Composite"), GRAYSCALE("Grayscale");

	private static Hashtable<String, ColorMode> colorModes =
		new Hashtable<>();

	static {
		for (final ColorMode colorMode : ColorMode.values()) {
			colorModes.put(colorMode.getLabel(), colorMode);
		}
	}

	public static ColorMode get(final String label) {
		return colorModes.get(label);
	}

	public static String[] getLabels() {
		return colorModes.keySet().toArray(new String[0]);
	}

	private String label;

	private ColorMode(final String label) {
		this.label = label;
	}

	// -- ColorMode methods --

	public String getLabel() {
		return label;
	}

	// -- Object methods --

	@Override
	public String toString() {
		return label;
	}

}
