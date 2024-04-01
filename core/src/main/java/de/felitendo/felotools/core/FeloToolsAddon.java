package de.felitendo.felotools.core;

import de.felitendo.felotools.core.commands.Coords;
import de.felitendo.felotools.core.commands.Help;
import javax.inject.Singleton;
import de.felitendo.felotools.core.commands.PvP;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.event.labymod.config.ConfigurationSaveEvent;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
@Singleton
public class FeloToolsAddon extends LabyAddon<AddonConfiguration> {

  public static FeloToolsAddon addon;
  public static String Prefix = "§7[§6FeloTools§7] §r";

  public static FeloToolsAddon getAddon() {
    return addon;
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.logger().info("[FeloTools-Addon] Addon loaded.");

    addon = this;

    init();
  }

  //Register Commands here
  private void init() {
    this.registerCommand(new Help(this));
    this.registerCommand(new PvP(this));
    this.registerCommand(new Coords(this));
  }

  @Override
  protected Class<AddonConfiguration> configurationClass() {
    return AddonConfiguration.class;
  }

  public void reloadShortcutsList() {
    this.labyAPI().eventBus().fire(new ConfigurationSaveEvent());
  }
}
