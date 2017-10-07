package utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import config.Configration;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class InitialiseDriver {

        private DesiredCapabilities capabilities = new DesiredCapabilities();
        private static IOSDriver iosDriver = null;

//        private String appiumPort;
//        private String serverIp;

       
        public void setup(){
            initDriver();
        }
        


        private void initDriver(){
           
        		System.out.println("Inside initDriver method");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Configration.PLATFORM_NAME);
            capabilities.setCapability(MobileCapabilityType.APP, Configration.APP);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Configration.DEVICE_NAME);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Configration.AUTOMATION_NAME);
            capabilities.setCapability("noReset", Configration.NO_RESET);
            String serverUrl = "http://" + Configration.APPIUM_SERVER_IP + ":" + Configration.APPIUM_PORT + "/wd/hub";
          //  String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";

            try
            {
                System.out.println("Argument to driver object : " + serverUrl);
                iosDriver = new IOSDriver(new URL(serverUrl), capabilities);

            }
            catch (NullPointerException | MalformedURLException ex) {
                throw new RuntimeException("appium driver could not be initialised for device ");
            }
            System.out.println("Driver in initdriver is : "+iosDriver);

        }

 
        public void tearDown(){
        	iosDriver.quit();
        }

    }
