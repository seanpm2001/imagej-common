/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2015 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
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
package net.imagej.converters;

import net.imglib2.Dimensions;
import net.imglib2.FinalInterval;

import org.scijava.convert.AbstractConverter;
import org.scijava.convert.ConversionRequest;
import org.scijava.plugin.Plugin;

/**
 * Converter from native int[] array to Dimensions
 * 
 * Christian Dietz, University of Konstanz
 */
@Plugin(type = ConvertLongArrayToDimensions.class)
public class ConvertIntArrayToFinalInterval extends
		AbstractConverter<int[], FinalInterval> implements
		ConvertIntArrayToDimensions<FinalInterval> {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object src, Class<T> dest) {
		final int[] in = (int[]) src;
		final long[] out = new long[in.length];
		
		for(int i = 0; i < in.length; i++){
			out[i] = in[i];
		}
		
		return (T) new FinalInterval(out);
	}

	@Override
	public Class<FinalInterval> getOutputType() {
		return FinalInterval.class;
	}

	@Override
	public Class<int[]> getInputType() {
		return int[].class;
	}

	@Override
	public boolean canConvert(Object src, Class<?> dest) {
		return canConvert(new ConversionRequest(src.getClass(), dest));
	}

	@Override
	public boolean canConvert(ConversionRequest req) {
		return supports(req);
	}

	@Override
	public boolean supports(ConversionRequest request) {
		return request.sourceClass() == int[].class
				&& Dimensions.class.isAssignableFrom(request.destClass());
	}
}
