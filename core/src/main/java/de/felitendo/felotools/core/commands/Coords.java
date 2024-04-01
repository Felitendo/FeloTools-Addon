package de.felitendo.felotools.core.commands;

import de.felitendo.felotools.core.FeloToolsAddon;
import net.labymod.api.LabyAPI;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.util.I18n;
import java.text.DecimalFormat;
import java.util.Objects;

public class Coords extends Command {

  private final String syntax = "/ftcoords";
  private final FeloToolsAddon addon;

  public Coords(FeloToolsAddon addon) {
    super("ftcoords");
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    // Get the player's position
    var player = Objects.requireNonNull(labyAPI.minecraft().getClientPlayer());
    double playerX = player.getPosX();
    double playerY = player.getPosY();
    double playerZ = player.getPosZ();

    // Cast doubles to ints to remove decimals
    int intX = (int) playerX;
    int intY = (int) playerY;
    int intZ = (int) playerZ;

    // Set the clipboard with player's position
    labyAPI.minecraft().setClipboard(intX + ", " + intY + ", " + intZ);

    // Send a message indicating that the position is copied to clipboard
    // sendMessage("Player's position copied to clipboard: " + intX + ", " + intY + ", " + intZ);
    sendMessage();

    return true; // Return true if execution is successful
  }

  public void sendMessage() {
    displayTranslatableMsg("felotools.commands.coords.msg1", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.coords.msg2", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.coords.msg3", NamedTextColor.GREEN);
  }

  private void displayTranslatableMsg(String key, TextColor textColor, Object... arguments) {
    String translationKey = key;

    if (key.equals("coords.msg3")) {
      String translation = I18n.translate("felotools.commands.coords.msg1");
      String HelpWorldlengthFirstSplit = translation.split("§6")[1];
      int HelpWorldlengthSecondSplitLength = HelpWorldlengthFirstSplit.split(" §a")[0].length();
      StringBuilder sb = new StringBuilder(I18n.translate("felotools.commands.coords.msg3"));
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