/*
 * Copyright (c) 2009, Harald Kuhr
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name "TwelveMonkeys" nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.twelvemonkeys.imageio.metadata.exif;

import com.twelvemonkeys.imageio.metadata.AbstractEntry;

/**
 * EXIFEntry
 *
 * @author <a href="mailto:harald.kuhr@gmail.com">Harald Kuhr</a>
 * @author last modified by $Author: haraldk$
 * @version $Id: EXIFEntry.java,v 1.0 Nov 13, 2009 5:47:35 PM haraldk Exp$
 */
final class EXIFEntry extends AbstractEntry {
    final private short type;

    EXIFEntry(final int identifier, final Object value, final short type) {
        super(identifier, value);

//        if (type < 1 || type > TIFF.TYPE_NAMES.length) {
//            throw new IllegalArgumentException(String.format("Illegal EXIF type: %s", type));
//        }
        
        this.type = type;
    }

    public short getType() {
        return type;
    }

    @Override
    public String getFieldName() {
        switch ((Integer) getIdentifier()) {
            case TIFF.TAG_EXIF_IFD:
                return "EXIF";
            case TIFF.TAG_XMP:
                return "XMP";
            case TIFF.TAG_IPTC:
                return "IPTC";
            case TIFF.TAG_PHOTOSHOP:
                return "Adobe";
            case TIFF.TAG_ICC_PROFILE:
                return "ICCProfile";

            case TIFF.TAG_IMAGE_WIDTH:
                return "ImageWidth";
            case TIFF.TAG_IMAGE_HEIGHT:
                return "ImageHeight";
            case TIFF.TAG_COMPRESSION:
                return "Compression";
            case TIFF.TAG_ORIENTATION:
                return "Orientation";
            case TIFF.TAG_X_RESOLUTION:
                return "XResolution";
            case TIFF.TAG_Y_RESOLUTION:
                return "YResolution";
            case TIFF.TAG_RESOLUTION_UNIT:
                return "ResolutionUnit";
            case TIFF.TAG_JPEG_INTERCHANGE_FORMAT:
                return "JPEGInterchangeFormat";
            case TIFF.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH:
                return "JPEGInterchangeFormatLength";
            case TIFF.TAG_MAKE:
                return "Make";
            case TIFF.TAG_MODEL:
                return "Model";
            case TIFF.TAG_SOFTWARE:
                return "Software";
            case TIFF.TAG_DATE_TIME:
                return "DateTime";
            case TIFF.TAG_ARTIST:
                return "Artist";
            case TIFF.TAG_HOST_COMPUTER:
                return "HostComputer";
            case TIFF.TAG_COPYRIGHT:
                return "Copyright";

            case EXIF.TAG_EXPOSURE_TIME:
                return "ExposureTime";
            case EXIF.TAG_F_NUMBER:
                return "FNUmber";
            case EXIF.TAG_EXPOSURE_PROGRAM:
                return "ExposureProgram";
            case EXIF.TAG_ISO_SPEED_RATINGS:
                return "ISOSpeedRatings";

            case EXIF.TAG_EXIF_VERSION:
                return "ExifVersion";
            case EXIF.TAG_DATE_TIME_ORIGINAL:
                return "DateTimeOriginal";
            case EXIF.TAG_DATE_TIME_DIGITIZED:
                return "DateTimeDigitized";
            case EXIF.TAG_IMAGE_NUMBER:
                return "ImageNumber";
            case EXIF.TAG_USER_COMMENT:
                return "UserComment";

            case EXIF.TAG_COLOR_SPACE:
                return "ColorSpace";
            case EXIF.TAG_PIXEL_X_DIMENSION:
                return "PixelXDimension";
            case EXIF.TAG_PIXEL_Y_DIMENSION:
                return "PixelYDimension";

            // TODO: More field names
        }

        return null;
    }

    @Override
    public String getTypeName() {
        return TIFF.TYPE_NAMES[type - 1];
    }
}
