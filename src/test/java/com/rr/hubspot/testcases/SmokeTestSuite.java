package com.rr.hubspot.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        LogIn.class, //+
        SignOut.class,//+

        CreateNewContact.class, //+
        ChangeContactEmail.class, //+

        CreateNewCompany.class, //+
        AddCityToCompany.class, //+
        AssociateContactWithCompany.class, //+
        //AddNotesToCompany.class, //-

        RemoveNewContact.class, //+
        RemoveNewCompany.class //+
        })

public class SmokeTestSuite {
}
