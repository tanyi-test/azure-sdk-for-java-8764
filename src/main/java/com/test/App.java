package com.test;

import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.costmanagement.v2018_05_31.implementation.CostManagementManager;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));

        ApplicationTokenCredentials credentials = ApplicationTokenCredentials.fromFile(credFile);

        CostManagementManager manager = CostManagementManager.authenticate(credentials, credentials.defaultSubscriptionId());
        manager.subscriptionDimensions().listAsync().toBlocking().last();
    }
}
