package com.andrewsdosreis.rockpaperscissors.exception.handler;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorHandler {

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private String method;

	public ErrorHandler() {
	}

	public ErrorHandler(Long timestamp, Integer status, String error, String message, String path, String method) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.method = method;
	}

	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ErrorHandler timestamp(Long timestamp) {
		setTimestamp(timestamp);
		return this;
	}

	public ErrorHandler status(Integer status) {
		setStatus(status);
		return this;
	}

	public ErrorHandler error(String error) {
		setError(error);
		return this;
	}

	public ErrorHandler message(String message) {
		setMessage(message);
		return this;
	}

	public ErrorHandler path(String path) {
		setPath(path);
		return this;
	}

	public ErrorHandler method(String method) {
		setMethod(method);
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
