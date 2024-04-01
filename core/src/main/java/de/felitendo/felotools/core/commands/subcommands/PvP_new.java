package de.felitendo.felotools.core.commands.subcommands;

import de.felitendo.felotools.core.FeloToolsAddon;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.util.I18n;
import static net.labymod.api.Laby.labyAPI;

public class PvP_new extends SubCommand {

  public PvP_new() { super("new"); }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    sendMessage();
    labyAPI().config().multiplayer().classicPvP().oldBackwards().set(false);
    labyAPI().config().multiplayer().classicPvP().oldBlockBuild().set(false);
    labyAPI().config().multiplayer().classicPvP().oldBow().set(false);
    labyAPI().config().multiplayer().classicPvP().oldCreativeLayout().set(false);
    labyAPI().config().multiplayer().classicPvP().oldDamageColor().set(false);
    labyAPI().config().multiplayer().classicPvP().oldFishingRod().set(false);
    labyAPI().config().multiplayer().classicPvP().oldFood().set(false);
    labyAPI().config().multiplayer().classicPvP().oldHeadRotation().set(false);
    labyAPI().config().multiplayer().classicPvP().oldHeart().set(false);
    labyAPI().config().multiplayer().classicPvP().oldHitbox().set(false);
    labyAPI().config().multiplayer().classicPvP().oldItemPosture().set(false);
    labyAPI().config().multiplayer().classicPvP().oldRange().set(false);
    labyAPI().config().multiplayer().classicPvP().oldSlowdown().set(false);
    labyAPI().config().multiplayer().classicPvP().oldSneaking().set(false);
    labyAPI().config().multiplayer().classicPvP().oldSurvivalLayout().set(false);
    labyAPI().config().multiplayer().classicPvP().oldBackwards().set(false);
    labyAPI().config().multiplayer().classicPvP().oldSword().set(false);
    labyAPI().config().multiplayer().classicPvP().potionFix().set(false);
    labyAPI().config().multiplayer().classicPvP().shouldRemoveRecipeBook().set(false);
    return true;
  }

  public void sendMessage() {
    displayTranslatableMsg("felotools.commands.pvp_new.msg1", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.pvp_new.msg2", NamedTextColor.GREEN);
    displayTranslatableMsg("felotools.commands.pvp_new.msg3", NamedTextColor.GREEN);
  }

  private void displayTranslatableMsg(String key, TextColor textColor, Object... arguments) {
    String translationKey = key;

    if (key.equals("pvp_new.msg3")) {
      String translation = I18n.translate("felotools.commands.pvp_new.msg1");
      String HelpWorldlengthFirstSplit = translation.split("§6")[1];
      int HelpWorldlengthSecondSplitLength = HelpWorldlengthFirstSplit.split(" §a")[0].length();
      StringBuilder sb = new StringBuilder(I18n.translate("felotools.commands.pvp_new.msg3"));
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