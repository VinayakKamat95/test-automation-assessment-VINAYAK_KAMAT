package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.HrmTestData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class TestDataProvider {

    @DataProvider
    public static Object[][] getCredentialsFromTest() {
        return new Object[][]{
                {"user1", "demouserpwd", "Sofia O'Sullivan","EMP003"},
                {"user2", "demouserpwd", "Taylor Holmes","EMP003"}
        };
    }

    @DataProvider(name = "getCredentialsFromJson")
    public static Object[][] getCredentialsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        final String testDataFilePath = System.getProperty("user.dir") + "/src/test/resources/hrms-test-data.json";
        File testDataFile = new File(testDataFilePath);
        final HrmTestData[] hrmTestData = objectMapper.readValue(testDataFile, HrmTestData[].class);
        final Object[][] objects = new Object[hrmTestData.length][4];
        for (int i = 0; i < hrmTestData.length; i++) {
            objects[i][0] = hrmTestData[i].getUsername();
            objects[i][1] = hrmTestData[i].getPassword();
            objects[i][2] = hrmTestData[i].getExpectedFullName();
            objects[i][3] = hrmTestData[i].getEmployeeNumber();
        }
        return objects;
    }

    @DataProvider(name = "getAdminCredentialsFromJson")
    public static Object[][] getAdminCredentialsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        final String testDataFilePath = System.getProperty("user.dir") + "/src/test/resources/hrms-test-data-admin.json";
        File testDataFile = new File(testDataFilePath);
        final HrmTestData[] hrmTestData = objectMapper.readValue(testDataFile, HrmTestData[].class);
        final Object[][] objects = new Object[hrmTestData.length][2];
        for (int i = 0; i < hrmTestData.length; i++) {
            objects[i][0] = hrmTestData[i].getUsername();
            objects[i][1] = hrmTestData[i].getPassword();
        }
        return objects;
    }
}
