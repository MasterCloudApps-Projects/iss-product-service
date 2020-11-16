package es.urjc.code.products.infrastructure.adapter.controller;

import org.testcontainers.containers.GenericContainer;

public class MongoDbContainer extends GenericContainer<MongoDbContainer> {

	public static final String DEFAULT_IMAGE_AND_TAG = "mongo:4.2.6";
	public static final int DEFAULT_PORT = 27017;

	public MongoDbContainer() {
		super(DEFAULT_IMAGE_AND_TAG);
		this.addExposedPort(DEFAULT_PORT);
	}

	public String getUri() {
		final String ip = this.getContainerIpAddress();
		final Integer port = this.getMappedPort(DEFAULT_PORT);
		return String.format("mongodb://%s:%s/test", ip, port);
	}

}
