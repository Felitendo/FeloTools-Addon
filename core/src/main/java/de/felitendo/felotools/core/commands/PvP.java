package de.felitendo.felotools.core.commands;

import de.felitendo.felotools.core.FeloToolsAddon;
import de.felitendo.felotools.core.commands.subcommands.PvP_new;
import de.felitendo.felotools.core.commands.subcommands.PvP_old;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.util.I18n;

public class PvP extends Command {

  private final FeloToolsAddon addon;

  public PvP(FeloToolsAddon addon) {
    super("ftpvp");
    this.addon = addon;
    withSubCommand(new PvP_new());
    withSubCommand(new PvP_old());
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (prefix.equalsIgnoreCase("ftpvp")) {
      sendMessage();
    }
    return true;
  }

  public void sendMessage() {
    displayTranslatableMsg("felotools.commands.pvp.msg1", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.pvp.msg2", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.pvp.msg3", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.pvp.msg4", NamedTextColor.GREEN);
  }

  private void displayTranslatableMsg(String key, TextColor textColor, Object... arguments) {
    String translationKey = key;

    if (key.equals("help.msg4")) {
      String translation = I18n.translate("felotools.commands.pvp.msg1");
      String HelpWorldlengthFirstSplit = translation.split("§6")[1];
      int HelpWorldlengthSecondSplitLength = HelpWorldlengthFirstSplit.split(" §a")[0].length();
      StringBuilder sb = new StringBuilder(I18n.translate("felotools.commands.pvp.msg4"));
      for (int i = 0; i < HelpWorldlengthSecondSplitLength - 4; i++) {
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