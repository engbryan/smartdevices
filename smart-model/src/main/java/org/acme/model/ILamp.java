package org.acme.model;

import org.acme.device.IPhysicalDevice;

public interface ILamp extends IPhysicalDevice {

    boolean on();

    boolean off();
}
