package org.acme.model;

import java.util.stream.Stream;
import org.acme.device.IPhysicalDevice;

public interface ICamera extends IPhysicalDevice {

    Stream getStream();

    byte[] getFrame(int position);
}
