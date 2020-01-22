package com.zeligsoft.base.ui.menus.actions;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Wrapper to rename the result
 * 
 * @author Young-Soo Roh
 */
public class ReplaceResultNameCommand extends CommandWrapper {

	private String regex;

	private String replacement;

	/**
	 * Constructor.
	 *
	 * @param command
	 */
	public ReplaceResultNameCommand(Command command, String regex, String replacement) {
		super(command);
		this.regex = regex;
		this.replacement = replacement;
	}

	/**
	 * Wrap.
	 *
	 * @param command   the command
	 * @param part      the part
	 * @param container the container
	 * @return the command
	 */
	public static Command wrap(Command command, String regex, String replacement) {
		return new ReplaceResultNameCommand(command, regex, replacement);
	}

	/**
	 * @see org.eclipse.emf.common.command.CommandWrapper#execute()
	 *
	 */
	@Override
	public void execute() {

		super.execute();
		rename();
	}

	/**
	 * @see org.eclipse.emf.common.command.CommandWrapper#undo()
	 *
	 */
	@Override
	public void undo() {
		super.undo();
	}

	/**
	 * @see org.eclipse.emf.common.command.CommandWrapper#redo()
	 *
	 */
	@Override
	public void redo() {
		super.redo();
		rename();
	}

	private void rename() {
		Collection<?> results = getResultsCommand();
		if (!results.isEmpty()) {
			Iterator<?> resultIterator = results.iterator();

			// Get first result
			final Object result = resultIterator.next();
			if (result instanceof NamedElement) {
				NamedElement ne = (NamedElement) result;
				ne.setName(ne.getName().replaceAll(regex, replacement));
			}
		}
	}

	/**
	 * Gets the results command.
	 *
	 * @return the results command
	 */
	private Collection<?> getResultsCommand() {

		// Get results list
		Collection<?> resultsCommand = getResult();
		if (getResult().isEmpty()) {

			// Get affected objects list if it is not a command with result
			resultsCommand = getAffectedObjects();
		}

		return resultsCommand;
	}
}