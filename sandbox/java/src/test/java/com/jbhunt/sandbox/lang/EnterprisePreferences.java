package com.jbhunt.sandbox.lang;

import com.jbhunt.biz.auditinfohelpers.HardCodedAuditInfoCallback;
import com.jbhunt.wsc.preferences.sunspi.JBHPreferencesFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.prefs.Preferences;

import static org.junit.Assert.assertEquals;

public class EnterprisePreferences {
    @Before
    public void setUp() throws Exception {
        System.setProperty("runtime.environment", "TEST");
    }

    @Test
    public void enterprisePreferencesTest() {
        JBHPreferencesFactory prefsFactory = JBHPreferencesFactory.buildDefaultPreferencesFactory(new HardCodedAuditInfoCallback("test", "jisatd1"));
        Preferences prefs =  prefsFactory.getUserRoot("jisatd1").node("trucksOnAMap/searchCriteria");
        prefs.put("defaultFleetCode", "TEST"); // DCS LASH64
        assertEquals("TEST", prefs.get("defaultFleetCode", null));
    }
}
