/*
 * #%L
 * ImageJ2 software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2022 ImageJ2 developers.
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

package net.imagej.types;

import java.math.BigDecimal;

import net.imglib2.type.numeric.integer.ByteType;

import org.scijava.AbstractContextual;
import org.scijava.plugin.Plugin;

/**
 * {@link DataType} definition for 8-bit signed integers.
 * 
 * @author Barry DeZonia
 */
@Plugin(type = DataType.class)
public class DataType8BitSignedInteger extends AbstractContextual implements
	DataType<ByteType>
{

	private final ByteType type = new ByteType();

	@Override
	public ByteType getType() {
		return type;
	}

	@Override
	public String shortName() {
		return "8-bit int";
	}

	@Override
	public String longName() {
		return "8-bit signed integer";
	}

	@Override
	public String description() {
		return "An integer data type ranging between " + Byte.MIN_VALUE + " and " +
			Byte.MAX_VALUE;
	}

	@Override
	public boolean isComplex() {
		return false;
	}

	@Override
	public boolean isFloat() {
		return false;
	}

	@Override
	public boolean isSigned() {
		return true;
	}

	@Override
	public boolean isBounded() {
		return true;
	}

	@Override
	public void lowerBound(ByteType dest) {
		dest.set(Byte.MIN_VALUE);
	}

	@Override
	public void upperBound(ByteType dest) {
		dest.set(Byte.MAX_VALUE);
	}

	@Override
	public int bitCount() {
		return 8;
	}

	@Override
	public ByteType createVariable() {
		return new ByteType();
	}

	@Override
	public void cast(ByteType val, BigComplex dest) {
		dest.setReal(val.get());
		dest.setImag(BigDecimal.ZERO);
	}

	@Override
	public void cast(BigComplex val, ByteType dest) {
		setLong(dest, val.getReal().longValue());
	}

	@Override
	public boolean hasDoubleRepresentation() {
		return true;
	}

	@Override
	public boolean hasLongRepresentation() {
		return true;
	}

	@Override
	public double asDouble(ByteType val) {
		return val.get();
	}

	@Override
	public long asLong(ByteType val) {
		return val.get();
	}

	@Override
	public void setDouble(ByteType val, double v) {
		setLong(val, (long) v);
	}

	@Override
	public void setLong(ByteType val, long v) {
		if (v < Byte.MIN_VALUE) val.set(Byte.MIN_VALUE);
		else if (v > Byte.MAX_VALUE) val.set(Byte.MAX_VALUE);
		else val.set((byte) v);
	}

}
