package org.acme.device;

public interface IPhysicalDevice extends IDevice {

    String getFirmwareVersion();

    String getHardwareVersion();

    String getModel();

    String getBrand();

    boolean reboot();
}
