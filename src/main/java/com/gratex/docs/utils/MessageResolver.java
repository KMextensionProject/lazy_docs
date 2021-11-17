package com.gratex.docs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.gratex.docs.enums.Resources;

public final class MessageResolver {

	private static Properties properties = new Properties();

	static {
		try {
			InputStream iStream = MessageResolver.class.getClassLoader().getResourceAsStream(Resources.MESSAGES_MAP);
			properties.load(iStream);
		} catch (IOException readingFailure) {
			readingFailure.printStackTrace();
		}
	}

	public static String resolveMessage(String property, Object... messageArguments) {
		String message = properties.getProperty(property, property);
		if (messageArguments.length != 0) {
			message = insertArguments(message, messageArguments);
		}
		return message;
	}

	private static String insertArguments(String message, Object[] messageArguments) {
		for (int i = 0; i < messageArguments.length; i++) {
			message = message.replace("{" + i +"}", messageArguments[i].toString());
		}
		return message;
	}
}
