package net.davebalda.pacocraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class HealCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("heal").executes(HealCommand::run));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();
        assert player != null;
        player.setHealth(player.getMaxHealth());
        player.getHungerManager().setFoodLevel(20); // Assuming max food level is 20
        player.getHungerManager().setSaturationLevel(20); // Assuming max saturation level is 20

        context.getSource().sendFeedback(() -> Text.literal("Curato come si deve!")
                .formatted(Formatting.GREEN), false);

        return 1;
    }
}
