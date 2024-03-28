package de.felitendo.felotools.core.commands;

import de.felitendo.felotools.core.FeloToolsAddon;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.util.I18n;

public class Help extends Command {

  private final String syntax = "/fthelp";
  private final FeloToolsAddon addon;

  public Help(FeloToolsAddon addon) {
    super("fthelp");
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (prefix.equalsIgnoreCase("fthelp")) {
      if (arguments.length != 0) {
        displayTranslatableMsg("felotools.commands.general.syntax", NamedTextColor.RED,
            syntax);
      } else {
        sendMessage();
      }
      return true;
    }
    return false;
  }

  public void sendMessage() {
    displayTranslatableMsg("felotools.commands.help.msg1", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.help.msg2", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.help.msg3", NamedTextColor.GREEN);
  }

  private void displayTranslatableMsg(String key, TextColor textColor, Object... arguments) {
    String translationKey = key;

    if (key.equals("help.msg3")) {
      String translation = I18n.translate("felotools.commands.help.msg1");
      String HelpWorldlengthFirstSplit = translation.split("§6")[1];
      int HelpWorldlengthSecondSplitLength = HelpWorldlengthFirstSplit.split(" §a")[0].length();
      StringBuilder sb = new StringBuilder(I18n.translate("felotools.commands.help.msg3"));
      for (int i = 0; i < HelpWorldlengthSecondSplitLength - 3; i++) {
        sb.append("-");
      }
      String message = FeloToolsAddon.Prefix + sb;
      this.displayMessage(Component.text(message, textColor));
    } else {
      String message = FeloToolsAddon.Prefix + I18n.translate(translationKey, arguments);
      this.displayMessage(Component.text(message, textColor));
    }
  }
}