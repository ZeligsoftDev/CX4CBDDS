/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.licensing;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.eclipse.osgi.util.NLS;

import com.zeligsoft.base.licensing.internal.l10n.Messages;

/**
 * Summary information about the licensing status of a feature.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class FeatureStatus {
	
	/** Expiry indicating an invalid feature. */
	public static int EXPIRY_INVALID = -2;

	/** Expiry indicating an expired feature. */
	public static int EXPIRY_EXPIRED = -1;
	
	/** Expiry indicating a feature expiring today. */
	public static int EXPIRY_TODAY = 0;
	
	/** Expiry indicating an expired feature. */
	public static int EXPIRY_NEVER = Integer.MAX_VALUE;
	
	
	/** Expiries indicating a permanent feature. */
	public static String RLM_PERMANENT = "permanent"; //$NON-NLS-1$
	
	public static String RLM_LICENSE = "RLM License"; //$NON-NLS-1$
	
	public static String FLEX_LICENSE = "FlexLM License"; //$NON-NLS-1$
	
	
	private final String feature;

	private int expiry;
	
	private String status;
	
	private String licenseType;
	
	@SuppressWarnings({ "serial", "nls", "static-access" })
	private static final HashMap<String, Integer> DATE_ABBREVIATIONS = 
		 new HashMap<String, Integer>() 
	        {
	            {
	                put("jan", GregorianCalendar.JANUARY); put("feb", GregorianCalendar.FEBRUARY); 
	                put("mar", GregorianCalendar.MARCH); put("apr", GregorianCalendar.APRIL);
	                put("may", GregorianCalendar.MAY); put("jun", GregorianCalendar.JUNE);
	                put("jul", GregorianCalendar.JULY); put("aug", GregorianCalendar.AUGUST);
	                put("sep", GregorianCalendar.SEPTEMBER); put("oct", GregorianCalendar.OCTOBER);
	                put("nov", GregorianCalendar.NOVEMBER); put("dec", GregorianCalendar.DECEMBER);
	            }
	        };

	/**
	 * Initializes me.
	 * 
	 * @param feature
	 *            the feature name
	 * @param expiry
	 *            the "days remaining" code from Flex
	 */
	public FeatureStatus(String feature, int expiry, String licType) {
		this.feature = feature;
		
		this.expiry = expiry;
		status = NLS.bind(Messages.FeatureStatus_days, expiry);
		
		this.licenseType = licType;
	}
	
	/*
	 * This is an additional constructor for RLM. RLM expiration and Flex
	 * expiration of licenses give different statuses and expiration
	 * times.  The modifier is currently only used to differentiate between the
	 * two constructors, so that once Flex is removed, we can simply use this
	 * constructor. 
	 */
	public FeatureStatus(String feature, String expiry, int isPermanent, String licType) {
		this.feature = feature;
		
		if (expiry.toLowerCase().contains(RLM_PERMANENT)) {
			this.expiry = EXPIRY_NEVER;
			status = Messages.FeatureStatus_permanent;
		} else {
			this.expiry = daysToExpiration(expiry);
			status = NLS.bind(Messages.FeatureStatus_days, this.expiry);
		}
		
		this.licenseType = licType;
	}
	
	/**
	 * Converts the date that RLM gives us and
	 * transfers into it days left
	 * 
	 * @param expiry
	 * @return
	 */
	private static int daysToExpiration(String expiry){
		String [] rlmDate = expiry.split("-"); //$NON-NLS-1$
		Calendar today = Calendar.getInstance(); //today's date
		
		//rlm gives us a three character abbreviation 
		//of the month, need to convert to integer
		Calendar licDate = new GregorianCalendar(Integer.parseInt(rlmDate[2]), DATE_ABBREVIATIONS.get(rlmDate[1]), 
				Integer.parseInt(rlmDate[0]));
		
		int daysBetween = 0;  
		while (today.before(licDate)) {  
		  today.add(Calendar.DAY_OF_MONTH, 1);  
		  daysBetween++;
		}  
		return daysBetween;  
	}

	/**
	 * Queries the feature that I summarize.
	 * 
	 * @return my feature
	 */
	public String getFeature() {
		return feature;
	}
	
	/**
	 * Returns the number of days remaining until the feature expires, or else
	 * one of the special values enumerated by this class.
	 * 
	 * @return the expiry of this feature
	 */
	public int getExpiry() {
		return expiry;
	}

	/**
	 * Queries the feature's licensing status.
	 * 
	 * @return my status
	 */
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "Feature(" + feature + ", " + status + ", " + licenseType + ")"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$
	}
	
}
