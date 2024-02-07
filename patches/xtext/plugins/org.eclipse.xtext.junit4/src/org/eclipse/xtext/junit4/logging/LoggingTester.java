/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.junit4.logging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Longs;

/**
 * @deprecated Use org.eclipse.xtext.testing.logging.LoggingTester instead
 */
@Deprecated(forRemoval = true)
public class LoggingTester {
	public static class LogCapture {
		private final List<LogEntry> logEntries;

		public void assertNoLogEntries() {
			assertNumberOfLogEntries(0);
		}

		public void assertLogEntry(String... messageParts) {
			assertNumberOfLogEntries(1, messageParts);
		}

		public void assertLogEntry(Level level, String... messageParts) {
			assertNumberOfLogEntries(1, level, messageParts);
		}

		public void assertNumberOfLogEntries(int number) {
			assertNumberOfLogEntries(number, new String[] {});
		}

		public void assertNumberOfLogEntries(int number, String... messageParts) {
			assertNumberOfLogEntries(number, null, messageParts);
		}

		public void assertNumberOfLogEntries(int number, Level level, String... messageParts) {
			Iterable<LogEntry> passed = 
					Iterables.filter(
							logEntries, 
							(LogEntry log) -> {
								return (level == null || Objects.equal(log.level, level)) 
										&& IterableExtensions
											.forall(messageParts == null ? null : Arrays.asList(messageParts), 
													(String it) -> log.message.contains(it));
							});
			if (Iterables.size(passed) != number) {
				StringConcatenation builder = new StringConcatenation();
				if (number == 0) {
					builder.append("Expected no log entries");
					builder.newLine();
				} else {
					if (number == 1) {
						builder.append("Expected a log entry");
						builder.newLine();
					} else {
						builder.append("Expected ");
						builder.append(number);
						builder.append(" log entries");
						builder.newLineIfNotEmpty();
					}
				}
				if (level != null) {
					builder.append("with ");
					builder.append(level);
					builder.append(" level");
					builder.newLineIfNotEmpty();
				}
				builder.append("containing the phrases ");
				builder.append(IterableExtensions.join(messageParts == null ? null : Arrays.asList(messageParts), ", ",
						(String it) -> "\"" + it + "\""));
				builder.newLineIfNotEmpty();
				builder.append("but got");
				builder.newLine();
				builder.append(logEntries);
				builder.newLineIfNotEmpty();
				Assert.fail(builder.toString());
			}
		}

		public LogCapture(List<LogEntry> logEntries) {
			this.logEntries = logEntries;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((logEntries == null) ? 0 : logEntries.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LogCapture other = (LogCapture) obj;
			if (logEntries == null) {
				if (other.logEntries != null)
					return false;
			} else if (!logEntries.equals(other.logEntries))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("logEntries", logEntries);
			return b.toString();
		}

		public List<LogEntry> getLogEntries() {
			return logEntries;
		}
	}

	public static class LogEntry {
		private final String message;

		private final String source;

		private final long timeStamp;

		private final Level level;

		public LogEntry(String message, String source, long timeStamp, Level level) {
			this.message = message;
			this.source = source;
			this.timeStamp = timeStamp;
			this.level = level;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((level == null) ? 0 : level.hashCode());
			result = prime * result + ((message == null) ? 0 : message.hashCode());
			result = prime * result + ((source == null) ? 0 : source.hashCode());
			result = prime * result + (int) (timeStamp ^ (timeStamp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LogEntry other = (LogEntry) obj;
			if (level == null) {
				if (other.level != null)
					return false;
			} else if (!level.equals(other.level))
				return false;
			if (message == null) {
				if (other.message != null)
					return false;
			} else if (!message.equals(other.message))
				return false;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			if (timeStamp != other.timeStamp)
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("message", message);
			b.add("source", source);
			b.add("timeStamp", timeStamp);
			b.add("level", level);
			return b.toString();
		}

		public String getMessage() {
			return message;
		}

		public String getSource() {
			return source;
		}

		public long getTimeStamp() {
			return timeStamp;
		}

		public Level getLevel() {
			return level;
		}
	}

	@Plugin(name = "QueueAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
	private static class QueueAppender extends AbstractAppender {
		
		public static final String NAME = "QueueAppender";

		private final Queue<LogEntry> events = new ConcurrentLinkedQueue<LogEntry>();

		@PluginFactory
		public static QueueAppender createAppender(@PluginAttribute("name") String name, 
				@PluginElement("Layout") Layout<? extends Serializable> layout,
				@PluginElement("Filter") Filter filter) {
			return new QueueAppender(name, filter, layout);
		}

		protected QueueAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
			super(name, filter, layout);
		}

		@Override
		public void append(LogEvent event) {
			LogEntry entry = new LogEntry(event.getMessage().getFormattedMessage(), event.getLoggerName(),
					event.getNanoTime(), event.getLevel());
			events.add(entry);
		}

		@SuppressWarnings("unused")
		public Queue<LogEntry> getEvents() {
			return events;
		}
	}

	private static class SourceFilter extends AbstractFilter {
		
		private final Logger source;

		@Override
		public Result filter(LogEvent event) {
			if (Objects.equal(event.getLoggerName(), source.getName())) {
				return Result.DENY;
			} else {
				return Result.NEUTRAL;
			}
		}

	    /**
	     * Appender Filter method. The default returns NEUTRAL.
	     * @param logger the Logger.
	     * @param level The logging Level.
	     * @param marker The Marker, if any.
	     * @param msg The message, if present.
	     * @param t A throwable or null.
	     * @return The Result of filtering.
	     */
	    @Override
	    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final Message msg,
	                         final Throwable t) {
			if (Objects.equal(logger.getName(), source.getName())) {
				return Result.DENY;
			} else {
				return Result.NEUTRAL;
			}
	    }

	    /**
	     * Appender Filter method. The default returns NEUTRAL.
	     * @param logger the Logger.
	     * @param level The logging Level.
	     * @param marker The Marker, if any.
	     * @param msg The message, if present.
	     * @param t A throwable or null.
	     * @return The Result of filtering.
	     */
	    @Override
	    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final Object msg,
	                         final Throwable t) {
			if (Objects.equal(logger.getName(), source.getName())) {
				return Result.DENY;
			} else {
				return Result.NEUTRAL;
			}
	    }

	    /**
	     * Appender Filter method. The default returns NEUTRAL.
	     * @param logger the Logger.
	     * @param level The logging Level.
	     * @param marker The Marker, if any.
	     * @param msg The message, if present.
	     * @param params An array of parameters or null.
	     * @return The Result of filtering.
	     */
	    @Override
	    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
	                         final Object... params) {
			if (Objects.equal(logger.getName(), source.getName())) {
				return Result.DENY;
			} else {
				return Result.NEUTRAL;
			}
	    }

		public SourceFilter(Logger source) {
			this.source = source;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((source == null) ? 0 : source.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SourceFilter other = (SourceFilter) obj;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).addAllFields().toString();
		}

		@SuppressWarnings("unused")
		public Logger getSource() {
			return source;
		}
	}

	public static LogCapture captureLogging(Level level, Class<?> source, Runnable action) {
		final Logger logger = LogManager.getLogger(source);
		final LoggerContext ctx = (LoggerContext) LogManager.getContext();
		final Configuration config = ctx.getConfiguration();
		final LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
		final QueueAppender appender = QueueAppender.createAppender(QueueAppender.NAME, null, null);
		final Level oldLevel = logger.getLevel();
		List<LoggerConfig> allLoggerConfigs = loggerConfigHierarchy(loggerConfig);
		SourceFilter filter = new SourceFilter(logger);
		try {
			loggerConfig.addAppender(appender, level, filter);
			for (LoggerConfig lc : allLoggerConfigs) {
				lc.addFilter(filter);
			}
			action.run();
			List<LogEntry> events = IterableExtensions.<LogEntry> sortWith(
					IterableExtensions.<LogEntry> toList(appender.getEvents()), TEMPORAL_ORDER);
			return new LogCapture(events);
		} finally {
			loggerConfig.removeAppender(appender.getName());
			loggerConfig.setLevel(oldLevel);
			for (LoggerConfig lc : allLoggerConfigs) {
				lc.removeFilter(filter);
				loggerConfig.setLevel(oldLevel);
			}
		}
	}

	private static List<LoggerConfig> loggerConfigHierarchy(LoggerConfig loggerConfig) {
		List<LoggerConfig> loggerConfigs = new ArrayList<>();
		for (LoggerConfig current = loggerConfig; current != null; current = current.getParent())
			loggerConfigs.add(current);
		return loggerConfigs;
	}

	private static final Comparator<LogEntry> TEMPORAL_ORDER = (LogEntry $0, LogEntry $1) -> {
		return Longs.compare($0.timeStamp, $1.timeStamp);
	};
}
