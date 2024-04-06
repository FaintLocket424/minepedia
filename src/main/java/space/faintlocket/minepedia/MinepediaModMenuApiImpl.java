package space.faintlocket.minepedia;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class MinepediaModMenuApiImpl implements ModMenuApi {
    private String currentValue = "";

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.translatable("title.minepedia.config"));

            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            builder.setSavingRunnable(() -> {
                Minepedia.logger.info("Saving lmao");
            });

            ConfigCategory general = builder.getOrCreateCategory(Text.translatable("category.minepedia.general"));
            general.addEntry(entryBuilder.startStrField(Text.translatable("option.minepedia.optionA"), currentValue)
                    .setDefaultValue("This is the default value")
                    .setTooltip(Text.translatable("tooltip.minepedia.optionA"))
                    .setSaveConsumer(newValue -> currentValue = newValue)
                    .build());

            return builder.build();
        };
    }
}
