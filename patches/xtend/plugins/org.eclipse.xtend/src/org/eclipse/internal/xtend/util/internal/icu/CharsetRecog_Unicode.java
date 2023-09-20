package org.eclipse.internal.xtend.util.internal.icu;
/**
This code was taken from the com.ibm.icu library (3.6.1). We needed to copy it to have not 
a dependency to this large library only the need of charset recognition.
(KTH 2007-07-30)

The com.ibm.icu library is published under Eclipse Public License V1.0.
 */

/*
 *******************************************************************************
 * Copyright (C) 1996-2006, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 *
 */

/**
 * This class matches UTF-16 and UTF-32, both big- and little-endian. The
 * BOM will be used if it is present.
 * 
 * @internal
 */
abstract class CharsetRecog_Unicode extends CharsetRecognizer {

    /* (non-Javadoc)
     * @see com.ibm.icu.text.CharsetRecognizer#getName()
     */
    abstract String getName();

    /* (non-Javadoc)
     * @see com.ibm.icu.text.CharsetRecognizer#match(com.ibm.icu.text.CharsetDetector)
     */
    abstract int match(CharsetDetector det);
    
    static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode
    {
        String getName()
        {
            return "UTF-16BE";
        }
        
        int match(CharsetDetector det)
        {
            byte[] input = det.fRawInput;
            
            if ((input[0] & 0xFF) == 0xFE && (input[1] & 0xFF) == 0xFF) {
                return 100;
            }
            
            // TODO: Do some statastics to check for unsigned UTF-16BE
            return 0;
        }
    }
    
    static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode
    {
        String getName()
        {
            return "UTF-16LE";
        }
        
        int match(CharsetDetector det)
        {
            byte[] input = det.fRawInput;
            
            if ((input[0] & 0xFF) == 0xFF && (input[1] & 0xFF) == 0xFE && (input[2] != 0x00 || input[3] != 0x00)) {
                return 100;
            }
            
            // TODO: Do some statastics to check for unsigned UTF-16LE
            return 0;
        }
    }
    
    static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode
    {
        abstract int getChar(byte[] input, int index);
        
        abstract String getName();
        
        int match(CharsetDetector det)
        {
            byte[] input   = det.fRawInput;
            int limit      = (det.fRawLength / 4) * 4;
            int numValid   = 0;
            int numInvalid = 0;
            boolean hasBOM = false;
            int confidence = 0;
            
            if (getChar(input, 0) == 0x0000FEFF) {
                hasBOM = true;
            }
            
            for(int i = 0; i < limit; i += 4) {
                int ch = getChar(input, i);
                
                if (ch < 0 || ch >= 0x10FFFF || (ch >= 0xD800 && ch <= 0xDFFF)) {
                    numInvalid += 1;
                } else {
                    numValid += 1;
                }
            }
            
            
            // Cook up some sort of confidence score, based on presense of a BOM
            //    and the existence of valid and/or invalid multi-byte sequences.
            if (hasBOM && numInvalid==0) {
                confidence = 100;
            } else if (hasBOM && numValid > numInvalid*10) {
                confidence = 80;
            } else if (numValid > 3 && numInvalid == 0) {
                confidence = 100;            
            } else if (numValid > 0 && numInvalid == 0) {
                confidence = 80;
            } else if (numValid > numInvalid*10) {
                // Probably corruput UTF-32BE data.  Valid sequences aren't likely by chance.
                confidence = 25;
            }
            
            return confidence;
        }
    }
    
    static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32
    {
        int getChar(byte[] input, int index)
        {
            return (input[index + 0] & 0xFF) << 24 | (input[index + 1] & 0xFF) << 16 |
                   (input[index + 2] & 0xFF) <<  8 | (input[index + 3] & 0xFF);
        }
        
        String getName()
        {
            return "UTF-32BE";
        }
    }

    
    static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32
    {
        int getChar(byte[] input, int index)
        {
            return (input[index + 3] & 0xFF) << 24 | (input[index + 2] & 0xFF) << 16 |
                   (input[index + 1] & 0xFF) <<  8 | (input[index + 0] & 0xFF);
        }
        
        String getName()
        {
            return "UTF-32LE";
        }
    }
}
