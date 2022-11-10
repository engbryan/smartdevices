package org.acme.feature;

public interface IService<T, R> extends IFeature<T, R> {

    String getReturnType();
}
