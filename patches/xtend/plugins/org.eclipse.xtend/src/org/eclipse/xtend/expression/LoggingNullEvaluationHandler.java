/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package org.eclipse.xtend.expression;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

/**
 * Logs null evaluation events to the log category of this class.
 * <p>
 * The log level of the resulting message is configurable. By default messages will be logged with ERROR level.
 * 
 * @author karsten.thoms@itemis.de
 * 
 */
public class LoggingNullEvaluationHandler implements NullEvaluationHandler {
	private Logger log = LogManager.getLogger(LoggingNullEvaluationHandler.class);

	public enum Level {
		OFF, TRACE, DEBUG, INFO, WARN, ERROR, FATAL
	}

	private Level level = Level.ERROR;

	/**
	 * {@inheritDoc}
	 */
	public Object handleNullEvaluation(final SyntaxElement element, final ExecutionContext ctx) {
		if (isLevelEnabled()) {
			final CharSequence msg = buildMessage(element, ctx);
			switch (level) {
			case FATAL:
				log.fatal(msg);
				break;
			case ERROR:
				log.error(msg);
				break;
			case WARN:
				log.warn(msg);
				break;
			case INFO:
				log.info(msg);
				break;
			case DEBUG:
				log.debug(msg);
				break;
			case TRACE:
				log.trace(msg);
				break;
			default:
				break;
			}
		}
		return null;
	}

	private boolean isLevelEnabled() {
		switch (level) {
		case FATAL:
			return log.isFatalEnabled();
		case ERROR:
			return log.isErrorEnabled();
		case WARN:
			return log.isWarnEnabled();
		case INFO:
			return log.isInfoEnabled();
		case DEBUG:
			return log.isDebugEnabled();
		case TRACE:
			return log.isTraceEnabled();
		default:
			return false;
		}
	}

	/**
	 * Changes the log category.
	 * 
	 * @param category
	 *            Logger category
	 */
	public void setLogCategory(final String category) {
		log = LogManager.getLogger(category);
	}

	/**
	 * Set log level for messages.
	 * 
	 * @param level
	 *            The level
	 */
	public void setLevel(final Level level) {
		this.level = level;
	}

	/**
	 * Build the error message.
	 * 
	 * @param element
	 *            Current {@link SyntaxElement} that raised the Null Evaluation
	 * @param ctx
	 *            Current context
	 * @return Error message
	 */
	protected CharSequence buildMessage(final SyntaxElement element, final ExecutionContext ctx) {
		StringBuilder msg = new StringBuilder();
		msg.append("null evaluation in ").append(element.getFileName()).append(" on line ").append(element.getLine()).append(" '").append(element)
				.append("'");

		return msg;
	}
}
