package org.eclipse.emfcloud.coffee.modelserver.commands;

import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfcloud.coffee.Node;
import org.eclipse.emfcloud.coffee.modelserver.commands.semantic.AddAutomatedTaskCommand;
import org.eclipse.emfcloud.modelserver.glsp.notation.commands.AddShapeCommand;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class IssueSampleCommand extends RecordingCommand {

   private AddShapeCommand command;
   private final EditingDomain domain;

   public IssueSampleCommand(final EditingDomain domain, final URI modelUri, final GPoint classPosition, final Supplier<? extends EObject> supplier) {
      super((TransactionalEditingDomain) domain);
      this.command = new AddShapeCommand(domain, modelUri, classPosition, supplier);
      this.domain = domain;
   }

   @Override
   protected void doExecute() {
      // This code occurs error when undo
      domain.getCommandStack().execute(command);
   }
}
